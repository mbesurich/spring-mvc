package web.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }
//        if (user.getId() == null) {
//            em.persist(user);
//        } else {
//            em.merge(user);
//        }
//    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.roleSet", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteUserById(Long id) {
        em.remove(getUserById(id));
    }

    @Override
    public User getUserByEmail(String email) {
        return em
                .createQuery("SELECT u FROM User u WHERE u.email LIKE :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
