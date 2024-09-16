package com.securejob.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securejob.app.model.JobUser;
import com.securejob.app.service.JobUserService;

@RestController
public class JobUserRegisterController {
	
	@Autowired
	private JobUserService service;
	
	@PostMapping("register")
	public JobUser register(@RequestBody JobUser user) {
		service.saveUser(user);
		return user;	
		
	}
}
