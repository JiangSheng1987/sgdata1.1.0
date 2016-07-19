package com.sgdata.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 *教师信息的实体类
 */
public class Teacher {

	/**
	 * 教工号
	 */
	private String teaID;
	
	/**
	 * 教师姓名
	 */
	private String teaName;
	
	/**
	 * 性别
	 */
	private String teaSex;
	
	/**
	 * 出生年日
	 */
	private Date teaBirth;
	
	/**
	 * 电话
	 */
	private String teaTel;
	
	/**
	 * 邮箱
	 */
	private String teaEmail;
	
	/**
	 * 所在系部
	 */
	private String dept;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 是否是管理员
	 */
	private String isManager;
	
	/**
	 * 
	 */
	private Department department;
	
	/**
	 * 学生课程信息的集合
	 */
	private Set studentcourses = new HashSet();
	
	/**
	 * 学生比赛信息的集合
	 */
	private Set studentmatches = new HashSet();
	
	/**
	 * 教师课程信息的集合
	 */
	private Set teachercourses = new HashSet();
	
	/**
	 * 教师比赛信息的集合
	 */
	private Set teachermatches = new HashSet();
	
	public String getTeaID() {
		return teaID;
	}

	public void setTeaID(String teaID) {
		this.teaID = teaID;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaSex() {
		return teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	public Date getTeaBirth() {
		return teaBirth;
	}

	public void setTeaBirth(Date teaBirth) {
		this.teaBirth = teaBirth;
	}

	public String getTeaTel() {
		return teaTel;
	}

	public void setTeaTel(String teaTel) {
		this.teaTel = teaTel;
	}

	public String getTeaEmail() {
		return teaEmail;
	}

	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public Set getTeachercourses() {
		return teachercourses;
	}

	public void setTeachercourses(Set teachercourses) {
		this.teachercourses = teachercourses;
	}

	public Set getTeachermatches() {
		return teachermatches;
	}

	public void setTeachermatches(Set teachermatches) {
		this.teachermatches = teachermatches;
	}

}
