package JustDessert.DAO;

import JustDessert.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Collection;

@Repository
public class CommentDAO implements ICommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<Comment> getComments() {
        Session session = sessionFactory.getCurrentSession();

        Collection<Comment> allComments = session.createQuery("from Comment", Comment.class).getResultList();

        return allComments;
    }

    @Override
    public void saveComment(Comment newComment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(newComment);
    }

    @Override
    public Comment getCommentByID(int ID) {
        Session session = sessionFactory.getCurrentSession();
        Comment targetComment;
        targetComment = session.get(Comment.class,ID);
        return targetComment;
    }

    @Override
    public void DeleteCommentByID(int ID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Comment c where c.commentID  = :ID");
        query.setParameter("ID", ID);

        query.executeUpdate();
    }
}
