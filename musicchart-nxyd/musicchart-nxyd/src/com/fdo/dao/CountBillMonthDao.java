package com.fdo.dao;

import java.util.List;

import com.fdo.hum.MonthlyMusicCategory;
import com.fdo.hum.MonthlyType;
import com.fdo.hum.RenewLog;
import com.fdo.hum.TBillMonth;
import com.fdo.hum.TBillMonthLog;
import com.fdo.hum.TBillUnsmonth;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.ShouRuDateVO;

public interface CountBillMonthDao {

	public List<ShouRuDateVO> findSRfeeAndPeopleDay(String code);		//今天，昨天
	public List<ShouRuDateVO> findSevenDay(String day,String code);		//7天
	public List<ShouRuDateVO> findMon();		//当月
	public ShouRuDateVO findAll(String code ,String day);		//当月总数
	
	public List<MonthlyMusicCategory> findClassAll();		//所有大包月产品
	public MonthlyType findProduct(String code);		//包月产品
	public List<MonthlyType> findSamllclassAll();		//所有子产品
	
	public List<TBillMonthLog> findBillMonthLogs(String orderID,String userID,Integer page); 		//订购记录
	public Integer findBillMonthLogsCount(String orderID,String userID); 
	
	public List<CPShouRuVO> findCpShouRuVOs(String day);		//包月收入占比
	public String findZDJ(String day);		//总点击量
	/**
	 * CP包月
	 */
	public List<MonthlyMusicCategory> findBaoYue(String productId);		//查找CP包月产品
	public List<TBillMonthLog> findDD(String stat,String end,String productId,String status,Integer page);	//条件查询订单
	public Integer findDDCount(String stat,String end,String productId,String status);
	public ShouRuDateVO findZdd(String state,String end,String productId,String status);		//第二个条件查询总订单
	public ShouRuDateVO findzd(String orderId,String userId);			//第一个条件查询总订单
	public List<TBillMonthLog> findDG(String stat,String end,String productId,String status);	//条件查询订单2
	public RenewLog findAllLog(String day);  //续订退订统计
	
	/**
	 * 退订
	 */
	public List<TBillUnsmonth> findTDAll(String orderId,String userId,Integer page);
	public Integer findTDAllCount(String orderId,String userId);
	
}
