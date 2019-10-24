package com.saikumar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.saikumar.Repository.EmployeeDao;
import com.saikumar.model.Employee;


@RestController
public class EmployeeController {
	
	int pages = 5;
	@Autowired
	private EmployeeDao employeeDao;
	@RequestMapping("/")
	public ModelAndView getAllEmployees() {
		ModelAndView modelAndView = new ModelAndView();
		List<Employee> lst = (List<Employee>) employeeDao.findAll();
		modelAndView.addObject("page", pages);
		modelAndView.addObject("totalrecords", lst.size());
		modelAndView.addObject("employees",lst);
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping("/displayAll/Page/{pageno}")
	public ModelAndView getAllEmployeesbypagination(@PathVariable("pageno")int pageno) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("page", pages);
		List<Employee> list = (List<Employee>) employeeDao.findAll();
		modelAndView.addObject("totalrecords",list.size());
		modelAndView.addObject("employees",employeeDao.findAll(PageRequest.of(pageno,pages)).getContent());
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
//	@RequestMapping("displayjavatrainers")
//	public ModelAndView getEmployee() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findByDeptDesig("java", "training"));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
////	@RequestMapping("displayjavaemployees")
////	public ModelAndView getJavaEmployee() {
////		ModelAndView modelAndView1 = new ModelAndView();
////		modelAndView1.addObject("employees", employeeDao.findByDept("java"));
////		modelAndView1.setViewName("home");
////		return modelAndView1;
////	}
//
//	@RequestMapping("displayemployeessalary")
//	public ModelAndView getEmployeessalary() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findByBasic(20000));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
//	@RequestMapping("displayjavaemployeessalary")
//	public ModelAndView getJavaEmployeessalary() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findByBasicandDept(20000, "java" ,"training"));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
//	
////	@RequestMapping("namestartswith")
////	public ModelAndView getJavaEmployeessalarys() {
////		ModelAndView modelAndView1 = new ModelAndView();
////		modelAndView1.addObject("employees", employeeDao.findByBasicandDepts(20000, "java" ,"training"));
////		modelAndView1.setViewName("home");
////		return modelAndView1;
////	}
//
//	@RequestMapping("orderbydesig")
//	public ModelAndView getordereddesig() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findAll(Sort.by("desig")));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
//	
//	@RequestMapping("descbydesig")
//	public ModelAndView getdescordereddesig() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findAll(Sort.by("desig").descending()));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
//	@RequestMapping("descbydesigandsalary")
//	public ModelAndView getdescordereddesigandsalary() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findAll(Sort.by("desig").descending().and(Sort.by("basic").descending())));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//
//	
//	@RequestMapping("javadescbysalary")
//	public ModelAndView getjavadescbysalary() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findByDept("java", Sort.by("basic").descending()));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
//	@RequestMapping("number")
//	public ModelAndView getnumber() {
//		ModelAndView modelAndView1 = new ModelAndView();
//		modelAndView1.addObject("employees", employeeDao.findByBasicandDepts(10000, "java", "training", Sort.by("basic").descending()));
//		modelAndView1.setViewName("home");
//		return modelAndView1;
//	}
//	
////	@PostMapping("/addEmployee")
////	public String addEmployee(@RequestBody String empStr) {
////		return employeeService.addEmployee(empStr);
////	}
////	
////	@PostMapping("/addAllEmployees")
////	public String addAllEmployees(@RequestBody String str) {
////		return employeeService.addAllEmployees(str);
////	}
////	
////	@DeleteMapping("/{id}/delete")
////	public String deleteEmployee(@PathVariable("id") int id) {
////		return employeeService.deleteEmployee(id);
////	}
////	
////	@PostMapping("/deleteAll")
////	public String deleteAllEmployees(@RequestBody List<Employee> id) {
////		return employeeService.deleteAllEmployees(id);
////	}
////	
////	@PostMapping("/{id}/getEmployee")
////	public Employee getEmployee(@PathVariable("id") int id) {
////		return employeeService.getEmployee(id);
////	}
}
