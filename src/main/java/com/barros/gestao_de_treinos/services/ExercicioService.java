package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.ExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.GrupoMuscular;
import com.barros.gestao_de_treinos.mappers.ExercicioMapper;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.repositories.GrupoMuscularRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    @Autowired
    private GrupoMuscularRepository grupoMuscularRepository;

    public static final String MSG_NAO_ENCONTRADO = "Exercício não encontrado. Id = ";

    public List<ExercicioDTO> findAll() {
        List<Exercicio> exercicioList = repository.findAll();
        return exercicioList.stream().map(ExercicioMapper::toDTO).toList();
    }

    public ExercicioDTO findById(Long id) {
        Exercicio entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
        return ExercicioMapper.toDTO(entity);
    }

    public ExercicioDTO insert(ExercicioDTO obj) {
        Exercicio entityCriada = repository.save(ExercicioMapper.toEntity(obj));
        return ExercicioMapper.toDTO(entityCriada);
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

    public ExercicioDTO update(Long id, ExercicioDTO obj) {
        try {
            Exercicio entity = repository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
            updateData(entity, obj);
            repository.save(entity);
            return findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id);
        }
    }

    private void updateData(Exercicio entity, ExercicioDTO obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());

        Long idGrupoMuscular = obj.getIdGrupoMuscular();
        GrupoMuscular grupoMuscular = grupoMuscularRepository.findById(idGrupoMuscular).orElseThrow(
                () -> new ResourceNotFoundException(GrupoMuscularService.MSG_NAO_ENCONTRADO + idGrupoMuscular));
        grupoMuscular.setId(obj.getIdGrupoMuscular());
        grupoMuscular.setNome(obj.getNomeGrupoMuscular());
        entity.setGrupoMuscular(grupoMuscular);
    }
}
