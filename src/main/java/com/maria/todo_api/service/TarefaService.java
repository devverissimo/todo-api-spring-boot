package com.maria.todo_api.service;

import com.maria.todo_api.dto.TarefaRequestDTO;
import com.maria.todo_api.dto.TarefaResponseDTO;
import com.maria.todo_api.exception.TarefaNaoEncontradaException;
import com.maria.todo_api.model.Tarefa;
import com.maria.todo_api.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TarefaService {

    public TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;
    }

    public TarefaResponseDTO buscarPorId(Long id){
        return TarefaResponseDTO.de(
                repository.findById(id)
                        .orElseThrow(() -> new TarefaNaoEncontradaException(id))
        );

    }

    public TarefaResponseDTO criar(@RequestBody @Valid TarefaRequestDTO dto){
        Tarefa tarefa  = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setPrazo(dto.prazo());
        tarefa.setStatus("PENDENTE");
        return TarefaResponseDTO.de(repository.save(tarefa));
    }

    public TarefaResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid TarefaRequestDTO dto){
        Tarefa existente = repository.findById(id)
                        .orElseThrow(() -> new TarefaNaoEncontradaException(id));

        existente.setTitulo(dto.titulo());
        existente.setDescricao(dto.descricao());
        existente.setStatus(dto.status());
        return TarefaResponseDTO.de(repository.save(existente));
    }

    public void deletar(Long id){
        repository.findById(id)
                        .orElseThrow(() -> new TarefaNaoEncontradaException(id));
        repository.deleteById(id);
    }

    public List<TarefaResponseDTO> listar(String status) {
        List<Tarefa> tarefas = (status != null && !status.isBlank())
                ? repository.findByStatus(status.toUpperCase())
                : repository.findAll();

        return tarefas.stream()
                .map(TarefaResponseDTO::de)
                .toList();
    }

}
