package org.junit.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class JunitTest {

	@Test
	public static void main(String[] args) {
//		Configuration cfg = new Configuration().configure();
//		SessionFactory sf = cfg.buildSessionFactory();
//		
//		Session session = sf.openSession();
//		//Transaction ts = session.beginTransaction();
//		
//		List list = null;
////			String sql = "select c.*,t.teaName from Course as c left join c.teacher t";
//			String sql = "from Teacher t inner join fetch t.courses c";
//			Query query = session.createQuery(sql);
//			list = query.list();
//			Iterator iter6 = list.iterator();
//			
//			while(iter6.hasNext()){
//				Object[] stu = (Object[])iter6.next();
//				System.out.println(stu[0]+"\t"+stu[1]+"\t"+stu[2]+"\t"+stu[3]);
//			}
//			//ts.commit();
			
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		//Transaction ts = session.beginTransaction();
		
		List list = null;
		try{
//			String sql = "select c.*,t.teaName from Course as c left join c.teacher t";
			String sql = "from Course c left join fetch c.teacher t";
			Query query = session.createQuery(sql);
			list = query.list();
			Iterator iter6 = list.iterator();
			
			while(iter6.hasNext()){
				Object[] stu = (Object[])iter6.next();
				System.out.println(stu[0]+"\t"+stu[1]+"\t"+stu[2]+"\t"+stu[3]);
			}
			//ts.commit();
		}catch (Exception e) {
			// TODO: handle exception
			//if(ts!=null) ts.rollback();
		}
		
	}
}
