package com.saikumar.service;

import java.util.List;

import com.saikumar.model.Employee;

public interface EmloyeeService {

		public List<Employee> getAllEmployees();
		
		public String addEmployee(String e);
		
		public String addAllEmployees(String str);
		
		public String deleteEmployee(int id);
		
		public String deleteAllEmployees(List<Employee> id);
		
		public Employee getEmployee(int id);
}
