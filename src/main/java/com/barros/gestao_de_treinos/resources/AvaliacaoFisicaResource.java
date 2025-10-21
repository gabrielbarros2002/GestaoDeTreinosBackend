package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.entities.AvaliacaoFisica;
import com.barros.gestao_de_treinos.services.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacao-fisica")
public class AvaliacaoFisicaResource {

    @Autowired
    private AvaliacaoFisicaService service;

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> findAll() {
        List<AvaliacaoFisica> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoFisica> findById(@PathVariable Long id) {
        AvaliacaoFisica obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> insert(@RequestBody AvaliacaoFisica obj) {
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
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @RequestBody AvaliacaoFisica obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
