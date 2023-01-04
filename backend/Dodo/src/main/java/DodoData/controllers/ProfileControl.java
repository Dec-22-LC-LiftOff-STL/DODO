package DodoData.controllers;

import DodoData.models.DodoRepos.InterestsTypeRepository;
import DodoData.models.DodoRepos.ProfileRepository;
import DodoData.models.DodoRepos.UserInfoRepository;
import DodoData.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;

@Controller
public class ProfileControl {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private InterestsTypeRepository interestsTypeRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("buildnest")
    public String displayBuildNest(Model model){

        model.addAttribute(new Profile());

        return "buildnest";
    }


}
