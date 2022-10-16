package com.jpaexample.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaexample.demo.entity.Employee;
import com.jpaexample.demo.exception.ResourceNotFoundException;
import com.jpaexample.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(empId).orElseThrow(
				() -> new ResourceNotFoundException("No Employee found belonging to Employee Id: "+empId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employee/{empId}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int empId,@RequestBody Employee req)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(empId).orElseThrow(
				() -> new ResourceNotFoundException("No Employee found to update Employee belonging to Employee Id: "+empId));
		employee.setFirstName(req.getFirstName());
		employee.setLastName(req.getLastName());
		employee.setEmail(req.getEmail());
		return ResponseEntity.ok(employeeRepository.save(employee));
	}
	

	@DeleteMapping("/employee/{empId}")
	public Map<String, Boolean> deleteEmployeeById(@PathVariable int empId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(empId).orElseThrow(
				() -> new ResourceNotFoundException("No Employee found to delete Employee belonging to Employee Id: "+empId));
		employeeRepository.delete(employee);
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return res;
	}
}
