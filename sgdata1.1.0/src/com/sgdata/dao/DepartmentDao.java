package com.sgdata.dao;

import java.util.List;

import com.sgdata.po.Department;

public interface DepartmentDao {

	/**
	 * 获取所有的系部信息
	 * @return
	 */
	public List<Department> getAllDepart(String hql);
	
	/**
	 * 通过系部名称获取对应的ID号
	 * @param departName
	 * 			系部名称
	 * @return 系部ID号
	 */
	public int getDepartId(final String departName);
	
}
