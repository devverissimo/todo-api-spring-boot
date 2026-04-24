package com.maria.todo_api.controller;

import com.maria.todo_api.model.Tarefa;
import com.maria.todo_api.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody @Valid Tarefa tarefa) {
        return ResponseEntity.status(201).body(service.criar(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>>listar(@RequestParam(required = false) String status){
        return ResponseEntity.ok(service.listar(status));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        return ResponseEntity.ok(service.atualizar(id, tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> detelar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
