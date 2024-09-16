package com.securejob.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.securejob.app.model.JobUser;

@Repository
public interface JobUserRepo extends JpaRepository<JobUser, Integer>  {
	
	JobUser findByUsername(String username);
}
