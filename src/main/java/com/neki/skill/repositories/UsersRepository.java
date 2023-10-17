package com.neki.skill.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neki.skill.entities.UserSkills;
import com.neki.skill.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT us FROM UserSkills us WHERE us.users.idUsers = :idUsers")
    List<UserSkills> findByUsersId(@Param("idUsers") Long idUsers);
    
}
