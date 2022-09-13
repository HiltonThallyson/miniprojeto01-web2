package com.jeanlima.mvcapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.jeanlima.mvcapp.model.Curso;

@Component
public class CursoServiceImpl implements CursoService {

    public ArrayList<Curso> cursos;

    @Override
    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }

    @Override
    public void salvarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

}
