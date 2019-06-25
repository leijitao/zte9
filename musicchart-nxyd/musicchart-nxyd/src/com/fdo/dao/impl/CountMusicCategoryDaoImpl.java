package com.fdo.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdo.dao.CountMusicCategoryDao;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;

public class CountMusicCategoryDaoImpl extends HibernateDaoSupport implements CountMusicCategoryDao {

	@Override
	public List<ClickVO> findCountMusicCategoryDay(String typeCode) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Date today = new Date();
		Calendar   cal   =   Calendar.getInstance();
	    cal.add(Calendar.DATE,   -1);
	    String yesterday = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	    Date ye = null;
	    try {
	    	ye = new SimpleDateFormat("yyyy-MM-dd").parse(yesterday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date start = new Date();
		Date end = new Date();
		Date ystart = new Date();
		Date yend = new Date();
	    SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
	    SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String format = null;
	    String format2 = null;
	    try {
			start = formater2.parse(formater.format(new Date())+ " 00:00:00");
			end = formater2.parse(formater.format(new Date())+ " 23:59:59");
			format = formater2.format(start);
			format2 = formater2.format(end);
		    ystart = formater2.parse(formater.format(ye)+ " 00:00:00");
		    yend = formater2.parse(formater.format(ye)+ " 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tsql = "select count(*), count(distinct userId) "
				+ "from count_music_category where  cateClickTime<='"+format2+"' and cateClickTime>='"+format+"' and typeCode='"+typeCode+"'";
		List list = openSession.createSQLQuery(tsql).list();
		List<ClickVO> clist1 = new ArrayList<ClickVO>();
		List<ClickVO> clist2 = new ArrayList<ClickVO>();
		List<List<ClickVO>> clist = new ArrayList<List<ClickVO>>();
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			ClickVO cvo = new ClickVO();
			Object[] o = (Object[]) iterator.next();
			for (int i = 0; i < o.length; i++) {
				cvo.setClicks(Integer.parseInt(o[0].toString()));
				cvo.setClickRen(Integer.parseInt(o[1].toString()));
			}
			clist1.add(cvo);
		}
		openSession.close();
		return clist1;
	}

	@Override
	public List<ClickVO> findCountMusicCategoryYesterday(String typeCode) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Date today = new Date();
		Calendar   cal   =   Calendar.getInstance();
	    cal.add(Calendar.DATE,   -1);
	    String yesterday = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	    Date ye = null;
	    try {
	    	ye = new SimpleDateFormat("yyyy-MM-dd").parse(yesterday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date ystart = new Date();
		Date yend = new Date();
	    SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
	    SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String format3 = null;
	    String format4 = null;
	    try {
		    ystart = formater2.parse(formater.format(ye)+ " 00:00:00");
		    yend = formater2.parse(formater.format(ye)+ " 23:59:59");
		    format3 = formater2.format(ystart);
		    format4 = formater2.format(yend);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String yesterDaySQL = "select count(*), count(distinct userId) "
				+ "from count_music_category where  cateClickTime<='"+format4+"' and cateClickTime>='"+format3+"' and typeCode='"+typeCode+"'";
		List list2 = openSession.createSQLQuery(yesterDaySQL).list();
		List<ClickVO> clist2 = new ArrayList<ClickVO>();
		Iterator iterator2 = list2.iterator();
		while(iterator2.hasNext()){
			ClickVO cvo = new ClickVO();
			Object[] o = (Object[]) iterator2.next();
			for (int i = 0; i < o.length; i++) {
				cvo.setClicks(Integer.parseInt(o[0].toString()));
				cvo.setClickRen(Integer.parseInt(o[1].toString()));
			}
			clist2.add(cvo);
		}
		return clist2;
	}

	@Override
	public List<ClickDateVO> findSevenDay(String day,String typeCode) {
		// TODO Auto-generated method stub
		String da = null;
		String xiao = null;
		Date date3 = null;
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		int days = 0;
		if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar instance = Calendar.getInstance();
			instance.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(day));
			Date sevenDate = instance.getTime();
			xiao = sdf.format(sevenDate);
			Date date = new Date();
			da = sdf.format(date);
			days = Integer.parseInt(day);
		}else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1]+" 23:59:59";
	        Date date = null;
			try {
				date = format2.parse(xiao);
				date3 = format2.parse(da);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        days = (int) ((date3.getTime() - date.getTime()) / (1000*3600*24));
		}
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(cateClickTime,'%Y-%m-%d'),"
				+ "count(*),count(distinct userId) "
				+ "from count_music_category where cateClickTime<='"+da+"' and cateClickTime>='"+xiao+"' and typeCode='"+typeCode+"'"
				+ "group by date_format(cateClickTime,'%Y-%m-%d')";
		List list = openSession.createSQLQuery(sql).list();
		List<ClickDateVO> list2 = new ArrayList<ClickDateVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			ClickDateVO cdVo = new ClickDateVO();
			Object[] object = (Object[]) iterator.next();
			cdVo.setClickDate(object[0].toString());
			cdVo.setClicks(Integer.parseInt(object[1].toString()));
			cdVo.setClickRen(Integer.parseInt(object[2].toString()));
			list2.add(cdVo);
		}
		List<ClickDateVO> list3 = new ArrayList<ClickDateVO>();
		for (int i = 0; i <=days ; i++) {
			String format = null;
			if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
				Calendar time = Calendar.getInstance();
				time.add(Calendar.DAY_OF_MONTH, -i);
				Date date2 = time.getTime();
				format = format2.format(date2);
			}else {
				long time = date3.getTime() - (long)(1000*60*60*24)*i;
				Date date2 = new Date(time);
				format = format2.format(date2);
			}
			ClickDateVO cdv = new ClickDateVO();
			cdv.setClickDate(format);
			cdv.setClicks(0);
			cdv.setClickRen(0);
			list3.add(cdv);
			for (ClickDateVO clickDateVO : list2) {
				if (clickDateVO.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(clickDateVO);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<ClickDateVO> findMon(String typeCode) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONDAY,-1);
		Date sevenDate = instance.getTime();
		String seven = sdf.format(sevenDate);
		Date date = new Date();
		String today = sdf.format(date);
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(cateClickTime,'%Y-%m-%d'),"
				+ "count(*),count(distinct userId) "
				+ "from count_music_category where cateClickTime<='"+date+"' and cateClickTime>='"+seven+"' and typeCode='"+typeCode+"'"
				+ "group by date_format(cateClickTime,'%Y-%m-%d') ";
		
		List<ClickDateVO> list2 = new ArrayList<ClickDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			ClickDateVO ckdVo = new ClickDateVO();
			ckdVo.setClickDate(object[0].toString());
			ckdVo.setClicks(Integer.parseInt(object[1].toString()));
			ckdVo.setClickRen(Integer.parseInt(object[2].toString()));
			list2.add(ckdVo);
		}
		List<ClickDateVO> list3 = new ArrayList<ClickDateVO>();
		Calendar t1 = Calendar.getInstance();
		t1.add(Calendar.DAY_OF_MONTH, 0);
		Date da = t1.getTime();
		int day = da.getDate();
		for (int i = 0; i < day; i++) {
			Calendar time = Calendar.getInstance();
			time.add(Calendar.DAY_OF_MONTH, -i);
			Date date2 = time.getTime();
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
			String format = sdft.format(date2);
			ClickDateVO cdv = new ClickDateVO();
			cdv.setClickDate(format);
			cdv.setClicks(0);
			cdv.setClickRen(0);
			list3.add(cdv);
			for (ClickDateVO clickDateVO : list2) {
				if (clickDateVO.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(clickDateVO);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public ClickVO findAll(String day,String typeCode) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String da = null;
		String xiao = null;
		if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar instance = Calendar.getInstance();
			instance.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(day));
			Date sevenDate = instance.getTime();
			xiao = sdf.format(sevenDate);
			Date date = new Date();
			da = sdf.format(date);
		}else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1]+" 23:59:59";
		}
		String sql = "select count(*),count(distinct userId) "
				+ "from count_music_category "
				+ "where cateClickTime<='"+da+"' and cateClickTime>='"+xiao+"' and typeCode='"+typeCode+"'";
		List list = openSession.createSQLQuery(sql).list();
		List<ClickVO> ckvClickVOs = new ArrayList<ClickVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			ClickVO ckvo = new ClickVO();
			for (int i = 0; i < object.length; i++) {
				ckvo.setClicks(Integer.parseInt(object[0].toString()));
				ckvo.setClickRen(Integer.parseInt(object[1].toString()));
				ckvClickVOs.add(ckvo);
			}
		}
		ClickVO cVo = new ClickVO();
		for (ClickVO clickVO : ckvClickVOs) {
			cVo.setClicks(clickVO.getClicks());
			cVo.setClickRen(clickVO.getClickRen());
		}
		openSession.close();
		return cVo;
	}

	@Override
	public List<ClickDateVO> findYesrMon(String codeId) {
		// TODO Auto-generated method stub
		String[] split = codeId.split(",");
		String id = split[0];
		String yearString = split[1];
		String monString = split[2];
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, Integer.parseInt(yearString));  
        a.set(Calendar.MONTH, Integer.parseInt(monString) - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE); 
        String riqi1 = yearString+"-"+monString+"-"+"01 00:00:00";
        String riqi2 = yearString+"-"+monString+"-"+maxDate+" 23:59:59";
        Date fdDate = null;
        Date fDate = null;
		try {
			fdDate = sdf.parse(riqi2);
			fDate = sdf.parse(riqi1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String start = sdf.format(fDate);
        String end = sdf.format(fdDate);
		
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(cateClickTime,'%Y-%m-%d'),count(*),count(distinct userId) "
				+ "from count_music_category where cateClickTime<='"+end+"' and cateClickTime>='"+start+"' and typeCode='"+id+"'"
				+ "group by date_format(cateClickTime,'%Y-%m-%d') ";

		List<ClickDateVO> list2 = new ArrayList<ClickDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			ClickDateVO ckdVo = new ClickDateVO();
			ckdVo.setClickDate(object[0].toString());
			ckdVo.setClicks(Integer.parseInt(object[1].toString()));
			ckdVo.setClickRen(Integer.parseInt(object[2].toString()));
			list2.add(ckdVo);
		}
		List<ClickDateVO> list3 = new ArrayList<ClickDateVO>();
		for (int i = 0; i <maxDate ; i++) {
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
			String ri = yearString+"-"+monString+"-"+(i+1);
			Date date = null;
			try {
				date = sdft.parse(ri);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String format = sdft.format(date);
			ClickDateVO cdv = new ClickDateVO();
			cdv.setClickDate(format);
			cdv.setClicks(0);
			cdv.setClickRen(0);
			list3.add(cdv);
			for (ClickDateVO clickDateVO : list2) {
				if (clickDateVO.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(clickDateVO);
				}
			}
		}
		openSession.close();
		return list3;
	}



}
