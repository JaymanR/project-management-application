package com.jrp.pma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}
	
	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}

	public Optional<Employee> findById(long theId) {
		// TODO Auto-generated method stub
		return empRepo.findById(theId);
	}

	public void deleteById(long theId) {
		// TODO Auto-generated method stub
		Optional<Employee> theEmp = empRepo.findById(theId);
		if (theEmp.isPresent()) {
			empRepo.delete(theEmp.get());
		}
	}
}
