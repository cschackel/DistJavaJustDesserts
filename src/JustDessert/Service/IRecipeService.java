package JustDessert.Service;

import JustDessert.entity.Recipe;

import java.util.Collection;

public interface IRecipeService {
    Collection<Recipe> getRecipes();

    void saveRecipe(Recipe newRecipe);

    Recipe getRecipeByID(int ID);

    Collection<Recipe> getRecipesByDessertID(int dessertID);
}
