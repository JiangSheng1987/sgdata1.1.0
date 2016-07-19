package com.sgdata.po;

/**
 * 学生比赛信息的实体类
 * @author Administrator
 *
 */
public class StudentMatch {

	/**
	 * ID号
	 */
	private int id;

	private Student student;
	
	private Match match;
	
	private Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
}
