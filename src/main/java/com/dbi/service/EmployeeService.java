package com.dbi.service;

import java.util.List;

import com.dbi.jpa.Employee;

public interface EmployeeService {
	
	public Employee create(Employee Employee) ;

	public void delete(int id);

	public List<Employee> findAll() ;

	public Employee findById(int id) ;

	public Employee update(Employee employee) ;

}
