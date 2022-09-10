package com.jeanlima.mvcapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jeanlima.mvcapp.model.Estudante;

@Component
public class EstudanteServiceImpl implements EstudanteService{

    public List<Estudante> estudantes = new ArrayList<Estudante>();    

    @Override
    public void salvarEstudante(Estudante estudante) {
        Integer id = estudantes.size()+1;
        Estudante novoEstudante = new Estudante(estudante.getPrimeiroNome(), estudante.getUltimoNome(), estudante.getCurso(), estudante.getLinguagem(), estudante.getEmail());
        novoEstudante.setId(id);
        try{
            this.estudantes.add(novoEstudante);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        
    }

    @Override
    public void deletarEstudante(Estudante estudante) {
        
        this.estudantes.remove(estudante);
        
    }

    @Override
    public Estudante getEstudanteById(Integer id) {
        for (Estudante estudante : estudantes) {
            if(estudante.getId() == id){
                return estudante;
            }
        }
        return null;
    }

    @Override
    public List<Estudante> getListaEstudante() {
        return this.estudantes;
    }

    @Override
    public List<Estudante> getListaEstudanteByCurso(String curso) {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        for (Estudante estudante : this.estudantes) {
            if(estudante.getCurso().equals(curso)){
                estudantes.add(estudante);
            }
        }
        return estudantes;
    }
    @Override
    public List<Estudante> getListaEstudanteByLanguage(String language) {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        for (Estudante estudante : this.estudantes) {
            if(estudante.getLinguagem().equals(language)){
                estudantes.add(estudante);
            }
        }
        return estudantes;
    }

    
}
