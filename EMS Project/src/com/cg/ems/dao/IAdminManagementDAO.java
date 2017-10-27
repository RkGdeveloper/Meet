package com.cg.ems.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;

public interface IAdminManagementDAO {

	void addEmployeeDetails(EmployeeBean empBean);

	EmployeeBean getEmployeeDetailsBasedOnId(int empId);

	ArrayList<EmployeeBean> getAllEmpoyeeDetails();

	DepartmentBean insertDepartment(DepartmentBean b);

	DesignationBean insertDesignation(DesignationBean desigB);

	AddressBean insertAddress(AddressBean addB);

	int isDeptNameExist(String deptName);

	int isDesigNameExist(String desigName);



	


	
}
