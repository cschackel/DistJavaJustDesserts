package JustDessert.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class RecipeViewModel {
    private int recipeID;

    private Dessert dessert;
    private String title;
    private String body;
    private List<String> ingredients;

    public RecipeViewModel()
    {

    }

    public RecipeViewModel(Dessert dessert, String title, String body, String ingredients) {
        this.dessert = dessert;
        this.title = title;
        this.body = body;
        this.ingredients = Arrays.asList(ingredients.split(","));
    }

    public RecipeViewModel(String title, String body, String ingredients) {
        this.title = title;
        this.body = body;
        this.ingredients = Arrays.asList(ingredients.split(","));
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredientsString() {
        return String.join(",",ingredients);
    }

    public void addIngredient(String s)
    {
        ingredients.add(s);
    }

    public void removeIngredient(String s)
    {
        ingredients.remove(s);
    }

    public void setIngredients(String ingredients) {
        this.ingredients = Arrays.asList(ingredients.split(","));
    }

    @Override
    public String toString()
    {
        String output;
        output = "RecipeViewModel:{\nRecipeID: "+getRecipeID() +
                "\nDessertID: "+getDessert().getDessertID()+
                "\nTitle: "+getTitle()+
                "\nBody: "+getBody()+
                "\nIngredients: "+getIngredients()+
                "\n}";
        return output;
    }
}
