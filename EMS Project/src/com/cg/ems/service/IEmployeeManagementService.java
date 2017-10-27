package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.EmployeeBean;

public interface IEmployeeManagementService {

	EmployeeBean getEmployeeDetailsBasedOnId(int empid);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(String string);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(String string);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(String string);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String string);

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(String string);

	ArrayList<EmployeeBean> getAllEmployeeDetails();

	
}
