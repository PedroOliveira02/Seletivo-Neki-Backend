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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/skills")
@Tag(name = "Skills", description = "Endpoints das skills")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @GetMapping
    @Operation(summary = "Busca todas as skills",  description = "Busca todas as skills", tags = {
            "Skills" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<SkillsDto>> getAllSkills() {
        return ResponseEntity.ok(skillsService.getAllSkills());
    }

    @PostMapping
    @Operation(summary = "Adiciona uma nova skill", description = "Adiciona uma nova skill", tags = {
            "Skills" }, responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<?> saveSkills(@RequestBody SkillsDto skillsDto) {
        Skills skills = skillsService.saveSkills(skillsDto);
        return new ResponseEntity<>(skills, HttpStatus.CREATED);
    }
}
