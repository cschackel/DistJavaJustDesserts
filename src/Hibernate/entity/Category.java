package Hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private int categoryID;
    @Column(name = "categoryname")
    private String categoryName;
    @Column(name = "imagename")
    private String imageName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    //@JoinColumn(name = "dessertid")
    private List<Dessert> dessertList;

    public Category()
    {

    }

    public Category(String categoryName, String imageName, List<Dessert> dessertList) {
        this.categoryName = categoryName;
        this.imageName = imageName;
        this.dessertList = dessertList;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Dessert> getDessertList() {
        return dessertList;
    }

    public void setDessertList(List<Dessert> dessertList) {
        this.dessertList = dessertList;
    }

    @Override
    public String toString()
    {
        String output;
        output = "Category:{\nCategoryID: "+getCategoryID() +
                "\nCategory Name: "+ getCategoryName()+
                "\nImage Name: "+getImageName()+
                "\n}";
        return output;
    }
}
