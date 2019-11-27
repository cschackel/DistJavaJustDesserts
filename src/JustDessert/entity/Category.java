package JustDessert.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private int categoryID;
    @NotNull
    @Size(min = 1, max = 50, message = "1-50 characters")
    @Column(name = "categoryname")
    private String categoryName;
    @Column(name = "imagename")
    @Size(min = 1, max = 50, message = "1-50 characters")
    private String imageName;
    //ALL Because if Category Is Deleted, all Desserts of that Category should be deleted
    //Default Lazy Loading OK because it is efficient and it is not always necessary to know desserts
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

    public void addDessert(Dessert newDessert)
    {
        if(dessertList==null)
        {
            dessertList = new LinkedList<>();
        }
        dessertList.add(newDessert);
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
