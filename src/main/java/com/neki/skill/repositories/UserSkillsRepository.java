package com.neki.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.skill.entities.UserSkills;

public interface UserSkillsRepository extends JpaRepository<UserSkills, Long> {
    
}
