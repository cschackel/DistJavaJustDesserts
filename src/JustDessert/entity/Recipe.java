package JustDessert.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeid")
    private int recipeID;
    //Cascade Does Not include Delete Because If a Recipe is removed, the Dessert should remain
    //Eager OK because it allows Recipe to access Dessert Data and it is not a large amount of data
    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "dessertid")
    //@Column(name = "dessertid")
    private Dessert dessert;
    @NotNull
    @Size(min = 1, max = 50, message = "1-50 characters")
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    @NotNull
    @Size(min = 1, max = 5000, message = "1-5000 characters")
    private String body;
    @Column(name = "ingredients")
    @Size(min = 1, max = 5000, message = "1-5000 characters")
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

    public Recipe(String title, String body, String ingredients) {
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
                "\nIngredients: "+getIngredients()+
                "\n}";
        return output;
    }
}
