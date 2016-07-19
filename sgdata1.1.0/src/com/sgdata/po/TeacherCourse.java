package com.sgdata.po;

/**
 * 教师课程信息的实体类
 * @author Administrator
 *
 */
public class TeacherCourse {

	private int id;

	private Course course;
	
	private Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
