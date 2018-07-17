package com.cg.sevensixjdbc.ui;

import java.util.Scanner;
import java.util.Set;

import com.cg.sevensixjdbc.dto.Employee;
import com.cg.sevensixjdbc.service.EmployeeService;
import com.cg.sevensixjdbc.service.IEmployeeService;



public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		IEmployeeService service=new EmployeeService();
		Scanner sc=new Scanner(System.in);
		String choice1;
		do {
			System.out.println("1.to add employee");
			System.out.println("2.delete employee");
			System.out.println("3.to access details based on scheme");
			System.out.println("4.To access details based on salary in ascending order");
			System.out.println("enter a choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Selected to add employee");
				System.out.println("enter the name:");
				String name=sc.next();
				System.out.println("enter the insurance scheme:");
				String scheme=sc.next();
				System.out.println("enter the designation:");
				String designation=sc.next();
				System.out.println("enter the salary:");
				int salary=sc.nextInt();
				
				e.setName(name);
				e.setInsuranceScheme(scheme);
				e.setDesignation(designation);
				e.setSalary(salary);
				int id=service.addEmployee(e);
				
				System.out.println(id);
				break;
			case 2:
				System.out.println("delete employee");
				System.out.println("enter the id:");
				int id1=sc.nextInt();
				boolean result=service.deleteEmployee(id1);
				if(result)
				{
					System.out.println("successful");
				}
				else
				{
					System.out.println("unsuccessful");
				}
				break;
			case 3:
				//System.out.println("to access details based on scheme");
				System.out.println("enter the id:");
				int scheme1=sc.nextInt();
				Employee employee=service.showDetailsByScheme(scheme1);
				/*for (String pro :myprod.keySet()) {
					System.out.println(myprod.get(pro).getDesignation());
					System.out.println(myprod.get(pro).getName());
					System.out.println(myprod.get(pro).getSalary());
				}*/
					System.out.println(employee.getId());
					System.out.println(employee.getInsuranceScheme());
					System.out.println(employee.getName());
					System.out.println(employee.getSalary());
					System.out.println(employee.getDesignation());
				
				break;
			case 4:
				System.out.println("To access details based on salary");
				System.out.println("enter the salary:");
				int salary1=sc.nextInt();
				Employee employee1=service.showDetailsBySalary(salary1);
				System.out.println(employee1.getId());
				System.out.println(employee1.getInsuranceScheme());
				System.out.println(employee1.getName());
				System.out.println(employee1.getSalary());
				System.out.println(employee1.getDesignation());
				break;
				}
			
		
		
			
			System.out.println("enter y to use n to exit");
		choice1=sc.next();
		}while(choice1.equalsIgnoreCase("y")||choice1.equalsIgnoreCase("yes"));
	/*	System.out.println("enter the name:");
		String name=sc.next();
		System.out.println("enter the id:");
		int id=sc.nextInt();
		System.out.println("enter the salary:");
		int salary=sc.nextInt();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		e.getDesignation();
		e.getInsuranceScheme();
		System.out.println(e.toString());
*/
	}

	}


