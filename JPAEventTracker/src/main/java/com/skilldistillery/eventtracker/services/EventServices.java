package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Prospects;

public interface EventServices {

	List<Prospects> getAll();

	Prospects create(Prospects prospect);

	boolean delete(Integer id);

	Prospects update(Integer id, Prospects prospect);

}