package com.sgdata.action;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sgdata.po.Course;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.CourseService;

/**
 * 
 *	实现课程信息管理的Action类(控制类)
 *  原理：SSH框架开发中，是Spring框架来管理Struts2的Action，然后Hibernate的Session也是给Spring管理的，
 *  	配置Action类步骤：
 *  	1.要先引入Service类
 *  	2.然后写JSP页面里需要用到的set()、get()方法
 *  	3.自定义一些返回String类型的方法，然后通过配置struts.xml文件，实现调用
 *  	
 *  注意：1.继承ActionSupport，在下面重载的方法或自定义的方法里，才可以返回SUCCESS这些常数
 *  	 2.默认情况下，Struts2会自动执行重载的execute()方法的
 *  	 3.可以自己定义一些返回String类型的方法，然后通过struts2调用
 */
public class CourseInfoManagerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 采用注解的方式引入Service类
	 */
	@Resource private CourseService courseService;

	
	private int page;
	
	/**
	 * 课程代码
	 */
	private String courseID;
	
	/**
	 * 课程名
	 */
	private String courseName;
	
	/**
	 * 学分
	 */
	private String credit;
	
	/**
	 * 课程类型
	 */
	private String type;
	
	/**
	 * 任课老师
	 */
	private String teaName;
	
	/**
	 * 开课时间
	 */
	private String time;

	/**
	 * 课程信息的列表
	 */
	private List courseInfos;
	
	/**
	 * 任课教师信息的列表
	 */
	private List courseTeachersInfo;
	
	
	private PageBean pageBean;
	
	public CourseInfoManagerAction(){
	}

	public List getCourseInfos() {
		return courseInfos;
	}

	public void setCourseInfos(List courseInfos) {
		this.courseInfos = courseInfos;
	}


	@SuppressWarnings("rawtypes")
	public List getCourseTeachersInfo() {
		return courseTeachersInfo;
	}

	public void setCourseTeachersInfo(List courseTeachersInfo) {
		this.courseTeachersInfo = courseTeachersInfo;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	/**
	 * 自定义一些返回String类型的方法，然后通过配置struts.xml文件，来调用方法
	 */
	
	/**
	 * 获取所有课程信息的方法，默认情况下,execute()方法会默认执行，自己定义的方法
	 * @return
	 * @throws Exception
	 */
	public String getAllInfo() throws Exception {
		pageBean = courseService.getAllCourseInfo(3, page);
		courseInfos = pageBean.getList();
		return SUCCESS;
	}
	
	/**
	 * 通过课程代码获取任课老师信息
	 * @return
	 * @throws Exception
	 */
	public String getTeachersInfoById() throws Exception {
		courseTeachersInfo = courseService.getCourseTeachersInfo(courseID);
		return SUCCESS;
	}
	
	public String addInfo() throws Exception {
		Course course = new Course();
		course.setCourseID(courseID);
		course.setCourseName(courseName);
		course.setCredit(Integer.parseInt(credit));
		course.setTime(Date.valueOf(time));
		course.setType(type);
		courseService.newCourse(course);
		return SUCCESS;
	}
	
	
}
