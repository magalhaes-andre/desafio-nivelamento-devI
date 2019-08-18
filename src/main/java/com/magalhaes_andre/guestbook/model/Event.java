package com.magalhaes_andre.guestbook.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Event{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
    private String local;
	@OneToMany
	@JoinColumn(name = "event_id")
	private List<Guest> guests;

    public void setName(String name){
        this.name = name;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setGuests(List<Guest> guests){
        this.guests = guests;
    }

    public String getName(){
        return this.name;
    }

    public List<Guest> getGuests(){
        return this.guests;
    }

    public String getLocal(){
        return this.local;
    }
}