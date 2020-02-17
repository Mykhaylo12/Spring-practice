package spring.practice.dao;

import spring.practice.model.User;
import java.util.List;

public interface UserDao {
    public void add(User user);

    public List<User> getListOfUsers();

    User getUsersbyId(Long id);
}
