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

import com.sgdata.dao.StudentDao;
import com.sgdata.po.Student;
import com.sgdata.util.HibernateUtil;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	@Resource HibernateTemplate ht;
	
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Student> getAllStudentInfo(final String hql,final int offset,final int length) {
		
		return ht.execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List<Student> students = query.list();
				return students;
			}
		});
		
	}


	/**
	 * 更新学生信息
	 */
	public void saveOrUpdateInfo(Student student) {
		ht.saveOrUpdate(student);
	}

	/**
	 * 删除学生信息
	 */
	public void removeStudentInfo(Student student) {
		ht.delete(student);
	}

	/**
	 * 通过学号获取详细信息
	 */
	@SuppressWarnings("rawtypes")
	public List getStudentInfoById(String hql,String stuID) {
		
		List list = (List)ht.find(hql, stuID);
		return list;
		
	}

	/**
	 * 获取学习情况信息
	 */
	@SuppressWarnings("rawtypes")
	public List getLearnScore(String hql,String stuID) {
		List list = (List)ht.find(hql,stuID);
		return list;
	}

	/**
	 * 获取比赛情况信息
	 */
	@SuppressWarnings("rawtypes")
	public List getMatchScore(String hql,String stuID) {
		List list = (List)ht.find(hql,stuID);
		return list;
	}

	/**
	 * 获取总记录数
	 * 
	 * @param hql
	 * 			查询条件
	 * @return	总记录数
	 */
	public int getAllRowCount(String hql) {
		return ht.find(hql).size();
	}

	/**
	 * 通过学号查询学生信息
	 * @param hql
	 * 			查询sql
	 * @param id
	 * 			学号
	 * @return 某个学号的学生信息
	 */
	public List<Student> getInfoById(String hql, String id) {
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>)ht.find(hql, id);
		return students;
	}

}
