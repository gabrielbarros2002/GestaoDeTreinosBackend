package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.entities.Treino;

public class TreinoMapper {

    public static TreinoDTO toDTO(Treino entity) {
        TreinoDTO dto = new TreinoDTO();
        dto.setIdTreino(entity.getId());
        dto.setNomeTreino(entity.getNome());

        return dto;
    }

    public static Treino toEntity(TreinoDTO dto) {
        Treino entity = new Treino();
        entity.setId(dto.getIdTreino());
        entity.setNome(dto.getNomeTreino());

        return entity;
    }

}
