package com.sgdata.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sgdata.dao.TeacherDao;
import com.sgdata.dao.impl.TeacherDaoImpl;
import com.sgdata.po.Teacher;
import com.sgdata.service.TeacherService;
import com.sgdata.service.impl.TeacherServiceBean;
/**
 * 用Struts2框架进行登录验证
 *
 */
public class LoginCheckAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 引入Service类
	 */
	@Resource private TeacherService teacherService;
	
	/**
	 * 教师信息实体类的对象
	 */
	private Teacher teacher;
	
	/**
	 * 教师登录账号
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 验证码
	 */
	private String captcha;
	
	public LoginCheckAction(){
		teacher = new Teacher();
		//teacherService = new TeacherServiceBean();
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	/**
	 * 重载的execute方法，默认情况下，Struts2框架会自动执行的
	 */
	@Override
	public String execute() throws Exception {

		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		//获取系统验证码
		String rand = session.getAttribute("rand").toString().toLowerCase();
		//将用户输入的验证码全部转换为小写的
		String j_captcha = captcha.toLowerCase();
		//发送账号获取教师的账号信息，并存储在一个Teacher对象里
		teacher = teacherService.loginCheck(account);
		//
		if(account.equals(teacher.getTeaID())&&password.equals(teacher.getPassword())&&j_captcha.equals(rand))
			return SUCCESS;
		else
			return INPUT;
	}
	
}
