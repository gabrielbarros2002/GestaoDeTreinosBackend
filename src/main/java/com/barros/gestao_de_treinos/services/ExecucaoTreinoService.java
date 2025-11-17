package com.barros.gestao_de_treinos.services;

import com.barros.gestao_de_treinos.DTOs.ExecucaoExercicioSerieDTO;
import com.barros.gestao_de_treinos.DTOs.ExecucaoTreinoDTO;
import com.barros.gestao_de_treinos.DTOs.ExecucaoTreinoExercicioDTO;
import com.barros.gestao_de_treinos.entities.ExecucaoExercicioSerie;
import com.barros.gestao_de_treinos.entities.ExecucaoTreino;
import com.barros.gestao_de_treinos.entities.ExecucaoTreinoExercicio;
import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.mappers.ExecucaoTreinoMapper;
import com.barros.gestao_de_treinos.repositories.ExecucaoExercicioSerieRepository;
import com.barros.gestao_de_treinos.repositories.ExecucaoTreinoExercicioRepository;
import com.barros.gestao_de_treinos.repositories.ExecucaoTreinoRepository;
import com.barros.gestao_de_treinos.repositories.ExercicioRepository;
import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.barros.gestao_de_treinos.utils.Util.naoTemValor;

@Service
public class ExecucaoTreinoService {

    @Autowired
    private ExecucaoTreinoRepository repository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private ExecucaoExercicioSerieRepository exercicioSerieRepository;

    @Autowired
    private ExecucaoTreinoExercicioRepository treinoExercicioRepository;

    public static final String MSG_NAO_ENCONTRADO = "Execução de treino não encontrada. Id = ";

    public List<ExecucaoTreinoDTO> findAll() {
        List<ExecucaoTreino> treinoList = repository.findAll();
        return treinoList.stream().map(ExecucaoTreinoMapper::toDTO).toList();
    }

    public ExecucaoTreinoDTO findById(Long id) {
        ExecucaoTreino obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + id));
        return ExecucaoTreinoMapper.toDTO(obj);
    }

    public ExecucaoTreinoDTO insert(ExecucaoTreinoDTO dto) {
        ExecucaoTreino novoTreino = gravarTreino(null, dto, true);
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

    public ExecucaoTreinoDTO update(Long id, ExecucaoTreinoDTO obj) {
        obj.setIdTreino(id);
        ExecucaoTreino treinoAtualizado = gravarTreino(id, obj, false);
        return findById(treinoAtualizado.getId());
    }

    private ExecucaoTreino gravarTreino(Long idTreino, ExecucaoTreinoDTO dto, Boolean insercao) {
        ExecucaoTreino treino;
        if (insercao) {
            treino = new ExecucaoTreino();
            treino.setId(null);
            treino.setDataHoraExecucao(LocalDateTime.now());
        } else {
            treino = repository.findById(idTreino).orElseThrow(
                    () -> new ResourceNotFoundException(MSG_NAO_ENCONTRADO + idTreino));
        }

        treino.setNome(dto.getNomeTreino());
        treino.getExercicios().clear();
        for (ExecucaoTreinoExercicioDTO treinoExercicioDTO : dto.getExercicios()) {
            ExecucaoTreinoExercicio treinoExercicio = criarTreinoExercicio(treino, treinoExercicioDTO, insercao);
            treino.addExercicio(treinoExercicio);

            for (ExecucaoExercicioSerieDTO serieDTO : treinoExercicioDTO.getSeries()) {
                ExecucaoExercicioSerie exercicioSerie = criarExercicioSerie(treinoExercicio, serieDTO, insercao);
                treinoExercicio.addSerie(exercicioSerie);
            }
        }

        return repository.save(treino);
    }

    private ExecucaoTreinoExercicio criarTreinoExercicio(ExecucaoTreino treino, ExecucaoTreinoExercicioDTO treinoExercicioDTO, Boolean insercao) {
        ExecucaoTreinoExercicio treinoExercicio;
        Long idTreinoExercicio = treinoExercicioDTO.getId();
        if (insercao || naoTemValor(idTreinoExercicio)) {
            treinoExercicio = new ExecucaoTreinoExercicio();
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

    private ExecucaoExercicioSerie criarExercicioSerie(ExecucaoTreinoExercicio treinoExercicio, ExecucaoExercicioSerieDTO serieDTO, Boolean insercao) {
        ExecucaoExercicioSerie exercicioSerie;
        Long idExercicioSerie = serieDTO.getId();
        if (insercao || naoTemValor(serieDTO.getId())) {
            exercicioSerie = new ExecucaoExercicioSerie();
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
