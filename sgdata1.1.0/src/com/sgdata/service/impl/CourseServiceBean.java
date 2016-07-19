package com.sgdata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sgdata.dao.CourseDao;
import com.sgdata.po.Course;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.CourseService;

@Transactional(readOnly=false)
public class CourseServiceBean implements CourseService {

	@Resource private CourseDao courseDao;
	
	public PageBean getAllCourseInfo(int pageSize,int currentPage) {
		final String hql = "from Course c order by c.courseID";
		int allRow = courseDao.getAllRowCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, currentPage);
		final int length = pageSize;
		final int page = PageBean.countCurrentPage(currentPage);
		
		List list = courseDao.getAllCourseInfo(hql, offset, length);
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(page);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	public List getCourseTeachersInfo(String courseID) {
		/*HQL查询，通过左连接，连接教师课程表、教师表、课程表**/
		String hql = "from TeacherCourse tc left join fetch tc.teacher t " +
				"left join fetch tc.course c where c.courseID=?";
		return courseDao.getCourseTeachersInfo(hql,courseID);
	}

	public int getAllRowCount(String hql) {
		return courseDao.getAllRowCount(hql);
	}

	public boolean newCourse(final Course course) {
		courseDao.newCourse(course);
		return true;
	}

}
