package com.maria.todo_api.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResponse {

    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
    private List<String> detalhes;

    public ErroResponse(int status, String mensagem){
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }

    public ErroResponse(int status,String mensagem, List<String> detalhes){
        this(status, mensagem);
        this.detalhes = detalhes;

    }

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<String> getDetalhes() {
        return detalhes;
    }
}
