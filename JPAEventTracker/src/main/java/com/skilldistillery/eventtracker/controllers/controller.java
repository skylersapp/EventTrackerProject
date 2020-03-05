
package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Playground;
import com.skilldistillery.eventtracker.entities.Prospects;
import com.skilldistillery.eventtracker.services.ProspectServices;

@RequestMapping("api")
@RestController
public class ProspectController {

	@Autowired
	ProspectServices prospectServ;

	@GetMapping("prospects")
	public List<Prospects> getAll() {
		return prospectServ.getAll();
	}

	@PostMapping("prospects")
	public Prospects create(@RequestBody Prospects prospect, HttpServletResponse response) {
		System.err.println(prospect);
		if (prospectServ.create(prospect) != null) {
			response.setStatus(201);
			return prospect;
		}
		response.setStatus(400);
		return null;

	}

	@DeleteMapping("prospects/{pid}")
	public void delete(@PathVariable Integer pid, HttpServletResponse response) {
		System.err.println("****************" + pid);
		if (prospectServ.delete(pid)) {
			response.setStatus(204);

		} else {
			response.setStatus(400);
		}
	}

	@PutMapping("playgrounds/{pid}")
	public Prospects update(@PathVariable Integer pid, @RequestBody Playground prospect, HttpServletResponse response) {
		Prospects updatedProspect = playServ.update(pid, prospect);
		if (updatedProspect != null) {
			response.setStatus(200);
			return updatedProspect;

		} else {
			response.setStatus(400);
			return null;
		}

	}

}