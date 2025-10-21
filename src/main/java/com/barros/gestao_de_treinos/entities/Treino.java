package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "treinos")
public class Treino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do treino é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull(message = "A data de criação é obrigatória")
    @Column
    private LocalDate dataCriacao;

    @NotNull(message = "O treino deve pelo menos um exercício")
    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreinoExercicio> exercicios;

    public Treino() {
    }

    public Treino(Long id, String nome, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.exercicios = new ArrayList<>();
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<TreinoExercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<TreinoExercicio> exercicios) {
        this.exercicios = exercicios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Treino treino = (Treino) o;
        return Objects.equals(id, treino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return "Treino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", exercicios=" + exercicios +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
