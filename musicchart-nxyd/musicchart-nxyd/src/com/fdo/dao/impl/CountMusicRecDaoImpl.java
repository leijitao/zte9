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

import com.fdo.dao.CountMusicRecDao;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;
import com.fdo.vo.RecClicksStatVO;

public class CountMusicRecDaoImpl extends HibernateDaoSupport implements CountMusicRecDao {

	@Override
	public List<ClickVO> findCountMusicRecs(String codeId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date start = new Date();
		Date end = new Date();

		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String format = null;
		String format2 = null;
		try {
			start = formater2.parse(formater.format(new Date()) + " 00:00:00");
			end = formater2.parse(formater.format(new Date()) + " 23:59:59");
			format = formater2.format(start);
			format2 = formater2.format(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tsql = null;
		if (codeId.equals("0")) {
			tsql = "select count(*),count(distinct userId) " + "from count_music_rec where  recClickTime<='" + format2
					+ "' and recClickTime>='" + format + "'";
		} else {
			tsql = "select count(*),count(distinct userId) " + "from count_music_rec where  recClickTime<='" + format2
					+ "' and recClickTime>='" + format + "' and recommdId='" + codeId + "'";
		}
		List list = openSession.createSQLQuery(tsql).list();
		List<ClickVO> clist1 = new ArrayList<ClickVO>();
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			ClickVO ckvo = new ClickVO();
			Object[] o = (Object[]) iterator.next();
			for (int i = 0; i < o.length; i++) {
				ckvo.setClicks(Integer.parseInt(o[0].toString()));
				ckvo.setClickRen(Integer.parseInt(o[1].toString()));
			}
			clist1.add(ckvo);
		}
		/*
		 * while(iterator2.hasNext()){ ClickVO ckVo = new ClickVO(); Object[] o =
		 * (Object[]) iterator2.next(); for (int i = 0; i < o.length; i++) {
		 * ckVo.setClicks(Integer.parseInt(o[0].toString()));
		 * ckVo.setClickRen(Integer.parseInt(o[1].toString())); } clist2.add(ckVo); }
		 */
		openSession.close();
		return clist1;
	}

	@Override
	public List<ClickVO> findClickVOs(String codeId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();

		Date today = new Date();
		// Date yesterday = new Date(today.getTime() -
		// 86400000L);//86400000L��������˼��˵1���ʱ��=24Сʱ x 60���� x 60�� x 1000����
		// ��λ��L��
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
		Date ye = null;
		try {
			ye = new SimpleDateFormat("yyyy-MM-dd").parse(yesterday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// String yday = new SimpleDateFormat("yyyy-MM-dd ").format(yesterday);
		// String tday = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(today);

		Date start = new Date();
		Date end = new Date();
		Date ystart = new Date();
		Date yend = new Date();

		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String format = null;
		String format2 = null;
		String format3 = null;
		String format4 = null;
		try {
			start = formater2.parse(formater.format(new Date()) + " 00:00:00");
			end = formater2.parse(formater.format(new Date()) + " 23:59:59");
			format = formater2.format(start);
			format2 = formater2.format(end);
			ystart = formater2.parse(formater.format(ye) + " 00:00:00");
			yend = formater2.parse(formater.format(ye) + " 23:59:59");
			format3 = formater2.format(ystart);
			format4 = formater2.format(yend);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String tsql = ""
		// + "select count(*) as ������� , count(distinct userId) as ������� "
		// + "from count_music_rec where recClickTime<='"+format2+"' and
		// recClickTime>='"+format+"' and recommdId='"+codeId+"'";
		String ysql = null;
		if (codeId.equals("0")) {
			ysql = "select count(*),count(distinct userId) " + "from count_music_rec where  recClickTime<='" + format4
					+ "' and recClickTime>='" + format3 + "'";
		} else {
			ysql = "select count(*),count(distinct userId) " + "from count_music_rec where  recClickTime<='" + format4
					+ "' and recClickTime>='" + format3 + "' and recommdId='" + codeId + "'";
		}
		// List list = openSession.createSQLQuery(tsql).list();
		List list2 = openSession.createSQLQuery(ysql).list();
		// List<ClickVO> clist1 = new ArrayList<ClickVO>();
		List<ClickVO> clist2 = new ArrayList<ClickVO>();
		// List<List<ClickVO>> clist = new ArrayList<List<ClickVO>>();
		Iterator iterator2 = list2.iterator();
		/*
		 * Iterator iterator = list.iterator();
		 * 
		 * while(iterator.hasNext()){ ClickVO ckvo = new ClickVO(); Object[] o =
		 * (Object[]) iterator.next(); for (int i = 0; i < o.length; i++) {
		 * ckvo.setClicks(Integer.parseInt(o[0].toString()));
		 * ckvo.setClickRen(Integer.parseInt(o[1].toString())); } clist1.add(ckvo); }
		 */
		while (iterator2.hasNext()) {
			ClickVO ckVo = new ClickVO();
			Object[] o = (Object[]) iterator2.next();
			for (int i = 0; i < o.length; i++) {
				ckVo.setClicks(Integer.parseInt(o[0].toString()));
				ckVo.setClickRen(Integer.parseInt(o[1].toString()));
			}
			clist2.add(ckVo);
		}
		return clist2;
	}

	@Override
	public List<ClickDateVO> findSevenDay(String day, String codeId) {
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
		} else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1] + " 23:59:59";
			Date date = null;
			try {
				date = format2.parse(xiao);
				date3 = format2.parse(da);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			days = (int) ((date3.getTime() - date.getTime()) / (1000 * 3600 * 24));
		}
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = null;
		if (codeId.equals("0")) {
			sql = "select date_format(recClickTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
					+ "from count_music_rec where recClickTime<='" + da + "' and recClickTime>='" + xiao + "' "
					+ "group by date_format(recClickTime,'%Y-%m-%d')";
		} else {
			sql = "select date_format(recClickTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
					+ "from count_music_rec where recClickTime<='" + da + "' and recClickTime>='" + xiao
					+ "' and recommdId='" + codeId + "' " + "group by date_format(recClickTime,'%Y-%m-%d')";
		}
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
		for (int i = 0; i <= days; i++) {
			String format = null;
			if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
				Calendar time = Calendar.getInstance();
				time.add(Calendar.DAY_OF_MONTH, -i);
				Date date2 = time.getTime();
				format = format2.format(date2);
			} else {
				long time = date3.getTime() - (long) (1000 * 60 * 60 * 24) * i;
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
	public List<ClickDateVO> findMon(String codeId) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONDAY, -1);
		Date sevenDate = instance.getTime();
		String seven = sdf.format(sevenDate);
		Date date = new Date();
		String today = sdf.format(date);
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(recClickTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_rec where recClickTime<='" + date + "' and recClickTime>='" + seven
				+ "' and recommdId='" + codeId + "'" + "group by date_format(recClickTime,'%Y-%m-%d') ";

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
	public ClickVO findAll(String day, String codeId) {
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
		} else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1] + " 23:59:59";
		}
		String sql = null;
		if (codeId.equals("0")) {
			sql = "select count(*),count(distinct userId) " + "from count_music_rec " + "where recClickTime<='" + da
					+ "' and recClickTime>='" + xiao + "'";
		} else {
			sql = "select count(*),count(distinct userId) " + "from count_music_rec " + "where recClickTime<='" + da
					+ "' and recClickTime>='" + xiao + "' and recommdId='" + codeId + "'";
		}
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
		String riqi1 = yearString + "-" + monString + "-" + "01 00:00:00";
		String riqi2 = yearString + "-" + monString + "-" + maxDate + " 23:59:59";
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
		String sql = "select date_format(recClickTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_rec where recClickTime<='" + end + "' and recClickTime>='" + start
				+ "' and recommdId='" + id + "'" + "group by date_format(recClickTime,'%Y-%m-%d') ";

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
		for (int i = 0; i < maxDate; i++) {
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
			String ri = yearString + "-" + monString + "-" + (i + 1);
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

	@Override
	public ClickVO findfzd(String codeId) {
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date start = new Date();
		Date end = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String format = null;
		String format2 = null;
		try {
			start = formater2.parse(formater.format(new Date()) + " 00:00:00");
			end = formater2.parse(formater.format(new Date()) + " 23:59:59");
			format = formater2.format(start);
			format2 = formater2.format(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tsql = "select count(*) ,count(distinct userId) "
				+ "from count_music_rec c,music_recom m where m.id=c.recommdId and m.typeCode='" + codeId + "' "
				+ "and recClickTime<='" + format2 + "' and recClickTime>='" + format + "'";
		List list = openSession.createSQLQuery(tsql).list();
		Iterator iterator = list.iterator();
		ClickVO ckvo = new ClickVO();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ckvo.setClicks(Integer.parseInt(o[0].toString()));
			ckvo.setClickRen(Integer.parseInt(o[1].toString()));
		}
		openSession.close();
		return ckvo;
	}

	@Override
	public ClickVO findfzy(String codeId) {
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
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
			ystart = formater2.parse(formater.format(ye) + " 00:00:00");
			yend = formater2.parse(formater.format(ye) + " 23:59:59");
			format3 = formater2.format(ystart);
			format4 = formater2.format(yend);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ysql = "select count(*) ,count(distinct userId) "
				+ "from count_music_rec c,music_recom m where m.id=c.recommdId and m.typeCode='" + codeId + "' "
				+ "and recClickTime<='" + format4 + "' and recClickTime>='" + format3 + "'";
		List list2 = openSession.createSQLQuery(ysql).list();
		Iterator iterator2 = list2.iterator();
		ClickVO ckVo = new ClickVO();
		while (iterator2.hasNext()) {
			Object[] o = (Object[]) iterator2.next();
			ckVo.setClicks(Integer.parseInt(o[0].toString()));
			ckVo.setClickRen(Integer.parseInt(o[1].toString()));
		}
		return ckVo;
	}

	@Override
	public List<ClickDateVO> findSevenDayTJW(String day, String codeId) {
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
		} else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1] + " 23:59:59";
			Date date = null;
			try {
				date = format2.parse(xiao);
				date3 = format2.parse(da);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			days = (int) ((date3.getTime() - date.getTime()) / (1000 * 3600 * 24));
		}
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(c.recClickTime,'%Y-%m-%d'), count(*) ,count(distinct userId) from count_music_rec c,music_recom m "
				+ "where m.id=c.recommdId and m.typeCode='" + codeId + "' " + "and c.recClickTime<='" + da
				+ "' and c.recClickTime>='" + xiao + "' " + "group by date_format(c.recClickTime,'%Y-%m-%d') ";
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
		for (int i = 0; i <= days; i++) {
			String format = null;
			if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
				Calendar time = Calendar.getInstance();
				time.add(Calendar.DAY_OF_MONTH, -i);
				Date date2 = time.getTime();
				format = format2.format(date2);
			} else {
				long time = date3.getTime() - (long) (1000 * 60 * 60 * 24) * i;
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
	public ClickVO findAllTJW(String day, String codeId) {
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
		} else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1] + " 23:59:59";
		}
		String sql = "select count(*) ,count(distinct userId) from count_music_rec c,music_recom m "
				+ "where m.id=c.recommdId and m.typeCode='" + codeId + "' " + "and c.recClickTime<='" + da
				+ "' and c.recClickTime>='" + xiao + "'";
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
	public ClickVO findAllzd(String codeId) {
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date start = new Date();
		Date end = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String format = null;
		String format2 = null;
		try {
			start = formater2.parse(formater.format(new Date()) + " 00:00:00");
			end = formater2.parse(formater.format(new Date()) + " 23:59:59");
			format = formater2.format(start);
			format2 = formater2.format(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tsql = "select count(*) ,count(distinct userId) "
				+ "from count_music_rec c,music_recom m where m.id=c.recommdId and m.typeCode='" + codeId + "' "
				+ "and recClickTime<='" + format2 + "' and recClickTime>='" + format + "'";
		String tsql2 = "select count(*),count(distinct userId) from music_type m,count_music_category c "
				+ "where m.typeCode=c.typeCode and m.pCode='" + codeId + "' " + "and c.cateClickTime<='" + format2
				+ "' and c.cateClickTime>='" + format + "'";
		List list = openSession.createSQLQuery(tsql).list();
		Iterator iterator = list.iterator();
		ClickVO ckvo = new ClickVO();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ckvo.setClicks(Integer.parseInt(o[0].toString()));
			ckvo.setClickRen(Integer.parseInt(o[1].toString()));
		}
		List list2 = openSession.createSQLQuery(tsql2).list();
		Iterator iterator2 = list2.iterator();
		ClickVO ckvo2 = new ClickVO();
		while (iterator2.hasNext()) {
			Object[] o = (Object[]) iterator2.next();
			ckvo2.setClicks(Integer.parseInt(o[0].toString()));
			ckvo2.setClickRen(Integer.parseInt(o[1].toString()));
		}
		ClickVO ckVo3 = new ClickVO();
		ckVo3.setClicks(ckvo.getClicks() + ckvo2.getClicks());
		ckVo3.setClickRen(ckvo.getClickRen() + ckvo2.getClickRen());
		openSession.close();
		return ckVo3;
	}

	@Override
	public ClickVO findAllzy(String codeId) {
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
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
			ystart = formater2.parse(formater.format(ye) + " 00:00:00");
			yend = formater2.parse(formater.format(ye) + " 23:59:59");
			format3 = formater2.format(ystart);
			format4 = formater2.format(yend);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tsql = "select count(*) ,count(distinct userId) "
				+ "from count_music_rec c,music_recom m where m.id=c.recommdId and m.typeCode='" + codeId + "' "
				+ "and recClickTime<='" + format4 + "' and recClickTime>='" + format3 + "'";
		String tsql2 = "select count(*),count(distinct userId) from music_type m,count_music_category c "
				+ "where m.typeCode=c.typeCode and m.pCode='" + codeId + "' " + "and c.cateClickTime<='" + format4
				+ "' and c.cateClickTime>='" + format3 + "'";
		List list = openSession.createSQLQuery(tsql).list();
		Iterator iterator = list.iterator();
		ClickVO ckvo = new ClickVO();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ckvo.setClicks(Integer.parseInt(o[0].toString()));
			ckvo.setClickRen(Integer.parseInt(o[1].toString()));
		}
		List list2 = openSession.createSQLQuery(tsql2).list();
		Iterator iterator2 = list2.iterator();
		ClickVO ckvo2 = new ClickVO();
		while (iterator2.hasNext()) {
			Object[] o = (Object[]) iterator2.next();
			ckvo2.setClicks(Integer.parseInt(o[0].toString()));
			ckvo2.setClickRen(Integer.parseInt(o[1].toString()));
		}
		ClickVO ckVo3 = new ClickVO();
		ckVo3.setClicks(ckvo.getClicks() + ckvo2.getClicks());
		ckVo3.setClickRen(ckvo.getClickRen() + ckvo2.getClickRen());
		openSession.close();
		return ckVo3;
	}

	@Override
	public List<ClickDateVO> findAllSevenDay(String day, String codeId) {
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
		} else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1] + " 23:59:59";
			Date date = null;
			try {
				date = format2.parse(xiao);
				date3 = format2.parse(da);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			days = (int) ((date3.getTime() - date.getTime()) / (1000 * 3600 * 24));
		}
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(c.recClickTime,'%Y-%m-%d'), count(*) ,count(distinct userId) from count_music_rec c,music_recom m "
				+ "where m.id=c.recommdId and m.typeCode='" + codeId + "' " + "and c.recClickTime<='" + da
				+ "' and c.recClickTime>='" + xiao + "' " + " group by date_format(c.recClickTime,'%Y-%m-%d') ";
		String sql2 = "select date_format(c.cateClickTime,'%Y-%m-%d'), count(*),count(distinct userId) "
				+ "from music_type m,count_music_category c " + "where m.typeCode=c.typeCode and m.pCode='" + codeId
				+ "' " + "and c.cateClickTime<='" + da + "' and c.cateClickTime>='" + xiao + "' "
				+ " group by date_format(c.cateClickTime,'%Y-%m-%d') ";
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
		for (int i = 0; i <= days; i++) {
			String format = null;
			if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
				Calendar time = Calendar.getInstance();
				time.add(Calendar.DAY_OF_MONTH, -i);
				Date date2 = time.getTime();
				format = format2.format(date2);
			} else {
				long time = date3.getTime() - (long) (1000 * 60 * 60 * 24) * i;
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

		// 过渡线
		List list_2 = openSession.createSQLQuery(sql2).list();
		List<ClickDateVO> list2_2 = new ArrayList<ClickDateVO>();
		Iterator iterator_2 = list_2.iterator();
		while (iterator_2.hasNext()) {
			ClickDateVO cdVo = new ClickDateVO();
			Object[] object = (Object[]) iterator_2.next();
			cdVo.setClickDate(object[0].toString());
			cdVo.setClicks(Integer.parseInt(object[1].toString()));
			cdVo.setClickRen(Integer.parseInt(object[2].toString()));
			list2_2.add(cdVo);
		}
		List<ClickDateVO> list3_2 = new ArrayList<ClickDateVO>();
		for (int i = 0; i <= days; i++) {
			String format = null;
			if (day.equals("7") || day.equals("30") || day.equals("90") || day.equals("180")) {
				Calendar time = Calendar.getInstance();
				time.add(Calendar.DAY_OF_MONTH, -i);
				Date date2 = time.getTime();
				format = format2.format(date2);
			} else {
				long time = date3.getTime() - (long) (1000 * 60 * 60 * 24) * i;
				Date date2 = new Date(time);
				format = format2.format(date2);
			}
			ClickDateVO cdv = new ClickDateVO();
			cdv.setClickDate(format);
			cdv.setClicks(0);
			cdv.setClickRen(0);
			list3_2.add(cdv);
			for (ClickDateVO clickDateVO : list2_2) {
				if (clickDateVO.getClickDate().equals(format)) {
					list3_2.remove(i);
					list3_2.add(clickDateVO);
				}
			}
		}
		for (ClickDateVO c1 : list3) {
			for (ClickDateVO c2 : list3_2) {
				if (c1.getClickDate().equals(c2.getClickDate())) {
					c1.setClicks(c1.getClicks() + c2.getClicks());
					c1.setClickRen(c1.getClickRen() + c2.getClickRen());
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public ClickVO findAllClickVO(String day, String codeId) {
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
		} else {
			String[] split = day.split(",");
			xiao = split[0];
			da = split[1] + " 23:59:59";
		}
		String sql = "select count(*) ,count(distinct userId) from count_music_rec c,music_recom m "
				+ "where m.id=c.recommdId and m.typeCode='" + codeId + "' " + "and c.recClickTime<='" + da
				+ "' and c.recClickTime>='" + xiao + "'";
		String sql2 = "select count(*),count(distinct userId) from music_type m,count_music_category c "
				+ "where m.typeCode=c.typeCode and m.pCode='" + codeId + "' " + "and c.cateClickTime<='" + da
				+ "' and c.cateClickTime>='" + xiao + "'";
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		ClickVO ckvo = new ClickVO();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			ckvo.setClicks(Integer.parseInt(object[0].toString()));
			ckvo.setClickRen(Integer.parseInt(object[1].toString()));
		}
		List list2 = openSession.createSQLQuery(sql2).list();
		Iterator iterator2 = list2.iterator();
		ClickVO ckvo2 = new ClickVO();
		while (iterator2.hasNext()) {
			Object[] object = (Object[]) iterator2.next();
			ckvo2.setClicks(Integer.parseInt(object[0].toString()));
			ckvo2.setClickRen(Integer.parseInt(object[1].toString()));
		}
		ClickVO ckvo3 = new ClickVO();
		ckvo3.setClicks(ckvo.getClicks() + ckvo2.getClicks());
		ckvo3.setClickRen(ckvo.getClickRen() + ckvo2.getClickRen());
		openSession.close();
		return ckvo3;
	}

	@Override
	public List<RecClicksStatVO> selectRecClicks(String className, String day) {
		String beginDate = null;
		String endDate = null;
		if ("7".equals(day) || "30".equals(day) || "90".equals(day) || "180".equals(day)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar instance = Calendar.getInstance();
			instance.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(day));
			Date assignedDate = instance.getTime();
			endDate = sdf.format(assignedDate);
			Date date = new Date();
			beginDate = sdf.format(date);
		} else {
			String[] split = day.split(",");
			beginDate = split[0];
			endDate = split[1];
		}
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		// 统计每个大分类下热推位某个时间段内的点击量；clickCount表示点击量，userClickCount表示点击用户量（用户去重逻辑是按天为单位去重的）
		String sql = "SELECT t.id,t.recName,SUM(t.clicks) AS clicks,SUM(t.userClicks) AS userClicks FROM "
				+ "(SELECT r.id,r.specialName AS recName,count(c.id) AS clicks,count(DISTINCT c.userId) AS userClicks "
				+ "FROM count_music_rec AS c INNER JOIN music_recom AS r ON c.recommdId=r.id " + "WHERE r.typeCode= '"
				+ className + "' AND c.recClickTime BETWEEN '" + beginDate + "' AND DATE_ADD('" + endDate
				+ "',INTERVAL 1 DAY) GROUP BY r.id,DATE_FORMAT(c.recClickTime,'%Y-%m-%d')) t "
				+ "GROUP BY t.id ORDER BY clicks DESC,userClicks DESC";
		List<RecClicksStatVO> recClicksStatVOLsit = new ArrayList<RecClicksStatVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			RecClicksStatVO recClicksStatVO = new RecClicksStatVO();
			recClicksStatVO.setId(Integer.valueOf(String.valueOf(o[0])));
			recClicksStatVO.setRecName(String.valueOf(o[1]));
			recClicksStatVO.setClicks(Integer.valueOf(String.valueOf(o[2])));
			recClicksStatVO.setUserClicks(Integer.valueOf(String.valueOf(o[3])));
			recClicksStatVOLsit.add(recClicksStatVO);
		}
		return recClicksStatVOLsit;
	}

}
