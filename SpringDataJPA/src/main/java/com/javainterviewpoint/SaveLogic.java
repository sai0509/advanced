package com.javainterviewpoint;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SaveLogic 
{
    private static SaveLogic saveLogic;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public static void main( String[] args )
    {
        //Reading the Configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        
        //Get the SaveLogic bean
        saveLogic = (SaveLogic)context.getBean("saveLogic");
        
        saveLogic.saveEmployee();
        
        context.close();
    }
    
    public void saveEmployee()
    {
        Employee employee = new Employee();
        employee.setEmpName("yash");
        
        Employee_Address employeeAddress1 = new Employee_Address();
        employeeAddress1.setStreet("c");
        employeeAddress1.setCity("hyedrabad");
        employeeAddress1.setCountry("india");
        employeeAddress1.setState("ap");
        employeeAddress1.setEmployee(employee);
        
//        
//        Employee_Address employeeAddress2 = new Employee_Address();
//        employeeAddress2.setStreet("Street 2");
//        employeeAddress2.setCity("City 2");
//        employeeAddress2.setCountry("Country 2");
//        employeeAddress2.setState("State 2");
//        employeeAddress2.setEmployee(employee);
        
        Set<Employee_Address> employeeAddressSet = new HashSet<Employee_Address>();
        employeeAddressSet.add(employeeAddress1);
//        employeeAddressSet.add(employeeAddress2);
        
        employee.setEmployeeAddress(employeeAddressSet);
        
        
        employeeRepository.save(employee);
        System.out.println("Employee and Employee Address saved successfully!!");
    }
}
