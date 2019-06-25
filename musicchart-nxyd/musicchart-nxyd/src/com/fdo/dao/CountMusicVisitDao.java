package com.fdo.dao;

import java.util.List;

import com.fdo.vo.ActiveDateVO;
import com.fdo.vo.ActiveVO;

public interface CountMusicVisitDao {
	
	public List<ActiveVO> findCountMuSicVisitDay();		//今天
	public List<ActiveVO> findCountMuSicVisitYesterday();		//昨天
	public List<ActiveDateVO> findSevenDay(String day);		//7天
	public List<ActiveDateVO> findMon();		//当月
	public ActiveVO findAll(String mub);		//当月总数				
	public List<ActiveDateVO> findYesrMon(String codeId);		//年月

}
