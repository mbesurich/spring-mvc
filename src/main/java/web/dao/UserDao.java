package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> show();
    User getUser(int id);
    void update(int id);
    void delete(int id);

}
