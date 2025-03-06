package com.jrp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
