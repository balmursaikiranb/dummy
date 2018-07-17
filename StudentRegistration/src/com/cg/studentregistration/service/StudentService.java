package com.cg.studentregistration.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.cg.studentregistration.dao.IStudentDao;
import com.cg.studentregistration.dao.StudentDao;
import com.cg.studentregistration.dto.StudentDto;
import com.cg.studentregistration.exception.StudentException;


public class StudentService  implements IStudentService{
IStudentDao std=new StudentDao();
Scanner sc=new Scanner(System.in);
private boolean validateDate(LocalDate str)
{
	LocalDate date1 = null;
if(str.isAfter(date1.now()))
		{
	return true;
		}
return false;
}
private boolean validateName(String str)
{
String pattern="[A-Za-z]*";
if(str.matches(pattern))
		{
	return true;
		}
return false;
}
/*private boolean validatePhone()
{
String pattern="[0-9]+9";
StudentDto dto=new StudentDto();
if((dto.getsPhone()).matches(pattern))
		{
	return true;
		}
return false;
}*/
private boolean validateEmail(String str)
{
String pattern="[A-Za-z0-9]+@[a-zA-Z]+.com";
if(str.matches(pattern))
		{
	return true;
		}
return false;
}
/*private boolean validateDate(String str)
{
String pattern="[1-9]+1-[A-Za-z]+2-[0-9]+3";
if(str.matches(pattern))
		{
	return true;
		}
return false;
}*/
private boolean validateAge(int str)
{

if((str>=1)&&(str<99))
		{
	return true;
		}
return false;
}

@Override
	public int addStudentDetails(StudentDto details) throws StudentException {
	
	while(true)
	{
		if(validateDate(details.getDate()))
		{
			break;
		}else
		{
			throw new StudentException("incorrect name pattern try again");
			/*System.out.println("incorrect name pattern try again");
			String name=sc.next();
			details.setsName(name);*/
		}
		
	}while(true)
	{
		if(validateName(details.getsName()))
		{
			break;
		}else
		{
			throw new StudentException("incorrect name pattern try again");
			/*System.out.println("incorrect name pattern try again");
			String name=sc.next();
			details.setsName(name);*/
		}
		
	}
	while(true)
	{
		if(validateEmail((String)details.getEmail()))
		{
			break;
		}else
		{
			throw new StudentException("incorrect email pattern try again");
		/*	System.out.println("incorrect email pattern try again");
			String name=sc.next();
			details.setEmail(name);*/
		}
		
	}
	while(true)
	{
		if(validateAge(details.getAge()))
		{
			break;
		}else
		{
			throw new StudentException("incorrect age try again");
		/*	System.out.println("incorrect age try again");
			int name=sc.nextInt();
			details.setAge(name);*/
		}
		
	}
	
		int sid=std.addStudentDetails(details);
		return sid;
	}

	@Override
	public StudentDto viewStudentStatus(int id) {
		
		return std.viewStudentStatus(id);
	}

	
}
