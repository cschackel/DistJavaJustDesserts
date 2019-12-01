package JustDessert.Controller;

import JustDessert.Service.ICategoryService;
import JustDessert.Service.ICommentService;
import JustDessert.Service.IImageFileService;
import JustDessert.entity.Comment;
import JustDessert.entity.Dessert;
import JustDessert.Service.IDessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Console;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/dessert")
public class DessertController {

    @Autowired
    private IDessertService dessertService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IImageFileService imageFileService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/{dessertID}")
    public String showDessertPage(@PathVariable int dessertID, Model model)
    {
        Dessert dessert = dessertService.getDessertByIDEager(dessertID);
        model.addAttribute("dessert",dessert);
        model.addAttribute("newComment",new Comment());
        return "dessert/dessert";
    }

    @PostMapping("/{dessertID}/addComment")
    public String addComment(@PathVariable int dessertID, Model model, @Valid @ModelAttribute(name ="newComment") Comment newComment, BindingResult bindingResult, HttpServletRequest request)
    {
        if (bindingResult.hasErrors()) {

            Dessert dessert = dessertService.getDessertByIDEager(dessertID);
            model.addAttribute("dessert",dessert);
            model.addAttribute("newComment",newComment);
            return "dessert/dessert";
        }
        else
        {
            if(newComment.getDessert()==null)
            {
                System.out.println("Null");
                return "redirect:/dessert/"+dessertID;
            }
            else
            {
                commentService.saveComment(newComment);
                return "redirect:/dessert/"+dessertID;
            }
        }
    }
/*
    @GetMapping("/search/{searchTerm}")
    public String displaySearchResults(@PathVariable String searchTerm, Model model)
    {
        Collection<Dessert> desserts = dessertService.getDessertsByName(searchTerm);
        model.addAttribute("desserts",desserts);
        return "dessert/dessertSearch";
    }
*/


    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {

        Collection<Dessert> desserts = dessertService.getDessertsByName(theSearchTerm);

        theModel.addAttribute("desserts", desserts);

        return "dessert/dessertSearch";
    }

    @RequestMapping("/add")
    public  String showAddDessert(Model model)
    {
        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("newDessert",new Dessert());
        return "dessert/newDessertForm";
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }

    @PostMapping("/save")
    public String saveDonut(@RequestParam(name = "dessertImage") MultipartFile file,
                            @Valid @ModelAttribute(name = "newDessert") Dessert newDessert,
                            BindingResult bindingResult,
                            Model model,
                            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);

            model.addAttribute("categories",categoryService.getCategories());

            return "dessert/newDessertForm";
        }

        dessertService.addDessert(newDessert, file, request.getServletContext().getRealPath("/"));

        return "redirect:/";
    }
}
