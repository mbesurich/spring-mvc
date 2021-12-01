package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void add(User user);
    List<User> show();
    User getUser(Long id);
    void delete(Long id);
    Set<Role> getAllRoles();
    Role getRoleById(String id);
}
