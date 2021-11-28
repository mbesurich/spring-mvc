package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> show();
    User getUser(Long id);
    void delete(Long id);

    @Transactional
    Role getByRoleName(String roleName);
}
