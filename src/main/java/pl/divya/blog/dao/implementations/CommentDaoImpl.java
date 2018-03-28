package pl.divya.blog.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.divya.blog.dao.CommentDao;
import pl.divya.blog.entity.Comment;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Comment> getCommentsByPostId(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Comment> query = currentSession.createQuery("from Comment where id_post=:postId order by date desc");
        query.setParameter("postId", id);
        List<Comment> commentsByPost = query.getResultList();
        return commentsByPost;
    }

    @Override
    public void addNewComment(Comment comment) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(comment);
    }

    @Override
    public void deleteCommentsByPost(int postId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Comment where id_post=:postId");
        query.setParameter("postId", postId);
        query.executeUpdate();
    }

    @Override
    public void deleteCommentsByUser(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createSQLQuery("delete from comments where id_post in (select id_post from posts natural join users where id_user=:userId)");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    public void deleteAllComments() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Comment");
        query.executeUpdate();
    }

    @Override
    public void deleteCommentsByCategory(int categoryId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createSQLQuery("delete from comments where id_post in (select id_post from posts natural join categories where id_category=:categoryId)");
        query.setParameter("categoryId", categoryId);
        query.executeUpdate();
    }
}
