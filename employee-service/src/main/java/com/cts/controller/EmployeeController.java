package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		return employeeService.getEmployee(empId);
	}

	@PostMapping
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/{empId}")
	public String updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
		return employeeService.updateEmployee(empId, employee);
	}

	@DeleteMapping("/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		return employeeService.deleteEmployee(empId);
	}
}
