package com.fdo.service.impl;

import java.lang.Thread.State;
import java.util.List;

import com.fdo.dao.CountBillMonthDao;
import com.fdo.hum.MonthlyMusicCategory;
import com.fdo.hum.MonthlyType;
import com.fdo.hum.RenewLog;
import com.fdo.hum.TBillMonth;
import com.fdo.hum.TBillMonthLog;
import com.fdo.hum.TBillUnsmonth;
import com.fdo.service.CountBillMonthService;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.ShouRuDateVO;

public class CountBillMonthServiceImpl implements CountBillMonthService {

	private CountBillMonthDao countBillMonthDao;
	
	public CountBillMonthDao getCountBillMonthDao() {
		return countBillMonthDao;
	}
	public void setCountBillMonthDao(CountBillMonthDao countBillMonthDao) {
		this.countBillMonthDao = countBillMonthDao;
	}

	@Override
	public List<ShouRuDateVO> findSRfeeAndPeopleDay(String code) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findSRfeeAndPeopleDay(code);
	}
	@Override
	public List<ShouRuDateVO> findSevenDay(String day,String code) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findSevenDay(day,code);
	}
	@Override
	public List<ShouRuDateVO> findMon() {
		// TODO Auto-generated method stub
		return countBillMonthDao.findMon();
	}
	@Override
	public ShouRuDateVO findAll(String code ,String day) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findAll(code,day);
	}
	@Override
	public List<MonthlyMusicCategory> findClassAll() {
		// TODO Auto-generated method stub
		return countBillMonthDao.findClassAll();
	}
	@Override
	public MonthlyType findProduct(String code) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findProduct(code);
	}
	@Override
	public List<MonthlyType> findSamllclassAll() {
		// TODO Auto-generated method stub
		return countBillMonthDao.findSamllclassAll();
	}
	@Override
	public Integer findBillMonthLogsCount(String orderID, String userID) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findBillMonthLogsCount(orderID, userID);
	}
	@Override
	public List<TBillMonthLog> findBillMonthLogs(String orderID, String userID,Integer page) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findBillMonthLogs(orderID, userID,page);
	}
	@Override
	public List<MonthlyMusicCategory> findBaoYue(String productId) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findBaoYue(productId);
	}
	@Override
	public List<CPShouRuVO> findCpShouRuVOs(String day) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findCpShouRuVOs(day);
	}
	@Override
	public String findZDJ(String day) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findZDJ(day);
	}
	@Override
	public List<TBillMonthLog> findDD(String stat, String end, String productId, String status,Integer page) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findDD(stat, end, productId, status, page);
	}
	@Override
	public Integer findDDCount(String stat, String end, String productId, String status) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findDDCount(stat, end, productId, status);
	}
	@Override
	public ShouRuDateVO findZdd(String state, String end, String productId, String status) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findZdd(state, end, productId, status);
	}
	@Override
	public ShouRuDateVO findzd(String orderId, String userId) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findzd(orderId, userId);
	}
	@Override
	public List<TBillMonthLog> findDG(String stat, String end, String productId, String status) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findDG(stat, end, productId, status);
	}
	@Override
	public RenewLog findAllLog(String day) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findAllLog(day);
	}
	@Override
	public List<TBillUnsmonth> findTDAll(String orderId, String userId, Integer page) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findTDAll(orderId, userId, page);
	}
	@Override
	public Integer findTDAllCount(String orderId, String userId) {
		// TODO Auto-generated method stub
		return countBillMonthDao.findTDAllCount(orderId, userId);
	}

}
