package com.sgdata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.transaction.annotation.Transactional;

import com.sgdata.dao.TeacherDao;
import com.sgdata.po.Teacher;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.TeacherService;

@Transactional(readOnly=false)
public class TeacherServiceBean implements TeacherService {

	@Resource private TeacherDao teacherDao;
	public Teacher loginCheck(String account) {
		return teacherDao.loginCheck(account);
	}
	
	public PageBean getAllTeacherInfo(int pageSize,int currentPage) {
		final String hql = "from Teacher t left join fetch t.department depart order by t.teaID";
		int allRow = teacherDao.getAllRowCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, currentPage);
		final int length = pageSize;
		final int page = PageBean.countCurrentPage(currentPage);
		
		List list = teacherDao.getAllTeacherInfo(hql, offset, length);
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(page);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public List getTeachingCourse(String teaID) {
		String hql = "from TeacherCourse tc left join fetch tc.course c " +
				"left join fetch tc.teacher t where t.teaID=?";
		return teacherDao.getTeachingCourse(hql,teaID);
	}

	public List getMatchGuide(String teaID) {
		String hql = "from TeacherMatch tm left join fetch tm.match m " +
				"left join fetch tm.teacher t where t.teaID=?";
		return teacherDao.getMatchGuide(hql,teaID);
	}

	public List getCourseStudentsInfo(String courseID) {
		String hql = "from StudentCourse sc left join fetch sc.course c " +
				"left join fetch sc.student s where c.courseID=?";
		return teacherDao.getCourseStudentsInfo(hql,courseID);
	}

	public List getMatchStudentsInfo(int matchID) {
		String hql = "from StudentMatch sm left join fetch sm.match m " +
				"left join fetch sm.student s where m.matchID=?";
		return teacherDao.getMatchStudentsInfo(hql,matchID);
	}

	public int getAllRowCount(String hql) {
		return teacherDao.getAllRowCount(hql);
	}

	/**
	 * 根据工号查询教师信息
	 * @param hql
	 * 			查询sql
	 * @param teaID
	 * 			工号
	 * @return
	 */
	public List getTeaInfoById(String teaID) {
		String hql = "from Teacher t left join fetch t.department depart where t.teaID=?";
		return teacherDao.getTeaInfoById(hql, teaID);
	}
	
	

}
