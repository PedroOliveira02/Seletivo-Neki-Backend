package com.neki.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.skill.entities.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
    
}
