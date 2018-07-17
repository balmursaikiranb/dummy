package com.cg.studentregistration.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.cg.studentregistration.dto.StudentDto;

class testingStudent {

	StudentDto person=new StudentDto();
	@BeforeClass
	public static void first() throws Exception
	{
		System.out.println("before class");
	}
	@AfterClass
	public static void last()throws Exception
	{
		System.out.println("after class");
	}
	@org.junit.jupiter.api.Test
	public void testfirst()
	{
		person.setsName("saikiran");
		String lname=person.getsName();
		assertEquals("saikiran", lname);	
	}
	@org.junit.jupiter.api.Test
	public void testemail()
	{
		person.setEmail("Balmur@gmail.com");
		String lname=person.getEmail();
		assertEquals("Balmur@gmail.com", lname);
		
	}
	@org.junit.jupiter.api.Test
	public void testgender()
	{
		person.setGender("M");
		String g=person.getGender();
		assertEquals("M",g);
		
	}

}
