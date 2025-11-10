package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.GrupoMuscularDTO;
import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.mappers.GrupoMuscularMapper;
import com.barros.gestao_de_treinos.repositories.GrupoMuscularRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoMuscularService {

    @Autowired
    private GrupoMuscularRepository repository;

    public static final String MSG_NAO_ENCONTRADO = "Grupo muscular não encontrado. Id = ";

    public List<GrupoMuscularDTO> findAll() {
        List<GrupoMuscular> grupoMuscularList = repository.findAll();
        return grupoMuscularList.stream().map(GrupoMuscularMapper::toDTO).toList();
    }

    public GrupoMuscularDTO findById(Long id) {
        GrupoMuscular entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
        return GrupoMuscularMapper.toDTO(entity);
    }

    public GrupoMuscularDTO insert(GrupoMuscularDTO obj) {
        GrupoMuscular entity = repository.save(GrupoMuscularMapper.toEntity(obj));
        return GrupoMuscularMapper.toDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public GrupoMuscularDTO update(Long id, GrupoMuscularDTO obj) {
        try {
            GrupoMuscular entity = repository.getReferenceById(id);
            updateData(entity, obj);
            GrupoMuscular entityAtualizada = repository.save(entity);
            return GrupoMuscularMapper.toDTO(entityAtualizada);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id);
        }
    }

    private void updateData(GrupoMuscular entity, GrupoMuscularDTO obj) {
        entity.setNome(obj.getNome());
    }
}
