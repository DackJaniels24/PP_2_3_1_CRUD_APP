package web.userDAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDAO {
    public List<User> list;
    private static int USERS_COUNT;
    {
        list = new ArrayList<>();
        list.add(new User(++USERS_COUNT,"Alex", "Frost", 18));
        list.add(new User(++USERS_COUNT,"John", "Wayne", 19));
        list.add(new User(++USERS_COUNT,"Tom", "Ford", 20));
    }
    public List<User>index(){
        return list;
    }
    public User show(int id) {
        return list.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    @Override
    public void add(User user) {
    }
    public void remove(int id) {
        list.removeIf(u -> u.getId() == id);
    }
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setAge(updatedUser.getAge());
    }
    public void save(User user) {
        user.setId(++USERS_COUNT);
        list.add(user);
    }
}
