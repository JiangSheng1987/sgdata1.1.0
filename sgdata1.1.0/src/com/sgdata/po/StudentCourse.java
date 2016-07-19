package com.sgdata.po;

/**
 * 学生课程信息的实体类
 *
 */
public class StudentCourse {

	/**
	 * ID号
	 */
	private int id;
	
	/**
	 * 课程成绩
	 */
	private int score;
	
	private Student student;
	
	private Course course;
	
	private Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
