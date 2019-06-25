package com.fdo.dao.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdo.dao.CountMusicVisitDao;
import com.fdo.vo.ActiveDateVO;
import com.fdo.vo.ActiveVO;

public class CountMusicVisitDaoImpl extends HibernateDaoSupport implements CountMusicVisitDao {

	@Override
	public List<ActiveVO> findCountMuSicVisitDay() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Date today = new Date();
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
		Date start = new Date();
		Date end = new Date();
		Date ystart = new Date();
		Date yend = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String format = null;
		String format2 = null;
		try {
			start = formater2.parse(formater.format(new Date()) + " 00:00:00");
			end = formater2.parse(formater.format(new Date()) + " 23:59:59");
			format = formater2.format(start);
			format2 = formater2.format(end);
			ystart = formater2.parse(formater.format(ye) + " 00:00:00");
			yend = formater2.parse(formater.format(ye) + " 23:59:59");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tsql = "select count(*), count(distinct userId) " + "from count_music_visit where  visitTime<='"
				+ format2 + "' and visitTime>='" + format + "'";
		List list = openSession.createSQLQuery(tsql).list();
		List<ActiveVO> clist1 = new ArrayList<ActiveVO>();
		List<ActiveVO> clist2 = new ArrayList<ActiveVO>();
		List<List<ActiveVO>> clist = new ArrayList<List<ActiveVO>>();
		// Iterator iterator2 = list2.iterator();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			ActiveVO aVo = new ActiveVO();
			Object[] o = (Object[]) iterator.next();
			for (int i = 0; i < o.length; i++) {
				aVo.setTotalUser(Integer.parseInt(o[0].toString()));
				aVo.setActiveUser(Integer.parseInt(o[1].toString()));
				Double a = Double.valueOf(o[0].toString());
				Double b = Double.valueOf(o[1].toString());
				Double c = a / b;
				if (Double.isNaN(c)) {
					aVo.setRatio("0");
				} else {
					DecimalFormat decimalFormat = new DecimalFormat("###################0.##");
					String format5 = decimalFormat.format(c);
					String f = format5;
					aVo.setRatio(f);
				}
			}
			clist1.add(aVo);
		}
		openSession.close();
		return clist1;
	}

	@Override
	public List<ActiveVO> findCountMuSicVisitYesterday() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Date today = new Date();
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
		String yesterDaySQL = "select count(*), count(distinct userId) " + "from count_music_visit where  visitTime<='"
				+ format4 + "' and visitTime>='" + format3 + "'";
		List list2 = openSession.createSQLQuery(yesterDaySQL).list();
		List<ActiveVO> clist2 = new ArrayList<ActiveVO>();
		Iterator iterator2 = list2.iterator();
		while (iterator2.hasNext()) {
			ActiveVO aVo = new ActiveVO();
			Object[] o = (Object[]) iterator2.next();
			for (int i = 0; i < o.length; i++) {
				aVo.setTotalUser(Integer.parseInt(o[0].toString()));
				aVo.setActiveUser(Integer.parseInt(o[1].toString()));
				Double a = Double.valueOf(o[0].toString());
				Double b = Double.valueOf(o[1].toString());
				Double c = a / b;
				if (Double.isNaN(c)) {
					aVo.setRatio("0");
				} else {
					DecimalFormat decimalFormat = new DecimalFormat("###################0.##");
					String format5 = decimalFormat.format(c);
					String f = format5;
					aVo.setRatio(f);
				}
			}
			clist2.add(aVo);
		}
		return clist2;
	}

	@Override
	public List<ActiveDateVO> findSevenDay(String day) {
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
		/*
		 * String sql = "select date_format(visitTime,'%Y-%m-%d')," +
		 * "count(*),count(distinct userId) " +
		 * "from count_music_visit where visitTime<='"+da+"' and visitTime>='"+xiao+"'"
		 * + "group by date_format(visitTime,'%Y-%m-%d')";
		 */
		String sql = "select a.day,a.pv,b.wpv,c.ypv,a.uv,b.wuv,c.yuv from"
				+ " (select date_format(visitTime,'%Y-%m-%d') as day,count(*) as pv,count(distinct userId) as uv"
				+ " from count_music_visit where visitTime between '" + xiao + "' and '" + da + "'"
				+ " group by date_format(visitTime,'%Y-%m-%d')) as a,"
				+ " (select  date_format(visitTime,'%Y-%m-%d') as day, count(*) as wpv, count(DISTINCT userId) as wuv"
				+ " from count_music_visit  WHERE userId not in (select DISTINCT userId from  t_bill_month)"
				+ " and visitTime between '" + xiao + "' and '" + da
				+ "' group by date_format(visitTime,'%Y-%m-%d')) as b,"
				+ " (select  date_format(visitTime,'%Y-%m-%d') as day, count(*) as ypv, count(DISTINCT userId) as yuv "
				+ " from count_music_visit  WHERE userId  in (select DISTINCT userId from  t_bill_month) "
				+ " and visitTime between '" + xiao + "' and '" + da
				+ "' group by date_format(visitTime,'%Y-%m-%d')) as c" + " where a.day=b.day and b.day=c.day";
		List list = openSession.createSQLQuery(sql).list();
		List<ActiveDateVO> list2 = new ArrayList<ActiveDateVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			ActiveDateVO advo = new ActiveDateVO();
			Object[] o = (Object[]) iterator.next();
			for (int i = 0; i < o.length; i++) {
				advo.setClickDate(o[0].toString());
				advo.setTotalUser(Integer.parseInt(o[1].toString()));
				advo.setWpv(Integer.parseInt(o[2].toString()));
				advo.setYpv(Integer.parseInt(o[3].toString()));
				advo.setActiveUser(Integer.parseInt(o[4].toString()));
				advo.setWuv(Integer.parseInt(o[5].toString()));
				advo.setYuv(Integer.parseInt(o[6].toString()));

				Double a = Double.valueOf(o[1].toString());
				Double b = Double.valueOf(o[4].toString());
				Double c = a / b;
				if (Double.isNaN(c)) {
					advo.setRatio("0");
				} else {
					DecimalFormat decimalFormat = new DecimalFormat("###################0.##");
					String format5 = decimalFormat.format(c);
					String f = format5;
					advo.setRatio(f);
				}
			}
			list2.add(advo);
		}
		List<ActiveDateVO> list3 = new ArrayList<ActiveDateVO>();
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
			ActiveDateVO advo = new ActiveDateVO();
			advo.setClickDate(format);
			advo.setTotalUser(0);
			advo.setActiveUser(0);
			advo.setWpv(0);
			advo.setWuv(0);
			advo.setYpv(0);
			advo.setYuv(0);
			advo.setRatio("0");
			list3.add(advo);
			for (ActiveDateVO acdvo : list2) {
				if (acdvo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(acdvo);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<ActiveDateVO> findMon() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONDAY, -1);
		Date sevenDate = instance.getTime();
		String seven = sdf.format(sevenDate);
		Date date = new Date();
		String today = sdf.format(date);
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(visitTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_visit where visitTime<='" + date + "' and visitTime>='" + seven + "'"
				+ "group by date_format(visitTime,'%Y-%m-%d') ";

		List<ActiveDateVO> list2 = new ArrayList<ActiveDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ActiveDateVO advo = new ActiveDateVO();
			for (int i = 0; i < o.length; i++) {
				advo.setClickDate(o[0].toString());
				advo.setTotalUser(Integer.parseInt(o[1].toString()));
				advo.setActiveUser(Integer.parseInt(o[2].toString()));
				Double a = Double.valueOf(o[1].toString());
				Double b = Double.valueOf(o[2].toString());
				Double c = a / b;
				if (Double.isNaN(c)) {
					advo.setRatio("0");
				} else {
					DecimalFormat decimalFormat = new DecimalFormat("###################0.##");
					String format5 = decimalFormat.format(c);
					String f = format5;
					advo.setRatio(f);
				}
			}
			list2.add(advo);
		}
		List<ActiveDateVO> list3 = new ArrayList<ActiveDateVO>();
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
			ActiveDateVO advo = new ActiveDateVO();
			advo.setClickDate(format);
			advo.setTotalUser(0);
			advo.setActiveUser(0);
			advo.setRatio("0");
			list3.add(advo);
			for (ActiveDateVO acdvo : list2) {
				if (acdvo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(acdvo);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public ActiveVO findAll(String day) {
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
		/*
		 * String sql = "select count(*),count(distinct userId) " +
		 * "from count_music_visit " +
		 * "where visitTime<='"+da+"' and visitTime>='"+xiao+"'";
		 */
		// String sql = "select a.pv,b.wpv,c.ypv,a.uv,b.wuv,c.yuv from"
		// + " (select count(*) as pv,count(distinct userId) as uv from
		// count_music_visit"
		// + " where visitTime between '" + xiao + "' and '" + da + "') as a,"
		// + " (select count(*) as wpv, count(DISTINCT userId) as wuv from
		// count_music_visit"
		// + " WHERE userId not in (select DISTINCT userId from t_bill_month) and
		// visitTime" + " between '" + xiao
		// + "' and '" + da + "') as b,"
		// + " (select count(*) as ypv, count(DISTINCT userId) as yuv from
		// count_music_visit"
		// + " WHERE userId in (select DISTINCT userId from t_bill_month) and visitTime"
		// + " between '" + xiao
		// + "' and '" + da + "') as c";
		String sql = "SELECT a.pv,b.wpv,c.ypv,a.uv,b.wuv,c.yuv FROM "
				+ "( SELECT sum(cmv.c) AS pv,sum(cmv.cu) AS uv FROM ( SELECT count(*) AS c,count(DISTINCT userId) AS cu FROM count_music_visit AS mv WHERE visitTime BETWEEN '"
				+ xiao + "' AND '" + da + "' GROUP BY DATE_FORMAT(mv.visitTime,'%Y-%m-%d')) cmv) AS a,"
				+ "( SELECT sum(cmv.c) AS wpv,sum(cmv.cu) AS wuv FROM ( SELECT count(*) AS c,count(DISTINCT userId) AS cu FROM count_music_visit AS mv WHERE userId NOT IN ( SELECT DISTINCT userId FROM t_bill_month) AND visitTime BETWEEN '"
				+ xiao + "' AND '" + da + "' GROUP BY DATE_FORMAT(mv.visitTime,'%Y-%m-%d')) cmv) AS b,"
				+ "( SELECT sum(cmv.c) AS ypv,sum(cmv.cu) AS yuv FROM ( SELECT count(*) AS c,count(DISTINCT userId) AS cu FROM count_music_visit AS mv WHERE userId IN ( SELECT DISTINCT userId FROM t_bill_month) AND visitTime BETWEEN '"
				+ xiao + "' AND '" + da + "' GROUP BY DATE_FORMAT(mv.visitTime,'%Y-%m-%d')) cmv) AS c";
		List list = openSession.createSQLQuery(sql).list();
		ActiveVO avo = new ActiveVO();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			avo.setTotalUser(Integer.parseInt(o[0].toString()));
			avo.setWpvInteger(Integer.parseInt(o[1].toString()));
			avo.setYpvInteger(Integer.parseInt(o[2].toString()));
			avo.setActiveUser(Integer.parseInt(o[3].toString()));
			avo.setWuvInteger(Integer.parseInt(o[4].toString()));
			avo.setYuvInteger(Integer.parseInt(o[5].toString()));
			Double a = Double.valueOf(o[0].toString());
			Double b = Double.valueOf(o[3].toString());
			Double c = a / b;
			if (Double.isNaN(c)) {
				avo.setRatio("0");
			} else {
				DecimalFormat decimalFormat = new DecimalFormat("###################0.##");
				String format5 = decimalFormat.format(c);
				String f = format5;
				avo.setRatio(f);
			}
		}
		openSession.close();
		return avo;
	}

	@Override
	public List<ActiveDateVO> findYesrMon(String codeId) {
		// TODO Auto-generated method stub
		String[] split = codeId.split(",");
		String yearString = split[0];
		String monString = split[1];

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
		String sql = "select date_format(visitTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_visit where visitTime<='" + end + "' and visitTime>='" + start + "'"
				+ "group by date_format(visitTime,'%Y-%m-%d') ";

		List<ActiveDateVO> list2 = new ArrayList<ActiveDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ActiveDateVO activeDateVO = new ActiveDateVO();
			for (int i = 0; i < o.length; i++) {
				activeDateVO.setClickDate(o[0].toString());
				activeDateVO.setTotalUser(Integer.parseInt(o[1].toString()));
				activeDateVO.setActiveUser(Integer.parseInt(o[2].toString()));
				Double aa = Double.valueOf(o[1].toString());
				Double b = Double.valueOf(o[2].toString());
				Double c = aa / b;
				if (Double.isNaN(c)) {
					activeDateVO.setRatio("0");
				} else {
					DecimalFormat decimalFormat = new DecimalFormat("###################0.##");
					String format5 = decimalFormat.format(c);
					String f = format5;
					activeDateVO.setRatio(f);
				}
			}
			list2.add(activeDateVO);
		}
		List<ActiveDateVO> list3 = new ArrayList<ActiveDateVO>();
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
			ActiveDateVO adv = new ActiveDateVO();
			adv.setClickDate(format);
			adv.setTotalUser(0);
			adv.setActiveUser(0);
			adv.setRatio("0");
			list3.add(adv);
			for (ActiveDateVO advo : list2) {
				if (advo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(advo);
				}
			}
		}
		openSession.close();
		return list3;
	}

}
