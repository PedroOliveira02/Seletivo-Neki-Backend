package com.neki.skill.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserSkillByIdDto {
    
    private Long idUserSkills;

    private String nome;

    private Integer level;
    
    private String descricao;
}
