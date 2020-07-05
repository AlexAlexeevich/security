package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Long id) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return this.sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findByUserName(String name) {
        List<User> result = this.sessionFactory.getCurrentSession().createQuery("FROM User WHERE name = :name")
                .setParameter("name", name).getResultList();
        if(result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
