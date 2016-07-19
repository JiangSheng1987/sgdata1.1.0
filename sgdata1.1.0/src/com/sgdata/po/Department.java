package com.sgdata.po;

import java.util.HashSet;
import java.util.Set;

public class Department {

	/**
	 * 系部ID号
	 */
	private int departID;
	
	/**
	 * 系部名称
	 */
	private String departName;
	
	private Set<Student> students = new HashSet<Student>();

	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	private Set<Class> classes = new HashSet<Class>();
	
	public int getDepartID() {
		return departID;
	}

	public void setDepartID(int departID) {
		this.departID = departID;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}
	
}
