package DodoData.models.DodoRepos;

import DodoData.models.InterestsType;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface InterestsTypeRepository extends JpaRepository<InterestsType, Id> {
    List<InterestsType> CHOICES = new ArrayList<>();
    static List<InterestsType> findByUserValueTrue(Boolean userValue){

        return CHOICES;
    }

}

