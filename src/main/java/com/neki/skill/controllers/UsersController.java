package com.neki.skill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.skill.dto.UserSkillByIdDto;
import com.neki.skill.dto.UsersDto;
import com.neki.skill.entities.Users;
import com.neki.skill.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    UsersService usersService;

    @PostMapping
    public ResponseEntity<?> saveUsers(@RequestBody UsersDto usersDto) {
        Users users = usersService.saveUsers(usersDto);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("/user-skills/{idUsers}")
    public ResponseEntity<List<UserSkillByIdDto>> getSkillsByUsers(@PathVariable Long idUsers) {
        List<UserSkillByIdDto> user = usersService.finUserSkillsByIdUsers(idUsers);
        return ResponseEntity.ok(user);
    }
}
