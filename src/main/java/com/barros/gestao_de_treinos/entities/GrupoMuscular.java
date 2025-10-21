package com.barros.gestao_de_treinos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grupos_musculares")
public class GrupoMuscular implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do grupo muscular é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    public GrupoMuscular() {
    }

    public GrupoMuscular(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMuscular that = (GrupoMuscular) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "GrupoMuscular{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
