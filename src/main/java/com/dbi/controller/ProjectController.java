package com.dbi.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbi.dto.ProjectDTO;
import com.dbi.jpa.Project;
import com.dbi.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/getProjectDetails" , produces = {"application/json"}, method = RequestMethod.GET)
	public List<Project> getAllProjectDetails() {
		List<Project> list = null;

		try {
			list = projectService.findAll();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@RequestMapping(value = "/newProject", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO){
		Project project = new Project();
		BeanUtils.copyProperties(projectDTO, project);
		projectService.create(project);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	@RequestMapping(value = "/DeleteProjectDetails/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteProjectDetails(@PathVariable Integer id){

		projectService.delete(id);
		return HttpStatus.OK;

	}

	@RequestMapping(value = "/ProjectById/{id}", method = RequestMethod.GET)
	public Project get(@PathVariable Integer id){
		return projectService.findById(id);
	}

	@RequestMapping(value = "/editProjectDetails", method = RequestMethod.PUT, produces = {
			"application/json" }, consumes = { "application/json" })
	public Project update(@RequestBody Project project){
		return projectService.update(project);
	}


}
