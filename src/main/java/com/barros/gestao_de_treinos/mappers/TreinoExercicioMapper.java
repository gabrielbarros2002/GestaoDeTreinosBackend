package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;

import static com.barros.gestao_de_treinos.utils.Util.temValor;

public class TreinoExercicioMapper {

    public static TreinoExercicioDTO toDTO(TreinoExercicio entity) {
        TreinoExercicioDTO dto = new TreinoExercicioDTO();
        dto.setId(entity.getId());

        dto.setIdTreino(entity.getTreino().getId());
        dto.setIdExercicio(entity.getExercicio().getId());
        dto.setNomeExercicio(entity.getExercicio().getNome());
        dto.setNomeGrupoMuscular(entity.getExercicio().getGrupoMuscular().getNome());

        dto.setOrdem(entity.getOrdem());
        dto.setDescansoSegundos(entity.getDescansoSegundos());
        dto.setObservacao(entity.getObservacao());

        dto.setSeries(entity.getSeries().stream().map(ExercicioSerieMapper::toDTO).toList());

        return dto;
    }

    public static TreinoExercicio toEntity(TreinoExercicioDTO dto) {
        TreinoExercicio entity = new TreinoExercicio();
        entity.setId(temValor(dto.getId()) ? dto.getId() : null);

        Treino treino = new Treino();
        treino.setId(dto.getIdTreino());
        entity.setTreino(treino);

        Exercicio exercicio = new Exercicio();
        exercicio.setId(dto.getIdExercicio());
        entity.setExercicio(exercicio);

        entity.setOrdem(dto.getOrdem());
        entity.setDescansoSegundos(dto.getDescansoSegundos());
        entity.setObservacao(dto.getObservacao());

        entity.setSeries(dto.getSeries().stream().map(ExercicioSerieMapper::toEntity).toList());

        return entity;
    }

}
