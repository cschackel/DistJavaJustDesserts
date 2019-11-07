package Hibernate;

import Hibernate.entity.Category;
import Hibernate.entity.Comment;
import Hibernate.entity.Dessert;
import Hibernate.entity.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();
        try{

            //Category
            Category newCat = new Category();
            newCat.setCategoryName("Jellos");
            newCat.setImageName("test1.jpg");
            newCat.addDessert(new Dessert("Red Jello","A Red Jello",4.5,"Color","jello-red"));
            int newCatID = app.createCategory(newCat);  //Create

            Category cat1 = app.getCategoryByID(newCatID);  //Read
            Category cat2 = new Category();
            cat2.setCategoryName("Revised Category");
            cat2.setImageName("rev_cat");

            cat2.setCategoryID(cat1.getCategoryID());
            System.out.println(cat1);
            app.updateCategory(cat2);  //Update
            System.out.println(cat1);

            System.out.println("Display Desserts");
            app.displayCategoryDesserts(cat1.getCategoryID());

            app.deleteCategoryByID(cat1.getCategoryID());  //Delete

            //Dessert

            Dessert newDessert = new Dessert("Fluffy Cakes","A Fluffy Cake",3.0,"Fluff","fluffy-cake");
            newDessert.setCategory(app.getCategoryByID(2));
            Comment newComment = new Comment("Tim Allen","Super Fluffy","The Fluffyest");
            newComment.setDessert(newDessert);
            newDessert.addComment(newComment);
            Recipe newRecipe = new Recipe("Best Recipe","Just Do It","Motivation");
            newRecipe.setDessert(newDessert);
            newDessert.addRecipe(newRecipe);
            int dessertID = app.createDessert(newDessert);  //Create

            Dessert d1 = app.getDessertByID(dessertID);  //Read
            Dessert d2 = new Dessert("Bad Cakes","Awful",1,"Horror","bad");
            d2.setDessertID(d1.getDessertID());
            System.out.println(d1);
            app.updateDessert(d2);  //Update
            System.out.println(d1);

            app.deleteDessertByID(d1.getDessertID());

            //Comment

            Comment comment = new Comment("Jack","Yay","Hoora");
            Dessert targetDessert = app.getDessertByID(1);
            comment.setDessert(targetDessert);
            int commentID = app.createComment(comment);  //Create

            Comment c1 = app.getCommentByID(commentID);  //Read
            Comment c2 = new Comment("Davy Jones","Loser","This is Trash");
            c2.setCommentID(c1.getCommentID());
            c2.setDessert(targetDessert);
            System.out.println(c1);
            app.updateComment(c2);  //Update
            System.out.println(c1);

            app.deleteCommentByID(c1.getCommentID());  //Delete

            //Recipe

            Recipe recipe = new Recipe("Best Recipe","The Greatest","Awe,Power");
            recipe.setDessert(app.getDessertByID(1));
            int recipeID = app.createRecipe(recipe); //Create

            Recipe r1 = app.getRecipeByID(recipeID);  //Read
            Recipe r2 = new Recipe("Love Muffins","Made With Love","Love,Flour");
            r2.setRecipeID(r1.getRecipeID());
            r2.setDessert(app.getDessertByID(1));

            System.out.println(r1);
            app.updateRecipe(r2);  //Update
            System.out.println(r1);

            app.deleteRecipeByID(r1.getRecipeID());  //Delete

            System.out.println("End");

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

        System.out.println("Saving...");

        session.save(newCategory);
        System.out.println("Saving new Category with ID "+ newCategory.getCategoryID());

        System.out.println("# of Desserts: " + newCategory.getDessertList().size());

        for(Dessert d : newCategory.getDessertList())
        {
            d.setCategory(newCategory);
            session.save(d);
        }

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

        for(Recipe r: newDessert.getRecipeList())
        {
            r.setDessert(newDessert);
            session.save(r);
        }

        for(Comment c : newDessert.getCommentList())
        {
            c.setDessert(newDessert);
            session.save(c);
        }

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

    private void updateCategory(Category updatedCategory) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Category toUpdate = session.get(Category.class,updatedCategory.getCategoryID());

        if(toUpdate!=null)
        {
            toUpdate.setCategoryName(updatedCategory.getCategoryName());
            toUpdate.setImageName(updatedCategory.getImageName());
            toUpdate.setDessertList(updatedCategory.getDessertList());
        }

        session.getTransaction().commit();
    }

    private void updateDessert(Dessert updatedDessert) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Dessert toUpdate = session.get(Dessert.class,updatedDessert.getDessertID());

        if(toUpdate!=null)
        {
            toUpdate.setDessertName(updatedDessert.getDessertName());
            toUpdate.setImageName(updatedDessert.getImageName());
            toUpdate.setDescription(updatedDessert.getDescription());
            toUpdate.setDiscerningFeatures(updatedDessert.getDiscerningFeatures());
            toUpdate.setRating(updatedDessert.getRating());
            toUpdate.setCategory(updatedDessert.getCategory());
        }

        session.getTransaction().commit();
    }

    private void updateComment(Comment updatedComment) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Comment toUpdate = session.get(Comment.class,updatedComment.getCommentID());

        if(toUpdate!=null)
        {
            toUpdate.setPostedBy(updatedComment.getPostedBy());
            toUpdate.setTitle(updatedComment.getTitle());
            toUpdate.setBody(updatedComment.getBody());
            toUpdate.setDessert(updatedComment.getDessert());
        }

        session.getTransaction().commit();
    }

    private void updateRecipe(Recipe updatedRecipe) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Recipe toUpdate = session.get(Recipe.class,updatedRecipe.getRecipeID());

        if(toUpdate!=null)
        {
            toUpdate.setTitle(updatedRecipe.getTitle());
            toUpdate.setBody(updatedRecipe.getBody());
            toUpdate.setIngredients(updatedRecipe.getIngredients());
            toUpdate.setDessert(updatedRecipe.getDessert());
        }

        session.getTransaction().commit();
    }

    private void deleteCategoryByID(int catID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        Category category = session.get(Category.class,catID);

        if(category!=null)
        {
            System.out.println("# of Desserts: " + category.getDessertList().size());

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

    //TODO



    private void displayCategoryDesserts(int catID) {
        Session session = factory.getCurrentSession();

        // Start a transaction
        session.beginTransaction();

        List<Dessert> desserts = session.get(Category.class,catID).getDessertList();

        for(Dessert d:desserts)
        {
            System.out.println(d);
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
