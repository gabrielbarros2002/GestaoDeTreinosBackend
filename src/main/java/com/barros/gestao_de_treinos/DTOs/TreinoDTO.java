package com.barros.gestao_de_treinos.DTOs;

import java.util.List;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class TreinoDTO {

    private Long idTreino;
    private String nomeTreino;
    private List<TreinoExercicioDTO> exercicios;
    private Long idInstrutor;
    private String nomeInstrutor;

    public TreinoDTO() {
        iniciarAtributosEmBranco(this);
    }

    public Long getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Long idTreino) {
        this.idTreino = idTreino;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public List<TreinoExercicioDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<TreinoExercicioDTO> exercicios) {
        this.exercicios = exercicios;
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
}
