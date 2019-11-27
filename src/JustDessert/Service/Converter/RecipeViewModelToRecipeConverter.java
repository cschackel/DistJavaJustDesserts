package JustDessert.Service.Converter;

import JustDessert.entity.Recipe;
import JustDessert.entity.RecipeViewModel;
import org.springframework.core.convert.converter.Converter;

public class RecipeViewModelToRecipeConverter implements Converter<RecipeViewModel, Recipe> {
    @Override
    public Recipe convert(RecipeViewModel recipeViewModel) {
        Recipe recipe = new Recipe();
        recipe.setBody(recipeViewModel.getBody());
        recipe.setDessert(recipeViewModel.getDessert());
        recipe.setRecipeID(recipeViewModel.getRecipeID());
        recipe.setTitle(recipeViewModel.getTitle());
        recipe.setIngredients(recipeViewModel.getIngredientsString());
        return recipe;
    }


}
