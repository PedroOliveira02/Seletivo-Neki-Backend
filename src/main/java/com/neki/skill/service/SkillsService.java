package com.neki.skill.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.skill.dto.SkillsDto;
import com.neki.skill.entities.Skills;
import com.neki.skill.repositories.SkillsRepository;

@Service
public class SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    public List<SkillsDto> getAllSkills() {
        return skillsRepository.findAll()
                .stream()
                .map(s -> converterEntityParaDto(s))
                .collect(Collectors.toList());
    }

    public Skills saveSkills(SkillsDto skillsDto) {
        Skills skills = converterDtoParaEntity(skillsDto);
        return skillsRepository.save(skills);

    }

    public SkillsDto converterEntityParaDto(Skills skills) {
        SkillsDto skillsDto = new SkillsDto();
        skillsDto.setIdSkills(skills.getIdSkills());
        skillsDto.setNome(skills.getNome());
        skillsDto.setDescricao(skills.getDescricao());
        return skillsDto;
    }

    public Skills converterDtoParaEntity(SkillsDto skillsDto) {
        Skills skills = new Skills();
        skills.setIdSkills(skillsDto.getIdSkills());
        skills.setNome(skillsDto.getNome());
        skills.setDescricao(skillsDto.getDescricao());
        return skills;
    }
}
