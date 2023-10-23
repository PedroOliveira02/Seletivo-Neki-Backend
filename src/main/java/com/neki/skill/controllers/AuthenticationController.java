package com.neki.skill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neki.skill.dto.AuthenticationDto;
import com.neki.skill.dto.LoginResponseDto;
import com.neki.skill.entities.Users;
import com.neki.skill.exceptions.ResourceBadRequestException;
import com.neki.skill.infra.security.TokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Endpoint de autenticação")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Login do usuário", description = "Faz o login para autenticar o usuário para ter acesso aos outros endpoints", tags = {
            "Authentication" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDto data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var userDetails = (Users) auth.getPrincipal();
            var idUsers = userDetails.getIdUsers();
            var token = tokenService.generateToken(userDetails);
            return ResponseEntity.ok(new LoginResponseDto(idUsers, token));
        } catch (AuthenticationException e) {
            throw new ResourceBadRequestException("Credenciais inválidas. Verifique seu login e password!");
        }
    }
}
