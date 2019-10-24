package com.saikumar.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.saikumar.model.Employee;

@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee, Integer>{
	@Query("select e from Employee e where dept =  ?1 and desig = ?2")
	List<Employee> findByDeptDesig(String dept, String desig);
	
	@Query("select e from Employee e where dept =  ?1")
	List<Employee> findByDept(String dept, Sort sort);

	@Query("select e from Employee e where basic > ?1")
	List<Employee> findByBasic(int dept);

	@Query("select e from Employee e where basic > ?1 and dept = ?2 and desig = ?3")
	List<Employee> findByBasicandDept(int basic, String dept, String desig);
	
	@Query("select e from Employee e where basic > ?1 and dept = ?2 and desig = ?3 and empname Like 'a%'")
	List<Employee> findByBasicandDepts(int basic, String dept, String desig, Sort sort);
	
	

}
