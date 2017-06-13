package com.dbi.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee" ,schema="empmgmt")
public class Employee {
	
	@Id
	private Integer empId;
	
	private String empName;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}	
	
	public String toString(){
		return this.getEmpName()+" : "+this.getEmpId();
	}
}
