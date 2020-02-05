package com.spring.lesson3.rest_part1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.id.factory.IdentifierGeneratorFactory;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString (exclude = {"user"})
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int value;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}

