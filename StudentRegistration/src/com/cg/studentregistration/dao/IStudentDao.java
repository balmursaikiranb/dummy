package com.cg.studentregistration.dao;

import com.cg.studentregistration.dto.StudentDto;

public interface IStudentDao {
	public int addStudentDetails(StudentDto details);
	public StudentDto viewStudentStatus(int id);
}
