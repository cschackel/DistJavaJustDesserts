package springxml.beans;

import springxml.services.LoggerService;

import java.io.Serializable;

public class Category implements Serializable {

    private int categoryID;
    private String categoryName;
    private LoggerService ls;

    public Category(LoggerService ls) {
        this.ls = ls;
        logInfo("Created a new category");
    }

    public Category()
    {

    }

    public void setLs(LoggerService ls) {
        this.ls = ls;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
        logInfo("Category ID set to "+ categoryID);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        logInfo("Category Name set to "+ categoryName);
    }

    public void logInfo(String message)
    {
        ls.info(message);
    }

    public void logError(String message)
    {
        ls.error(message);
    }

    public void logWarning(String message)
    {
        ls.warning(message);
    }
}


