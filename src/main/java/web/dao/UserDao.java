package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> show();
    User getUser(Long id);
    void update(Long id);
    void delete(Long id);

    Role getByRoleName(String roleName);

    UserDetails getByEmail(String email);
}
