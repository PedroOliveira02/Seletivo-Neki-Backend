package com.neki.skill.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.neki.skill.entities.UserSkills;
import com.neki.skill.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login);

    @Query(value = "SELECT us FROM UserSkills us WHERE us.users.idUsers = :idUsers")
    List<UserSkills> findByUsersId(@Param("idUsers") Long idUsers);

}
