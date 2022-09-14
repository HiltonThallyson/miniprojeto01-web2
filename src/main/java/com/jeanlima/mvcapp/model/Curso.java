package com.jeanlima.mvcapp.model;

public class Curso {
    private Integer id;
    private String nome;

    public Curso(){}

    public Curso(Integer id, String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
