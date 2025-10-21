package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.DTOs.TreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.mappers.TreinoExercicioMapper;
import com.barros.gestao_de_treinos.mappers.TreinoMapper;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.repositories.UsuarioRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    public List<Treino> findAll() {
        return repository.findAll();
    }

    public Treino findById(Long id) {
        Optional<Treino> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public TreinoDTO insert(TreinoDTO dto) {
        Usuario instrutor = usuarioRepository.findById(dto.getIdInstrutor())
                .orElseThrow(() -> new ResourceNotFoundException(dto.getIdInstrutor()));

        Treino treino = TreinoMapper.toEntity(dto);
        treino.setExercicios(new ArrayList<>());
        treino = repository.save(treino);

        Treino finalTreino = treino;
        List<TreinoExercicio> exercicios = dto.getExercicios().stream().map(teDto -> {
            Exercicio exercicio = exercicioRepository.findById(teDto.getIdExercicio())
                    .orElseThrow(() -> new ResourceNotFoundException(teDto.getIdExercicio()));
            return TreinoExercicioMapper.toEntity(teDto, finalTreino, exercicio);
        }).toList();

        treino.setExercicios(exercicios);
        treino = repository.save(treino);

        TreinoDTO retorno = TreinoMapper.toDTO(treino);
        List<TreinoExercicioDTO> exerciciosDTO = treino.getExercicios().stream()
                .map(TreinoExercicioMapper::toDTO)
                .collect(Collectors.toList());
        retorno.setExercicios(exerciciosDTO);
        return retorno;
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public TreinoDTO update(Long id, TreinoDTO obj) {
        try {
            Treino entity = repository.getReferenceById(id);
            return updateData(entity, obj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private TreinoDTO updateData(Treino entity, TreinoDTO dto) {
        entity.setNome(dto.getNomeTreino());

        Set<TreinoExercicio> novosExercicios = Optional.ofNullable(dto.getExercicios())
                .orElseThrow(() -> new RuntimeException("Exercícios não foram enviados"))
                .stream()
                .map(teDto -> {
                    Exercicio exercicio = exercicioRepository.findById(teDto.getIdExercicio())
                            .orElseThrow(() -> new ResourceNotFoundException(teDto.getIdExercicio()));
                    return TreinoExercicioMapper.toEntity(teDto, entity, exercicio);
                })
                .collect(Collectors.toSet());

        entity.getExercicios().clear();
        entity.getExercicios().addAll(novosExercicios);

        Treino atualizado = repository.save(entity);

        TreinoDTO retorno = TreinoMapper.toDTO(atualizado);
        List<TreinoExercicioDTO> exerciciosDTO = atualizado.getExercicios().stream()
                .map(TreinoExercicioMapper::toDTO)
                .collect(Collectors.toList());
        retorno.setExercicios(exerciciosDTO);

        return retorno;
    }

}
