package DodoData.models;

import javax.persistence.Entity;

@Entity
public class UserInfo extends IdAbstract{

    private String name;

    private String password;

    //Constructors

    public UserInfo(String name, Integer id, Integer location, String email, String password) {
        this.name = name;
        this.password = password;
    }

    public UserInfo() {
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
