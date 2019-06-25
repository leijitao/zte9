package com.fdo.dao;

import java.util.List;

import com.fdo.hum.MusicCp;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.FindMusicInfoVO;
import com.fdo.vo.SongDateVO;
import com.fdo.vo.SongVO;

public interface CountMusicPlayDao {

	public SongVO findCountMusicPlayDay();		//今天
	public SongVO findCountMusicPlayYesterday();		//昨天
	public List<SongDateVO> findSevenDay(String day);		//7天
	public List<SongDateVO> findMon();		//当月
	public List<SongDateVO> findMon2();		//当月
	public SongVO findAll(String day);		//当月总数				
	public List<SongDateVO> findYesrMon(String year);		//年月
	public List<SongDateVO> findYesrMon2(String year);		//年月
	
	public List<FindMusicInfoVO> findMusicInfoVOs();		//当月总数
	public List<FindMusicInfoVO> findLikesMusicInfoVOs(String musiceName,String playerName,Integer page);		//模糊查找
	public Integer findLikesMusicInfoVOsCount(String musiceName,String playerName);		//COUNT分页总页数
	
	
	public SongVO findUserCPCountMusicPlayDay(String cpId,String musicId);		//今天
	public SongVO findUserCPCountMusicPlayYesterday(String cpId,String musicId);		//昨天
	public List<SongDateVO> findUserCPSevenDay(String day,String cpId,String musicId);		//7天
	public SongVO findUserCPAll(String day,String cpId,String musicId);		//总计
	
	public List<FindMusicInfoVO> findUserCPMusicInfoVOs(String cpId);		//前20
	public List<FindMusicInfoVO> findUserCPLikesMusicInfoVOs(String musiceName,String playerName,String cpId); 	//CP模糊查询

	public List<CPShouRuVO> findObjects(String day,Integer yu);	//饼图
	public List<MusicCp> findAll();			//所有cp
	public String findZBY(String day,Integer yu);		//总包月钱
}
