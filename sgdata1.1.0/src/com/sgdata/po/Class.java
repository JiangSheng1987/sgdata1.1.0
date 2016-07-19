package com.sgdata.po;

import java.util.HashSet;
import java.util.Set;

public class Class {

	/*
	 * 班级编号
	 */
	private int classID;
	
	/*
	 * 班级名称 
	 */
	private String className;
	
	private Department department;
	
	private Set<Student> students = new HashSet<Student>();
	
	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
}
