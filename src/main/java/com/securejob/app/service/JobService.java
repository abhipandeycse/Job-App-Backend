package com.securejob.app.service;

import com.securejob.app.repository.JobRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securejob.app.model.JobPost;

@Service
public class JobService {
	
	
	@Autowired
	public JobRepo repo;

	public void addJob(JobPost jobPost) {
		 repo.save(jobPost);
	}
	
	public List<JobPost> getAllJobs() {
		return repo.findAll();

	}
	
	public Optional<JobPost> getJob(int postId) {
		return repo.findById(postId);

	}
	
	public void updateJob(JobPost jobPost) {
		 repo.save(jobPost);
	}
	
	public void deleteJob(int postId) {
		 repo.deleteById(postId);
	}

	public void load() {
		List<JobPost> jobs = new ArrayList<>(List.of(
				new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
				new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",3, List.of("HTML", "CSS", "JavaScript", "React")),
				new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,List.of("Python", "Machine Learning", "Data Analysis")),
				new JobPost(4, "Network Engineer","Design and implement computer networks for efficient data communication", 5,List.of("Networking", "Cisco", "Routing", "Switching"))));
		
		repo.saveAll(jobs);
	}

	public List<JobPost> search(String keyword) {
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}
	
	
		
	
	
/*THIS ALL WE HAVE DONE FOR LIST ABOVE IS FOR THE DATABASE
 * 
 *  
@Autowired
	public JobRepo1 repo;

public List<JobPost> returnAllJobPosts() {
		return repo.returnAllJobPosts();

	}
	
	public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	
	}*/

	
}