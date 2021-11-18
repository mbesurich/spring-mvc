package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOimpl implements UserDao{

    private EntityManagerFactory entityManagerFactory;
    private List<User> users = null;

    @Autowired
    public UserDAOimpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

//
//    {
//        users = new ArrayList<>();
//        users.add(new User("BMW", "1", "100"));
//        users.add(new User("BMW2", "2", "6"));
//        users.add(new User("BMW3", "3", "7"));
//        users.add(new User("BMW4", "4", "8"));
//    }

    @Override
    public void add(User user) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = entityManagerFactory.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<User> show(int quantity) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = entityManagerFactory.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            users = em.createQuery("From User").getResultList();


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
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
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = entityManagerFactory.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.createQuery("delete from User where id=: id")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    }
}
