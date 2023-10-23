package com.neki.skill.entities;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.neki.skill.repositories.UsersRepository;

@Component
public class UsersDataLoader implements ApplicationRunner {

    private final UsersRepository usersRepository;

    public UsersDataLoader(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (usersRepository.count() == 0) {
            Users users = new Users();
            users.setLogin("Pedro");
            users.setPassword("$2a$10$x6Ptj5f5kTptDgIrbtDnbOd0YRAFrHqZJa47P3OCxaEYrHtmijuba");
            // Senha descriptografada para acesso com user ja criado: 12345
            usersRepository.save(users);
        }
    }
}
