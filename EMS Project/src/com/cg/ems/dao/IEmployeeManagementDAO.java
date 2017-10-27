package com.cg.ems.dao;

import java.util.ArrayList;

import com.cg.ems.bean.EmployeeBean;

public interface IEmployeeManagementDAO {

	
	EmployeeBean getEmployeeDetailsBasedOnId(int empId);

	ArrayList<EmployeeBean> getAllEmpoyeeDetails();
	
	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(String firstName);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(String lastname);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(String deptName);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String grade);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(
			String marStatus);

	
}
