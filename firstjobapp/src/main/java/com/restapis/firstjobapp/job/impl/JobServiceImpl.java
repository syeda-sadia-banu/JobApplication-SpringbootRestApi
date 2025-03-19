package com.restapis.firstjobapp.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapis.firstjobapp.job.Job;
import com.restapis.firstjobapp.job.JobRepository;
import com.restapis.firstjobapp.job.JobService;

import jakarta.transaction.Transactional;

@Service
public class JobServiceImpl implements JobService {

	// private List<Job> jobs = new ArrayList<>();

	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	//private Long nextId = 1L;

	@Override
	public List<Job> findAll() {

		return jobRepository.findAll();
	}

	@Override
	@Transactional
	public void createJob(Job job) {
		//job.setId(nextId++);

		jobRepository.save(job);

	}

	@Override
	@Transactional
	public Job getJobById(Long id) {
		/*
		 * for (Job job : job) { if (job.getId().equals(id)) {
		 * 
		 * return job; }
		 * 
		 * } return null;
		 */
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {
		/*
		 * Iterator<Job> iterator = jobs.iterator(); while (iterator.hasNext()) { Job
		 * job = iterator.next(); if (job.getId().equals(id)) { iterator.remove();
		 * return true; } } return false;
		 */
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOptional=jobRepository.findById(id);
		  
		if (jobOptional.isPresent()) {
			Job job=jobOptional.get();
		  job.setTitle(updatedJob.getTitle());
		  job.setMinSalary(updatedJob.getMinSalary());
		  job.setMaxSalary(updatedJob.getMaxSalary());
		  job.setLocation(updatedJob.getLocation()); 
		  jobRepository.save(job);
		  return true; 
		  }
		
	return false;

}

}
