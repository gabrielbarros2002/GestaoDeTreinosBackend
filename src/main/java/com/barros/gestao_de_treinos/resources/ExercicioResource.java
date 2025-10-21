package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.Exercicio;
import com.barros.gestao_de_treinos.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/exercicio")
public class ExercicioResource {

    @Autowired
    private ExercicioService service;

    @GetMapping
    public ResponseEntity<List<Exercicio>> findAll() {
        List<Exercicio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exercicio> findById(@PathVariable Long id) {
        Exercicio obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Exercicio> insert(@RequestBody Exercicio obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Exercicio> update(@PathVariable Long id, @RequestBody Exercicio obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
