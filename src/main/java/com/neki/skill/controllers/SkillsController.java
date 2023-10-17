package com.neki.skill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.skill.dto.SkillsDto;
import com.neki.skill.entities.Skills;
import com.neki.skill.service.SkillsService;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    
    @Autowired
    SkillsService skillsService;

    @GetMapping
    public ResponseEntity<List<SkillsDto>> getAllSkills() {
        return ResponseEntity.ok(skillsService.getAllSkills());
    }

    @PostMapping
    public ResponseEntity<?> saveSkills(@RequestBody SkillsDto skillsDto) {
        Skills skills = skillsService.saveSkills(skillsDto);
        return new ResponseEntity<>(skills, HttpStatus.CREATED);
    }
}
