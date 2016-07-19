package com.sgdata.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sgdata.dao.DepartmentDao;
import com.sgdata.po.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Resource HibernateTemplate ht;
	public List<Department> getAllDepart(String hql) {
		@SuppressWarnings("unchecked")
		List<Department> departments = (List<Department>) ht.find(hql);
		return departments;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int getDepartId(final String departName) {
		return ht.execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				String hql = "from Department d where d.departName = ?";
				Query query = session.createQuery(hql);
				query.setString(0, departName);
				int id = 0;
				return id;
			}
			
		});
	}

}
