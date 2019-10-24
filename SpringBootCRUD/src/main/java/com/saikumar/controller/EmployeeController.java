package com.saikumar.controller;

import java.util.List;

import javax.persistence.PostUpdate;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saikumar.model.Employee;
import com.saikumar.service.EmloyeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmloyeeService employeeService;
	@RequestMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody String empStr) {
		return employeeService.addEmployee(empStr);
	}
	
	@PostMapping("/addAllEmployees")
	public String addAllEmployees(@RequestBody String str) {
		return employeeService.addAllEmployees(str);
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteEmployee(@PathVariable("id") int id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PostMapping("/deleteAll")
	public String deleteAllEmployees(@RequestBody List<Employee> id) {
		return employeeService.deleteAllEmployees(id);
	}
	
	@PostMapping("/{id}/getEmployee")
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.getEmployee(id);
	}
}
