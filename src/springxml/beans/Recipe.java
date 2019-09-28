package springxml.beans;

import springxml.services.LoggerService;

import java.io.Serializable;

public class Recipe implements Serializable {
    private int recipeID;
    private int dessertID;
    private String title;
    private String body;
    private String ingredients;
    private LoggerService ls;


    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getDessertID() {
        return dessertID;
    }

    public void setDessertID(int dessertID) {
        this.dessertID = dessertID;
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
}
