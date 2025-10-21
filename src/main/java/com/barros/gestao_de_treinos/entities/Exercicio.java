package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "exercicios")
public class Exercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do exercício é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @Size(max = 500, message = "A descrição não pode ultrapassar {max} caracteres")
    @Column(length = 500)
    private String descricao;

    @NotNull(message = "O grupo muscular é obrigatório")
    @ManyToOne
    @JoinColumn(name = "grupo_muscular_id", nullable = false, foreignKey = @ForeignKey(name = "fk_exercicio_grupomuscular"))
    private GrupoMuscular grupoMuscular;

    public Exercicio() {
    }

    public Exercicio(Long id, String nome, String descricao, GrupoMuscular grupoMuscular) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.grupoMuscular = grupoMuscular;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exercicio exercicio = (Exercicio) o;
        return Objects.equals(id, exercicio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", grupoMuscular=" + grupoMuscular +
                '}';
    }
}
