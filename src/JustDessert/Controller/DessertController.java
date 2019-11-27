package JustDessert.Controller;

import JustDessert.Service.ICommentService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Console;

@Controller
@RequestMapping(value = "/dessert")
public class DessertController {

    @Autowired
    private IDessertService dessertService;

    @Autowired
    private ICommentService commentService;

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

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
