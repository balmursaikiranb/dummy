package com.cg.sevensixjdbc.dao;

import java.util.HashMap;

import com.cg.sevensixjdbc.dto.Employee;



public interface IEmployeeDao {
	
	public boolean deleteEmployee(int id);
	public int addEmployee(Employee emp);
	public Employee showDetailsByScheme(int scheme);
	public Employee showDetailsBasedOnSalary(int salary);
}
