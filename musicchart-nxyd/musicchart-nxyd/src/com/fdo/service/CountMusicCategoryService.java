package com.fdo.service;

import java.util.List;

import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;

public interface CountMusicCategoryService {

	public List<ClickVO> findCountMusicCategoryDay(String typeCode);		
	public List<ClickVO> findCountMusicCategoryYesterday(String typeCode);		
	public List<ClickDateVO> findSevenDay(String day,String typeCode);		
	public List<ClickDateVO> findMon(String typeCode);		
	public ClickVO findAll(String day,String typeCode);					
	public List<ClickDateVO> findYesrMon(String codeId);		
}
