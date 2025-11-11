package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.repositories.TreinoExercicioRepository;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioSerieService {

    @Autowired
    private TreinoExercicioRepository respository;

    public static final String MSG_NAO_ENCONTRADO = "Série do exercício não encontrada. Id = ";

    public List<TreinoExercicio> findAll() {
        return respository.findAll();
    }

    public TreinoExercicio findById(Long id) {
        Optional<TreinoExercicio> obj = respository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
    }
}
