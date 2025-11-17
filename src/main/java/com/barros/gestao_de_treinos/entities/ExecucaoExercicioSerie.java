package com.barros.gestao_de_treinos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

@Entity
@Table(name = "exercicio_series")
public class ExecucaoExercicioSerie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Deve estar relacionado à um treino")
    @JoinColumn(name = "treino_exercicio_id", foreignKey = @ForeignKey(name = "fk_execucaoexercicioserie_execucaotreinoexercicio"))
    private ExecucaoTreinoExercicio treinoExercicio;

    @NotNull(message = "O número da série é obrigatório")
    @Min(value = 1, message = "O número mínimo de série é 1")
    @Column(nullable = false)
    private Integer numSerie;

    @NotNull(message = "O número de repetições é obrigatório")
    @Column(nullable = false)
    private Integer repeticoes;

    @NotNull(message = "A carga é obrigatória")
    @Column(precision = 6, scale = 2)
    private BigDecimal carga;

    public ExecucaoExercicioSerie() {
        iniciarAtributosEmBranco(this);
    }

    public ExecucaoExercicioSerie(Long id, ExecucaoTreinoExercicio treinoExercicio, Integer numSerie, Integer repeticoes, BigDecimal carga) {
        this.id = id;
        this.treinoExercicio = treinoExercicio;
        this.numSerie = numSerie;
        this.repeticoes = repeticoes;
        this.carga = carga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public ExecucaoTreinoExercicio getTreinoExercicio() {
        return treinoExercicio;
    }

    public void setTreinoExercicio(ExecucaoTreinoExercicio treinoExercicio) {
        this.treinoExercicio = treinoExercicio;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    public BigDecimal getCarga() {
        return carga;
    }

    public void setCarga(BigDecimal carga) {
        this.carga = carga;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExecucaoExercicioSerie that = (ExecucaoExercicioSerie) o;
        return Objects.equals(id, that.id) && Objects.equals(treinoExercicio, that.treinoExercicio) && Objects.equals(numSerie, that.numSerie) && Objects.equals(repeticoes, that.repeticoes) && Objects.equals(carga, that.carga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, treinoExercicio, numSerie, repeticoes, carga);
    }

    @Override
    public String toString() {
        return "ExercicioSerie{" +
                "id=" + id +
                ", treinoExercicio=" + treinoExercicio +
                ", numSerie=" + numSerie +
                ", repeticoes=" + repeticoes +
                ", carga=" + carga +
                '}';
    }
}
