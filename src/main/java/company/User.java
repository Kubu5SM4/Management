package company;

public class User {

    protected int id;
    protected String login;
    protected String password;

    public User(int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId(){
        return id;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword (){
        return password;
    }

    public String toString(){
        return "\nUSER ID: " +id+
                ", \nLOGIN: " +login+
                ", \nPASSWORD: " +password+"\n";}



}
