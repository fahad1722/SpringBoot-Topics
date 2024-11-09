package com.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logging.model.Employee;
import com.logging.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	// Method to add a new employee
	public Employee saveEmployee(Employee employee) {
		logger.info("Saving employee: {}", employee);
		try {
			return employeeRepository.save(employee);
		} catch (Exception e) {
			logger.error("Error saving employee: {}", employee, e);
			throw e;
		}
	}

	public Employee getEmployeeById(Long id) {
		logger.info("Fetching employee with ID: {}", id);
		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee == null) {
			logger.warn("No employee found with ID: {}", id);
		}
		return employee;
	}

	public void deleteEmployee(Long id) {
		logger.info("Deleting employee with ID: {}", id);
		employeeRepository.deleteById(id);
	}
}
