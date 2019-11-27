package JustDessert.DAO;

import JustDessert.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository
public class CategoryDAO implements ICategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public CategoryDAO()
    {

    }

    @Override
    public Collection<Category> getCategories() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Category> allCategories = session.createQuery("from Category", Category.class).getResultList();

        return allCategories;
    }

    @Override
    public Collection<Category> getCategoriesEager() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Category> allCategories = session.createQuery("from Category c join fetch c.dessertList", Category.class).getResultList();

        return allCategories;
    }

    @Override
    public void addCategory(Category newCategory) {
        Session session = sessionFactory.getCurrentSession();

        session.save(newCategory);
    }

    @Override
    public Category getCategoryByID(int ID) {
        Session session = sessionFactory.getCurrentSession();
        Category targetCategory;
        targetCategory = session.get(Category.class,ID);
        return targetCategory;
    }

    @Override
    public Category getCategoryByIDEager(int id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = null;
        Query q = session.createQuery("from Category c join fetch c.dessertList where (c.categoryID = :id)",Category.class);
        List<Category> categories = q.setParameter("id",id).getResultList();
        if(categories!=null&&categories.size()>0)
        {
            category = categories.get(0);
        }
        return category;
    }
}
