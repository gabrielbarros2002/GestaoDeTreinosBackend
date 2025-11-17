package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "execucao_treinos")
public class ExecucaoTreino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do treino é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotNull(message = "A data e hora de execução é obrigatória")
    @Column
    private LocalDateTime dataHoraExecucao;

    @NotNull(message = "O treino deve pelo menos um exercício")
    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExecucaoTreinoExercicio> exercicios = new ArrayList<>();

    public ExecucaoTreino() {
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

    public LocalDateTime getDataHoraExecucao() {
        return dataHoraExecucao;
    }

    public void setDataHoraExecucao(LocalDateTime dataHoraExecucao) {
        this.dataHoraExecucao = dataHoraExecucao;
    }

    public List<ExecucaoTreinoExercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExecucaoTreinoExercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void addExercicio(ExecucaoTreinoExercicio exercicio) {
        this.exercicios.add(exercicio);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExecucaoTreino that = (ExecucaoTreino) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ExecucaoTreino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataHoraExecucao=" + dataHoraExecucao +
                ", exercicios=" + exercicios +
                '}';
    }
}
