package model.daoImpl;

import model.dao.UserDao;
import model.entities.User;
import model.util.GenerateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private final EntityManager em;
    public UserDaoImpl() {
        em = GenerateEntityManager.createEntityManager();
    }

    @Override
    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public Map<Integer, User> findAll() {
        Query query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> list = query.getResultList();

        Map<Integer, User> map = new HashMap<>();
        for (User u : list) {
            map.put(u.getId(), u);
        }
        return map;
    }

    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User update(User user) {
        em.getTransaction().begin();
        User updatedUser = em.merge(user);
        em.getTransaction().commit();
        return updatedUser;
    }

    @Override
    public void delete(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.remove(user);
        em.getTransaction().commit();
    }
}
