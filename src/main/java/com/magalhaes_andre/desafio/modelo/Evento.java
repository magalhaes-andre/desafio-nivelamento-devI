package com.magalhaes_andre.desafio.modelo;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Evento{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
    private String local;
	@OneToMany
	@JoinColumn(name = "id_evento")
	private List<Convidado> convidados;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLocal(String local){
        this.local = local;
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

    public String getLocal(){
        return this.local;
    }
}