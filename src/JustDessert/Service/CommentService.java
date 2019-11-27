package JustDessert.Service;

import JustDessert.DAO.ICommentDAO;
import JustDessert.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentDAO commentDAO;

    @Transactional
    @Override
    public Collection<Comment> getComments() {
        return commentDAO.getComments();
    }

    @Transactional
    @Override
    public void saveComment(Comment newComment) {
        commentDAO.saveComment(newComment);
    }

    @Transactional
    @Override
    public Comment getCommentByID(int ID) {
        return commentDAO.getCommentByID(ID);
    }
}
