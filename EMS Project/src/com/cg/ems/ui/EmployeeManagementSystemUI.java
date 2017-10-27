package com.cg.ems.ui;



import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.bean.LoginDetailsBean;
import com.cg.ems.service.AdminManagementServiceImpl;
import com.cg.ems.service.EmployeeManagementServiceImpl;
import com.cg.ems.service.IAdminManagementService;
import com.cg.ems.service.IEmployeeManagementService;
import com.cg.ems.service.ILoginService;
import com.cg.ems.service.LoginServiceImpl;

public class EmployeeManagementSystemUI {

	
	public static void main(String[] args) {
		
		ILoginService is = new LoginServiceImpl();
		EMSOperation emsOp = new EMSOperation();
		LoginDetailsBean loginDetails = new LoginDetailsBean();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Management System");
		System.out.println("******************************");
		while(true)
		{
		System.out.println("1.Login");
		System.out.println("2.Exit");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("Login");
		System.out.println("Enter Username");
		loginDetails.setUserName(sc.next());
		System.out.println("Enter Password");
		loginDetails.setPassword(sc.next());
		System.out.println("Enter your role Admin or Employee");
		String role=sc.next();
		loginDetails.setRole(role);
		
		int valid  = is.validateLogin(loginDetails);
		
		if(valid == 1 && role.equals("admin"))
		{
			emsOp.showOptionsOfAdmin();
		}
		else if(valid == 1 && role.equals("user"))
		{
			emsOp.showOptionsOfEmployee();
		}
		else
			System.out.println("Wrong User Name and Password");
		break;
		
		case 2:
			System.out.println("Thank You");
			System.exit(0);
			break;
		}

	
		}
		
		
	}
}

class EMSOperation{
	
	Scanner sc = new Scanner(System.in);
	EmployeeBean employee = new EmployeeBean();
	IAdminManagementService adminServiceRef = new AdminManagementServiceImpl();
	IEmployeeManagementService empServiceRef = new EmployeeManagementServiceImpl();
	ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
	
	
	
	void displayEmployeeListDetails(ArrayList<EmployeeBean> empBeanList){
		
		System.out.println("ID  || FirstName || LastName  || Department || Grade || Designation \n");
		
		for(EmployeeBean beanEmp :empBeanList){
			//System.out.println(beanEmp);
			System.out.println(beanEmp.getEmpId()+"\t"+beanEmp.getFirstName()+"\t\t"+beanEmp.getLastName()+"\t"+beanEmp.getDeptName()+"\t"+beanEmp.getGrade()+"\t"+beanEmp.getDesignationId());
		}
	}

	void displayEmployeeDetails(EmployeeBean empBean){
		System.out.println(empBean);
	}
	
	public void showOptionsOfEmployee() {
		
		while(true)
		{
		System.out.println("Options for Admin");
		System.out.println("1.Search based on Employee ID");
		System.out.println("2.Search based on Employee's First name");
		System.out.println("3.Search based on Employee's Last name");
		System.out.println("4.Search based on Department ID");
		System.out.println("5.Search based on Employee's grade");
		System.out.println("6.Search based on Employee's marital status");
		System.out.println("7.Get All Employee");
		System.out.println("8.Exit");
		System.out.println("What you want :");
		int choice=sc.nextInt();
		
		
		switch(choice)
		{
		case 1:searchBasedOnID();
			    break;
		case 2:searchBasedOnFirstName();
				break;
		case 3:searchBasedOnLastname();
		       break;
		case 4:searchBasedOnDepartmentID();
	    		break;
		case 5:searchBasedOnGrade();
				break;
		case 6:searchBasedOnMaritalStatus();
				break;
		case 7:
				getAllEmployeeDetails();
		}
		}
		
	}

	/*********************************************** User Operation **********************************************************/
	
	private void searchBasedOnFirstName() {
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnFirstName("Govind");
		displayEmployeeListDetails(empBeanList);
	}

	private void getAllEmployeeDetails() {
		empBeanList = empServiceRef.getAllEmployeeDetails();
		displayEmployeeListDetails(empBeanList);
		
	}

	private void searchBasedOnMaritalStatus() {
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnMaritalStatus("Single");
		displayEmployeeListDetails(empBeanList);
	}

	private void searchBasedOnGrade() {
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnGrade("M2");
		displayEmployeeListDetails(empBeanList);
		
	}

	private void searchBasedOnDepartmentID() {
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnDepartment("Developer");
		displayEmployeeListDetails(empBeanList);
		
	}

	private void searchBasedOnLastname() {
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnLastName("Prajapati");
		displayEmployeeListDetails(empBeanList);
		
	}

	private void searchBasedOnID() {
		EmployeeBean empB = empServiceRef.getEmployeeDetailsBasedOnId(10002);
		displayEmployeeDetails(empB);
		
	}

	
	
	
	
	
	
	
	/*********************************************** Admin Operation **********************************************************/
	public void showOptionsOfAdmin() {
		while(true)
		{
		System.out.println("----------:: Welcome Admin ::-------- ");
		System.out.println("1.Add new Employee");
		System.out.println("2.Update Employee details");
		System.out.println("3.View all Employee");
		System.out.println("4.Search Employee"
				+ "5.Exit");
		System.out.println("What you want :");
		int option=sc.nextInt();
		
		switch(option)
		{
		case 1:addNewEmployee();
			    break;
		case 2:updateEmployeeDetails();
				break;
		case 3:viewAllEmployee();
				break;
		case 4:searchEmployee();
				break;
		case 5:
			break;
		}
		}
	}

	private void searchEmployee() {
		System.out.println("\n\nEmployee Details Based on Id\n\n Enter Id Of Employee to Search");
		int empId = sc.nextInt();
		
		EmployeeBean empB = adminServiceRef.getEmployeeDetailsBasedOnId(empId);
		displayEmployeeDetails(empB);
	}

	private void viewAllEmployee() {
		
		/****All Employee Details **/
		System.out.println("\n\nAll Employee Details");
		ArrayList<EmployeeBean> empBeanList = adminServiceRef.getAllEmployeeDetails();
		displayEmployeeListDetails(empBeanList);
		
	}

	private void updateEmployeeDetails() {

		System.out.println("\n\nEmployee Details Based on Id\n\n Enter Id Of Employee to Update");
		int empId = sc.nextInt();
		
		EmployeeBean empB = adminServiceRef.getEmployeeDetailsBasedOnId(empId);
		displayEmployeeDetails(empB);
		
		
	}

	private void addNewEmployee() {
		System.out.println("Employee ID:");
		int empId=sc.nextInt();
		
		System.out.println("\nEnter Employee's first name:");
		String FirstName=sc.next();
		
		System.out.println("\nEnter Employee's last name:");
		String LastName=sc.next();
		
		System.out.println("\nEnter Employee's date Of joining: dd/MM/yyyy : ");
		String d1 = sc.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateOfJoining = LocalDate.parse(d1,formatter);
		Date doj = Date.valueOf(dateOfJoining);
		
		System.out.println("\nEnter Employee's date Of Birth: dd/MM/yyyy : ");
		String d2 = sc.next();
		
		LocalDate dateOfBirth = LocalDate.parse(d2,formatter);
		Date dob = Date.valueOf(dateOfBirth);
		
	
		/*System.out.println("Enter Department ID:");
		int deptId=sc.nextInt();*/
		
		System.out.println("Enter Department Name:");
		String deptName=sc.next();

		int deptid  = adminServiceRef.isDeptNameExist(deptName);
		System.out.println(deptid);

		DepartmentBean deptB = new DepartmentBean();
		deptB.setDeptName(deptName);
		int deptid1=isDeptNameExist(deptName);
	
		
		int deptID = 0;
		
		if(deptid1 > 0)
		{
			System.out.println("In If Dept Id"+deptid1);
			deptB.setDeptId(deptid1);
		}
		
		if(deptid1 == 0)
		{
		
			deptB = adminServiceRef.insertDepartment(deptB);
		
			if(deptB.getDeptId() >0){
				deptID =deptB.getDeptId();

				System.out.println("Dept Id"+deptID);
			}
		}
		
		System.out.println("Enter Designation Name:");
		String desigName=sc.next();
		
		int desigid  = adminServiceRef.isDesigNameExist(desigName);
		System.out.println(desigid);
		
		DesignationBean desigB = new DesignationBean();
		desigB.setDesigName(desigName);
		
		int desigid1=isDesigNameExist(desigName);
		int desigId = 0;
		
		if(desigid1 >0)
		{
			System.out.println("Dept Id"+desigid1);
			deptB.setDeptId(desigid1);
		}
		
		if(desigid1 == 0)
		{
			desigB = adminServiceRef.insertDesignation(desigB);
			
			if(desigB.getDesigId() >0)
			{
			desigId =desigB.getDesigId();
			System.out.println("Desig Id"+desigId);
		
		}
			
		}
		
		System.out.println("\nEnter Employee's Salary:");
		Long salary=sc.nextLong();
		
		//calculation of grade
		
		System.out.println("\nEnter Gender:");
		String gender=sc.next();
		
		System.out.println("\nEnter martial Status:");
		String martialStatus=sc.next();
		
	//	System.out.println("Enter AddressId:");
	//	int addId=sc.nextInt();
		
		AddressBean addB = new AddressBean();
		System.out.println("Enter door number:");
		int doorNo=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter street:");
		String street=sc.nextLine();
		
		System.out.println("Enter landmark:");
		String landmark=sc.nextLine();
		
		System.out.println("Enter Area:");
		String area=sc.nextLine();
		
		System.out.println("Enter pincode:");
		int pincode=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter district:");
		String district=sc.nextLine();
		
		System.out.println("Enter state:");
		String state=sc.nextLine();
		
		addB.setDoorNo(doorNo);
		addB.setStreet(street);
		addB.setLandmark(landmark);
		addB.setArea(area);
		addB.setPincode(pincode);
		addB.setDistrict(district);
		addB.setState(state);
		
		addB = adminServiceRef.insertAddress(addB);
		System.out.println("Address Id is "+addB.getAddressId());
		
		int addId =0;
		if(addB.getAddressId()>0){
			addId =addB.getAddressId();
		}
		
	
		System.out.println("Enter Contact number:");
		long contactNo=sc.nextLong();
		
		
		// add Employee details

		
								
		
		//EmployeeBean employee = new EmployeeBean(empId,FirstName,LastName,doj,dob,deptID,desigId,"M2",gender,salary,martialStatus,addId,contactNo);

		System.out.println("in Ui  "+employee);
		
		
		adminServiceRef.addEmployeeDetails(employee);
		
		
	}
	private int isDesigNameExist(String desigName) {
		// TODO Auto-generated method stub
		return adminServiceRef.isDesigNameExist(desigName);
	}

	/*********************************************************************************************************/

	private int isDeptNameExist(String deptName) {
		
		return adminServiceRef.isDeptNameExist(deptName);
	}

	


} 
