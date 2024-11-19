package com.back_end.JobsRocket.dto;

public class CategoriaDto {
    private String nome;

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}