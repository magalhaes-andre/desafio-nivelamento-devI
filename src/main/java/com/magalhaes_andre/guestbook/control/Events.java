package com.magalhaes_andre.guestbook.control;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magalhaes_andre.guestbook.dao.GuestDAO;
import com.magalhaes_andre.guestbook.dao.EventDAO;
import com.magalhaes_andre.guestbook.model.Guest;
import com.magalhaes_andre.guestbook.model.Event;
import com.magalhaes_andre.guestbook.model.Event;

@RestController
@RequestMapping("/guestbook")
public class Events {
	private List<Event> events;

	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	GuestDAO convidadoDAO;

	@PostMapping
	public Event addEvent(@RequestBody Event event) {
		eventDAO.save(event);
		return event;
	}

	@GetMapping
	public List<Event> listEvents() {
		return (List<Event>) eventDAO.findAll();
	}

	@DeleteMapping("/{id}")
	public boolean deleteEvent(@PathVariable Long id) {
		eventDAO.deleteById(id);
		return true;
	}
}