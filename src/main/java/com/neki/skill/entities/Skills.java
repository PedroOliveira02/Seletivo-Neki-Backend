package com.neki.skill.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skills")
    private Long idSkills;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricao;

    @OneToMany(mappedBy = "skills")
    private List<UserSkills> skill;
}
