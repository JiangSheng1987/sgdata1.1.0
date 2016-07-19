package com.sgdata.service;

import java.util.List;

import com.sgdata.po.page.PageBean;

public interface MatchService {

	/**
	 * 获取所有的比赛信息
	 * @return
	 */
	public PageBean getAllMatchInfo(int pageSize,int currentPage);
	
	/**
	 * 根据比赛的ID号获取参赛学生信息
	 * @param matchID
	 * @return
	 */
	public List getMatchStudentsInfo(int matchID);
	
	/**
	 * 获取总记录数
	 * 
	 * @param hql
	 * 			查询条件
	 * @return	总记录数
	 */
	public int getAllRowCount(String hql);
}
