package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dao.EmployeeManagementDAOImpl;
import com.cg.ems.dao.IEmployeeManagementDAO;
import com.cg.ems.exception.EMSException;

public class EmployeeManagementServiceImpl implements IEmployeeManagementService{

	IEmployeeManagementDAO ied = new EmployeeManagementDAOImpl();
	
	@Override
	public EmployeeBean getEmployeeDetailsBasedOnId(int empId) throws EMSException {
		return ied.getEmployeeDetailsBasedOnId(empId);
	}
	
	/******************** Employee method 
	 * @throws EMSException *******/
	
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(
			String firstName) throws EMSException {
		return ied.getEmployeeDetailsBasedOnFirstName(firstName);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(
			String lastname) throws EMSException {
		return ied.getEmployeeDetailsBasedOnLastName(lastname);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(
			String deptName) throws EMSException {
		return ied.getEmployeeDetailsBasedOnDepartment(deptName);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String grade) throws EMSException {
		return ied.getEmployeeDetailsBasedOnGrade(grade);
	}
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(
			String marStatus) throws EMSException {
		return ied.getEmployeeDetailsBasedOnMaritalStatus(marStatus);
	}

	@Override
	public ArrayList<EmployeeBean> getAllEmployeeDetails() throws EMSException {
		
		return ied.getAllEmpoyeeDetails();
	}

}
