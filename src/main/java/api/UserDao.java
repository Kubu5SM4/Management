package api;
import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    public List<User> getAllUsersFromFile() throws IOException;
    public User getUserByIdFromFile(Long userId) throws IOException;
    public User getUserByLoginFromFile(String userLogin) throws IOException;
    public void saveUsersToFile(List<User> users) throws IOException;
    public void saveUserToFile(User user) throws IOException;
    public void removeUserByIdFromFile(Long userId) throws IOException;
    public void removeUserByLoginFromFile(String userName) throws IOException;
}
