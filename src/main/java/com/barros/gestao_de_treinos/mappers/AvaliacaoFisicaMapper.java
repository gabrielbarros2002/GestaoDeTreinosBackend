package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.AvaliacaoFisicaDTO;
import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;

public class AvaliacaoFisicaMapper {

    public static AvaliacaoFisicaDTO toDTO(AvaliacaoFisica entity) {
        AvaliacaoFisicaDTO dto = new AvaliacaoFisicaDTO();
        dto.setId(entity.getId());
        dto.setData(entity.getData());
        dto.setPeso(entity.getPeso());
        dto.setAltura(entity.getAltura());
        dto.setPercentualGordura(entity.getPercentualGordura());

        return dto;
    }

    public static AvaliacaoFisica toEntity(AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica entity = new AvaliacaoFisica();
        entity.setId(dto.getId());
        entity.setData(dto.getData());
        entity.setPeso(dto.getPeso());
        entity.setAltura(dto.getAltura());
        entity.setPercentualGordura(dto.getPercentualGordura());

        return entity;
    }
}
