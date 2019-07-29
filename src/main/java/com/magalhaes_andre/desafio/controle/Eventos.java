package com.magalhaes_andre.desafio.controle;

import java.util.List;
import java.util.Optional;

import com.magalhaes_andre.desafio.modelo.Convidado;
import com.magalhaes_andre.desafio.modelo.Evento;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Eventos{
    private List<Evento> eventos;

    @RequestMapping("/adicionaEvento")
    public Evento adicionaEvento(@RequestBody Evento evento){
        eventos.add(evento);
        return evento;
    }

    @RequestMapping("/pesquisaEvento/{nomeDoEvento}")
    public Optional<Evento> pesquisaEvento(@PathVariable("nomeDoEvento") String nomeDoEvento){
        return eventos
                    .stream()
                    .filter(evento -> evento.getNome().equalsIgnoreCase(nomeDoEvento))
                    .findAny();
    }

    

    /*
    public Optional<Convidado> estaEmEvento(String nome){
        Optional<Convidado> convidado = Optional.empty();
        for(Evento evento : eventos){
            convidado = evento.getConvidados()
                    .stream()
                    .filter(c -> c.getNome().equalsIgnoreCase(nome))
                    .findAny();
        }        
        return convidado;
    }
    */

    public boolean temConvidadoRepetido(String nome){
        Optional<Convidado> convidado = Optional.empty();
        
        for(Evento evento : eventos){
            convidado = evento.getConvidados()
            .stream()
            .filter(c -> c.getNome().equalsIgnoreCase(nome))
            .findAny();
        }

        return convidado.isPresent();
    }

    @RequestMapping("/listaEventos")
    public List<Evento> listaEventos(){
        return eventos;
    }
}