package JustDessert.Service.Converter;

import JustDessert.entity.Recipe;
import JustDessert.entity.RecipeViewModel;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;

public class RecipeToRecipeViewModelConverter implements Converter<Recipe,RecipeViewModel> {
    @Override
    public RecipeViewModel convert(Recipe recipe) {
        RecipeViewModel recipeViewModel = new RecipeViewModel();
        recipeViewModel.setBody(recipe.getBody());
        recipeViewModel.setDessert(recipe.getDessert());
        recipeViewModel.setRecipeID(recipe.getRecipeID());
        recipeViewModel.setTitle(recipe.getTitle());
        recipeViewModel.setIngredients(Arrays.asList(recipe.getIngredients().split(",")));
        return recipeViewModel;
    }
}
