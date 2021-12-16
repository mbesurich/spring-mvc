package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void addUser(User user);
    void update(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUserById(Long id);
    Set<Role> getAllRoles();
    Role getRoleByName(String name);
    Set<Role> getRolesByNames(String[] names);
    User getUserByEmail(String email);
}
