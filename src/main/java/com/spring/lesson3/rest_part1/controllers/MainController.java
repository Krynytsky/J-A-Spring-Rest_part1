package com.spring.lesson3.rest_part1.controllers;

import com.spring.lesson3.rest_part1.models.User;
import com.spring.lesson3.rest_part1.repository.SkillRepo;
import com.spring.lesson3.rest_part1.repository.UserRepo;
import com.spring.lesson3.rest_part1.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private EmailService emailService;


//    @PostMapping("/users/{name}/{skills}")
//    public void saveUser(@PathVariable String name, @PathVariable String skills){
//        String[] split = skills.split("_");
//
//        List<Skill> skillList = Stream.of(split).map(s -> Skill.builder().title(s)
//                .build()).collect(Collectors.toList());
//
//        System.out.println("before"+" "+ skillList);
//        User user = userRepo.save(new User(name));
//
//        skillList.stream().forEach(skill -> {
//            skill.setUser(user);
//            skillRepo.save(skill);
//        });
//        System.out.println("after"+" "+ skillList);
//    }
@PostMapping("/users")
 public List<User> saveUser(@RequestBody User user){

    userRepo.save(user);
    user.getSkills().forEach(skills -> {
        skills.setUser(user);
        skillRepo.save(skills);
    });

    emailService.send(user);
    return userRepo.findAll();
 }

 @PostMapping("/login")
  public String login(@RequestBody User user){
     return"";
  }


}
