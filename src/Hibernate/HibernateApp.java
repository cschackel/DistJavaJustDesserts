package Hibernate;

import Hibernate.entity.Category;
import Hibernate.entity.Comment;
import Hibernate.entity.Dessert;
import Hibernate.entity.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    private SessionFactory factory;

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();
        try{
            Category newCat = new Category();
            newCat.setCategoryName("TestCat");
            newCat.setImageName("test1.jpg");
            int newCatID = app.createCategory(newCat);


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

    private int createCategory(Category newCategory) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        session.save(newCategory);
        System.out.println("Saving new Category with ID "+ newCategory.getCategoryID());

        // Commit the transaction
        session.getTransaction().commit();

        return newCategory.getCategoryID();
    }

    private int createDessert(Dessert newDessert) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        session.save(newDessert);
        System.out.println("Saving new Desert with ID "+ newDessert.getDessertID());

        // Commit the transaction
        session.getTransaction().commit();

        return newDessert.getDessertID();
    }

    private int createComment(Comment newComment) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        session.save(newComment);
        System.out.println("Saving new Comment with ID "+ newComment.getCommentID());

        // Commit the transaction
        session.getTransaction().commit();

        return newComment.getCommentID();
    }

    private int createRecipe(Recipe newRecipe) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        session.save(newRecipe);
        System.out.println("Saving new Desert with ID "+ newRecipe.getRecipeID());

        // Commit the transaction
        session.getTransaction().commit();

        return newRecipe.getRecipeID();
    }

    private void printCategoryByID(int catID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        System.out.println(session.get(Category.class,catID));

        // Commit the transaction
        session.getTransaction().commit();
    }

    private Category getCategoryByID(int catID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Category category = session.get(Category.class,catID);

        // Commit the transaction
        session.getTransaction().commit();

        return category;
    }

    private void printDessertByID(int dessertID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        System.out.println(session.get(Dessert.class,dessertID));

        // Commit the transaction
        session.getTransaction().commit();
    }

    private Dessert getDessertByID(int dessertID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Dessert dessert = session.get(Dessert.class,dessertID);

        // Commit the transaction
        session.getTransaction().commit();

        return dessert;
    }

    private void printCommentByID(int commentID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        System.out.println(session.get(Comment.class, commentID));

        // Commit the transaction
        session.getTransaction().commit();
    }

    private Comment getCommentByID(int commentID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Comment comment = session.get(Comment.class,commentID);

        // Commit the transaction
        session.getTransaction().commit();

        return comment;
    }

    private void printRecipeByID(int recipeID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        System.out.println(session.get(Recipe.class,recipeID));

        // Commit the transaction
        session.getTransaction().commit();
    }

    private Recipe getRecipeByID(int recipeID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Recipe recipe = session.get(Recipe.class,recipeID);

        // Commit the transaction
        session.getTransaction().commit();

        return recipe;
    }

    //TODO: UPDATE

    private void deleteCategoryByID(int catID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Category category = session.get(Category.class,catID);

        if(category!=null)
        {
            session.delete(category);
        }


        // Commit the transaction
        session.getTransaction().commit();
    }

    private void deleteDessertByID(int dessertID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Dessert dessert = session.get(Dessert.class,dessertID);

        if(dessert!=null)
        {
            session.delete(dessert);
        }


        // Commit the transaction
        session.getTransaction().commit();
    }

    private void deleteCommentByID(int commentID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Comment comment = session.get(Comment.class,commentID);

        if(comment!=null)
        {
            session.delete(comment);
        }


        // Commit the transaction
        session.getTransaction().commit();
    }

    private void deleteRecipeByID(int recipeID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Recipe recipe = session.get(Recipe.class,recipeID);

        if(recipe!=null)
        {
            session.delete(recipe);
        }


        // Commit the transaction
        session.getTransaction().commit();
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
