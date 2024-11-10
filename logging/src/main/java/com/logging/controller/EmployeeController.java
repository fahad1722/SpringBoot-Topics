package com.logging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logging.model.Employee;
import com.logging.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		log.info("Received request to save employee: {}", employee);
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		log.info("Received request to fetch employee with ID:   {}", id);
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		log.info("Received request to delete employee with ID: {}", id);
		employeeService.deleteEmployee(id);
	}
}
