package com.dbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbi.jpa.Project;
import com.dbi.jpa.ProjectRepo;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepo projectRepo;
	
	public Project create(Project project) {
		return projectRepo.save(project);
	}

	public void delete(int id) {
		projectRepo.delete(id);
	}

	public List<Project> findAll() {
		return projectRepo.findAll();
	}

	public Project findById(int id) {
		return projectRepo.findOne(id);
	}

	public Project update(Project project) {
		return projectRepo.save(project);
	}
	
	

}
