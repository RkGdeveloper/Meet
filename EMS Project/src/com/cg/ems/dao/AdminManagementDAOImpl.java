package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dbconfig.DbUtil;

public class AdminManagementDAOImpl implements IAdminManagementDAO{


	@Override
	public void addEmployeeDetails(EmployeeBean empBean) {
		try {
			
			
			System.out.println(empBean);
			
			
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO Employee_table VALUES(emp_table_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, empBean.getFirstName());
			pst.setString(2, empBean.getLastName());
			pst.setDate(3, empBean.getDateOfJoining());
			pst.setDate(4, empBean.getDateOfBirth());
			pst.setInt(5, empBean.getDeptId());
			pst.setInt(6, empBean.getDesignationId());
			pst.setString(7, empBean.getGrade());
			pst.setString(8, empBean.getGender());
			pst.setLong(9,empBean.getSalary());
			pst.setString(10, empBean.getMartialStatus());
			pst.setInt(11, empBean.getAddressId());
			pst.setLong(12, empBean.getContactNo());
			
			int noOfRows = pst.executeUpdate();
			if(noOfRows > 0)
				System.out.println("Row inserted ");
			else
				System.out.println("Failed");
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

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
				empB.setDeptId(rs.getInt(6));
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


	@Override
	 public DepartmentBean insertDepartment(DepartmentBean db)
	{
			int dId = 0;
			int value=0;
			Connection con;
			try {
				con = DbUtil.getConnection();
				PreparedStatement deptIdQuery = con.prepareStatement("insert into Department_table values(deptId_seq.nextval,?)");
				deptIdQuery.setString(1, db.getDeptName());
				value = deptIdQuery.executeUpdate();
				if(value > 0)
				{
				Statement st = con.createStatement();
				
				ResultSet rsp=st.executeQuery("Select deptId_seq.currval from dual");
				while(rsp.next())
					{
						dId=rsp.getInt(1);
						
					}
				
				db.setDeptId(dId);
				}
			} 
			catch (IOException | SQLException e1) 
			{

				e1.printStackTrace();
			}
		
			return db;
}

	@Override
	public DesignationBean insertDesignation(DesignationBean db1) {
		int dId1 = 0;
		int value=0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement desigIdQuery = con.prepareStatement("insert into Designation_table values(desigId_seq.nextval,?)");
			desigIdQuery.setString(1, db1.getDesigName());
			
			value = desigIdQuery.executeUpdate();
			if(value > 0)
			{
			Statement st = con.createStatement();
			
			ResultSet rsp=st.executeQuery("Select desigId_seq.currval from dual");
			while(rsp.next())
				{
					dId1=rsp.getInt(1);
					
				}
			
			db1.setDesigId(dId1);
			}
		} 
		catch (IOException | SQLException e1) 
		{

			e1.printStackTrace();
		}
	
		return db1;
	}
	
	

	@Override
	public AddressBean insertAddress(AddressBean db2) {
		int dId2 = 0;
		int value=0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement addIdQuery = con.prepareStatement("insert into Address_table values(addr_seq.nextval,?,?,?,?,?,?,?)");
			addIdQuery.setInt(1, (db2.getDoorNo()));
			addIdQuery.setString(2, db2.getStreet());
			addIdQuery.setString(3, db2.getLandmark());
			addIdQuery.setString(4, db2.getArea());
			addIdQuery.setInt(5, db2.getPincode());
			addIdQuery.setString(6, db2.getDistrict());
			addIdQuery.setString(7, db2.getState());
			
			
			value = addIdQuery.executeUpdate();
			if(value > 0)
			{
			Statement st = con.createStatement();
			
			ResultSet rsp=st.executeQuery("Select addr_seq.currval from dual");
			while(rsp.next()) 
				{
					dId2=rsp.getInt(1);
					
				}
			
			db2.setAddressId(dId2);
			}
		} 
		catch (IOException | SQLException e1) 
		{

			e1.printStackTrace();
		}
	
		return db2;
	}

	@Override
	public int isDeptNameExist(String deptName) {
		Connection con;
		int dId3 = 0;
		 
		try {
			con = DbUtil.getConnection();
			
			String isExist = "Select department_id from department_table where department_name = (?)";
			
			PreparedStatement pst = con.prepareStatement(isExist);
			pst.setString(1, deptName);
			
			ResultSet rsp=pst.executeQuery();
			
			
			while(rsp.next()) 
			{
				dId3 = rsp.getInt(1);
			}
			
			System.out.println("in DAO Layer"+dId3);
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dId3;

		
	}

	@Override
	public int isDesigNameExist(String desigName) {
		Connection con;
		int dId4 = 0;
		 
		try {
			con = DbUtil.getConnection();
			
			String isExist = "Select designation_id from designation_table where designation_name = (?)";
			
			PreparedStatement pst = con.prepareStatement(isExist);
			pst.setString(1, desigName);
			
			ResultSet rsp=pst.executeQuery();
			
			
			while(rsp.next()) 
			{
				dId4 = rsp.getInt(1);
			}
			
			System.out.println("in DAO Layer"+dId4);
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dId4;
	}
}
	
	
