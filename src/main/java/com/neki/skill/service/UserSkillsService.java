package com.neki.skill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.neki.skill.dto.UserSkillsDto;
import com.neki.skill.entities.UserSkills;
import com.neki.skill.exceptions.ResourceBadRequestException;
import com.neki.skill.exceptions.ResourceNotFoundException;
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
        UserSkills existingUserSkill = userSkillsRepository.findByUsersAndSkills(userSkills.getUsers(), userSkills.getSkills());
        if (existingUserSkill != null) {
            throw new ResourceBadRequestException("Este usuário já possui essa habilidade."); 
        } else if (userSkills.getUsers() == null) {
            throw new ResourceBadRequestException("O idUsers é obrigatório!");
        } else if (userSkills.getSkills() == null) {
            throw new ResourceBadRequestException("O idSkills é obrigatório!");
        } else if (userSkills.getLevel() == null) {
            throw new ResourceBadRequestException("Favor preencher o campo Level!");
        } else {
            return userSkillsRepository.save(userSkills);
        }
        
    }

    public UserSkills updateUserSkills(UserSkillsDto userSkillsDto, Long idUserSkills) {
        UserSkills userSkillsExistente = userSkillsRepository.findById(idUserSkills)
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
            userSkillsExistente.setLevel(userSkillsDto.getLevel());
        if (userSkillsExistente.getLevel() == null) {
            throw new ResourceBadRequestException("Favor preencher o Level!");
        } else {
            return userSkillsRepository.save(userSkillsExistente);
        }
        
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
