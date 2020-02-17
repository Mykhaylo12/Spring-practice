package spring.practice.service.impl;

import spring.practice.dao.UserDao;
import spring.practice.model.User;
import spring.practice.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
    }

    @Override
    public User getUsersbyId(Long id) {
        return userDao.getUsersbyId(id);
    }
}
