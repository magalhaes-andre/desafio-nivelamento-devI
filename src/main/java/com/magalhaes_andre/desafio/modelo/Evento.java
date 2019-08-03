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
	
	@ElementCollection
	@CollectionTable(name="Convidados", joinColumns=@JoinColumn(name="evento_id"))
	@Column(name="convidado")
	private List<String> convidados;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setConvidados(List<String> convidados){
        this.convidados = convidados;
    }

    public String getNome(){
        return this.nome;
    }

    public List<String> getConvidados(){
        return this.convidados;
    }

    public String getLocal(){
        return this.local;
    }
}