package com.dbi.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee" ,schema="empmgmt")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(unique = true)
	private Integer empCode;
	
	private String empName;
	
	private String empEmail;
	
	private Integer empMobile;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_CODE", referencedColumnName = "projectCode",nullable = false)
	//@JsonIgnore
	private Project project;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public Integer getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Integer empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}	
	
	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Integer getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(Integer empMobile) {
		this.empMobile = empMobile;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String toString(){
		return this.getEmpName()+" : "+this.getEmpId();
	}
}
