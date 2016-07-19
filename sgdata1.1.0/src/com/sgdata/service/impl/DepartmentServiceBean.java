package com.sgdata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sgdata.dao.DepartmentDao;
import com.sgdata.po.Department;
import com.sgdata.service.DepartmentService;

@Transactional(readOnly=false)
public class DepartmentServiceBean implements DepartmentService {

	@Resource private DepartmentDao departmentDao;
	
	public List<Department> getAllDepart(String hql) {
		return departmentDao.getAllDepart(hql);
	}

	public int getDepartId(String departName) {
		return departmentDao.getDepartId(departName);
	}

}
