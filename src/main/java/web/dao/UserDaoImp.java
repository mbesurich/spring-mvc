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
public class UserDaoImp implements UserDao{

    private EntityManagerFactory entityManagerFactory;
    private List<User> users = null;

    @Autowired
    public UserDaoImp(EntityManagerFactory entityManagerFactory) {
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
    public List<User> show() {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = entityManagerFactory.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            users = em.createQuery("SELECT u FROM User u").getResultList();

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
            return users;
    }

    @Override
    public User getUser(int id) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            em = entityManagerFactory.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            user = em.find(User.class, id);
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
        return user;
    }

    @Override
    public void update(int id) {
//        EntityManager em = null;
//        EntityTransaction transaction = null;
//        try {
//            em = entityManagerFactory.createEntityManager();
//            transaction = em.getTransaction();
//            transaction.begin();
//
//            User user = em.find(User.class, id);
//            user.
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//        } finally {
//            if (em != null && em.isOpen()) {
//                em.close();
//            }
//        }
    }

    @Override
    public void delete(int id) {
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
