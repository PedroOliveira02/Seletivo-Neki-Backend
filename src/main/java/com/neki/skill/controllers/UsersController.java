package com.neki.skill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.skill.dto.UserSkillByIdDto;
import com.neki.skill.dto.UsersDto;
import com.neki.skill.repositories.UsersRepository;
import com.neki.skill.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Endpoints dos usuários")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    @PostMapping
    @Operation(summary = "Adiciona novo usuário", description = "Adiciona novo usuário", tags = {
            "Users" }, responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<?> saveUsers(@RequestBody @Valid UsersDto usersDto) {
        // String encryptedPassword = new BCryptPasswordEncoder().encode(usersDto.getPassword());
        UsersDto newUsersDto = new UsersDto();
        newUsersDto.setLogin(usersDto.getLogin());
        newUsersDto.setPassword(usersDto.getPassword());
        UserDetails user = usersService.saveUsers(newUsersDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);          
    }

    @GetMapping("/user-skills/{idUsers}")
    @Operation(summary = "Busca skills por usuário", description = "Busca todas as skills relacionada ao mesmo usuário", tags = {
            "Users" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Forbidden", responseCode = "403", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<UserSkillByIdDto>> getSkillsByUsers(@PathVariable Long idUsers) {
        List<UserSkillByIdDto> user = usersService.finUserSkillsByIdUsers(idUsers);
        return ResponseEntity.ok(user);
    }
}
