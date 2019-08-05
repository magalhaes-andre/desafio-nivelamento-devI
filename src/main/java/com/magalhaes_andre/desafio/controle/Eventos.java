package com.magalhaes_andre.desafio.controle;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.magalhaes_andre.desafio.dao.ConvidadoDAO;
import com.magalhaes_andre.desafio.dao.EventoDAO;
import com.magalhaes_andre.desafio.modelo.Convidado;
import com.magalhaes_andre.desafio.modelo.Evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Eventos {
	private List<Evento> eventos;

	@Autowired
	EventoDAO eventoDAO;
	
	@Autowired
	ConvidadoDAO convidadoDAO;

	private boolean isPreenchido(Evento evento) {
		boolean validacao = false;
		if (!evento.getNome().isEmpty() && !evento.getLocal().isEmpty() && !evento.getConvidados().isEmpty()) {
			validacao = true;
		}
		return validacao;
	}

	private boolean convidadosRepetem(List<Convidado> convidados) {
		return convidados.stream()
				.filter(c -> Collections.frequency(convidados, c.getNome()) > 1)
				.findAny()
				.isPresent();
	}

	private boolean validaEvento(Evento evento) {
		return (isPreenchido(evento) && !convidadosRepetem(evento.getConvidados()));
	}

	@PostMapping("/adicionaEvento")
	public Evento adicionaEvento(@RequestBody Evento evento) {
		if (validaEvento(evento)) {
			for(Convidado convidado : evento.getConvidados()) {
				convidadoDAO.save(convidado);
			}
			eventoDAO.save(evento);
		}
		return evento;
	}

	@GetMapping("/listaEventos")
	public List<Evento> listaEventos() {
		return (List<Evento>) eventoDAO.findAll();
	}

	@DeleteMapping("/deletaEvento/{id}")
	public boolean deletaEvento(@PathVariable Long id) {
		try {
			eventoDAO.deleteById(id);
		} catch (Exception excecao) {
			return false;
		}
		return true;
	}
}