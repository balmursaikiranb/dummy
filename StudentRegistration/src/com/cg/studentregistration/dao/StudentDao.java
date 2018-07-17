package com.cg.studentregistration.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cg.studentregistration.dto.StudentDto;

public class StudentDao implements IStudentDao{
 
	Map<String,String> colleges=new HashMap<>();
Map<Integer,StudentDto> detail=new HashMap<>();
{
	colleges.put("delhi","IIT-D");
	colleges.put("hyderabad","IIT-H");
	colleges.put("chennai","IIT-M");
	colleges.put("bangalore","IIS-B");
	colleges.put("mumbai","IIT-B");
}

@Override
public int addStudentDetails(StudentDto details) {
	int sid=(int)(Math.random()*9000+1000);
	
	String city=details.getsCity();
	//details.getsCity().equalsIgnoreCase(city);
	details.setCollege(colleges.get(city));
	
	details.setStatus("Approved");
	detail.put((new Integer(sid)), details);
	return sid;
}

	@Override
	public StudentDto viewStudentStatus(int id) {
		
	/*StudentDto dao=null;
	Integer sid=Integer.parseInt(String.valueOf(id));
	if(detail.containsKey(sid))
	{
	dao=detail.get(sid);
	}*/
	return detail.get(id);
}
}


	

