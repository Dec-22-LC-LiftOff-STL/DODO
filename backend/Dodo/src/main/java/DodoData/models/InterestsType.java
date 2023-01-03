package DodoData.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@EntityScan
public class InterestsType extends IdAbstract{

    private String interestsType;

    public static Boolean userValue;

    public InterestsType(String type, boolean value){
        this.interestsType = type;
        this.userValue = value;
    }

    public InterestsType(){

    }

    //Getters and Setters

    public String getInterestsType() {
        return interestsType;
    }

    public void setInterestsType(String interestsType) {
        this.interestsType = interestsType;
    }

    public static Boolean getUserValue() {
        return userValue;
    }

    public static void setUserValue(Boolean userValue) {
        InterestsType.userValue = userValue;
    }
}
