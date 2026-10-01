package vn.minxi.service.impl;

import java.util.List;
import vn.minxi.dao.IUserDao_24162005;
import vn.minxi.dao.impl.UserDaoImpl_24162005;
import vn.minxi.entity.User_24162005;

public class UserServiceImpl_24162005 {
    private IUserDao_24162005 userDao = new UserDaoImpl_24162005();

    public User_24162005 findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void insert(User_24162005 user) {
        userDao.insert(user);
    }

    public void update(User_24162005 user) {
        userDao.update(user);
    }

    public void delete(String username) {
        userDao.delete(username);
    }

    public List<User_24162005> findAll(int page, int pageSize) {
        return userDao.findAll(page, pageSize);
    }

    public int count() {
        return userDao.count();
    }
}