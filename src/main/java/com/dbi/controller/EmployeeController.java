package com.dbi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbi.jpa.Employee;
import com.dbi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/newEmp")
	public String newEmp(){
		return "newEmp";
	}
	
	@RequestMapping(value="/saveEmp", consumes = { "application/json" }, method = RequestMethod.POST)
	//@ResponseStatus(value=HttpStatus.OK)
	public String saveEmp( @RequestBody Employee emp){
		System.out.println("invoked");
		empService.create(emp);
		return HttpStatus.OK + "";
		

	}
	
	@RequestMapping("/getEmployeeList")
	public List<Employee> getAllBookDetails() {
		List<Employee> list = null;

		try {
			list = empService.findAll();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	@RequestMapping(value = "/DeleteEmployeeDetails/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteBookDetails(@PathVariable Integer id)  {

		empService.delete(id);
		return HttpStatus.OK;

	}

	@RequestMapping(value = "/employeeById/{id}", method = RequestMethod.GET)
	public Employee get(@PathVariable Integer id){
		return empService.findById(id);
	}

	@RequestMapping(value = "/editEmployeeDetails", method = RequestMethod.PUT, produces = {
			"application/json" }, consumes = { "application/json" })
	public Employee update(@RequestBody Employee employee) {
		return empService.update(employee);
	}

}
