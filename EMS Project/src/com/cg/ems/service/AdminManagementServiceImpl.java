package com.cg.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dao.AdminManagementDAOImpl;
import com.cg.ems.dao.IAdminManagementDAO;

public class AdminManagementServiceImpl implements IAdminManagementService{

	IAdminManagementDAO ied = new AdminManagementDAOImpl();

	@Override
	public void addEmployeeDetails(EmployeeBean empBean) {
		ied.addEmployeeDetails(empBean); 
	}
	@Override
	public EmployeeBean getEmployeeDetailsBasedOnId(int empId) {
		return ied.getEmployeeDetailsBasedOnId(empId);
	}
	@Override
	public ArrayList<EmployeeBean> getAllEmployeeDetails() {
		return ied.getAllEmpoyeeDetails();
	}
	@Override
	public DepartmentBean insertDepartment(DepartmentBean deptB) {
	
		return ied.insertDepartment(deptB);
	}
	@Override
	public DesignationBean insertDesignation(DesignationBean desigB) {
	
		return  ied.insertDesignation(desigB);
	}
	@Override
	public AddressBean insertAddress(AddressBean addB) {
		return  ied.insertAddress(addB);
		
	}
	@Override
	public int isDeptNameExist(String deptName) {
		return ied.isDeptNameExist(deptName);
	}
	@Override
	public int isDesigNameExist(String desigName) {
		return ied.isDesigNameExist(desigName);
	}

	}
	

