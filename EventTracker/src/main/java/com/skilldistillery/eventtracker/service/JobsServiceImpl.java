package com.skilldistillery.eventtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Jobs;
import com.skilldistillery.eventtracker.repository.JobsRepo;

@Service
public class JobsServiceImpl implements JobsService{

	@Autowired
	private JobsRepo repo;
	
	@Override
	public List<Jobs> getJobsList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Jobs getJob(Integer id) {
		Optional<Jobs> jobOpt = repo.findById(id);
		if (jobOpt.isPresent()) {
			return jobOpt.get();
		}
		return null;
	}

	@Override
	public Jobs createJob(Jobs job) {
		repo.saveAndFlush(job);
		return job;
	}

	@Override
	public Jobs updateJob(Jobs job, Integer id) {
		Optional<Jobs> jobOpt = repo.findById(id);
		if (jobOpt.isPresent()) {
			Jobs managedJob = jobOpt.get();
			managedJob.setCompany(job.getCompany());
			managedJob.setInterviewer(job.getInterviewer());
			managedJob.setDateApplied(job.getDateApplied());
			managedJob.setPosition(job.getPosition());
			managedJob.setFirstInterview(job.getFirstInterview());
			managedJob.setDateFollowup(job.getDateFollowup());
			managedJob.setPositionOffered(job.getPositionOffered());
			managedJob.setSalary(job.getSalary());
			managedJob.setDateNext(job.getDateNext());
			repo.saveAndFlush(managedJob);
			return managedJob;
		}
		return job;
	}

	@Override
	public Boolean deleteJob(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	

}
