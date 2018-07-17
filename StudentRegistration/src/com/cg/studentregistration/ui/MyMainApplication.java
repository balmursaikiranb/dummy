package com.cg.studentregistration.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.studentregistration.dto.StudentDto;
import com.cg.studentregistration.exception.StudentException;
import com.cg.studentregistration.service.IStudentService;
import com.cg.studentregistration.service.StudentService;

public class MyMainApplication {

	public static void main(String[] args) {
		int choice = 0;
		IStudentService service = new StudentService();
		String ch;
		do {
			System.out.println("1.Add Student Details");
			System.out.println("2. View Student Status");
			System.out.println("3.Exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the choice:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("selected to Add Student details");
				System.out.println("enter the name:");
				String name = sc.next();
				System.out.println("enter the phone number:");
				long phone = sc.nextLong();
				System.out.println("enter the email id:");
				String emailid = sc.next();
				System.out.println("enter the age:");
				int age = sc.nextInt();
				System.out.println("enter the gender:");
				String gender = sc.next();
				System.out.println("enter the city:");
				String city = sc.next();
				try {
					System.out.println("enter the date you want to join in dd-MMM-yyyy format:");
					String date = sc.next();
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
					LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
					StudentDto sd = new StudentDto();
					sd.setsName(name);
					sd.setsPhone(phone);
					sd.setEmail(emailid);
					sd.setAge(age);
					sd.setGender(gender);
					sd.setsCity(city);
					sd.setDate(localDate);
					sd.setStatus("NotApproved");
				int id;
				try {
					id = service.addStudentDetails(sd);
					System.out.println("your id is:" + id);

				} catch (StudentException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				} catch (Exception e) {
					System.out.println("error in date");
				}

				break;
			case 2:
				System.out.println("enter student id to view details:");
				int id1 = sc.nextInt();
				StudentDto result = service.viewStudentStatus(id1);
				if(result!=null)
				{
						System.out.println("employee ID:"+result.getsName());
						System.out.println("employee Name:"+result.getsPhone());
						System.out.println("employee Salary:"+result.getEmail());
						System.out.println("employee Designation "+result.getAge());
						System.out.println("employee ID:"+result.getGender());
						System.out.println("employee Name:"+result.getsCity());
						System.out.println("employee Salary:"+result.getCollege());
						System.out.println("employee Salary:"+result.getDate());
						System.out.println("employee Salary:"+result.getStatus());
				}	
				else
				{
					System.out.println("Student id Not Found ......");
				}
				
			case 3:
				System.out.println("thankyou for using");
				System.exit(0);
				break;
			default:
				System.out.println("enter correct value");

			}
			System.out.println("enter y or yes to continue and n or no to exit");
			ch = sc.next();
		} while ((ch.equalsIgnoreCase("y")) || ch.equalsIgnoreCase("yes"));
	}
}
