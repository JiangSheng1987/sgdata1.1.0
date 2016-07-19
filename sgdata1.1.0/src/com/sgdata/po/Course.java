package com.sgdata.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 开设课程信息的实体类
 * @author Nicky
 *
 */
public class Course {
	
	/**
	 * 课程代码
	 */
	private String courseID;
	
	/**
	 * 课程名
	 */
	private String courseName;
	
	/**
	 * 学分
	 */
	private int credit;
	
	/**
	 * 课程类型
	 */
	private String type;
	
	/**
	 * 开课时间
	 */
	private Date time;
	
	/**
	 * 课程开始周数，默认为1
	 */
	private int week1;
	
	/**
	 * 
	 */
	private int week2;
	
	private Set studentcourses = new HashSet();
	
	private Set teachercourses = new HashSet();
	
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getWeek1() {
		return week1;
	}

	public void setWeek1(int week1) {
		this.week1 = week1;
	}

	public int getWeek2() {
		return week2;
	}

	public void setWeek2(int week2) {
		this.week2 = week2;
	}
	
	public Set getStudentcourses() {
		return studentcourses;
	}

	public void setStudentcourses(Set studentcourses) {
		this.studentcourses = studentcourses;
	}

	public Set getTeachercourses() {
		return teachercourses;
	}

	public void setTeachercourses(Set teachercourses) {
		this.teachercourses = teachercourses;
	}

}
