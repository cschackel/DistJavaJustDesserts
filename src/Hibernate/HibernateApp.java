package Hibernate;

import Hibernate.entity.Category;
import Hibernate.entity.Comment;
import Hibernate.entity.Dessert;
import Hibernate.entity.Recipe;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    private SessionFactory factory;

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();
        try{

        }
        finally {
            app.close();
        }


    }

    public HibernateApp()
    {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Dessert.class)
                .addAnnotatedClass(Recipe.class)
                .buildSessionFactory();
    }

    public void close()
    {
        factory.close();
    }
/*
private void template() {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();



        // Commit the transaction
        session.getTransaction().commit();
    }
 */



}
