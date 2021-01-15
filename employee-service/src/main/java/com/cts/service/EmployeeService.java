package com.cts.service;

import com.cts.model.Employee;

public interface EmployeeService {
	Employee getEmployee(int empId);

	String addEmployee(Employee employee);

	String updateEmployee(int empId, Employee employee);

	String deleteEmployee(int empId);
}
