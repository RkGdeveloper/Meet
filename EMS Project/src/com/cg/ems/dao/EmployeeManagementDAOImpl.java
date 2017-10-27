package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dbconfig.DbUtil;

public class EmployeeManagementDAOImpl implements IEmployeeManagementDAO{


	@Override
	public EmployeeBean getEmployeeDetailsBasedOnId(int empId) {
		
		EmployeeBean empB = new EmployeeBean();
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where Emp_Id = ?");
				pst.setInt(1, empId);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptName(rs.getString(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
			}
			System.out.println(empB);
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empB;
	}

	
	@Override
	public ArrayList<EmployeeBean> getAllEmpoyeeDetails() {
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		EmployeeBean empB =null;
		try {
			Connection con = DbUtil.getConnection();
			String query = "select * from Employee_table";
			Statement st = con.createStatement();

			
 			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				empB = new EmployeeBean();
				
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptName(rs.getString(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				//System.out.println(empB);
				empBeanList.add(empB);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empBeanList;
	}

	

	
	
	// Employee Method
	
	
	
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(
			String firstName) {
		
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_firstname = ?");
				pst.setString(1, firstName);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptName(rs.getString(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empBeanList;
	}

	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(
			String lastname) {
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_lastname = ?");
				pst.setString(1, lastname);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptName(rs.getString(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empBeanList;
	}

	
	
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(
			String deptName) {
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		int dId = 0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement deptIdQuery = con.prepareStatement("select department_id from Department_table where department_Name = ?");
			deptIdQuery.setString(1, deptName);
			ResultSet rst = deptIdQuery.executeQuery();
			if(rst.next())
			{
				dId = rst.getInt(1);
			}
			
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_dept_id = ?");
			pst.setInt(1, dId);
			ResultSet rs = pst.executeQuery();
				
					while(rs.next()){
						empB= new EmployeeBean();
						empB.setEmpId(rs.getInt(1));
						empB.setFirstName(rs.getString(2));
						empB.setLastName(rs.getString(3));
						empB.setDateOfJoining(rs.getDate(4));
						empB.setDateOfBirth(rs.getDate(5));
						empB.setDeptName(rs.getString(6));
						empB.setDesignationId(rs.getInt(7));
						empB.setGrade(rs.getString(8));
						empB.setGender(rs.getString(9));
						empB.setSalary(rs.getLong(10));
						empB.setMartialStatus(rs.getString(11));
						empB.setAddressId(rs.getInt(12));
						empB.setContactNo(rs.getLong(13));
						empBeanList.add(empB);
			
					}
			
			
		} catch (IOException | SQLException e1) {

			e1.printStackTrace();
		}
		
		
		return empBeanList;
	
	}

	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String grade) {
ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_grade = ?");
				pst.setString(1, grade);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptName(rs.getString(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empBeanList;
	}

	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(
			String marStatus) {
ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_marital_status = ?");
				pst.setString(1, marStatus);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptName(rs.getString(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return empBeanList;
	}


	
	
	
	
}
