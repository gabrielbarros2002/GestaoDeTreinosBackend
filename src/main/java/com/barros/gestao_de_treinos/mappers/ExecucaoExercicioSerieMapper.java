package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.ExecucaoExercicioSerieDTO;
import com.barros.gestao_de_treinos.entities.ExecucaoExercicioSerie;

import static com.barros.gestao_de_treinos.utils.Util.temValor;

public class ExecucaoExercicioSerieMapper {

    public static ExecucaoExercicioSerieDTO toDTO(ExecucaoExercicioSerie entity) {
        ExecucaoExercicioSerieDTO dto = new ExecucaoExercicioSerieDTO();
        dto.setId(entity.getId());

        dto.setNumSerie(entity.getNumSerie());
        dto.setRepeticoes(entity.getRepeticoes());
        dto.setCarga(entity.getCarga());

        return dto;
    }

    public static ExecucaoExercicioSerie toEntity(ExecucaoExercicioSerieDTO dto) {
        ExecucaoExercicioSerie entity = new ExecucaoExercicioSerie();
        entity.setId(temValor(dto.getId()) ? dto.getId() : null);

        entity.setNumSerie(dto.getNumSerie());
        entity.setRepeticoes(dto.getRepeticoes());
        entity.setCarga(dto.getCarga());

        return entity;
    }

}
