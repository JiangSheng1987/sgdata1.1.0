package com.sgdata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sgdata.dao.StudentDao;
import com.sgdata.po.Student;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.StudentService;

@Transactional(readOnly=false)
public class StudentServiceBean implements StudentService {

	@Resource private StudentDao studentDao;
	public PageBean getAllStudentInfo(int pageSize,int currentPage) {
		final String hql = "from Student s left join fetch s.department d" +
				" left join fetch s.mclass c order by s.stuID";
		int allRow = studentDao.getAllRowCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, currentPage);
		final int length = pageSize;
		final int page = PageBean.countCurrentPage(currentPage);
		
		List list = studentDao.getAllStudentInfo(hql, offset, length);
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(page);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public void saveOrUpdateInfo(Student student) {
		studentDao.saveOrUpdateInfo(student);
	}

	public void removeStudentInfo(Student student) {
		studentDao.removeStudentInfo(student);
	}

	@SuppressWarnings("rawtypes")
	public List getStudentInfoById(String stuID) {
		String hql = "from Student s left join fetch s.department d left join fetch s.mclass c where s.stuID=?";
		return studentDao.getStudentInfoById(hql,stuID);
	}

	@SuppressWarnings("rawtypes")
	public List getLearnScore(String stuID) {
		/*HQL连接查询*/
		String hql = "from StudentCourse sc left join fetch sc.student s " +
				"left join fetch sc.course c left join fetch sc.teacher t where s.stuID=?";
		return studentDao.getLearnScore(hql,stuID);
	}

	@SuppressWarnings("rawtypes")
	public List getMatchScore(String stuID) {
		String hql = "from StudentMatch sm left join fetch sm.student s " +
				"left join fetch sm.match m left join fetch sm.teacher t where s.stuID=?";
		return studentDao.getMatchScore(hql,stuID);
	}

	public int getAllRowCount(String hql) {
		return studentDao.getAllRowCount(hql);
	}

	public List<Student> getInfoById(String id) {
		String hql = "from Student s left join fetch s.department d left join fetch s.mclass c" +
				" where s.stuID=?";
		return studentDao.getInfoById(hql, id);
	}

}
