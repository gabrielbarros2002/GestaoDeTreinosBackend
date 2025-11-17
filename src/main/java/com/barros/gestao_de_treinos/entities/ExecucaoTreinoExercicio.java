package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

@Entity
@Table(name = "execucao_treino_exercicios")
public class ExecucaoTreinoExercicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Deve estar relacionado à um treino")
    @JoinColumn(name = "treino_id", foreignKey = @ForeignKey(name = "fk_execucaotreinoexercicio_execucaotreino"))
    private ExecucaoTreino execucaoTreino;

    @ManyToOne
    @NotNull(message = "Deve estar relacionado à um exercício")
    @JoinColumn(name = "exercicio_id", foreignKey = @ForeignKey(name = "fk_execucaotreinoexercicio_exercicio"))
    private Exercicio exercicio;

    @NotNull(message = "A ordem da série é obrigatória")
    @Min(value = 1, message = "Deve ter pelo menos 1 série")
    @Column(nullable = false)
    private Integer ordem;

    @NotNull(message = "O tempo de descanso é obrigatório")
    @Column(nullable = false)
    private Integer descansoSegundos;

    @Column
    private String observacao;

    @NotNull(message = "O exercício deve ter pelo menos uma série")
    @OneToMany(mappedBy = "treinoExercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExecucaoExercicioSerie> series = new ArrayList<>();

    public ExecucaoTreinoExercicio() {
        iniciarAtributosEmBranco(this);
    }

    public ExecucaoTreinoExercicio(Long id, ExecucaoTreino execucaoTreino, Exercicio exercicio, Integer ordem, Integer descansoSegundos, String observacao) {
        this.id = id;
        this.execucaoTreino = execucaoTreino;
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

    public ExecucaoTreino getExecucaoTreino() {
        return execucaoTreino;
    }

    public void setExecucaoTreino(ExecucaoTreino execucaoTreino) {
        this.execucaoTreino = execucaoTreino;
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

    public List<ExecucaoExercicioSerie> getSeries() {
        return series;
    }

    public void setSeries(List<ExecucaoExercicioSerie> series) {
        this.series = series;
    }

    public void addSerie(ExecucaoExercicioSerie serie) {
        this.series.add(serie);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExecucaoTreinoExercicio that = (ExecucaoTreinoExercicio) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ExecucaoTreinoExercicio{" +
                "id=" + id +
                ", treino=" + execucaoTreino +
                ", exercicio=" + exercicio +
                ", ordem=" + ordem +
                ", descansoSegundos=" + descansoSegundos +
                ", observacao='" + observacao + '\'' +
                ", series=" + series +
                '}';
    }
}
