package DodoData.controllers;

import DodoData.models.DodoRepos.InterestsTypeRepository;
import DodoData.models.InterestsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static DodoData.models.InterestsType.userValue;

@Controller
//@ComponentScan
public class InterestControl {

    @Autowired
    private InterestsTypeRepository interestsRepo;

    private List<InterestsType> userChoices;

    //GetMapping()
    public String showUserChoices(Model model, int userId) {
        userChoices = InterestsTypeRepository.findByUserValueTrue(true);
        model.addAttribute("savedInterests", userChoices);
        return "MyNest";
    }

    //@GetMapping()
    public String interestOptions(Model model){
        model.addAttribute("interests", interestsRepo.findAll());
        return "redirect";
    }



//    @GetMapping()
    public String interestChoices(){
        List<Iterable> choices = new ArrayList<>();
        choices.add(interestsRepo.findAll());

        List<Iterable> profileInterests = new ArrayList<>();

        for ( Iterable choice : choices) {
            if (userValue){
                profileInterests.add(choice);
            }
            return profileInterests.toString();
        }

        return "userProfile";
    }

}
