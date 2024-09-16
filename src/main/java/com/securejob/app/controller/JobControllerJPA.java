package com.securejob.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securejob.app.model.JobPost;
import com.securejob.app.service.JobService;

@RestController	
	public class JobControllerJPA {
		
		@Autowired
		private JobService service;
		

		@GetMapping("jobPosts")
		public List<JobPost> getAllJobs() {
			return service.getAllJobs();
			
		}
		
		@GetMapping("jobPosts/keyword/{keyword}")
		public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
			 return service.search(keyword);
		 
		}
		
		@GetMapping("/jobPost/{postId}")
		public Optional<JobPost> getJob(@PathVariable int postId) {
			return service.getJob(postId);
		}
		
		
		

		@PostMapping("jobPost")
		public Optional<JobPost> addJob(@RequestBody JobPost jobPost) {
			service.addJob(jobPost);
			return service.getJob(jobPost.getPostId());
		}
		
		
		
		@PutMapping("jobPost")
		public Optional<JobPost> updateJob(@RequestBody JobPost jobPost) {
			service.updateJob(jobPost);
			return service.getJob(jobPost.getPostId());
		}
		
		
		@DeleteMapping("jobPost/{postId}")
		public String deleteJob(@PathVariable int postId)
		{
			service.deleteJob(postId);
			return "Deleted";
		}
		
		
		@GetMapping("load")
		public String loadData() {
			service.load();
			return "success";
		}


	
	
}