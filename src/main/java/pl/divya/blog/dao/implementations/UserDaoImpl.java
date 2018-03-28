package pl.divya.blog.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.divya.blog.dao.UserDao;
import pl.divya.blog.entity.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Override
    public User getUserByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where username=:name");
        query.setParameter("name", name);
        User user = (User) query.getResultList().get(0);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from User where id_user=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<User> users = currentSession.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Override
    public void addNewUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void deleteAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from User");
        query.executeUpdate();
    }
}
