package com.fdo.service;

import java.util.List;

import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;
import com.fdo.vo.RecClicksStatVO;

public interface CountMusicRecService {

	public List<ClickVO> findCountMusicRecs(String codeId);
	public List<ClickVO> findClickVOs(String codeId);
	public List<ClickDateVO> findSevenDay(String day,String codeId);
	public List<ClickDateVO> findMon(String codeId);
	public ClickVO findAll(String day,String codeId);
	public List<ClickDateVO> findYesrMon(String codeId);
	public ClickVO findfzd(String codeId);		//今天
	public ClickVO findfzy(String codeId);		//昨天
	public List<ClickDateVO> findSevenDayTJW(String day,String codeId);		//7天
	public ClickVO findAllTJW(String day,String codeId);		//推荐位总计
	
	//全部
	public ClickVO findAllzd(String codeId);		//jin
	public ClickVO findAllzy(String codeId);
	public List<ClickDateVO> findAllSevenDay(String day,String codeId);		//7day
	public ClickVO findAllClickVO(String day,String codeId);

	/**
	* @Title: selectRecClicks  
	* @Description: 查询推荐位点击量 
	* @param @param mub 日期信息  
	* @param @param className
	* @param @return
	* @return List<RecClicksStatVO>
	* @throws  
	*/
	public List<RecClicksStatVO> selectRecClicks(String className, String day);
}
