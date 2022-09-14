package com.jeanlima.mvcapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeanlima.mvcapp.model.Curso;
import com.jeanlima.mvcapp.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @RequestMapping("/showForm")
    public String showFormCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/formCurso";
    }

    @RequestMapping("/addCurso")
    public String addCurso(@ModelAttribute("curso") Curso curso, Model model) {
        cursoService.salvarCurso(curso);
        model.addAttribute("curso", curso);
        return "curso/paginaCurso";
    }

    @RequestMapping("/listarCursos")
    public String listarCursos(Model model) {
        ArrayList<Curso> cursos = cursoService.getCursos();
        model.addAttribute("cursos", cursos);
        return "curso/listarCursos";
    }

    @GetMapping("/deletarCurso")
    public String deletarCurso(@RequestParam(value="id") Integer id, Model model) {
        Curso curso = cursoService.getCursoById(id);
        cursoService.removerCurso(curso);
        return "redirect:listarCursos";
    }
}
