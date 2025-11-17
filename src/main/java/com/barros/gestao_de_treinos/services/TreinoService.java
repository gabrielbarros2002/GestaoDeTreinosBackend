package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.ExercicioSerieDTO;
import com.barros.gestao_de_treinos.DTOs.TreinoDTO;
import com.barros.gestao_de_treinos.DTOs.TreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.entities.ExercicioSerie;
import com.barros.gestao_de_treinos.entities.Treino;
import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.mappers.TreinoMapper;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.repositories.ExercicioSerieRepository;
import com.barros.gestao_de_treinos.repositories.TreinoExercicioRepository;
import com.barros.gestao_de_treinos.repositories.TreinoRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.barros.gestao_de_treinos.utils.Util.naoTemValor;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private ExercicioSerieRepository exercicioSerieRepository;

    @Autowired
    private TreinoExercicioRepository treinoExercicioRepository;

    public static final String MSG_NAO_ENCONTRADO = "Treino não encontrado. Id = ";

    public List<TreinoDTO> findAll() {
        List<Treino> treinoList = repository.findAll();
        return treinoList.stream().map(TreinoMapper::toDTO).toList();
    }

    public TreinoDTO findById(Long id) {
        Treino obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
        return TreinoMapper.toDTO(obj);
    }

    public TreinoDTO insert(TreinoDTO dto) {
        Treino novoTreino = gravarTreino(null, dto, true);
        return findById(novoTreino.getId());
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
        obj.setIdTreino(id);
        Treino treinoAtualizado = gravarTreino(id, obj, false);
        return findById(treinoAtualizado.getId());
    }

    private Treino gravarTreino(Long idTreino, TreinoDTO dto, Boolean insercao) {
        Treino treino;
        if (insercao) {
            treino = new Treino();
            treino.setId(null);
            treino.setDataCriacao(LocalDate.now());
        } else {
            treino = repository.findById(idTreino).orElseThrow(
                    () -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + idTreino));
        }

        treino.setNome(dto.getNomeTreino());
        treino.getExercicios().clear();
        for (TreinoExercicioDTO treinoExercicioDTO : dto.getExercicios()) {
            TreinoExercicio treinoExercicio = criarTreinoExercicio(treino, treinoExercicioDTO, insercao);
            treino.addExercicio(treinoExercicio);

            for (ExercicioSerieDTO serieDTO : treinoExercicioDTO.getSeries()) {
                ExercicioSerie exercicioSerie = criarExercicioSerie(treinoExercicio, serieDTO, insercao);
                treinoExercicio.addSerie(exercicioSerie);
            }
        }

        return repository.save(treino);
    }

    private TreinoExercicio criarTreinoExercicio(Treino treino, TreinoExercicioDTO treinoExercicioDTO, Boolean insercao) {
        TreinoExercicio treinoExercicio;
        Long idTreinoExercicio = treinoExercicioDTO.getId();
        if (insercao || naoTemValor(idTreinoExercicio)) {
            treinoExercicio = new TreinoExercicio();
            treinoExercicio.setId(null);
        } else {
            treinoExercicio = treinoExercicioRepository.findById(idTreinoExercicio).orElseThrow(
                    () -> new ResourceNotFoundException(TreinoExercicioService.MSG_NAO_ENCONTRADO + idTreinoExercicio));
        }

        treinoExercicio.setTreino(treino);

        Long idExercicio = treinoExercicioDTO.getIdExercicio();
        Exercicio exercicio = exercicioRepository.findById(idExercicio).orElseThrow(
                () -> new ResourceNotFoundException(ExercicioService.MSG_NAO_ENCONTRADO + idExercicio));

        treinoExercicio.setExercicio(exercicio);
        treinoExercicio.setOrdem(treinoExercicioDTO.getOrdem());
        treinoExercicio.setDescansoSegundos(treinoExercicioDTO.getDescansoSegundos());

        return treinoExercicio;
    }

    private ExercicioSerie criarExercicioSerie(TreinoExercicio treinoExercicio, ExercicioSerieDTO serieDTO, Boolean insercao) {
        ExercicioSerie exercicioSerie;
        Long idExercicioSerie = serieDTO.getId();
        if (insercao || naoTemValor(serieDTO.getId())) {
            exercicioSerie = new ExercicioSerie();
            exercicioSerie.setId(null);
        } else {
            exercicioSerie = exercicioSerieRepository.findById(idExercicioSerie).orElseThrow(
                    () -> new ResourceNotFoundException(ExercicioSerieService.MSG_NAO_ENCONTRADO + idExercicioSerie));
        }

        exercicioSerie.setNumSerie(serieDTO.getNumSerie());
        exercicioSerie.setCarga(serieDTO.getCarga());
        exercicioSerie.setRepeticoes(serieDTO.getRepeticoes());
        exercicioSerie.setTreinoExercicio(treinoExercicio);

        return exercicioSerie;
    }

}
