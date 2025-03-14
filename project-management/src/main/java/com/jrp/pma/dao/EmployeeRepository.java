package com.jrp.pma.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel = "apiemployees", path="apiemployees")
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true,
			value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) projectCount"
			+ " FROM employee e"
			+ " LEFT JOIN project_employee pe"
			+ " ON pe.employee_id = e.employee_id"
			+ " GROUP BY e.first_name, e.last_name"
			+ " ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
	
	public Optional<Employee> findById(long theId);
	
}
