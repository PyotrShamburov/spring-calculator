package by.home.service;

import by.home.entity.User;
import by.home.entity.exception.UserAlreadyExistsException;
import by.home.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserStorage userStorage;

    public boolean addToStorage(User user) {
        if (!userStorage.contains(user)) {
            userStorage.save(user);
            return true;
        }
        throw new UserAlreadyExistsException("User with this login already exists!");
    }
    public User checkByLogin(String login) {
        return userStorage.getByLogin(login);
    }

    public boolean passwordCheck(User user, String password) {
        return user.getPassword().equals(password);
    }
}
