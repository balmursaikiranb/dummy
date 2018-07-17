package com.cg.sevensixjdbc.service;

import java.util.Set;

import com.cg.sevensixjdbc.dto.Employee;



public interface IEmployeeService {
	
	public boolean deleteEmployee(int id);
	public int addEmployee(Employee emp);
	public Employee showDetailsByScheme(int scheme);
	public Employee showDetailsBySalary(int salary1);
}
