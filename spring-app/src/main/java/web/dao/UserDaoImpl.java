package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    @Override
    public void delete(User user) {
        entityManager.merge(user);
        entityManager.remove(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
        entityManager.persist(user);
    }
}
