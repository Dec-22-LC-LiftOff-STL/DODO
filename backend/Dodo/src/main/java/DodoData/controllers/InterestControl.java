package DodoData.controllers;

import DodoData.models.DodoRepos.InterestsTypeRepository;
import DodoData.models.DodoRepos.ProfileRepository;
import DodoData.models.DodoRepos.UserRepository;
import DodoData.models.InterestsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static DodoData.models.InterestsType.userValue;

@Controller
//@ComponentScan
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class InterestControl {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private InterestsTypeRepository interestsTypeRepository;

    @Autowired
    private UserRepository userRepository;

    private List<InterestsType> userChoices;

    //GetMapping()
    public String showUserChoices(Model model) {
        userChoices = InterestsTypeRepository.findByUserValueTrue(true);
        model.addAttribute("savedInterests", userChoices);
        return "MyNest";
    }

//    @GetMapping()
    public String interestOptions(Model model){
        model.addAttribute("interests", interestsTypeRepository.findAll());
        return "redirect";
    }

//    @GetMapping()
    public String interestChoices(){
        List<Iterable> choices = new ArrayList<>();
        choices.add(interestsTypeRepository.findAll());

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
