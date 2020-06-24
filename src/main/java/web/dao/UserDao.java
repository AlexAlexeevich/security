package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(web.model.User user);
    void updateUser(User user);
    void deleteUser(Long id);
    web.model.User getUserById(Long id);
    List<User> getAllUsers();
    User findByUserName(String name);
}
