package com.barros.gestao_de_treinos.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class AvaliacaoFisicaDTO {

    private Long id;
    private LocalDate data;
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal imc;
    private BigDecimal percentualGordura;
    private BigDecimal massaMuscularKg;
    private Long idInstrutor;
    private String nomeInstrutor;
    private Long idAluno;
    private String nomeAluno;

    public AvaliacaoFisicaDTO() {
        iniciarAtributosEmBranco(this);
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

    public BigDecimal getMassaMuscularKg() {
        return massaMuscularKg;
    }

    public void setMassaMuscularKg(BigDecimal massaMuscularKg) {
        this.massaMuscularKg = massaMuscularKg;
    }

    public Long getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(Long idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
