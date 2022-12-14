package DodoData.models;

import javax.persistence.*;

@Entity
public class Profile extends IdAbstract{

    private Integer location;

    private String email;

    @OneToOne
    private User thisUser;

    //Constructors

    public Profile(int location, String email, User thisUser ) {
        this.location = location;
        this.email = email;
        this.thisUser = thisUser;
    }

    public Profile() {
    }

    //Getters and Setters

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getThisUser() {return thisUser;}

    public void setThisUser(User thisUser) { this.thisUser = thisUser;}


}
