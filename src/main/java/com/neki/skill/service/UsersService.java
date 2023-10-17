package com.neki.skill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neki.skill.dto.UserSkillByIdDto;
import com.neki.skill.dto.UsersDto;
import com.neki.skill.entities.Skills;
import com.neki.skill.entities.UserSkills;
import com.neki.skill.entities.Users;
import com.neki.skill.repositories.UsersRepository;

@Service
public class UsersService {
    
    @Autowired
    UsersRepository usersRepository;

    public Users saveUsers(UsersDto usersDto) {
        Users users = converterDtoParaEntity(usersDto);
        return usersRepository.save(users);
    }

    public List<UserSkillByIdDto> finUserSkillsByIdUsers(Long idUsers) {
        Skills skill = new Skills();
        List<UserSkills> userSkills = usersRepository.findByUsersId(idUsers);
        List<UserSkillByIdDto> userSkillsDto = new ArrayList<>();

        for (UserSkills userSkill : userSkills) {
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
}
