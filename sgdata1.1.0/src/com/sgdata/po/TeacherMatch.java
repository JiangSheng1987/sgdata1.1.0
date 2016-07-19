package com.sgdata.po;

/**
 * 教师比赛信息的实体类
 * @author Administrator
 *
 */
public class TeacherMatch {

	private int id;

	private Match match;
	
	private Teacher teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
