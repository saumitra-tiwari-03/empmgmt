package com.dbi.service;

import java.util.List;

import com.dbi.jpa.Project;


public interface ProjectService {
	
	public Project create(Project project);

	public void delete(int id) ;

	public List<Project> findAll() ;

	public Project findById(int id) ;

	public Project update(Project project) ;
	
}
