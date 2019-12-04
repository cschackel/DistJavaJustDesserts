package JustDessert.Service;

import JustDessert.entity.Comment;

import java.util.Collection;

public interface ICommentService {
    Collection<Comment> getComments();

    void saveComment(Comment newComment);

    Comment getCommentByID(int ID);

    void DeleteCommentByID(int ID);
}
