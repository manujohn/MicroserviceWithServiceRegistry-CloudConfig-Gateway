package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Department;
import com.example.model.User;
import com.example.model.UserDepartment;
import com.example.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public UserDepartment getUser(Long id) {

		User user = userRepo.findByUserId(id);

		Department department = restTemplate
				.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getUserDepartment(), Department.class);

		UserDepartment userDepartment = new UserDepartment(user, department);
		return userDepartment;
	}

}