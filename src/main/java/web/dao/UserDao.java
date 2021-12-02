package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

    void add(User user);
    List<User> show();
    User getUser(Long id);
    void delete(Long id);

    Role getRoleByName(String name);
    Set<Role> getAllRoles();

    User getByEmail(String email);
}
