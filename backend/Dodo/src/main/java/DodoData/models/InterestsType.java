package DodoData.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.type.AnyType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class InterestsType extends IdAbstract{

    Boolean interestsChecked;

    String interestName;
//    private Map<String, String> savedInterests;
//    @JsonAnySetter
//    public void savedInterestsJson(String key, String value) {
//        savedInterests.put(key, value);
//    }

//    public Map<String, String> getSavedInterests() {
//        return savedInterests;
//    }
//
//    public void setSavedInterests(Map<String, String> savedInterests) {
//        this.savedInterests = savedInterests;
//    }

//    static HashMap<String, List> searchInterests = new HashMap<>();

//    static List<String> interestTypes = new ArrayList<>();
//    public static String[] interestsArray = {
//            "Music", "Outdoors", "Gaming", "Nature", "Art", "Sports", "Nightlife", "Food", "History", "ScienceTechnology", "Culture", "Fashion", "Books", "Movies", "HealthWellness"
//    };
//    public String interestItem(){
//        for (String interest : interestsArray) {
//            interestsType = interest;
//        }
//        return interestsType;
//    }

//    constructors
    public InterestsType(Boolean check, String name){
        this.interestsChecked = check;
        this.interestName = name;
    }

    public InterestsType(){

    }

    //Getters and Setters

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public Boolean getInterestsChecked() {
        return interestsChecked;
    }

    public void setInterestsChecked(Boolean check) {
        this.interestsChecked = check;
    }

}
