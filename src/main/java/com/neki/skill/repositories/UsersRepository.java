package com.neki.skill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neki.skill.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
