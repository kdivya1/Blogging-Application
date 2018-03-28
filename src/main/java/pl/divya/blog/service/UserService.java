package pl.divya.blog.service;


import pl.divya.blog.entity.User;

import java.util.List;

public interface UserService {

    void addNewUser(User user);

    User getUserById(int id);

    User getUserByName(String name);

    void deleteUser(int id);

    List<User> getAllUsers();

    void deleteAllUsers();
}
