package com.cg.studentregistration.service;

import com.cg.studentregistration.dto.StudentDto;
import com.cg.studentregistration.exception.StudentException;

public interface IStudentService {
public int addStudentDetails(StudentDto details) throws StudentException;
public StudentDto viewStudentStatus(int id);
}
