package com.sgdata.dao;

import java.util.List;

import com.sgdata.po.Course;

public interface CourseDao {

	/**
	 * 获取所有课程信息
	 * @return
	 */
	public List getAllCourseInfo(final String hql,final int offset,final int length);
	
	/**
	 * 根据课程代码获取该课程的任课老师信息
	 * @return 
	 */
	public List getCourseTeachersInfo(String hql,String courseID);
	
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
