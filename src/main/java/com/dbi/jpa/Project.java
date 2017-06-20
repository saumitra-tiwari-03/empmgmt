package com.dbi.jpa;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Project" ,schema="empmgmt")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1317185181223945671L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectID;
	
	@Column(unique = true)
	private Integer projectCode;
	
	private String projectName;
	
	private String projectLeader;
	
	//@JsonIgnore
	@OneToMany(mappedBy="project", cascade = CascadeType.PERSIST)
	private Set<Employee> emp = new HashSet<Employee>();

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}
	
	public Integer getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public Set<Employee> getEmp() {
		return emp;
	}

	public void setEmp(Set<Employee> emp) {
		this.emp = emp;
	}

	public String toString(){
		return this.getProjectName()+" : "+this.getProjectID();
	}
	
	

}
