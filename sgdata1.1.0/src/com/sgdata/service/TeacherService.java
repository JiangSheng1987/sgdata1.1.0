package com.sgdata.service;

import java.util.List;

import com.sgdata.po.Teacher;
import com.sgdata.po.page.PageBean;

public interface TeacherService {

	/*
	 * 登录验证
	 */
	public Teacher loginCheck(String account);
	
	/**
	 * 获取所有教师的信息
	 * @return
	 */
	public PageBean getAllTeacherInfo(int pageSize,int currentPage);
	
	/**
	 * 获取教师任课情况的信息
	 */
	public List getTeachingCourse(String teaID);
	
	/**
	 * 获取教师指导比赛的信息
	 */
	public List getMatchGuide(String teaID);
	
	/**
	 * 获取某门课程的学生信息
	 * @param courseID
	 * @return
	 */
	public List getCourseStudentsInfo(String courseID);
	
	/**
	 * 获取参加某个比赛的学生信息
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
	
	/**
	 * 根据工号查询教师信息
	 * @param hql
	 * 			查询sql
	 * @param teaID
	 * 			工号
	 * @return
	 */
	public List getTeaInfoById(String teaID);
}
