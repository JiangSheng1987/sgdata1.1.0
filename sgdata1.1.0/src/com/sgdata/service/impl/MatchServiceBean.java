package com.sgdata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sgdata.dao.MatchDao;
import com.sgdata.po.page.PageBean;
import com.sgdata.service.MatchService;

@Transactional(readOnly=false)
public class MatchServiceBean implements MatchService {

	@Resource private MatchDao matchDao;
	public PageBean getAllMatchInfo(int pageSize,int currentPage) {
		final String hql = "from Match m order by m.matchID";
		int allRow = matchDao.getAllRowCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, currentPage);
		final int length = pageSize;
		final int page = PageBean.countCurrentPage(currentPage);
		
		List list = matchDao.getAllMatchInfo(hql, offset, length);
		
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(page);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	public List getMatchStudentsInfo(int matchID) {
		/*HQL查询，通过左连接，连接学生比赛表、学生表、比赛信息表*/
		String hql = "from StudentMatch sm left join fetch sm.student s " +
				"left join fetch sm.match m where m.matchID=?";
		return matchDao.getMatchStudentsInfo(hql,matchID);
	}
	public int getAllRowCount(String hql) {
		return matchDao.getAllRowCount(hql);
	}

}
