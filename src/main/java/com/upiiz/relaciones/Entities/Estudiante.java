package com.upiiz.relaciones.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nombre;

    private String correo;

    private String matricula;

    // Un estudiante tiene perfil
    // Traer la llave foraneo
    @OneToOne(targetEntity = Perfil.class)
    private Perfil perfil;

    // Un estudiante tiene un tutor
    @ManyToOne(targetEntity = Tutor.class)
    private Tutor tutor;

    // Un estudiante tiene muchos cursos
    @ManyToMany(targetEntity = Curso.class, fetch = FetchType.LAZY)
    private List<Curso> curso;
}
