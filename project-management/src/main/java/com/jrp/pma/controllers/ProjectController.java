package com.jrp.pma.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService proService;

	@Autowired
	EmployeeService empService;

	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);

		return "projects/display-projects";
	}

	@GetMapping("/new")
	public String displayProjectForm(Model model) {

		Project aProject = new Project();
		List<Employee> employees = empService.getAll();

		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);

		return "projects/new-project";
	}

	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		proService.save(project);
		// redirecting to prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
	@GetMapping("/update")
	public String displayProjectUpdateForm(@RequestParam("id") long theId, Model model) {
		Optional<Project> theProj = proService.findById(theId);
		model.addAttribute("project", theProj);
		
		return "projects/new-project";
	}
	
	@GetMapping("/delete")
	public String deleteProject(@RequestParam("id") long theId, Model model) {
		proService.deleteById(theId);
		
		return "redirect:/projects";
	}
}
