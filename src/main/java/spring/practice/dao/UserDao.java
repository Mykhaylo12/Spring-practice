package spring.practice.dao;

import java.util.List;
import spring.practice.model.User;

public interface UserDao {
    public void add(User user);

    public List<User> getListOfUsers();

    User getUsersbyId(Long id);
}
