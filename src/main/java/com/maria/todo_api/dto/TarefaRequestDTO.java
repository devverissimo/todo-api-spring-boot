package com.maria.todo_api.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;


public record TarefaRequestDTO(
       @NotBlank(message = "Titulo é obrigatorio")
       String titulo,

       String descricao,
       String status,
       @FutureOrPresent(message = "O prazo nao pode ser uma data no passado")
       LocalDate prazo
) {}
