package com.jrp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}
