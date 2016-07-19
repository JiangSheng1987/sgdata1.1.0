package com.sgdata.service;

import java.util.List;

import com.sgdata.po.Course;
import com.sgdata.po.page.PageBean;
public interface CourseService {

	/**
	 * 获取所有课程信息
	 * @return
	 */
	public PageBean getAllCourseInfo(int pageSize,int currentPage);
	
	/**
	 * 根据课程代码获取该课程的任课老师信息
	 * @return 
	 */
	public List getCourseTeachersInfo(String courseID);
	
	/**
	 * 获取总记录数
	 * 
	 * @param hql
	 * 			查询条件
	 * @return	总记录数
	 */
	public int getAllRowCount(String hql);
	
	/**
	 * 新开课程
	 * @param course
	 * 			课程信息实体类
	 * @return
	 */
	public boolean newCourse(final Course course);
}