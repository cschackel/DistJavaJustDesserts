package springxml.beans;

import springxml.services.LoggerService;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentID;
    private int dessertID;
    private String postedBy;
    private String title;
    private String body;
    private LoggerService ls;


    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getDessertID() {
        return dessertID;
    }

    public void setDessertID(int dessertID) {
        this.dessertID = dessertID;
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
}
