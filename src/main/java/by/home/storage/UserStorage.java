package by.home.storage;

import by.home.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private static int idCounter = 1;
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        user.setId(idCounter++);
        users.add(user);
    }
    public boolean contains(User user) {
        return users.contains(user);
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
