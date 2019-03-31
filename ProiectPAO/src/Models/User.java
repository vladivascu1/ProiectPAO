package Models;

public class User {

    protected String id;
    protected String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        this.id = "defaultid";
        this.password = "defaultpassword";
    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void afisareInfo()
    {
        System.out.println("ID: " + id);
    }



}
