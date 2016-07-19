package com.sgdata.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sgdata.po.Department;
import com.sgdata.po.Student;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.DepartmentService;
import com.sgdata.service.StudentService;

/**
 * 实现学生信息管理的Action类
 *	
 */
public class StudentInfoManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Resource private StudentService studentService;
	
	@Resource private DepartmentService departmentService;
	
	//当前页
	int page = 1;
	
	//学号
	private String stuID;
	
	//姓名
	private String stuName;
	
	//性别
	private String stuSex;
	
	//出生年月
	private Date stuBirth;
	
	//电话
	private String stuTel;
	
	//邮箱
	private String stuEmail;
	
	//系部
	private String dept;
	
	//身份证
	private String stuIDCard;
	
	//班级
	private String className;
	
	//密码
	private String password;
	
	
	/*
	 * 系部ID号
	 */
	private int departID;
	
	/*
	 * 班级ID 
	 */
	private int classID;
	
	/*
	 * 系部名称
	 */
	private String departName;
	
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private List student;
	
	/**
	 * 学生信息的列表
	 */
	private List<Student> studentsInfo;
	
	/**
	 * 学生学习成绩的信息列表
	 */
	@SuppressWarnings("rawtypes")
	private List learnScores;
	
	/**
	 * 学生比赛成绩的信息列表
	 */
	@SuppressWarnings("rawtypes")
	private List matchScores;
	
	private PageBean pageBean;
	
	/*
	 * 
	 */
	private List<Department> departmentsInfo;
	
	
	public StudentInfoManagerAction(){
		//student = new Student();
		
	}
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuBirth() {
		return stuBirth;
	}

	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStuIDCard() {
		return stuIDCard;
	}

	public void setStuIDCard(String stuIDCard) {
		this.stuIDCard = stuIDCard;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public int getDepartID() {
		return departID;
	}

	public void setDepartID(int departID) {
		this.departID = departID;
	}

	public int getClassID() {
		return classID;
	}


	public void setClassID(int classID) {
		this.classID = classID;
	}


	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	@SuppressWarnings("rawtypes")
	public List getStudent() {
		return student;
	}

	@SuppressWarnings("rawtypes")
	public void setStudent(List student) {
		this.student = student;
	}

	public void setStudentsInfo(List<Student> studentsInfo){
		this.studentsInfo = studentsInfo;
	}

	public List<Student> getStudentsInfo() {
		return studentsInfo;
	}

	@SuppressWarnings("rawtypes")
	public List getLearnScores() {
		return learnScores;
	}

	@SuppressWarnings("rawtypes")
	public void setLearnScores(List learnScores) {
		this.learnScores = learnScores;
	}

	@SuppressWarnings("rawtypes")
	public List getMatchScores() {
		return matchScores;
	}

	@SuppressWarnings("rawtypes")
	public void setMatchScores(List matchScores) {
		this.matchScores = matchScores;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	public List<Department> getDepartmentsInfo() {
		return departmentsInfo;
	}

	public void setDepartmentsInfo(List<Department> departmentsInfo) {
		this.departmentsInfo = departmentsInfo;
	}

	/**
	 * 获取学生的基本信息
	 * @return
	 * @throws Exception
	 */
	//@Override
	@SuppressWarnings("unchecked")
	public String getAllInfo() throws Exception {
		pageBean = studentService.getAllStudentInfo(3, page);
		String hql = "from Department depart order by depart.departID";
		departmentsInfo = departmentService.getAllDepart(hql);
		studentsInfo = pageBean.getList();
		return SUCCESS;
	}
	
	/**
	 * 通过学号获取学生的详细信息
	 * @return
	 * @throws Exception
	 */
	public String getInfoById() throws Exception {
		student = studentService.getStudentInfoById(stuID);
		return SUCCESS;
	}
	
	public String updateInfo() throws Exception {
		Student student = new Student();
		student.setStuID(stuID);
		student.setStuName(stuName);
		student.setStuSex(stuSex);
		student.setStuIDCard(stuIDCard);
		student.setDept(dept);
		student.setPassword(password);
		student.setStuBirth(stuBirth);
		student.setClassName(className);
		student.setStuEmail(stuEmail);
		student.setStuTel(stuTel);
		student.setPassword(password);
//		Department department = new Department();
//		department.setDepartID(departID);
//		student.setDepartment(department);
//		departID = departmentService.getDepartId(departName);
//		student.setDepartID(departID);
//		student.setClassID(classID);
		studentService.saveOrUpdateInfo(student);
		return SUCCESS;
	}
	
	/**
	 * 通过学号获取获取学生的学习成绩信息
	 * @return
	 * @throws Exception
	 */
	public String getLearnScoreById() throws Exception {
		learnScores = studentService.getLearnScore(stuID);
		return SUCCESS;
	}
	
	/**
	 * 通过学号获取学生的比赛ID号
	 * @return
	 * @throws Exception
	 */
	public String getMatchScoreById() throws Exception {
		matchScores = studentService.getMatchScore(stuID);
		return SUCCESS;
	}
	
	/**
	 * 通过学号查询学生信息
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getTheInfoById() throws Exception {
		studentsInfo = studentService.getInfoById(stuID);
		String hql = "from Department depart order by depart.departID";
		departmentsInfo = departmentService.getAllDepart(hql);
		return SUCCESS;
	}


}
