package com.sgdata.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.TeacherService;

/**
 * 教师信息管理的Action类
 *
 */
public class TeacherInfoManagerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource private TeacherService teacherService;
	
	private int page;
	
	/**
	 * 教师工号
	 */
	private String teaID;
	
	/**
	 * 教师姓名
	 */
	private String teaName;
	
	/**
	 * 教师性别
	 */
	private String teaSex;
	
	/**
	 * 出生年月
	 */
	private Date teaBirth;
	
	/**
	 * 电话
	 */
	private String teaTel;
	
	/**
	 * 邮箱
	 */
	private String teaEmail;
	
	/**
	 * 系别
	 */
	private String dept;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 课程代码
	 */
	private String courseID;
	
	/**
	 * 比赛的ID号
	 */
	private int matchID;
	
	/*存放教师基本信息的列表*/
	private List teachersInfo;
	
	/**
	 * 教师任课情况的信息列表
	 */
	private List teachingInfo;
	
	/**
	 * 教师指导比赛情况的信息列表
	 */
	private List matchGuideInfo;
	
	/**
	 * 某门课程的学生信息列表
	 */
	private List courseStudentsInfo;
	
	/**
	 * 参加某个比赛的学生信息列表
	 */
	private List matchStudentsInfo;
	
	private PageBean pageBean;
	
	public TeacherInfoManagerAction(){
		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getTeaID() {
		return teaID;
	}

	public void setTeaID(String teaID) {
		this.teaID = teaID;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaSex() {
		return teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	public Date getTeaBirth() {
		return teaBirth;
	}

	public void setTeaBirth(Date teaBirth) {
		this.teaBirth = teaBirth;
	}

	public String getTeaTel() {
		return teaTel;
	}

	public void setTeaTel(String teaTel) {
		this.teaTel = teaTel;
	}

	public String getTeaEmail() {
		return teaEmail;
	}

	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public List getTeachersInfo() {
		return teachersInfo;
	}

	public void setTeachersInfo(List teachersInfo) {
		this.teachersInfo = teachersInfo;
	}
	
	public List getTeachingInfo() {
		return teachingInfo;
	}

	public void setTeachingInfo(List teachingInfo) {
		this.teachingInfo = teachingInfo;
	}

	public List getMatchGuideInfo() {
		return matchGuideInfo;
	}

	public void setMatchGuideInfo(List matchGuideInfo) {
		this.matchGuideInfo = matchGuideInfo;
	}

	public List getCourseStudentsInfo() {
		return courseStudentsInfo;
	}

	public void setCourseStudentsInfo(List courseStudentsInfo) {
		this.courseStudentsInfo = courseStudentsInfo;
	}

	public List getMatchStudentsInfo() {
		return matchStudentsInfo;
	}

	public void setMatchStudentsInfo(List matchStudentsInfo) {
		this.matchStudentsInfo = matchStudentsInfo;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	/**
	 * 获取学生基本信息
	 * @return
	 * @throws Exception
	 */
	public String getAllInfo() throws Exception {
		pageBean = teacherService.getAllTeacherInfo(3, page);
		teachersInfo = pageBean.getList();
		return SUCCESS;
	}
	
	/**
	 * 通过工号获取教师任课情况信息
	 * @return
	 * @throws Exception
	 */
	public String getTeachingInfoById() throws Exception {
		teachingInfo = teacherService.getTeachingCourse(teaID);
		return SUCCESS;
	}
	
	/**
	 * 通过工号获取教师指导比赛情况的信息
	 * @return
	 * @throws Exception
	 */
	public String getMatchGuideInfoById() throws Exception {
		matchGuideInfo = teacherService.getMatchGuide(teaID);
		return SUCCESS;
	}
	
	/**
	 * 通过课程代码获取某门课程学生信息
	 * @return
	 * @throws Exception
	 */
	public String getCourseStudentsInfoById() throws Exception {
		courseStudentsInfo = teacherService.getCourseStudentsInfo(courseID);
		return SUCCESS;
	}
	
	/**
	 * 通过比赛ID号获取参加某个比赛的学生信息
	 * @return
	 * @throws Exception
	 */
	public String getMatchStudentsInfoById() throws Exception {
		matchStudentsInfo = teacherService.getMatchStudentsInfo(matchID);
		return SUCCESS;
	}
	
	public String getTeaInfoById() throws Exception {
		teachersInfo = teacherService.getTeaInfoById(teaID);
		return SUCCESS;
	}
}
