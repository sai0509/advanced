package com.employee;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class MainProg {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee");
		q.setFirstResult(2);
		q.setMaxResults(1);
		Criteria c = s.createCriteria(Employee.class);
//		c.add(Restrictions.gt("basic", 20000));
//		c.addOrder(Order.asc("empname"));
//		c.addOrder(Order.desc("basic"));
		List<Employee> employees = c.list();
		List<Employee> lst = q.list();
		
		for (Object ob : employees) {
			Employee e = (Employee) ob;
			System.out.println("Employ No : " + e.getEmpno());
			System.out.println("Employ Name : " + e.getEmpname());
			System.out.println("Employ Department : " + e.getDept());
			System.out.println("Employ Designation : " + e.getDesig());
			System.out.println("Employ Salary : " + e.getBasic());
			System.out.println("-------------------------------");
		}
		c.setProjection(Projections.property("empname"));
		List<Employee> employees2 = c.list();
		System.out.println(employees2.toString());
		System.out.println("ANOTHER METHOD-------------");
		
		Query query = s.getNamedQuery("HQL_GET_EMPLOYEE_BY_EMPNO");
		query.setInteger("empno", 4);
		Employee employee = (Employee) query.list().get(0);
		System.out.println(employee.toString());
		Query qa = s.getNamedQuery("HQL_GET_ALL_data");
		Employee employee2 = (Employee) qa.list().get(0);
		System.out.println(employee2.toString());
	}
}
