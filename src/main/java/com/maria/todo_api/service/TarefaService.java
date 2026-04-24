package com.maria.todo_api.service;

import com.maria.todo_api.exception.TarefaNaoEncontradaException;
import com.maria.todo_api.model.Tarefa;
import com.maria.todo_api.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    public TarefaRepository repository;

    public TarefaService(TarefaRepository repository){
        this.repository = repository;
    }

    public Tarefa buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    public Tarefa criar(Tarefa tarefa){
        tarefa.setStatus("PENDENTE");
        return repository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa dados){
        Tarefa existente = buscarPorId(id);
        existente.setTitulo(dados.getTitulo());
        existente.setDescricao((dados.getDescricao()));
        existente.setStatus(dados.getStatus());
        return repository.save(existente);
    }

    public void deletar(Long id){
        buscarPorId(id);
        repository.deleteById(id);
    }

    public List<Tarefa> listar(String status) {
        if (status != null && !status.isBlank()) {
            return repository.findByStatus(status.toUpperCase());
        }
        return repository.findAll();
    }

}
