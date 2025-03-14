package com.jrp.pma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project proj) {
		return proRepo.save(proj);
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}

	public Optional<Project> findById(long theId) {
		// TODO Auto-generated method stub
		return proRepo.findById(theId);
	}

	public void deleteById(long theId) {
		// TODO Auto-generated method stub
		Optional<Project> theProj = proRepo.findById(theId);
		if (theProj.isPresent()) {
			proRepo.delete(theProj.get());
		}
	}
}
