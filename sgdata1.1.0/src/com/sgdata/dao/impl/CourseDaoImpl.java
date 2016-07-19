package com.sgdata.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sgdata.dao.CourseDao;
import com.sgdata.po.Course;
import com.sgdata.po.Student;
import com.sgdata.util.HibernateUtil;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Resource HibernateTemplate ht;
	
	/**
	 * 获取课程的基本信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllCourseInfo(final String hql,final int offset,final int length) {
		
		return ht.execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		
	}

	/**
	 * 获取任课教师的信息
	 */
	@SuppressWarnings("rawtypes")
	public List getCourseTeachersInfo(String hql,String courseID) {
		List list = (List)ht.find(hql, courseID);
		return list;
	}

	public int getAllRowCount(String hql) {
		return ht.find(hql).size();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean newCourse(final Course course) {
		ht.execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				session.save(course);
				return true;
			}
			
		});
		return false;
	}

}
