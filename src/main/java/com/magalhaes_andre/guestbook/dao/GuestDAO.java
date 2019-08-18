package com.magalhaes_andre.guestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.magalhaes_andre.guestbook.model.Guest;

public interface GuestDAO extends CrudRepository<Guest, Long>{

}
