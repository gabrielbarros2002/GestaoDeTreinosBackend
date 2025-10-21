package com.barros.gestao_de_treinos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "avaliacoes_fisicas")
public class AvaliacaoFisica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data da avaliação é obrigatória")
    @PastOrPresent(message = "A data da avaliação não pode ser no futuro")
    @Column(nullable = false)
    private LocalDate data;

    @NotNull(message = "O peso é obrigatório")
    @Positive(message = "O peso deve ser maior que zero")
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @NotNull(message = "A altura é obrigatória")
    @Positive(message = "A altura deve ser maior que zero")
    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal altura;

    @NotNull(message = "O IMC é obrigatório")
    @Positive(message = "O IMC deve ser maior que zero")
    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal imc;

    @NotNull(message = "O percentual de gordura é obrigatório")
    @Positive(message = "O percentual de gordura deve ser maior que zero")
    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal percentualGordura;

    @PrePersist
    @PreUpdate
    private void calcularIMC() {
        if (peso != null && altura != null && altura.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal alturaAoQuadrado = altura.multiply(altura);
            this.imc = peso.divide(alturaAoQuadrado, 2, RoundingMode.HALF_EVEN);
        }
    }

    public AvaliacaoFisica() {
    }

    public AvaliacaoFisica(Long id, LocalDate data, BigDecimal peso, BigDecimal altura, BigDecimal imc, BigDecimal percentualGordura) {
        this.id = id;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.percentualGordura = percentualGordura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getImc() {
        return imc;
    }

    public void setImc(BigDecimal imc) {
        this.imc = imc;
    }

    public BigDecimal getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(BigDecimal percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoFisica that = (AvaliacaoFisica) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(peso, that.peso) && Objects.equals(altura, that.altura) && Objects.equals(imc, that.imc) && Objects.equals(percentualGordura, that.percentualGordura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, peso, altura, imc, percentualGordura);
    }

    @Override
    public String toString() {
        return "AvaliacaoFisica{" +
                "id=" + id +
                ", data=" + data +
                ", peso=" + peso +
                ", altura=" + altura +
                ", imc=" + imc +
                ", percentualGordura=" + percentualGordura +
                '}';
    }
}

