package com.sgdata.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.MatchService;

/**
 * 实现比赛信息管理的Action类
 *
 */
public class MatchInfoManagerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**/
	@Resource private MatchService matchService;

	private int page;
	
	/**
	 * 比赛ID号
	 */
	private int matchID;
	
	/**
	 * 比赛名称
	 */
	private String matchName;
	
	/**
	 * 参赛时间
	 */
	private Date matchTime;
	
	/**
	 * 获奖情况
	 */
	private String matchReward;
	
	/**
	 * 存储比赛信息的数值列表
	 */
	private List matchesInfo;
	
	/**
	 * 参赛学生的信息列表
	 */
	private List matchStudentsInfo;
	
	private PageBean pageBean;
	
	public MatchInfoManagerAction(){
		
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMatchID() {
		return matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public String getMatchReward() {
		return matchReward;
	}

	public void setMatchReward(String matchReward) {
		this.matchReward = matchReward;
	}

	public List getMatchesInfo() {
		return matchesInfo;
	}

	public void setMatchesInfo(List matchesInfo) {
		this.matchesInfo = matchesInfo;
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
	 * 获取所有的比赛信息
	 * @return
	 * @throws Exception
	 */
	public String getAllInfo() throws Exception {
		pageBean = matchService.getAllMatchInfo(3, page);
		matchesInfo = pageBean.getList();
		return SUCCESS;
	}
	
	/**
	 * 通过比赛ID号获取参赛学生的信息
	 * @return
	 * @throws Exception
	 */
	public String getStudentsInfoById() throws Exception {
		matchStudentsInfo = matchService.getMatchStudentsInfo(matchID);
		return SUCCESS;
	}
	
	
}
