package com.barros.gestao_de_treinos.DTOs;

import java.time.LocalDateTime;
import java.util.List;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class ExecucaoTreinoDTO {

    private Long idTreino;
    private String nomeTreino;
    private LocalDateTime dataHoraExecucao;
    private List<ExecucaoExercicioSerieDTO> exercicios;

    public ExecucaoTreinoDTO() {
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

    public LocalDateTime getDataHoraExecucao() {
        return dataHoraExecucao;
    }

    public void setDataHoraExecucao(LocalDateTime dataHoraExecucao) {
        this.dataHoraExecucao = dataHoraExecucao;
    }

    public List<ExecucaoExercicioSerieDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExecucaoExercicioSerieDTO> exercicios) {
        this.exercicios = exercicios;
    }
}
