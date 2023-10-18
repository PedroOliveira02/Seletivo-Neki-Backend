package com.neki.skill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.neki.skill.dto.UserSkillByIdDto;
import com.neki.skill.dto.UsersDto;
import com.neki.skill.entities.Skills;
import com.neki.skill.entities.UserSkills;
import com.neki.skill.entities.Users;
import com.neki.skill.exceptions.ResourceBadRequestException;
import com.neki.skill.exceptions.ResourceNotFoundException;
import com.neki.skill.repositories.UsersRepository;

@Service
public class UsersService {
    
    @Autowired
    UsersRepository usersRepository;

    public UserDetails saveUsers(UsersDto usersDto) {
        ValidarLogin(usersDto.getLogin());
        Users users = converterDtoParaEntity(usersDto);
        if (users.getLogin().isEmpty()) {
            throw new ResourceBadRequestException("Favor preencher o campo Login!");
        } else if (users.getPassword().isEmpty()) {
            throw new ResourceBadRequestException("Favor preencher o campo Password!");
        } else {
            return usersRepository.save(users);
        }
        
    }

    public List<UserSkillByIdDto> finUserSkillsByIdUsers(Long idUsers) {
        List<UserSkills> userSkills = usersRepository.findByUsersId(idUsers);
        if (userSkills.isEmpty()) {
            throw new ResourceNotFoundException("Usuário sem skill ou não encontrado!");
        }
        List<UserSkillByIdDto> userSkillsDto = new ArrayList<>();

        for (UserSkills userSkill : userSkills) {
            Skills skill = userSkill.getSkills();
            UserSkillByIdDto userSkillDto = new UserSkillByIdDto();
            userSkillDto.setIdUserSkills(userSkill.getIdUserSkill());
            userSkillDto.setNome(skill.getNome());
            userSkillDto.setLevel(userSkill.getLevel());
            userSkillDto.setDescricao(skill.getDescricao());
            userSkillsDto.add(userSkillDto);
        }

        return userSkillsDto;
    }

    public Users converterDtoParaEntity(UsersDto usersDto) {
        Users users = new Users();
        users.setIdUsers(usersDto.getIdUsers());
        users.setLogin(usersDto.getLogin());
        users.setPassword(usersDto.getPassword());
        return users;
    }

    public void ValidarLogin(String login) {
        UserDetails users = usersRepository.findByLogin(login);
        if (users != null) {
            throw new ResourceBadRequestException("Login já cadastrado!");
        }
    }
}

