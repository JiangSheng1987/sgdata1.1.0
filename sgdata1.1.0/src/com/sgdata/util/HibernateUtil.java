package com.sgdata.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * Hibernate进行Session创建的工具类
 * 和Spring框架一起用时就不用这个工具类，原因是Session用Spring框架进行管理
 * @author Nicky
 *
 */
public class HibernateUtil {
	//创建ServiceRegistry对象
	private static ServiceRegistry serviceRegistry;
	//创建SessionFactory对象
	private static SessionFactory sessionFactory;
	
	public HibernateUtil() {}
	
	static{
		Configuration configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public static void close(Session session){
		if(session != null){
			session.close();
		}
	}
	
}
