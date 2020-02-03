package com.spring.lesson3.rest_part1.repository;

import com.spring.lesson3.rest_part1.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill, Integer> {
}

