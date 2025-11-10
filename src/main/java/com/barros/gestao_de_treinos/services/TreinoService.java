package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.mappers.TreinoExercicioMapper;
import com.barros.gestao_de_treinos.mappers.TreinoMapper;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    public static final String MSG_NAO_ENCONTRADO = "Treino não encontrado. Id = ";

    public List<TreinoDTO> findAll() {
        List<Treino> treinoList = repository.findAll();
        return treinoList.stream().map(TreinoMapper::toDTO).toList();
    }

    public TreinoDTO findById(Long id) {
        Treino obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
        return TreinoMapper.toDTO(obj);
    }

    @Transient
    public TreinoDTO insert(TreinoDTO dto) {
        dto.setDataCriacao(LocalDate.now());
        Treino entity = TreinoMapper.toEntity(dto);
        Treino novoTreino = repository.save(entity);
        return TreinoMapper.toDTO(novoTreino);
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

    public TreinoDTO update(Long id, TreinoDTO obj) {
        try {
            Treino entity = repository.getReferenceById(id);
            return updateData(entity, obj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id);
        }
    }

    private TreinoDTO updateData(Treino entity, TreinoDTO dto) {
        entity.setNome(dto.getNomeTreino());
        entity.setExercicios(dto.getExercicios().stream().map(TreinoExercicioMapper::toEntity).toList());

        repository.save(entity);
        return TreinoMapper.toDTO(entity);
    }

}
