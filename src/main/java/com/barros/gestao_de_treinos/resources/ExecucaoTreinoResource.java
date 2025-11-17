package com.barros.gestao_de_treinos.resources;

import com.barros.gestao_de_treinos.DTOs.ExecucaoTreinoDTO;
import com.barros.gestao_de_treinos.services.ExecucaoTreinoService;
import com.barros.gestao_de_treinos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/execucao-treino")
public class ExecucaoTreinoResource {

    @Autowired
    private ExecucaoTreinoService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<ExecucaoTreinoDTO>> findAll() {
        List<ExecucaoTreinoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExecucaoTreinoDTO> findById(@PathVariable Long id) {
        ExecucaoTreinoDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ExecucaoTreinoDTO> insert(@RequestBody ExecucaoTreinoDTO obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdExecucaoTreino()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ExecucaoTreinoDTO> update(@PathVariable Long id, @RequestBody ExecucaoTreinoDTO obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
