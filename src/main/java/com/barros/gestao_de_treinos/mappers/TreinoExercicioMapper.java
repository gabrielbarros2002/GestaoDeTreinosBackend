package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;

public class TreinoExercicioMapper {

    public static TreinoExercicioDTO toDTO(TreinoExercicio entity) {
        TreinoExercicioDTO dto = new TreinoExercicioDTO();
        dto.setIdTreino(entity.getTreino().getId());
        dto.setIdExercicio(entity.getExercicio().getId());
        dto.setNomeExercicio(entity.getExercicio().getNome());
        dto.setNomeGrupoMuscular(entity.getExercicio().getGrupoMuscular().getNome());
        dto.setSeries(entity.getOrdem());

        return dto;
    }

    public static TreinoExercicio toEntity(TreinoExercicioDTO dto, Treino treino, Exercicio exercicio) {
        TreinoExercicio entity = new TreinoExercicio();

        entity.setId(dto.getIdTreino());
        entity.setTreino(treino);
        entity.setExercicio(exercicio);

        return entity;
    }

}
