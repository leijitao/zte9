package com.fdo.service;

import java.util.List;

import com.fdo.hum.MusicCp;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.FindMusicInfoVO;
import com.fdo.vo.SongDateVO;
import com.fdo.vo.SongVO;

public interface CountMusicPlayService {

	public SongVO findCountMusicPlayDay();		
	public SongVO findCountMusicPlayYesterday();		
	public List<SongDateVO> findSevenDay(String day);		
	public List<SongDateVO> findMon();		
	public List<SongDateVO> findMon2();		
	public SongVO findAll(String day);						
	public List<SongDateVO> findYesrMon(String year);		
	public List<SongDateVO> findYesrMon2(String year);		
	
	public List<FindMusicInfoVO> findMusicInfoVOs();		
	public List<FindMusicInfoVO> findLikesMusicInfoVOs(String musiceName,String playerName,Integer page);	
	public Integer findLikesMusicInfoVOsCount(String musiceName,String playerName);
	
	public SongVO findUserCPCountMusicPlayDay(String cpId,String musicId);		//今天
	public SongVO findUserCPCountMusicPlayYesterday(String cpId,String musicId);		//昨天
	public List<SongDateVO> findUserCPSevenDay(String day,String cpId,String musicId);		//7天
	public SongVO findUserCPAll(String day,String cpId,String musicId);		//总计
	
	public List<FindMusicInfoVO> findUserCPMusicInfoVOs(String cpId);		//前20首点击排行
	public List<FindMusicInfoVO> findUserCPLikesMusicInfoVOs(String musiceName,String playerName,String cpId);
	
	public List<CPShouRuVO> findObjects(String day,Integer yu);	//饼图
	public List<MusicCp> findAll();			//所有cp
	public String findZBY(String day,Integer yu);
}
