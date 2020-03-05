package com.skilldistillery.eventtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Jobs;

public interface JobsRepo extends JpaRepository<Jobs, Integer> {

}
