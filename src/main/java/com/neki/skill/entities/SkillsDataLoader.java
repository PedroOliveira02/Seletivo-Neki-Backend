package com.neki.skill.entities;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.neki.skill.repositories.SkillsRepository;

@Component
public class SkillsDataLoader implements ApplicationRunner {

    private final SkillsRepository skillsRepository;

    public SkillsDataLoader(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (skillsRepository.count() == 0) {
            Skills skill1 = new Skills();
            skill1.setNome("Desenvolvimento Web");
            skill1.setDescricao(
                    "Capacidade de criar aplicativos e sites da web usando tecnologias front-end (como HTML, CSS, JavaScript) e tecnologias back-end (como Node.js, Python, Ruby on Rails, etc.).");
            skillsRepository.save(skill1);

            Skills skill2 = new Skills();
            skill2.setNome("Gerenciamento de Projetos");
            skill2.setDescricao(
                    "Capacidade de planejar, coordenar e supervisionar projetos para atingir objetivos específicos, garantindo que o projeto seja concluído dentro do prazo e do orçamento.");
            skillsRepository.save(skill2);

            Skills skill3 = new Skills();
            skill3.setNome("Análise de Dados");
            skill3.setDescricao(
                    "Capacidade de coletar, processar e analisar dados para extrair informações valiosas e tomar decisões informadas. Isso geralmente envolve o uso de ferramentas como Python, R, SQL e visualização de dados.");
            skillsRepository.save(skill3);

            Skills skill4 = new Skills();
            skill4.setNome("Design Gráfico");
            skill4.setDescricao(
                    "Capacidade de criar elementos visuais atraentes, como logotipos, layouts de impressão, ilustrações e interfaces de usuário, usando ferramentas como Adobe Photoshop, Illustrator e InDesign.");
            skillsRepository.save(skill4);

            Skills skill5 = new Skills();
            skill5.setNome("Desenvolvimento Mobile");
            skill5.setDescricao(
                    "Capacidade de criar aplicativos móveis para dispositivos Android e iOS usando tecnologias como Java, Kotlin, Swift e Flutter.");
            skillsRepository.save(skill5);

            Skills skill6 = new Skills();
            skill6.setNome("Marketing Digital");
            skill6.setDescricao(
                    "Conhecimento em estratégias de marketing online, incluindo publicidade em mídias sociais, SEO, e-mail marketing, marketing de conteúdo e análise de dados.");
            skillsRepository.save(skill6);

            Skills skill7 = new Skills();
            skill7.setNome("Redes e Segurança de TI");
            skill7.setDescricao(
                    "Competência em configurar, manter e proteger redes de computadores e sistemas de segurança, incluindo firewalls, antivírus e políticas de segurança.");
            skillsRepository.save(skill7);

            Skills skill8 = new Skills();
            skill8.setNome("Atendimento ao Cliente");
            skill8.setDescricao(
                    "Capacidade de fornecer um excelente atendimento ao cliente, solucionar problemas e responder às perguntas dos clientes para garantir a satisfação e a fidelidade do cliente.");
            skillsRepository.save(skill8);

            Skills skill9 = new Skills();
            skill9.setNome("Ensino e Treinamento");
            skill9.setDescricao(
                    "Capacidade de ensinar e treinar outras pessoas em habilidades específicas, transmitindo conhecimentos e facilitando o aprendizado.");
            skillsRepository.save(skill9);

            Skills skill10 = new Skills();
            skill10.setNome("Escrita Criativa");
            skill10.setDescricao(
                    "Capacidade de criar conteúdo original e criativo, como romances, poesia, roteiros, blogs e artigos.");
            skillsRepository.save(skill10);

        }
    }
}
