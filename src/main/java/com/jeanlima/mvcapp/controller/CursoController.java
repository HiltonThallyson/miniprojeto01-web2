package com.jeanlima.mvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "curso/showCursos";
    }
}
