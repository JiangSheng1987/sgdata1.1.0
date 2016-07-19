package com.sgdata.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sgdata.dao.MatchDao;

public class MatchDaoImpl extends HibernateDaoSupport implements MatchDao {

	/**
	 * 引入HibernateTemplate类，这个类是Spring框架里的
	 */
	@Resource HibernateTemplate ht;
	
	/**
	 * 获取比赛基本信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllMatchInfo(final String hql,final int offset,final int length) {
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
	 * 获取参加比赛的学生名单
	 */
	@SuppressWarnings("rawtypes")
	public List getMatchStudentsInfo(String hql,int matchID) {
		
		List list = (List)ht.find(hql, matchID);
		return list;
	}

	public int getAllRowCount(String hql) {
		return ht.find(hql).size();
	}

}
