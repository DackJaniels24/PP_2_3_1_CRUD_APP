package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(Integer id);

    void remove(int id);

    void update(int id, User user);

    void save(User user);
}

