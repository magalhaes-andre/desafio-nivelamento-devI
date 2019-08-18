package com.magalhaes_andre.guestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.magalhaes_andre.guestbook.model.Event;

public interface EventDAO extends CrudRepository<Event, Long> {

}
