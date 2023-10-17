package com.neki.skill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.skill.dto.UserSkillsDto;
import com.neki.skill.entities.UserSkills;
import com.neki.skill.service.UserSkillsService;

@RestController
@RequestMapping("/user-skills")
public class UserSkillsController {
    
    @Autowired
    UserSkillsService userSkillsService;

    @PostMapping
    public ResponseEntity<?> saveUserSkills(@RequestBody UserSkillsDto userSkillsDto) {
        UserSkills userSkills = userSkillsService.saveUserSkills(userSkillsDto);
        return new ResponseEntity<>(userSkills, HttpStatus.CREATED);
    }

    @PutMapping("/{idUserSkills}")
    public ResponseEntity<?> updateUserSkills(@RequestBody UserSkillsDto userSkillsDto, @PathVariable Long idUserSkills) throws Exception {
        userSkillsService.updateUserSkills(userSkillsDto, idUserSkills);
        return new ResponseEntity<>(HttpStatus.OK);
        // userSkillsService.updatUserSkills(userSkillsDto, idUserSkills);
        // return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idUserSkills}")
    public ResponseEntity<?> deleteUserSkills(@PathVariable Long idUserSkills) throws Exception {
        userSkillsService.deleteUserSkills(idUserSkills);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
