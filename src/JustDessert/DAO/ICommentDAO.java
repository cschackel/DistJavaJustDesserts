package JustDessert.DAO;

import JustDessert.entity.Comment;

import java.util.Collection;

public interface ICommentDAO {
    Collection<Comment> getComments();

    void saveComment(Comment newComment);

    Comment getCommentByID(int ID);

    void DeleteCommentByID(int ID);
}
