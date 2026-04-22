package com.maria.todo_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String  descrição;

    @Column(nullable = false)
    private String status;

    private LocalDate prazo;

    public Long getId(){ return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPrazo() {
        return prazo;
    }
    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
}
