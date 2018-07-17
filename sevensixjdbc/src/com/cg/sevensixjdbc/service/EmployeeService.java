package com.cg.sevensixjdbc.service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.cg.sevensixjdbc.dao.EmployeeDao;
import com.cg.sevensixjdbc.dao.IEmployeeDao;
import com.cg.sevensixjdbc.dto.Employee;



public class EmployeeService implements IEmployeeService{
HashMap<Integer,Employee> list = new HashMap<Integer,Employee>();  
	IEmployeeDao dao=new EmployeeDao();
	public int addEmployee(Employee emp)	{
			//code to add employee
		
		
		return dao.addEmployee(emp);
	}
	public boolean deleteEmployee(int id)	{
//	     code to delete a employee whose id is passed as parameter
		return dao.deleteEmployee(id);
		}
	
	
	public  Employee  showDetailsBySalary(int salary) {
		
		return dao.showDetailsBasedOnSalary(salary);
		
	}
	public Employee showDetailsByScheme(int scheme) {
		
			

		return dao.showDetailsByScheme(scheme);
	}
}
