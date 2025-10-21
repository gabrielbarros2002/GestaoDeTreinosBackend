package com.barros.gestao_de_treinos.DTOs;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class TreinoExercicioDTO {

    private Long idTreino;
    private Long idExercicio;
    private String nomeExercicio;
    private String nomeGrupoMuscular;
    private Integer series;
    private Integer repeticoes;

    public TreinoExercicioDTO() {
        iniciarAtributosEmBranco(this);
    }

    public Long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Long idTreino) {
        this.idTreino = idTreino;
    }

    public Long getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(Long idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getNomeGrupoMuscular() {
        return nomeGrupoMuscular;
    }

    public void setNomeGrupoMuscular(String nomeGrupoMuscular) {
        this.nomeGrupoMuscular = nomeGrupoMuscular;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }
}
