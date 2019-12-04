package JustDessert.Service;

import JustDessert.DAO.ICategoryDAO;
import JustDessert.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Transactional
    @Override
    public Collection<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Transactional
    @Override
    public Collection<Category> getCategoriesEager() {
        return  categoryDAO.getCategoriesEager();
    }

    @Transactional
    @Override
    public void addCategory(Category newCategory) {
        categoryDAO.addCategory(newCategory);
    }

    @Transactional
    @Override
    public Category getCategoryByID(int ID) {
        return categoryDAO.getCategoryByID(ID);
    }

    @Transactional
    @Override
    public Category getCategoryByIDEager(int ID) {
        return categoryDAO.getCategoryByIDEager(ID);
    }

    @Transactional
    @Override
    public void DeleteCategoryByID(int ID) {
        categoryDAO.DeleteCategoryByID(ID);
    }
}
