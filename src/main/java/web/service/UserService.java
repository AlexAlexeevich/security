package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUser(String login);
    void addUser(User user);
    List<User> listUsers();
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(long id);
}
