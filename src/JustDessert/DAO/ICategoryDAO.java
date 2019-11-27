package JustDessert.DAO;

import JustDessert.entity.Category;

import java.util.Collection;

public interface ICategoryDAO {
    Collection<Category> getCategories();

    Collection<Category> getCategoriesEager();

    void addCategory(Category newCategory);

    Category getCategoryByID(int ID);

    Category getCategoryByIDEager(int id);
}
