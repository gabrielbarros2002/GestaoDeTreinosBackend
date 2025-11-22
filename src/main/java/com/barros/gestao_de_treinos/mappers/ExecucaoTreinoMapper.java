package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.ExecucaoTreinoDTO;
import com.barros.gestao_de_treinos.entities.ExecucaoTreino;
import com.barros.gestao_de_treinos.entities.ExecucaoTreinoExercicio;
import com.barros.gestao_de_treinos.entities.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import static com.barros.gestao_de_treinos.utils.Util.temValor;

public class ExecucaoTreinoMapper {

    public static ExecucaoTreinoDTO toDTO(ExecucaoTreino entity) {
        ExecucaoTreinoDTO dto = new ExecucaoTreinoDTO();
        dto.setIdExecucaoTreino(entity.getId());

        dto.setNomeExecucaoTreino(entity.getNomeTreino());
        dto.setDataHoraExecucao(entity.getDataHoraExecucao());
        dto.setIdUsuario(entity.getUsuario().getId());
        dto.setNomeUsuario(entity.getUsuario().getNome());

        dto.setExercicios(entity.getExercicios().stream().map(ExecucaoTreinoExercicioMapper::toDTO).toList());

        return dto;
    }

    public static ExecucaoTreino toEntity(ExecucaoTreinoDTO dto) {
        ExecucaoTreino entity = new ExecucaoTreino();
        entity.setId(temValor(dto.getIdExecucaoTreino()) ? dto.getIdExecucaoTreino() : null);

        entity.setNomeTreino(dto.getNomeExecucaoTreino());
        entity.setDataHoraExecucao(dto.getDataHoraExecucao());
        entity.setUsuario(new Usuario(
                dto.getIdUsuario(),
                dto.getNomeUsuario(),
                null, null, null
        ));

        List<ExecucaoTreinoExercicio> exercicios = dto.getExercicios().stream()
                .map(ExecucaoTreinoExercicioMapper::toEntity)
                .collect(Collectors.toList());
        entity.setExercicios(exercicios);

        return entity;
    }

}
