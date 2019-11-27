package JustDessert.Service;

import JustDessert.DAO.IRecipeDAO;
import JustDessert.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@Service
public class RecipeService implements IRecipeService {

    @Autowired
    private IRecipeDAO recipeDAO;


    @Transactional
    @Override
    public Collection<Recipe> getRecipes() {
        return recipeDAO.getRecipes();
    }

    @Transactional
    @Override
    public void saveRecipe(Recipe newRecipe) {
        recipeDAO.saveRecipe(newRecipe);
    }

    @Transactional
    @Override
    public Recipe getRecipeByID(int ID) {
        return recipeDAO.getRecipeByID(ID);
    }

    @Transactional
    @Override
    public Collection<Recipe> getRecipesByDessertID(int dessertID) {
        return recipeDAO.getRecipesByDessertID(dessertID);
    }
}
