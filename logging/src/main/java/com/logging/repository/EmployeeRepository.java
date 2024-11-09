package com.logging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logging.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
