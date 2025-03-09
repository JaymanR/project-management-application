package com.jrp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;

@Controller
public class HomeController {
	
	@Value("${version}")
	private String ver;

	@Autowired
	ProjectRepository proRepo;

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping
	public String displayHome(Model model) throws JsonProcessingException {
		
		model.addAttribute("versionNumber", ver);

		//Map<String, Object> map = new HashMap();

		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);

		List<EmployeeProject> anEmployeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectCnt", anEmployeesProjectCnt);

		List<ChartData> projectData = proRepo.getProjectStatus();
		// converting projectData object into json struct to use in js
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
		model.addAttribute("projectStatusCnt", jsonString);

		return "main/home";
	}
}
