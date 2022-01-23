package spring_crud.service;

import spring_crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User showUser(int id);

    void update(int id, User user);

    void delete(int id);
}
