package JustDessert.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentid")
     private int commentID;
    //Cascade Does Not include Delete Because If a Comment is removed, the Dessert should remain
    //Eager OK because it allows Comment to access Dessert Data and it is not a large amount of data
    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @NotNull
    @JoinColumn(name = "dessertid")
    //@Column(name = "dessertid")
     private Dessert dessert;
    @NotNull
    @Column(name = "postedby")
    @Size(min = 1, max = 50, message = "1-50 characters")
     private  String postedBy;
    @NotNull
    @Column(name = "title")
    @Size(min = 1, max = 50, message = "1-50 characters")

    private String title;
    @NotNull
    @Column(name = "body")
    @Size(min = 1, max = 1000, message = "1-1000 characters")

    private String body;


    public Comment()
    {

    }



    public Comment(Dessert dessert, String postedBy, String title, String body) {
        this.dessert = dessert;
        this.postedBy = postedBy;
        this.title = title;
        this.body = body;
    }

    public Comment(String postedBy, String title, String body) {
        this.postedBy = postedBy;
        this.title = title;
        this.body = body;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
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

    @Override
    public String toString()
    {
        String output;
        output = "Comment:{\nCommentID: "+getCommentID() +
                "\nDessertID: "+getDessert().getDessertID()+
                "\nTitle: "+getTitle()+
                "\nBody: "+getBody()+
                "\nPostedBy: "+getPostedBy()+
                "\n}";
        return output;
    }
}
