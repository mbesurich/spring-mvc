package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> show();
    User getUser(Long id);
    void update(Long id);
    void delete(Long id);

}
