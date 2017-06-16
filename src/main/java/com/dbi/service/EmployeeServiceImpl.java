package com.dbi.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbi.jpa.Employee;
import com.dbi.jpa.EmployeeRepo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee create(Employee emp) throws ServiceException {

		return employeeRepo.save(emp);
	}

	public void delete(int id) throws ServiceException {

		employeeRepo.delete(id);
	}

	public List<Employee> findAll() throws ServiceException {
		return employeeRepo.findAll();
	}

	public Employee findById(int id) throws ServiceException {
		return employeeRepo.findOne(id);
	}

	public Employee update(Employee book) throws ServiceException {
		return employeeRepo.save(book);
	}
	

}

