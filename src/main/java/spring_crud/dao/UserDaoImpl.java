package spring_crud.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring_crud.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    //один Entity Manager на одну транзакцию приложения
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userTemp = entityManager.find(User.class, id);
        userTemp.setName(updatedUser.getName());
        userTemp.setAge(updatedUser.getAge());
        userTemp.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(showUser(id));
    }
}
