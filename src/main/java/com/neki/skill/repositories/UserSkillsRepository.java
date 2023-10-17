package com.neki.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.skill.entities.Skills;
import com.neki.skill.entities.UserSkills;
import com.neki.skill.entities.Users;

public interface UserSkillsRepository extends JpaRepository<UserSkills, Long> {
    UserSkills findByUsersAndSkills(Users users, Skills skills);
}
