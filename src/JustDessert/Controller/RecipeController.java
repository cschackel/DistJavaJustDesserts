package JustDessert.Controller;

import JustDessert.Service.Converter.RecipeToRecipeViewModelConverter;
import JustDessert.entity.Recipe;
import JustDessert.Service.IRecipeService;
import JustDessert.entity.RecipeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @RequestMapping("/{dessertID}")
    public String showRecipePage(@PathVariable int dessertID, Model model)
    {
        List<RecipeViewModel> recipeViewModels = getRecipesForID(dessertID, model);
        model.addAttribute("recipes",recipeViewModels);
        model.addAttribute("newRecipe", new Recipe());

        return "recipe/recipe";
    }

    private List<RecipeViewModel> getRecipesForID(@PathVariable int dessertID, Model model) {
        Collection<Recipe> recipes = recipeService.getRecipesByDessertID(dessertID);

        List<RecipeViewModel> recipeViewModels = new LinkedList<RecipeViewModel>();

        int i = recipeViewModels.size();

        for (Recipe r: recipes) {
            RecipeToRecipeViewModelConverter converter = new RecipeToRecipeViewModelConverter();
            recipeViewModels.add(converter.convert(r));
        }

        return recipeViewModels;

    }

    @PostMapping("{dessertID}/add")
    public String addRecipe(Model model,@PathVariable int dessertID ,@Valid @ModelAttribute(name = "newRecipe") Recipe newRecipe, BindingResult bindingResult, HttpServletRequest request) throws Exception {
        if (bindingResult.hasErrors())
        {
            List<RecipeViewModel> recipeViewModels = getRecipesForID(dessertID, model);
            model.addAttribute("recipes",recipeViewModels);
            model.addAttribute("newRecipe", newRecipe);
            throw new Exception("Bad Model");
            //return "recipe/recipe";
        }
        else
        {
            if(newRecipe.getDessert()==null)
            {
                throw new Exception("No Dessert ID");
                //return "redirect:/recipe/"+dessertID;
            }
            else
            {
                recipeService.saveRecipe(newRecipe);
                return "redirect:/recipe/"+dessertID;
            }
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
