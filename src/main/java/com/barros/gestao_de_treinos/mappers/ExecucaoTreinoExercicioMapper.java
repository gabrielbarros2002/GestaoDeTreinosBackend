package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.ExecucaoTreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.ExecucaoTreino;
import com.barros.gestao_de_treinos.entities.ExecucaoTreinoExercicio;
import com.barros.gestao_de_treinos.entities.Exercicio;

import static com.barros.gestao_de_treinos.utils.Util.temValor;

public class ExecucaoTreinoExercicioMapper {

    public static ExecucaoTreinoExercicioDTO toDTO(ExecucaoTreinoExercicio entity) {
        ExecucaoTreinoExercicioDTO dto = new ExecucaoTreinoExercicioDTO();
        dto.setId(entity.getId());

        dto.setIdTreino(entity.getTreino().getId());
        dto.setIdExercicio(entity.getExercicio().getId());
        dto.setNomeExercicio(entity.getExercicio().getNome());
        dto.setNomeGrupoMuscular(entity.getExercicio().getGrupoMuscular().getNome());

        dto.setOrdem(entity.getOrdem());
        dto.setDescansoSegundos(entity.getDescansoSegundos());
        dto.setObservacao(entity.getObservacao());

        dto.setSeries(entity.getSeries().stream().map(ExecucaoExercicioSerieMapper::toDTO).toList());

        return dto;
    }

    public static ExecucaoTreinoExercicio toEntity(ExecucaoTreinoExercicioDTO dto) {
        ExecucaoTreinoExercicio entity = new ExecucaoTreinoExercicio();
        entity.setId(temValor(dto.getId()) ? dto.getId() : null);

        ExecucaoTreino treino = new ExecucaoTreino();
        treino.setId(dto.getIdTreino());
        entity.setTreino(treino);

        Exercicio exercicio = new Exercicio();
        exercicio.setId(dto.getIdExercicio());
        entity.setExercicio(exercicio);

        entity.setOrdem(dto.getOrdem());
        entity.setDescansoSegundos(dto.getDescansoSegundos());
        entity.setObservacao(dto.getObservacao());

        entity.setSeries(dto.getSeries().stream().map(ExecucaoExercicioSerieMapper::toEntity).toList());

        return entity;
    }

}
