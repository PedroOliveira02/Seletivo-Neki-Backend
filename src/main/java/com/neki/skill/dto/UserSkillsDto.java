package com.neki.skill.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserSkillsDto {

    private Long idUserSkills;

    private Integer level;

    private UsersDto usersDto;

    private SkillsDto skillsDto;
}
