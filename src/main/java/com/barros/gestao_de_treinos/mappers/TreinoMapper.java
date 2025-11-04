package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;

import java.util.List;
import java.util.stream.Collectors;

import static com.barros.gestao_de_treinos.utils.Util.temValor;

public class TreinoMapper {

    public static TreinoDTO toDTO(Treino entity) {
        TreinoDTO dto = new TreinoDTO();
        dto.setIdTreino(entity.getId());

        dto.setNomeTreino(entity.getNome());
        dto.setDataCriacao(entity.getDataCriacao());

        dto.setExercicios(entity.getExercicios().stream().map(TreinoExercicioMapper::toDTO).toList());

        return dto;
    }

    public static Treino toEntity(TreinoDTO dto) {
        Treino entity = new Treino();
        entity.setId(temValor(dto.getIdTreino()) ? dto.getIdTreino() : null);

        entity.setNome(dto.getNomeTreino());
        entity.setDataCriacao(dto.getDataCriacao());

        List<TreinoExercicio> exercicios = dto.getExercicios().stream()
                .map(TreinoExercicioMapper::toEntity)
                .collect(Collectors.toList());
        entity.setExercicios(exercicios);

        return entity;
    }

}
