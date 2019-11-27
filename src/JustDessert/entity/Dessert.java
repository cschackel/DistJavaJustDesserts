package JustDessert.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "desserts")
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dessertid")
    private int dessertID;
    @NotNull
    @Size(min = 1, max = 50, message = "1-50 characters")
    @Column(name = "dessertname")
    private String dessertName;
    //Cascade Does Not include Delete Because If a dessert is removed, the category should remain
    //Eager OK because it allows Dessert to access Category Data and it is not a large amount of data
    @ManyToOne(fetch = FetchType.EAGER,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "categoryid")
    @NotNull
    private Category category;
    @Column(name = "description")
    @Size(min = 1, max = 500, message = "1-500 characters")
    private String description;
    @Min(0)
    @Max(5)
    @NotNull
    @Column(name = "rating")
    private double rating;
    @Size(min = 1, max = 500, message = "1-500 characters")
    @NotNull
    @Column(name = "discerningfeatures")
    private String discerningFeatures;
    @Size(min = 1, max = 50, message = "1-50 characters")
    @Column(name = "imagename")
    private String imageName;


    //ALL Because if Dessert Is Deleted, all Recipes of that Dessert should be deleted
    //Default Lazy Loading OK because it is efficient and it is not always necessary to know recipes
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dessert")
    //@JoinColumn(name = "recipeid")
    private List<Recipe> recipeList;

    //ALL Because if Dessert Is Deleted, all Comments of that Dessert should be deleted
    //Default Lazy Loading OK because it is efficient and it is not always necessary to know comments
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "dessert")
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

    public Dessert(String dessertName, String description, double rating, String discerningFeatures, String imageName) {
        this.dessertName = dessertName;
        this.description = description;
        this.rating = rating;
        this.discerningFeatures = discerningFeatures;
        this.imageName = imageName;
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

    public void addComment(Comment newComment)
    {
        if(commentList==null)
        {
            commentList = new LinkedList<>();
        }
        commentList.add(newComment);
    }

    public void addRecipe(Recipe newRecipe)
    {
        if(recipeList==null)
        {
            recipeList = new LinkedList<>();
        }
        recipeList.add(newRecipe);
    }

    @Override
    public String toString()
    {
        String output;
        output = "Dessert:{\nDessertID: "+getDessertID() +
                "\nCategoryID: "+getCategory().getCategoryID()+
                "\nName: "+getDessertName()+
                "\nDescription: "+getDescription()+
                "\nDiscerning Features: "+getDiscerningFeatures()+
                "\nRating: "+getRating()+
                "\nImage Name: "+getImageName()+
                "\n}";
        return output;
    }
}
