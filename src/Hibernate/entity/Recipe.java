package Hibernate.entity;

import javax.persistence.*;

@Entity(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeid")
    private int recipeID;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "dessertid")
    //@Column(name = "dessertid")
    private Dessert dessert;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "ingredients")
    private String ingredients;

    public Recipe()
    {

    }

    public Recipe(Dessert dessert, String title, String body, String ingredients) {
        this.dessert = dessert;
        this.title = title;
        this.body = body;
        this.ingredients = ingredients;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString()
    {
        String output;
        output = "Recipe:{\nRecipeID: "+getRecipeID() +
                "\nDessertID: "+getDessert().getDessertID()+
                "\nTitle: "+getTitle()+
                "\nBody: "+getBody()+
                "\n Ingredients: "+getIngredients()+
                "\n}";
        return output;
    }
}
