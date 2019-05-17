package models;

import java.io.Serializable;

public class User implements Serializable {

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
        System.out.println("Parola: " + password);
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        text.append("User{id='");
        text.append(this.id);
        text.append("\'");
        text.append(",password='");
        text.append(this.password);
        text.append("\'}");

        return text.toString();
    }

}
