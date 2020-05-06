package dao;

import entity.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements api.UserDao{

    String fileName;

    public UserDaoImpl (String fileName){
        this.fileName = fileName;
    }

    public List<User> getAllUsersFromFile() throws IOException {
        List<User> users = new ArrayList<User>();

        BufferedReader usersReader = new BufferedReader(new FileReader(fileName));
        String readOneLine = usersReader.readLine();
        while(readOneLine != null) {
            String holder[] = readOneLine.split("-");

            Long userId = Long.parseLong(holder[0]);
            String userLogin = holder[1];
            String userPassword = holder[2];

            users.add(new User(userId, userLogin, userPassword));
            readOneLine = usersReader.readLine();
        }
        usersReader.close();
        return users;
    }

    public void saveUserToFile(User user) throws IOException{
        PrintWriter userWriter = new PrintWriter(fileName);
        userWriter.write(user.toString());
        userWriter.close();
    }

    public void saveUsersToFile(List<User> users) throws IOException{
        PrintWriter usersWriter = new PrintWriter(fileName);
        for(User user:users){
            usersWriter.write(user.toString());
        }
        usersWriter.close();
    }

    public User getUserByIdFromFile(Long userId) throws IOException{
        List<User> users = getAllUsersFromFile();
        for(User user:users){
            if(user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public User getUserByLoginFromFile(String userLogin) throws IOException{
        List<User> users = getAllUsersFromFile();
        for(User user:users){
            if(user.getLogin().equals(userLogin)){
                return user;
            }
        }
        return null;
    }

    public void removeUserByIdFromFile (Long userId) throws IOException{
        List<User> users = getAllUsersFromFile();
        for(User user:users){
            if(user.getId().equals(userId)){
                users.remove(user);
            }
            saveUsersToFile(users);
        }
    }

    public void removeUserByLoginFromFile(String userLogin) throws IOException{
        List<User> users = getAllUsersFromFile();
        for(User user:users){
            if(user.getLogin().equals(userLogin)){
                users.remove(user);
            }
            saveUsersToFile(users);
        }
    }




}
