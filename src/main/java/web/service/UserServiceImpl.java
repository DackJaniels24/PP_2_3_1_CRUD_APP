package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.userDAO.UserDao;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    @Transactional
    public List<User>index(){
        return userDao.index();
    }

    @Override
    @Transactional
    public User show(Integer id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void remove(int id) {
        userDao.remove(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

}