package service;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testGetAllUsers(){
        // is
        List<User> users = new ArrayList<User>();
        users.add(new User(1l, "admin", "admin"));
        users.add(new User(2l, "pablo", "pablo"));
        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        List<User> usersFromTestClass = userService.getAllUsers();
        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testAddUser(){
        //is
        List<User> users = new ArrayList<User>();
        User user = new User(1l, "kuba","kuba");
        users.add(user);
        //then
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
        List<User> usersFromTestClass = userService.getAllUsers();
        //expected
        Assert.assertEquals(users, usersFromTestClass);
    }

    @Test
    public void testRemoveUserById(){
        //is
        List<User> users = new ArrayList<User>();
        User admin = new User(1l,"admin","admin");
        User pablo = new User(2l, "pablo","pablo");
        users.add(admin);
        users.add(pablo);
        //then
        UserServiceImpl userService = new UserServiceImpl(users);
        users.remove(0);
        userService.removeUserById(1l);
        List<User> usersFromTestClass = userService.getAllUsers();
        //expected
        Assert.assertEquals(users,usersFromTestClass);

    }
}
