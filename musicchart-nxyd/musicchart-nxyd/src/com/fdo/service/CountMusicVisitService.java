package com.fdo.service;

import java.util.List;

import com.fdo.vo.ActiveDateVO;
import com.fdo.vo.ActiveVO;

public interface CountMusicVisitService {
	
	public List<ActiveVO> findCountMuSicVisitDay();		
	public List<ActiveVO> findCountMuSicVisitYesterday();		
	public List<ActiveDateVO> findSevenDay(String day);		
	public List<ActiveDateVO> findMon();		
	public ActiveVO findAll(String mub);					
	public List<ActiveDateVO> findYesrMon(String codeId);		

}
