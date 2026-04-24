package com.maria.todo_api.dto;

import com.maria.todo_api.model.Tarefa;

import java.time.LocalDate;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String status,
        LocalDate prazo
) {
    public static TarefaResponseDTO de(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getPrazo()
        );
    }

}
