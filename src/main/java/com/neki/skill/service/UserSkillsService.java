package com.neki.skill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.neki.skill.dto.UserSkillsDto;
import com.neki.skill.entities.UserSkills;
import com.neki.skill.repositories.UserSkillsRepository;

@Service
public class UserSkillsService {

    @Autowired
    UserSkillsRepository userSkillsRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    SkillsService skillsService;

    public UserSkills saveUserSkills(UserSkillsDto userSkillsDto) {
        UserSkills userSkills = converterDtoParaEntity(userSkillsDto);
        return userSkillsRepository.save(userSkills);
    }

    public UserSkills updatUserSkills(UserSkillsDto userSkillsDto, Long idUserSkills) throws NotFoundException {
        UserSkills userSkillsExistente = userSkillsRepository.findById(idUserSkills)
                .orElseThrow(() -> new NotFoundException());
        userSkillsExistente.setLevel(userSkillsDto.getLevel());
        return userSkillsRepository.save(userSkillsExistente);
    }

    public void deleteUserSkills(Long idUserSkills) throws NotFoundException {
        userSkillsRepository.findById(idUserSkills)
            .orElseThrow(() -> new NotFoundException());
        userSkillsRepository.deleteById(idUserSkills);
    }

    public UserSkills converterDtoParaEntity(UserSkillsDto userSkillsDto) {
        UserSkills userSkills = new UserSkills();
        userSkills.setIdUserSkill(userSkillsDto.getIdUserSkills());
        userSkills.setLevel(userSkillsDto.getLevel());
        userSkills.setUsers(usersService.converterDtoParaEntity(userSkillsDto.getUsersDto()));
        userSkills.setSkills(skillsService.converterDtoParaEntity(userSkillsDto.getSkillsDto()));
        return userSkills;
    }
}
