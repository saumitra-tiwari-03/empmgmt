package com.dbi.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Project" ,schema="empmgmt")
public class Project {
	
	@Id
	private Integer projectID;
	
	private String projectName;
	
	private Integer empid;

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	
	public String toString(){
		return this.getProjectName()+" : "+this.getProjectID()+" : "+this.getEmpid();
	}
	
	

}
