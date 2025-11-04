package com.barros.gestao_de_treinos.DTOs;

import java.math.BigDecimal;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class ExercicioSerieDTO {

    private Long id;
    private Integer numSerie;
    private Integer repeticoes;
    private BigDecimal carga;

    public ExercicioSerieDTO() {
        iniciarAtributosEmBranco(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
