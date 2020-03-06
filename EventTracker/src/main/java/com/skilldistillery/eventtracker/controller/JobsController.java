package com.skilldistillery.eventtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Jobs;
import com.skilldistillery.eventtracker.service.JobsService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*","http://localhost:4200"})
public class JobsController {

	@Autowired
	private JobsService srv;
	
	@GetMapping("jobs")
	public List<Jobs> getJobList(){
		return srv.getJobsList();
	}
	
	@GetMapping("jobs/{id}")
	public Jobs getJob(@PathVariable Integer id) {
		return srv.getJob(id);
	}
	
	@PostMapping("jobs")
	public Jobs createJobs(@RequestBody Jobs job) {
		return srv.createJob(job);
	}
	
	@PutMapping("jobs/{id}")
	public Jobs updateJobs(@RequestBody Jobs job, @PathVariable Integer id) {
		return srv.updateJob(job, id);
	}
	
	@DeleteMapping("jobs/{id}")
	public void deleteJobs(@PathVariable Integer id) {
		srv.deleteJob(id);
	}
	
}
