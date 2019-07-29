package com.magalhaes_andre.desafio.modelo;

import java.util.List;

public class Evento{

    private String nome;
    private Local localDoEvento;
    private List<Convidado> convidados;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLocal(Local local){
        this.localDoEvento = local;
    }

    public void setConvidados(List<Convidado> convidados){
        this.convidados = convidados;
    }

    public String getNome(){
        return this.nome;
    }

    public List<Convidado> getConvidados(){
        return this.convidados;
    }

    public Local getLocal(){
        return this.localDoEvento;
    }
}