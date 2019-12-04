package JustDessert.DAO;

import JustDessert.entity.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
@Repository
public class RecipeDAO implements IRecipeDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Collection<Recipe> getRecipes() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Recipe> allRecipes = session.createQuery("from Recipe", Recipe.class).getResultList();

        return allRecipes;
    }

    @Override
    public void saveRecipe(Recipe newRecipe) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(newRecipe);
    }

    @Override
    public Recipe getRecipeByID(int ID) {
        Session session = sessionFactory.getCurrentSession();
        Recipe targetRecipe;
        targetRecipe = session.get(Recipe.class,ID);
        return targetRecipe;
    }

    @Override
    public Collection<Recipe> getRecipesByDessertID(int dessertID) {
        Session session = sessionFactory.getCurrentSession();

        List<Recipe> recipes;

        Query query = session.createQuery("from Recipe r where r.dessert.dessertID = :dessertID ");

        query.setParameter("dessertID",dessertID);

        recipes = query.getResultList();

        return recipes;
    }

    @Override
    public void DeleteRecipeByID(int ID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Recipe  r where r.recipeID  = :ID");
        query.setParameter("ID", ID);

        query.executeUpdate();
    }
}
