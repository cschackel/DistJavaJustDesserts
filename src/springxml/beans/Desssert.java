package springxml.beans;

import springxml.services.LoggerService;

import java.io.Serializable;

public class Desssert implements Serializable {
    private int dessertID;
    private int categoryID;
    private String dessertName;
    private String description;
    private String discerningFeatures;
    private double rating;
    private LoggerService ls;


    public int getDessertID() {
        return dessertID;
    }

    public void setDessertID(int dessertID) {
        this.dessertID = dessertID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscerningFeatures() {
        return discerningFeatures;
    }

    public void setDiscerningFeatures(String discerningFeatures) {
        this.discerningFeatures = discerningFeatures;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
