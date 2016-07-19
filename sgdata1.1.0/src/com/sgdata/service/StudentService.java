package com.sgdata.service;

import java.util.List;

import com.sgdata.po.Student;
import com.sgdata.po.page.PageBean;

public interface StudentService {

	/**
	 * 获取所有的学生信息记录，并进行信息分页显示
	 * 
	 * @param hql
	 * 			查询条件
	 * @param offset
	 * 			开始记录数
	 * @param length
	 * 			一次查询几条记录
	 * @return
	 */
	public PageBean getAllStudentInfo(int pageSize,int currentPage);
	
	/**
	 * 保存或修改学生信息
	 * @param student
	 */
	public void saveOrUpdateInfo(Student student);
	
	/**
	 * 删除信息
	 * @param student
	 */
	public void removeStudentInfo(Student student);
	
	/**
	 * 通过ID号获取详细信息
	 * @param stuID
	 * @return
	 */
	public List getStudentInfoById(String stuID);
	
	/**
	 * 通过学号获取学生学习成绩
	 * @param stuID
	 * @return
	 */
	public List getLearnScore(String stuID);
	
	/**
	 * 通过学号获取学生比赛信息
	 * @param stuID
	 * @return
	 */
	public List getMatchScore(String stuID);
	
	/**
	 * 获取总记录数
	 * 
	 * @param hql
	 * 			查询条件
	 * @return	总记录数
	 */
	public int getAllRowCount(String hql);
	
	/**
	 * 通过学号查询学生信息
	 * @param hql
	 * 			查询sql
	 * @param id
	 * 			学号
	 * @return 某个学号的学生信息
	 */
	public List<Student> getInfoById(final String id);
	
}
