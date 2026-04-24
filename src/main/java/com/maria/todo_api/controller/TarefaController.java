package com.maria.todo_api.controller;

import com.maria.todo_api.dto.TarefaRequestDTO;
import com.maria.todo_api.dto.TarefaResponseDTO;
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
    public ResponseEntity<TarefaResponseDTO> criar(@RequestBody @Valid TarefaRequestDTO dto) {
        return ResponseEntity.status(201).body(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>>listar(@RequestParam(required = false) String status){
        return ResponseEntity.ok(service.listar(status));
    }


    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO dto){
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> detelar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
