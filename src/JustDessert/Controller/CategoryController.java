package JustDessert.Controller;

import JustDessert.entity.Category;
import JustDessert.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/{categoryID}")
    public String showCategoryPage(Model model, @PathVariable int categoryID)
    {
        Category category = categoryService.getCategoryByIDEager(categoryID);

        model.addAttribute("category",category);
        return "/category/category";
    }
}
