package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
    }

    @Override
    public List<User> show() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        em.remove(getUser(id));
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) em
                .createQuery("SELECT r FROM Role r WHERE r.name LIKE :role")
                .setParameter("role", name)
                .getSingleResult();
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<Role>(em.createQuery("SELECT r FROM Role r").getResultList());
    }

    @Override
    public User getByEmail(String email) {
        return (User) em
                .createQuery("SELECT u FROM User u WHERE u.email LIKE :email")
                .setParameter("email", email)
                .getSingleResult();
    }
}
