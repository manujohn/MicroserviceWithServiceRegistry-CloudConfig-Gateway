package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Department;
import com.example.repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepo departmentRepo;
	
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	public Department getDepartment(Long id) {
		return departmentRepo.findByDepartmentId(id);
	}

}
