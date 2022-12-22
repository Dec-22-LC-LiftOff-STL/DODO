package DodoData.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EntityScan
public class InterestsType {

    private Integer userId;
    @Id
    @GeneratedValue
    private Integer interestsId;

    private String interestsType;

    public static Boolean userValue;

    public InterestsType(int userId, int id, String type, boolean value){
//        this.userId = userId;
        this.interestsId = id;
        this.interestsType = type;
        this.userValue = value;
    }

    public InterestsType(){

    }



}
