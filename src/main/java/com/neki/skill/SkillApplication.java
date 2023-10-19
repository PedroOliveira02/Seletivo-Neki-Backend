package com.neki.skill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Processo seletivo Neki", version = "1", description = "Documentação da API de skills para processo seletivo da Neki"))

public class SkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillApplication.class, args);
	}

}
