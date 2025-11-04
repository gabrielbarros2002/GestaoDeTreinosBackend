package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.ExercicioSerieDTO;
import com.barros.gestao_de_treinos.entities.ExercicioSerie;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;

import static com.barros.gestao_de_treinos.utils.Util.temValor;

public class ExercicioSerieMapper {

    public static ExercicioSerieDTO toDTO(ExercicioSerie entity) {
        ExercicioSerieDTO dto = new ExercicioSerieDTO();
        dto.setId(entity.getId());

        dto.setNumSerie(entity.getNumSerie());
        dto.setRepeticoes(entity.getRepeticoes());
        dto.setCarga(entity.getCarga());

        return dto;
    }

    public static ExercicioSerie toEntity(ExercicioSerieDTO dto) {
        ExercicioSerie entity = new ExercicioSerie();
        entity.setId(temValor(dto.getId()) ? dto.getId() : null);

        entity.setNumSerie(dto.getNumSerie());
        entity.setRepeticoes(dto.getRepeticoes());
        entity.setCarga(dto.getCarga());

        return entity;
    }

}
