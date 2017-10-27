package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dao.EmployeeManagementDAOImpl;
import com.cg.ems.dao.IEmployeeManagementDAO;

public class EmployeeManagementServiceImpl implements IEmployeeManagementService{

	IEmployeeManagementDAO ied = new EmployeeManagementDAOImpl();
	
	@Override
	public EmployeeBean getEmployeeDetailsBasedOnId(int empId) {
		return ied.getEmployeeDetailsBasedOnId(empId);
	}
	
	/******************** Employee method *******/
	
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(
			String firstName) {
		return ied.getEmployeeDetailsBasedOnFirstName(firstName);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(
			String lastname) {
		return ied.getEmployeeDetailsBasedOnLastName(lastname);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(
			String deptName) {
		return ied.getEmployeeDetailsBasedOnDepartment(deptName);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String grade) {
		return ied.getEmployeeDetailsBasedOnGrade(grade);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(
			String marStatus) {
		return ied.getEmployeeDetailsBasedOnMaritalStatus(marStatus);
	}

	@Override
	public ArrayList<EmployeeBean> getAllEmployeeDetails() {
		
		return ied.getAllEmpoyeeDetails();
	}

}
