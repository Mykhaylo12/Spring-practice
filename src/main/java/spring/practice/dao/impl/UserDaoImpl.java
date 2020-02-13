package spring.practice.dao.impl;

import spring.practice.dao.UserDao;
import spring.practice.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add user to DB", e);
        }
    }

    public List<User> getListOfUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> from_user = sessionFactory.openSession()
                    .createQuery("from User", User.class);
            return from_user.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Cat't get all users from DB", e);
        }
    }
}
