package com.spring.lesson3.rest_part1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString(exclude = {"skills"})
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Skill> skills = new ArrayList<>();
    private String email;
    private String password;

    public User() {
    }
    public User(String name, List<Skill> skills){
        this.name = name;
        this.skills = skills;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
