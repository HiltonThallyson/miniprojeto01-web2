package com.jeanlima.mvcapp.service;

import java.util.ArrayList;

import com.jeanlima.mvcapp.model.Curso;

public interface CursoService {
    public void salvarCurso(Curso curso);
    public void removerCurso(Curso curso);
    public Curso getCursoById(Integer id);
    public ArrayList<Curso> getCursos();
}
