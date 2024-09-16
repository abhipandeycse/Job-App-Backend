package com.securejob.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securejob.app.model.JobUser;
import com.securejob.app.repo.JobUserRepo;

@Service
public class JobUserService {
	
	@Autowired
	private JobUserRepo repo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public JobUser saveUser(JobUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return repo.save(user);
		
	}
}
