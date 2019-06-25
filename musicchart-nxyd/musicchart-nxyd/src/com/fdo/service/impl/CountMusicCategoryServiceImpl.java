package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.CountMusicCategoryDao;
import com.fdo.service.CountMusicCategoryService;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;

public class CountMusicCategoryServiceImpl implements CountMusicCategoryService {

	private CountMusicCategoryDao countMusicCategoryDao;
	
	public CountMusicCategoryDao getCountMusicCategoryDao() {
		return countMusicCategoryDao;
	}

	public void setCountMusicCategoryDao(CountMusicCategoryDao countMusicCategoryDao) {
		this.countMusicCategoryDao = countMusicCategoryDao;
	}

	@Override
	public List<ClickVO> findCountMusicCategoryDay(String typeCode) {
		// TODO Auto-generated method stub
		return countMusicCategoryDao.findCountMusicCategoryDay(typeCode);
	}

	@Override
	public List<ClickVO> findCountMusicCategoryYesterday(String typeCode) {
		// TODO Auto-generated method stub
		return countMusicCategoryDao.findCountMusicCategoryYesterday(typeCode);
	}

	@Override
	public List<ClickDateVO> findSevenDay(String day,String typeCode) {
		// TODO Auto-generated method stub
		return countMusicCategoryDao.findSevenDay(day,typeCode);
	}

	@Override
	public List<ClickDateVO> findMon(String typeCode) {
		// TODO Auto-generated method stub
		return countMusicCategoryDao.findMon(typeCode);
	}

	@Override
	public ClickVO findAll(String day,String typeCode) {
		// TODO Auto-generated method stub
		return countMusicCategoryDao.findAll(day,typeCode);
	}

	@Override
	public List<ClickDateVO> findYesrMon(String codeId) {
		// TODO Auto-generated method stub
		return countMusicCategoryDao.findYesrMon(codeId);
	}

	
}
