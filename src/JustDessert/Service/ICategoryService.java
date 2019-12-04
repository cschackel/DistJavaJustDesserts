package JustDessert.Service;

import JustDessert.entity.Category;

import javax.transaction.Transactional;
import java.util.Collection;

public interface ICategoryService {
    Collection<Category> getCategories();

    Collection<Category> getCategoriesEager();

    void addCategory(Category newCategory);

    Category getCategoryByID(int ID);

    Category getCategoryByIDEager(int ID);

    void DeleteCategoryByID(int ID);


}
