package pl.divya.blog.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.divya.blog.dao.PostDao;
import pl.divya.blog.entity.Post;

import java.util.List;


@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Post> getAllPosts() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Post> query = currentSession.createQuery("from Post order by date desc", Post.class);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public List<Post> getPostsByLimit(int startPosition, int limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Post> query = currentSession.createQuery("from Post order by date desc", Post.class);
        query.setFirstResult(startPosition);
        query.setMaxResults(limit);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Post post = currentSession.get(Post.class, id);
        return post;
    }

    @Override
    public void addNewPost(Post post) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(post);
    }

    @Override
    public List<Post> getPostsByUser(int userId,int startPosition, int limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Post> query = currentSession.createQuery("from Post where id_user=:userId order by date desc");
        query.setParameter("userId", userId);
        query.setFirstResult(startPosition);
        query.setMaxResults(limit);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public List<Post> getPostsByCategory(int categoryId,int startPosition, int limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Post> query = currentSession.createQuery("from Post where id_category=:categoryId order by date desc");
        query.setParameter("categoryId", categoryId);
        query.setFirstResult(startPosition);
        query.setMaxResults(limit);
        List<Post> posts = query.getResultList();
        return posts;
    }

    @Override
    public void deletePost(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Post where id_post=:postId");
        query.setParameter("postId", id);
        query.executeUpdate();
    }

    @Override
    public void deletePostByAuthor(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Post where id_user=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public void deleteAllPosts() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Post");
        query.executeUpdate();
    }

    @Override
    public void deletePostByCategory(int categoryId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createSQLQuery("delete from tags where tags.id_post in (select posts.id_post from posts natural join categories where id_category=:categoryId)");
        query.setParameter("categoryId", categoryId);
        query.executeUpdate();
        query = currentSession.createQuery("delete from Post where id_category=:categoryId");
        query.setParameter("categoryId", categoryId);
        query.executeUpdate();
    }

    @Override
    public void updateCategory(int categoryId, String categoryName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("update Post set category=:categoryName where id_category=:categoryId");
        query.setParameter("categoryName", categoryName);
        query.setParameter("categoryId", categoryId);
        query.executeUpdate();
    }

    @Override
    public int postCount() {
        Session currrentSession = sessionFactory.getCurrentSession();
        return ((Long) currrentSession.createQuery("select count(*) from Post").uniqueResult()).intValue();
    }

    @Override
    public int postCountByCategory(int categoryId) {
        Session currrentSession = sessionFactory.getCurrentSession();
        Query query = currrentSession.createQuery("select count(*) from Post where id_category=:categoryId");
        query.setParameter("categoryId", categoryId);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public int postCountByUser(int userId) {
        Session currrentSession = sessionFactory.getCurrentSession();
        Query query = currrentSession.createQuery("select count(*) from Post where id_user=:userId");
        query.setParameter("userId", userId);
        return ((Long) query.uniqueResult()).intValue();
    }

}
