package com.cg.ems.bean;

public class DepartmentBean {

	private int deptId;
	private String deptName;
	
	
	public DepartmentBean(String deptName) {
		super();
		
		this.deptName = deptName;
	}
	public DepartmentBean() {
		
	}
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "DepartmentBean [deptName=" + deptName + "]";
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	
}
