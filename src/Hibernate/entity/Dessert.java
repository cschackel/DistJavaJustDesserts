package Hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dessertid")
    private int dessertID;
    @Column(name = "dessertname")
    private String dessertName;
    @ManyToOne(fetch = FetchType.EAGER,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @Column(name = "categoryid")
    private Category category;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private double rating;
    @Column(name = "discerningfeatures")
    private String discerningFeatures;
    @Column(name = "imagename")
    private String imageName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    //@JoinColumn(name = "categoryid")
    //private List<Category> categoryList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recipeid")
    //@JoinColumn(name = "recipeid")
    private List<Recipe> recipeList;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "commentid")
    //@JoinColumn(name = "commentid")
    private List<Comment> commentList;

    public Dessert()
    {

    }

    public Dessert(String dessertName, Category category, String description, double rating, String discerningFeatures, String imageName, List<Recipe> recipeList, List<Comment> commentList) {
        this.dessertName = dessertName;
        this.category = category;
        this.description = description;
        this.rating = rating;
        this.discerningFeatures = discerningFeatures;
        this.imageName = imageName;
        this.recipeList = recipeList;
        this.commentList = commentList;
    }

    public int getDessertID() {
        return dessertID;
    }

    public void setDessertID(int dessertID) {
        this.dessertID = dessertID;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDiscerningFeatures() {
        return discerningFeatures;
    }

    public void setDiscerningFeatures(String discerningFeatures) {
        this.discerningFeatures = discerningFeatures;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString()
    {
        String output;
        output = "Dessert:{\nDessertID: "+getDessertID() +
                "\ncategoryID: "+getCategory().getCategoryID()+
                "\nName: "+getDessertName()+
                "\nDescription: "+getDescription()+
                "\n Discerning Features: "+getDiscerningFeatures()+
                "\nRating: "+getRating()+
                "\nImage Name: "+getImageName()+
                "\n}";
        return output;
    }
}
