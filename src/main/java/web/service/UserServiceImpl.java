package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public User getUser(String login) {
        User temp = userDao.findByUserName(login);
        return temp;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        User userFromDB = userDao.findByUserName(user.getName());
        if (userFromDB != null) {
            return;
        }
        //user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        //user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> listRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getUserByName(name);
    }
}
