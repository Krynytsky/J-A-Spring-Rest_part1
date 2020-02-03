package com.spring.lesson3.rest_part1.controllers;

import com.spring.lesson3.rest_part1.models.Skill;
import com.spring.lesson3.rest_part1.models.User;
import com.spring.lesson3.rest_part1.repository.SkillRepo;
import com.spring.lesson3.rest_part1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class MainController {

//    private List<User> users = new ArrayList<User>(){{
//        this.add(new User(1,"Kristy"));
//        this.add(new User(2,"Viki"));
//        this.add(new User(3,"Luis"));
//        this.add(new User(4,"Peter"));
//
//    }};
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SkillRepo skillRepo;



    @GetMapping("/users")
    private  //@ResponseBody
    List<User> users(){
        return userRepo.findAll();
    }

    @PostMapping("/users/{name}/{skills}")
    public void saveUser(@PathVariable String name, @PathVariable String skills){
        String[] split = skills.split("_");
//?????????????????????????????????????????????
//        List<Skill> skillList = new ArrayList<>();
//        for (String skill : split) {
//            Skill singleSkill = Skill.builder().title(skill).build();
//            skillList.add(singleSkill);
//        }
//        Stream<String> stringStream =
        List<Skill> skillList = Stream.of(split).map(s -> Skill.builder().title(s)
                .build()).collect(Collectors.toList());

        System.out.println("before"+" "+ skillList);
        User user = userRepo.save(new User(name));

        skillList.stream().forEach(skill -> {
            skill.setUser(user);
            skillRepo.save(skill);
        });
        System.out.println("after"+" "+ skillList);
    }
}
