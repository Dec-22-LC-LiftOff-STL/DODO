package DodoData.controllers;

import DodoData.dto.InterestsDTO;
import DodoData.dto.MessageResponse;
import DodoData.models.DodoRepos.BuildNestURL;
import DodoData.models.DodoRepos.InterestsTypeRepository;
import DodoData.models.DodoRepos.UserRepository;
import DodoData.models.InterestsPOJO;
import DodoData.models.InterestsType;
import DodoData.models.Json;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.apache.commons.io.IOUtils;
import org.hibernate.mapping.Map;
//import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class InterestControl {

    @Autowired
    InterestsTypeRepository interestsTypeRepository;

    @Autowired
    UserRepository userRepository;

    public HashMap<String, Boolean> userChoices;

    public List<Boolean> userList;

    private static final ObjectMapper objectMapper = getDefaultObjectMapper();

    private static BuildNestURL site;

    static {
        try {
            site = getDefaultSite();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder json = new StringBuilder();

    public InterestControl() throws MalformedURLException {
    }

    private static BuildNestURL getDefaultSite() throws MalformedURLException {
        BuildNestURL defaultSite = new BuildNestURL();
        return defaultSite;
    }

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

//    @PostMapping("/buildnest")
//    public static <A> A fromJson(@RequestBody JsonNode node, Class<A> clazz) throws JsonProcessingException {
//
//        InterestsPOJO pojo = Json.fromJson(node, InterestsPOJO.class);
//
//        System.out.println("Here is your InterestsPOJO: " + pojo);
//
//        return objectMapper.treeToValue(node, clazz);
//    }

    public static String stream(URL site) {
        try (InputStream input = site.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            System.out.println("Json from stream: " + json);
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @PostMapping("/buildnest")
    public static <A> A fromJson(Class<A> clazz) throws JsonProcessingException {

        try (InputStream input = site.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            System.out.println("Json from stream: " + json);
            json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonNode node = Json.parse(json.toString());
        InterestsPOJO pojo = Json.fromJson(node, InterestsPOJO.class);

        System.out.println("Here is your InterestsPOJO: " + pojo);

        return objectMapper.treeToValue(node, clazz);
    }


//    @PostMapping ("/buildnest")
//    public ResponseEntity<?> userInterests(@RequestBody InterestsDTO savedInterest){
//
//        if (savedInterest.getInterestsChecked() != null){
//            userList.add(savedInterest.getInterestsChecked());
//        }
//        InterestsType interestsType = new InterestsType(savedInterest.getInterestsChecked(), savedInterest.getInterestName());
////        userChoices.put(savedInterest.getInterestName(), savedInterest.getInterestsChecked());
//
//        interestsTypeRepository.save(interestsType);
//        System.out.println(savedInterest.getInterestsChecked());
//        System.out.println(userList);
//
//        return ResponseEntity.ok(new MessageResponse("Interests saved!"));
//    }




//    https://www.javaguides.net/2019/07/objectmapper-json-to-java-object.html
//    @PostMapping("/buildnest")
//    public ObjectMapper returnInterestsObject(@RequestBody InterestsDTO savedInterest) throws JsonParseException, JsonMappingException, IOException{
//        InterestsType interestsType =
//                new InterestsType(savedInterest.getInterestsChecked(),
//                        savedInterest.getInterestName());
//        interestsTypeRepository.save(interestsType);
//        System.out.println(savedInterest.getInterestsChecked());
//
//        ObjectMapper interestsMapper = new ObjectMapper();
//        InputStream fileInputStream = new FileInputStream("http://localhost:4200/buildnest");
//        InterestsType typeInterests = interestsMapper.readValue(fileInputStream, InterestsType.class);
//        fileInputStream.close();
//
//        System.out.println("Interests saved!");
//
//        return interestsMapper;
//    }




//    @PostMapping("/buildnest")
//    public InterestsType returnInterestsTypeMap(@RequestBody @RequestParam InterestsType savedInterests, InterestsDTO interests) throws JsonProcessingException {
//
//        InterestsType interestsType = new InterestsType(savedInterests.savedInterestsJson(AnyType, AnyType));
//        ObjectMapper jsonInterests = new ObjectMapper()
//                .readerFor(ObjectMapper.class)
//                .readValue("http://localhost:4200/buildnest");
//
//        return savedInterests;
//    }




//    public static InterestsType getJsonInterests(URL "http://localhost:4200/buildnest") {
//            String json =IOUtils.toString(http:://localhost:4200/buildnest, Charset.forName("UTF-8"));
//        return new InterestsType(json);
//    }


}
