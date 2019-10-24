package com.saikumar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saikumar.model.Employee;
import com.saikumar.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmloyeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		if (employees.size() > 0) {
			return employees;
		} else {
			return new ArrayList<Employee>();
		}
	}

	@Override
	public String addEmployee(String e) {
		JSONObject jsonObject =  (JSONObject) JSONValue.parse(e);
		Employee employee = new Employee();
		long id1 =  (long) jsonObject.get("id");
		int id = (int) id1;
		employee.setId(id);
		employee.setName((String) jsonObject.get("name"));
		employee.setSalary((double) jsonObject.get("salary"));
		employeeRepository.save(employee);
		return "Employe Added Sucessfully";
	}

	@Override
	public String addAllEmployees(String str) {
		List<Employee> employees = new ArrayList<Employee>();
		JSONArray jsonArray = (JSONArray) JSONValue.parse(str);
		for(int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			Employee employee = new Employee();
			long id = (long) jsonObject.get("id");
			int id1 = (int) id;
			employee.setId(id1);
			employee.setName((String) jsonObject.get("name"));
			employee.setSalary((double) jsonObject.get("salary"));
			employees.add(employee);
		}
		employeeRepository.saveAll(employees);
		return "All Employees Added Successfully";
	}

	@Override
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "employee deleted successfully";
		
	}

	@Override
	public String deleteAllEmployees(List<Employee> id) {
		employeeRepository.deleteAll(id);
		return "ALL Employees Deleted Successfully";
	}

	@Override
	public Employee getEmployee(int id) {
	Optional<Employee>	employees = employeeRepository.findById(id);
	return employees.get();
	}

}
