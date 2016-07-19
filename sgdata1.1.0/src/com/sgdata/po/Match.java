package com.sgdata.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 比赛信息的实体类
 * @author Administrator
 *
 */
public class Match {

	/**
	 * 比赛ID号
	 */
	private int matchID;
	
	/**
	 * 比赛的名称
	 */
	private String matchName;
	
	/**
	 * 比赛时间
	 */
	private Date matchTime;
	
	/**
	 * 比赛奖励
	 */
	private String matchReward;
	
	private Set studentmatches = new HashSet();
	
	private Set teachermatches = new HashSet();
	
	public Match(){
		
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public String getMatchReward() {
		return matchReward;
	}

	public void setMatchReward(String matchReward) {
		this.matchReward = matchReward;
	}

	public Set getStudentmatches() {
		return studentmatches;
	}

	public void setStudentmatches(Set studentmatches) {
		this.studentmatches = studentmatches;
	}

	public Set getTeachermatches() {
		return teachermatches;
	}

	public void setTeachermatches(Set teachermatches) {
		this.teachermatches = teachermatches;
	}
	
	
}
