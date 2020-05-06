package entity;

public class User {

    protected Long id;
    protected String login;
    protected String password;

    public User(Long id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Long getId(){
        return id;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword (){
        return password;
    }

    public String toString(){
        return  id+ "-" +
                login+ "-" +
                password+"\n";}



}
