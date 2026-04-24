package com.maria.todo_api.exception;

public class TarefaNaoEncontradaException extends RuntimeException{

    public TarefaNaoEncontradaException(Long id){
        super("Tarefa com id " + id +  " nao encontrada");
    }

}
