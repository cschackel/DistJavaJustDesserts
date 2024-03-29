package JustDessert.DAO;

import JustDessert.entity.Category;
import JustDessert.entity.Dessert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

@Repository
public class DessertDAO implements IDessertDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<Dessert> getDesserts() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Dessert> allDesserts = session.createQuery("from Dessert", Dessert.class).getResultList();

        return allDesserts;
    }

    @Override
    public void addDessert(Dessert newDessert) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(newDessert);
    }

    @Override
    public Dessert getDessertByID(int ID) {
        Session session = sessionFactory.getCurrentSession();
        Dessert targetDessert;
        targetDessert = session.get(Dessert.class,ID);
        return targetDessert;
    }

    @Override
    public Dessert getDessertByIDEager(int id) {
        Session session = sessionFactory.getCurrentSession();
        Dessert dessert = null;
        Query q = session.createQuery("from Dessert d join fetch d.commentList where (d.dessertID = :id)",Dessert.class);
        List<Dessert> desserts = q.setParameter("id",id).getResultList();
        if(desserts!=null&&desserts.size()>0)
        {
            dessert =desserts.get(0);
        } else
        {
            q = session.createQuery("from Dessert d where (d.dessertID = :id)",Dessert.class);
            desserts = q.setParameter("id",id).getResultList();
            if(desserts!=null&&desserts.size()>0)
            {
                dessert =desserts.get(0);
                dessert.getCommentList().size();
            }
        }
        return dessert;
    }

    @Override
    public Collection<Dessert> getDessertsByName(String s) {
        Session session = sessionFactory.getCurrentSession();
        List<Dessert> desserts;
        Query q = session.createQuery("from Dessert d where lower(d.dessertName) like :searchTerm");
        String theSearchTerm = "%" + s.toLowerCase() + "%";
        q.setParameter("searchTerm",theSearchTerm);
        desserts = q.getResultList();
        return desserts;
    }

    @Override
    public void deleteDessertByID(int ID) {
        Session session = sessionFactory.getCurrentSession();

        // Delete object using primary key
        Query query = session.createQuery("delete from Dessert d where d.dessertID  = :ID");
        // Set parameter value
        query.setParameter("ID", ID);

        // Perform the delete
        query.executeUpdate();
    }
}
