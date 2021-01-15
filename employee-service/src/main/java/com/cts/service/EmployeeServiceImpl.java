package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Employee;
import com.cts.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployee(int empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public String addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee added successfully";
	}

	@Override
	public String updateEmployee(int empId, Employee employee) {
		Employee emp = employeeRepository.findById(empId).orElse(null);
		if (emp != null) {
			if (emp.getName() != null) {
				emp.setName(employee.getName());
			}
			if (emp.getDept() != null) {
				emp.setDept(employee.getDept());
			}
			if (emp.getSalary() != 0) {
				emp.setSalary(employee.getSalary());
			}
			employeeRepository.save(emp);
			return "Employee with id " + empId + " updated successfully";
		}
		return "Employee with id " + empId + " does not exist";
	}

	@Override
	public String deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
		return "Employee with id " + empId + " deleted successfully";
	}

}
