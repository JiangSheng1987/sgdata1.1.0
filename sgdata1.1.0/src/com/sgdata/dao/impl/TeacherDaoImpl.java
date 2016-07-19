package com.sgdata.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sgdata.dao.TeacherDao;
import com.sgdata.po.Teacher;

public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao{
	
	@Resource HibernateTemplate ht;
	
	/**
	 * 登录验证
	 */
	public Teacher loginCheck(String account) {
		return ht.get(Teacher.class, account);
	}

	/**
	 * 获取教师基本信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllTeacherInfo(final String hql,final int offset,final int length) {
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
	 * 获取教师课程信息
	 */
	@SuppressWarnings("rawtypes")
	public List getTeachingCourse(String hql,String teaID) {
		List list = (List)ht.find(hql, teaID);
		return list;
	}

	/**
	 * 获取教师指导比赛信息
	 */
	@SuppressWarnings("rawtypes")
	public List getMatchGuide(String hql,String teaID) {
		List list = (List)ht.find(hql, teaID);
		return list;
	}

	/**
	 * 获取某门课程的学生名单信息
	 */
	@SuppressWarnings("rawtypes")
	public List getCourseStudentsInfo(String hql,String courseID) {
		List list = (List)ht.find(hql, courseID);
		return list;
	}

	/**
	 * 获取参加某个比赛的学生名单信息
	 */
	@SuppressWarnings("rawtypes")
	public List getMatchStudentsInfo(String hql,int matchID) {
		List list = (List)ht.find(hql, matchID);
		return list;
	}

	public int getAllRowCount(String hql) {
		return ht.find(hql).size();
	}
	
	/**
	 * 根据工号查询教师信息
	 * @param hql
	 * 			查询sql
	 * @param teaID
	 * 			工号
	 * @return
	 */
	public List getTeaInfoById(String hql, String teaID) {
		List list = (List)ht.find(hql, teaID);
		return list;
	}

}
