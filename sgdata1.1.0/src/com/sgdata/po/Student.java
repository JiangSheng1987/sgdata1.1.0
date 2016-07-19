package com.sgdata.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 学生信息的实体类
 * @author Nicky
 *
 */
public class Student {
	
	/*
	 * 学号
	 */
	private String stuID;
	
	/*
	 * 班级
	 */
	private String stuName;
	
	/*
	 * 性别
	 */
	private String stuSex;
	
	/*
	 * 出生年日
	 */
	private Date stuBirth;
	
	/*
	 * 电话
	 */
	private String stuTel;
	
	/*
	 * 邮箱
	 */
	private String stuEmail;
	
	/*
	 * 专业
	 */
	private String dept;
	
	/*
	 * 身份证
	 */
	private String stuIDCard;
	
	/*
	 * 班级
	 */
	private String className;
	
	/*
	 * 登录密码
	 */
	private String password;
	
	/*
	 * 系部ID，外键
	 */
	private int departID;
	
	/*
	 * 班级ID，外键 
	 */
	private int classID;
	
	private Set studentcourses = new HashSet();
	
	private Set studentmatches = new HashSet();
	
	private Department department;
	
	private Class mclass;

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuBirth() {
		return stuBirth;
	}

	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStuIDCard() {
		return stuIDCard;
	}

	public void setStuIDCard(String stuIDCard) {
		this.stuIDCard = stuIDCard;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepartID() {
		return departID;
	}

	public void setDepartID(int departID) {
		this.departID = departID;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public Set getStudentcourses() {
		return studentcourses;
	}

	public void setStudentcourses(Set studentcourses) {
		this.studentcourses = studentcourses;
	}

	public Set getStudentmatches() {
		return studentmatches;
	}

	public void setStudentmatches(Set studentmatches) {
		this.studentmatches = studentmatches;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Class getMclass() {
		return mclass;
	}

	public void setMclass(Class mclass) {
		this.mclass = mclass;
	}
	
}
