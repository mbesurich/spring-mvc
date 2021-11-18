package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOimpl implements UserDao{

    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("BMW", "1", "100"));
        users.add(new User("BMW2", "2", "6"));
        users.add(new User("BMW3", "3", "7"));
        users.add(new User("BMW4", "4", "8"));
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public List<User> show(int quantity) {
        if (quantity > users.size()) {
            return users;
        } else {
            return users.subList(0, quantity);
        }
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
