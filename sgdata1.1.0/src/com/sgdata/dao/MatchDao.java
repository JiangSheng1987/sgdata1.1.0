package com.sgdata.dao;

import java.util.List;

public interface MatchDao {

	/**
	 * 获取所有的比赛信息
	 * @return
	 */
	public List getAllMatchInfo(final String hql,final int offset,final int length);
	
	/**
	 * 根据比赛的ID号获取参赛学生信息
	 * @param matchID
	 * @return
	 */
	public List getMatchStudentsInfo(String hql,int matchID);
	
	/**
	 * 获取总记录数
	 * 
	 * @param hql
	 * 			查询条件
	 * @return	总记录数
	 */
	public int getAllRowCount(String hql);
}
