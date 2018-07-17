package com.cg.sevensixjdbc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.sevensixjdbc.dbutil.DBUtil;
import com.cg.sevensixjdbc.dto.Employee;

public class EmployeeDao implements IEmployeeDao {
	Connection con = null;

	public EmployeeDao() {// throws TakeCareClinicException {
		// TODO Auto-generated constructor stub
		try {
			con = DBUtil.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Establishing connection
	}

	@Override
	public Employee showDetailsBasedOnSalary(int salary) {
		Employee patient = new Employee();
		try {
			String sql = "SELECT * FROM Employee1 WHERE salary = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, salary);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				patient.setId(res.getInt(1));
				patient.setName(res.getString(2));
				patient.setSalary(res.getInt(3));
				patient.setDesignation(res.getString(4));
				patient.setInsuranceScheme(res.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return patient;

	}

	@Override
	public boolean deleteEmployee(int id) {
		try {
			String sql = "DELETE FROM Employee1 WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			// set the corresponding param
			pstmt.setInt(1, id);
			// execute the delete statement
			int rs = pstmt.executeUpdate();

			if (rs == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public int addEmployee(Employee employee) {
		int employeeId = 0;
		// Employee employee=new Employee();
		try {
			employeeId = getEmployeeId(); // Getting Unique Patient Id from Sequence
			String sql = "INSERT INTO Employee1 VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, employeeId);
			pstmt.setString(2, employee.getName());
			pstmt.setInt(3, employee.getSalary());
			pstmt.setString(4, employee.getDesignation());
			pstmt.setString(5, employee.getInsuranceScheme());
			int row = pstmt.executeUpdate();

			return employeeId;
		} catch (Exception e) {
			System.out.println("error");
		}
		return employeeId;

	}

	// Sequence to fetch next value of Patient ID
	private int getEmployeeId() {
		// TODO Auto-generated method stub
		int employeeId1 = 0;
		String sql = "SELECT Patient_Id_Sequence.NEXTVAL FROM DUAL";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				employeeId1 = res.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("error");
		}
		return employeeId1;

	}

	@Override
	public Employee showDetailsByScheme(int scheme) {
		Employee patient = new Employee();
		if (validPatientID(scheme)) // Checking if Patient id Exists
		{
			try {
				String sql = "SELECT * FROM Employee1 WHERE id = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, scheme);
				ResultSet res = pstmt.executeQuery();
				if (res.next()) {
					patient.setId(res.getInt(1));
					patient.setName(res.getString(2));
					patient.setSalary(res.getInt(3));
					patient.setDesignation(res.getString(4));
					patient.setInsuranceScheme(res.getString(5));	
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
		} else {

		}

		return patient;
	}

	
	private boolean validPatientID(int scheme) {
		
		boolean flag = false;
		String query = "SELECT * FROM Employee1 WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, scheme);
			ResultSet res = pstmt.executeQuery();
			if (res.next())
				flag = true;
		} catch (SQLException e) {
			System.out.println("error");
		}
		return flag;

	}

}
