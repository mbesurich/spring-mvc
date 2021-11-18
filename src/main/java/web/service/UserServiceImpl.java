package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService{

    private UserDao userDAO;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public List<User> show(int quantity) {
        return userDAO.show(quantity);
    }

    @Transactional
    @Override
    public void update(Long id) {
        userDAO.update(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
