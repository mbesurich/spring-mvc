package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void update(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUserById(Long id);
    User getUserByEmail(String email);
}
