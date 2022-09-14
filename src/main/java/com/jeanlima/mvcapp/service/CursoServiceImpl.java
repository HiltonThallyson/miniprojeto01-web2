package com.jeanlima.mvcapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.jeanlima.mvcapp.model.Curso;

@Component
public class CursoServiceImpl implements CursoService {

    public ArrayList<Curso> cursos = new ArrayList<Curso>();

    @Override
    public void removerCurso(Curso curso) {
        cursos.remove(curso);
    }

    @Override
    public void salvarCurso(Curso curso) {
        Integer id = cursos.size() + 1;
        Curso novoCurso = new Curso(curso.getNome());
        novoCurso.setId(id);
        if (!cursos.contains(novoCurso)) {
            cursos.add(novoCurso);
        }
    }

    @Override
    public ArrayList<Curso> getCursos() {
        return this.cursos;
    }

    @Override
    public Curso getCursoById(Integer id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;

    }

}
