package com.skilldistillery.eventtracker.service;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Jobs;

public interface JobsService {

	
	public List<Jobs> getJobsList();
	public Jobs getJob(Integer id);
	public Jobs createJob(Jobs job);
	public Jobs updateJob(Jobs job, Integer id);
	public Boolean deleteJob(Integer id);
}
