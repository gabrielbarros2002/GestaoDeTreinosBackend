package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import com.barros.gestao_de_treinos.repositories.AvaliacaoFisicaRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository repository;

    public static final String MSG_NAO_ENCONTRADO = "Avaliação física não encontrada. Id = ";

    public List<AvaliacaoFisica> findAll() {
        return repository.findAll();
    }

    public AvaliacaoFisica findById(Long id) {
        Optional<AvaliacaoFisica> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
    }

    public AvaliacaoFisica insert(AvaliacaoFisica obj) {
        return repository.save(obj);
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

    public AvaliacaoFisica update(Long id, AvaliacaoFisica obj) {
        try {
            AvaliacaoFisica entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id);
        }
    }

    private void updateData(AvaliacaoFisica entity, AvaliacaoFisica obj) {
        entity.setData(obj.getData());
        entity.setAltura(obj.getAltura());
        entity.setPeso(obj.getPeso());
        entity.setPercentualGordura(obj.getPercentualGordura());
    }
}
