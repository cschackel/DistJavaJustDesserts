package JustDessert.DAO;

import JustDessert.entity.Recipe;

import java.util.Collection;

public interface IRecipeDAO {
    Collection<Recipe> getRecipes();

    void saveRecipe(Recipe newRecipe);

    Recipe getRecipeByID(int ID);

    Collection<Recipe> getRecipesByDessertID(int dessertID);
}
