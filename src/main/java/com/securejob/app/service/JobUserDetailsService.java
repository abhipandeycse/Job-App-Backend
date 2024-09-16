package com.securejob.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securejob.app.model.JobUser;
import com.securejob.app.model.JobUserPrincipal;
import com.securejob.app.repo.JobUserRepo;

@Service
public class JobUserDetailsService implements UserDetailsService {
	
	@Autowired
	private JobUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	JobUser user=	repo.findByUsername(username);
		if(user==null) {
			System.out.println("404 NOT FOUND");
			throw new UsernameNotFoundException("404 NOT FOUND");
		}
		return new JobUserPrincipal(user);
	}

}
