package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

@Entity
@Table(name = "treino_exercicios")
public class TreinoExercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Deve estar relacionado à um treino")
    @JoinColumn(name = "treino_id", foreignKey = @ForeignKey(name = "fk_treinoexercicio_treino"))
    private Treino treino;

    @ManyToOne
    @NotNull(message = "Deve estar relacionado à um exercício")
    @JoinColumn(name = "exercicio_id", foreignKey = @ForeignKey(name = "fk_treinoexercicio_exercicio"))
    private Exercicio exercicio;

    @NotNull(message = "O número de séries é obrigatório")
    @Min(value = 1, message = "Deve ter pelo menos 1 série")
    @Column(nullable = false)
    private Integer ordem;

    @NotNull(message = "O tempo de descanso é obrigatório")
    @Column(nullable = false)
    private Integer descansoSegundos;

    @Column
    private String observacao;

    public TreinoExercicio() {
        iniciarAtributosEmBranco(this);
    }

    public TreinoExercicio(Long id, Treino treino, Exercicio exercicio, Integer ordem, Integer descansoSegundos, String observacao) {
        this.id = id;
        this.treino = treino;
        this.exercicio = exercicio;
        this.ordem = ordem;
        this.descansoSegundos = descansoSegundos;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getDescansoSegundos() {
        return descansoSegundos;
    }

    public void setDescansoSegundos(Integer descansoSegundos) {
        this.descansoSegundos = descansoSegundos;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreinoExercicio that = (TreinoExercicio) o;
        return Objects.equals(id, that.id) && Objects.equals(treino, that.treino) && Objects.equals(exercicio, that.exercicio) && Objects.equals(ordem, that.ordem) && Objects.equals(descansoSegundos, that.descansoSegundos) && Objects.equals(observacao, that.observacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, treino, exercicio, ordem, descansoSegundos, observacao);
    }

    @Override
    public String toString() {
        return "TreinoExercicio{" +
                "id=" + id +
                ", treino=" + treino +
                ", exercicio=" + exercicio +
                ", ordem=" + ordem +
                ", descansoSegundos=" + descansoSegundos +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
