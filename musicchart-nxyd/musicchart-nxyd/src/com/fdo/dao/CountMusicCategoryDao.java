package com.fdo.dao;

import java.util.List;

import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;

public interface CountMusicCategoryDao {

	public List<ClickVO> findCountMusicCategoryDay(String typeCode);		//今天
	public List<ClickVO> findCountMusicCategoryYesterday(String typeCode);		//昨天
	public List<ClickDateVO> findSevenDay(String day,String typeCode);		//7天
	public List<ClickDateVO> findMon(String typeCode);		//当月
	public ClickVO findAll(String day,String typeCode);		//当月总数	
	public List<ClickDateVO> findYesrMon(String codeId); 		//年月
}
