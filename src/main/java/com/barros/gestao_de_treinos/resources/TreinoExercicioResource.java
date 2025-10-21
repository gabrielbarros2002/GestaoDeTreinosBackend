package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.TreinoExercicio;
import com.barros.gestao_de_treinos.services.ExercicioService;
import com.barros.gestao_de_treinos.services.TreinoExercicioService;
import com.barros.gestao_de_treinos.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/treino-exercicio")
public class TreinoExercicioResource {

    @Autowired
    private TreinoExercicioService service;

    @Autowired
    private TreinoService treinoService;

    @Autowired
    private ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<TreinoExercicio>> findAll() {
        List<TreinoExercicio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<TreinoExercicio> findById(
            @RequestParam Long id
    ) {
        TreinoExercicio obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

}
