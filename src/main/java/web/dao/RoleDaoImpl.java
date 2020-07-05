package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Role> getAllRoles() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();
    }

    @Override
    public Role getUserByName(String role) {
        List<Role> result = this.sessionFactory.getCurrentSession().createQuery("FROM Role WHERE role = :role")
                .setParameter("role", role).getResultList();
        if(result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
