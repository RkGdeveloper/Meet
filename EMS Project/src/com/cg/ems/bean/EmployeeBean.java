package com.cg.ems.bean;

import java.sql.Date;


public class EmployeeBean {

	private int empId;
	private String FirstName;
	private String LastName;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private int DeptId;
	private String deptName;
	private int designationId;
	private String desigName;
	
	private String grade;
	private String gender;
	private long salary;
	private String martialStatus;
	private int addressId;
	private long contactNo;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getDeptId() {
		return DeptId;
	}
	public void setDeptId(int deptId) {
		DeptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesigName() {
		return desigName;
	}
	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	

	//"Govind","Prajapati","16/AUG/2017","20/DEC/1995",111,1112,"M2","Male",25000,"Single",1010,"8286301908");
	

	public EmployeeBean(){}
	
	
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	
	
	
	
	
	public EmployeeBean(int empId, String firstName, String lastName,
			Date dateOfJoining, Date dateOfBirth, int deptId,int designationId,String grade, String gender,
			long salary, String martialStatus, int addressId, long contactNo) {
		this.empId = empId;
		FirstName = firstName;
		LastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		DeptId = deptId;
		this.designationId = designationId;
		this.grade = grade;
		this.gender = gender;
		this.salary = salary;
		this.martialStatus = martialStatus;
		this.addressId = addressId;
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", DeptId=" + DeptId
				+ ", designationId=" + designationId + ", grade=" + grade
				+ ", gender=" + gender + ", salary=" + salary
				+ ", martialStatus=" + martialStatus + ", addressId="
				+ addressId + ", contactNo=" + contactNo + "]";
	}
	
	
	
	
	
}
