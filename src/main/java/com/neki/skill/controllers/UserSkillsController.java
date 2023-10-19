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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user-skills")
@Tag(name = "UserSkills", description = "Endpoints dos usuários e suas skills")
public class UserSkillsController {

    @Autowired
    UserSkillsService userSkillsService;

    @PostMapping
    @Operation(summary = "Adiciona skill no usuário", description = "Adiciona uma nova skill ao usuário", tags = {
            "UserSkills" }, responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<?> saveUserSkills(@RequestBody UserSkillsDto userSkillsDto) {
        UserSkills userSkills = userSkillsService.saveUserSkills(userSkillsDto);
        return new ResponseEntity<>(userSkills, HttpStatus.CREATED);
    }

    @PutMapping("/{idUserSkills}")
    @Operation(summary = "Atualiza o level da skill", description = "Atualiza o level de uma skill do usuário", tags = {
            "UserSkills" }, responses = {
                    @ApiResponse(description = "Updated", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<?> updateUserSkills(@RequestBody UserSkillsDto userSkillsDto, @PathVariable Long idUserSkills)
            throws Exception {
        userSkillsService.updateUserSkills(userSkillsDto, idUserSkills);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{idUserSkills}")
    @Operation(summary = "Deleta uma skill do usuário", description = "Deleta uma skill relacionada ao usuário", tags = {
            "UserSkills" }, responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<?> deleteUserSkills(@PathVariable Long idUserSkills) throws Exception {
        userSkillsService.deleteUserSkills(idUserSkills);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
