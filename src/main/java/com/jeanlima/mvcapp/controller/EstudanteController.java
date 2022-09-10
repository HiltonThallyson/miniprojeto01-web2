package com.jeanlima.mvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeanlima.mvcapp.model.Estudante;
import com.jeanlima.mvcapp.service.EstudanteService;

@Controller
@RequestMapping("/estudante")
public class EstudanteController {


    @Autowired
    @Qualifier("estudanteServiceImpl")
    EstudanteService estudanteService;

    @RequestMapping("/showForm")
    public String showFormEstudante(Model model){

        model.addAttribute("estudante", new Estudante());
        return "estudante/formEstudante";
    }

    @RequestMapping("/addEstudante")
    public String showFormEstudante(@ModelAttribute("estudante") Estudante estudante,  Model model){

        estudanteService.salvarEstudante(estudante);
        model.addAttribute("estudante", estudante);
        return "estudante/paginaEstudante";
    }

    @GetMapping("/detalharEstudante")
    public String detalharEstudante(@RequestParam(value="id") Integer id, Model model) {
        Estudante estudante = estudanteService.getEstudanteById(id);
        model.addAttribute("estudante", estudante);
        return "estudante/paginaEstudante";
    }

    @RequestMapping("/getListaEstudantes")
    public String showListaEstudante(Model model){

        List<Estudante> estudantes = estudanteService.getListaEstudante();
        model.addAttribute("estudantes",estudantes);
        return "estudante/listaEstudantes";

    }

    @RequestMapping("/getListaEstudantesPorCurso")
    public String showListaEstudantesPorCurso(Model model) {
        List<Estudante> estudantesBTI = estudanteService.getListaEstudanteByCurso("BTI");
        List<Estudante> estudantesEngComp = estudanteService.getListaEstudanteByCurso("EngComp");
        List<Estudante> estudantesEngSoft = estudanteService.getListaEstudanteByCurso("EngSoft");
        model.addAttribute("estudantesBTI", estudantesBTI);
        model.addAttribute("estudantesEngComp", estudantesEngComp);
        model.addAttribute("estudantesEngSoft", estudantesEngSoft);
        return "estudante/listaEstudantesPorCurso";
    }

    @RequestMapping("/getListaEstudantesPorLinguagem")
    public String showListaEstudantesPorLinguagem(Model model) {
        List<Estudante> estudantesJava = estudanteService.getListaEstudanteByLanguage("Java");
        List<Estudante> estudantesC = estudanteService.getListaEstudanteByLanguage("C");
        List<Estudante> estudantesPython = estudanteService.getListaEstudanteByLanguage("Python");
        List<Estudante> estudantesJs = estudanteService.getListaEstudanteByLanguage("Javasript");
        model.addAttribute("estudantesJava", estudantesJava);
        model.addAttribute("estudantesC", estudantesC);
        model.addAttribute("estudantesPython", estudantesPython);
        model.addAttribute("estudantesJs", estudantesJs);
        return "estudante/listaEstudantePorLinguagem";
    }

    
    
}
