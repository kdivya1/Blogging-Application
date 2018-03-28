package pl.divya.blog.dao;


import pl.divya.blog.entity.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);
    User getUserByName(String name);
    void deleteUser(int id);
    List<User> getAllUsers();
    void addNewUser(User user);
    void deleteAllUsers();
}
