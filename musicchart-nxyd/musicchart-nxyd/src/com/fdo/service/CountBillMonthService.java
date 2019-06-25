package com.fdo.service;

import java.util.List;

import com.fdo.hum.MonthlyMusicCategory;
import com.fdo.hum.MonthlyType;
import com.fdo.hum.RenewLog;
import com.fdo.hum.TBillMonth;
import com.fdo.hum.TBillMonthLog;
import com.fdo.hum.TBillUnsmonth;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.ShouRuDateVO;

public interface CountBillMonthService {

	public List<ShouRuDateVO> findSRfeeAndPeopleDay(String code);		
	public List<ShouRuDateVO> findSevenDay(String day,String code);		
	public List<ShouRuDateVO> findMon();		
	public ShouRuDateVO findAll(String code ,String day);		
	
	public List<MonthlyMusicCategory> findClassAll();
	public MonthlyType findProduct(String code);	
	public List<MonthlyType> findSamllclassAll();
	
	public List<TBillMonthLog> findBillMonthLogs(String orderID,String userID,Integer page);
	public Integer findBillMonthLogsCount(String orderID,String userID);
	public List<CPShouRuVO> findCpShouRuVOs(String day);		//包月收入占比
	
	public List<MonthlyMusicCategory> findBaoYue(String productId);
	public String findZDJ(String day);
	public List<TBillMonthLog> findDD(String stat,String end,String productId,String status,Integer page);
	public Integer findDDCount(String stat,String end,String productId,String status);
	public ShouRuDateVO findZdd(String state,String end,String productId,String status);
	public ShouRuDateVO findzd(String orderId,String userId);	
	public List<TBillMonthLog> findDG(String stat,String end,String productId,String status);
	public RenewLog findAllLog(String day);
	
	public List<TBillUnsmonth> findTDAll(String orderId,String userId,Integer page);
	public Integer findTDAllCount(String orderId,String userId);
}
