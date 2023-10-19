package com.neki.skill.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UsersDto {

    private Long idUsers;

    private String login;

    private String password;
}
