package com.cg.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;

public interface IAdminManagementService {

	
	void addEmployeeDetails(EmployeeBean empBean);

	EmployeeBean getEmployeeDetailsBasedOnId(int empid);

	ArrayList<EmployeeBean> getAllEmployeeDetails();

	DepartmentBean insertDepartment(DepartmentBean deptB);

	DesignationBean insertDesignation(DesignationBean desigB);

	AddressBean insertAddress(AddressBean addB);

	int isDeptNameExist(String deptName);

	int isDesigNameExist(String desigName);

	



	
}
