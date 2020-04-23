package api;

import entity.User;
import java.util.List;

public interface UserService {

    // public UserService(){}

    List<User> getAllUsers();
    void addUser(User user);
    void removeUserById(Long userId);

    }


