package com.magalhaes_andre.desafio.dao;

import org.springframework.data.repository.CrudRepository;

import com.magalhaes_andre.desafio.modelo.Evento;

public interface EventoDAO extends CrudRepository<Evento, Long> {

}
