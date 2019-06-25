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

import com.fdo.dao.CountBillMonthDao;
import com.fdo.hum.MonthlyMusicCategory;
import com.fdo.hum.MonthlyType;
import com.fdo.hum.RenewLog;
import com.fdo.hum.TBillMonthLog;
import com.fdo.hum.TBillUnsmonth;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.ShouRuDateVO;

public class CountBillMonthDaoImpl extends HibernateDaoSupport implements CountBillMonthDao {

	@Override
	public List<ShouRuDateVO> findSRfeeAndPeopleDay(String code) {
		// TODO Auto-generated method stub
		String sql = null;
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
		String zuotian1, jint, zuot, jint2, zuot2, zuot3, UV = null;
		if (code == null) {
			zuotian1 = "select sum(total_fee),count(distinct userId) " + "from t_bill_month where createTime<='"
					+ format4 + "' and createTime>='" + format3 + "'";
			sql = "select sum(total_fee),count(distinct userId) " + "from t_bill_month where createTime<='" + format2
					+ "' and createTime>='" + format + "'";
			/*
			 * jint = "select count(*) " +
			 * "from t_bill_month where endTime<='"+format2+"' and endTime>='"+format+"'";
			 */
			jint = "select sum(unsubscribeMonth) " + "from renew_log where createDateTime<='" + format2
					+ "' and createDateTime>='" + format + "'";
			/*
			 * zuot = "select count(*) " +
			 * "from t_bill_month where endTime<='"+format4+"' and endTime>='"+format3+"'";
			 */
			zuot = "select sum(unsubscribeMonth) "
					+ "from renew_log where createDateTime<='2017-11-11' and createDateTime>='2017-11-13'";
			/*
			 * jint2 = "select count(*) " +
			 * "from t_bill_month where createTime<='"+format2+"' and createTime>='"+format+
			 * "'";
			 */
			/*
			 * zuot2 = "select count(*) " +
			 * "from t_bill_month where createTime<='"+format4+"' and createTime>='"+format3
			 * +"'";
			 */
			jint2 = "select count(distinct userId) " + "from t_bill_month where createTime<='" + format2
					+ "' and createTime>='" + format + "'";
			UV = "select count(distinct userId) " + "from count_music_visit where visitTime<='" + format2
					+ "' and visitTime>='" + format + "'";
			/* 昨天订购用户数 */
			zuot2 = "select count(distinct userId) " + "from t_bill_month where createTime<='" + format4
					+ "' and createTime>='" + format3 + "'";
			/* 昨天UV */
			zuot3 = "select count(distinct userId) " + "from count_music_visit where visitTime<='" + format4
					+ "' and visitTime>='" + format3 + "'";
			/*
			 * zuot3 = "select count(*) " + "from t_bill_month_log";
			 */
		} else {
			sql = "select sum(total_fee),count(distinct userId) " + "from t_bill_month where createTime<='" + format2
					+ "' and createTime>='" + format + "' and productID='" + code + "'";
			zuotian1 = "select sum(total_fee),count(distinct userId) " + "from t_bill_month where createTime<='"
					+ format4 + "' and createTime>='" + format3 + "' and productID='" + code + "'";
			jint = "select count(*) " + "from t_bill_month where endTime<='" + format2 + "' and endTime>='" + format
					+ "' and productID='" + code + "'";
			zuot = "select count(*) " + "from t_bill_month where endTime<='" + format4 + "' and endTime>='" + format3
					+ "' and productID='" + code + "'";
			/*
			 * jint2 = "select count(*) " +
			 * "from t_bill_month where createTime<='"+format2+"' and createTime>='"
			 * +format+"' and productID='"+code+"'";
			 */
			/*
			 * zuot2 = "select count(*) " +
			 * "from t_bill_month where createTime<='"+format4+"' and createTime>='"
			 * +format3+"' and productID='"+code+"'"; zuot3 = "select count(*) " +
			 * "from t_bill_month_log where productID='"+code+"'";
			 */
			jint2 = "select count(distinct userId) " + "from t_bill_month where createTime<='" + format2
					+ "' and createTime>='" + format + "'  and productID='" + code + "'";
			UV = "select count(distinct userId) " + "from count_music_visit where visitTime<='" + format2
					+ "' and visitTime>='" + format + "'";
			/* 昨天订购用户数 */
			zuot2 = "select count(distinct userId) " + "from t_bill_month where createTime<='" + format4
					+ "' and createTime>='" + format3 + "'  and productID='" + code + "'";
			/* 昨天UV */
			zuot3 = "select count(distinct userId) " + "from count_music_visit where visitTime<='" + format4
					+ "' and visitTime>='" + format3 + "'";
		}
		System.out.println(zuot);
		// Object bysbzt = openSession.createSQLQuery(zuot3).uniqueResult();
		Object bysbjt = openSession.createSQLQuery(zuot3).uniqueResult();
		Object bycgzt = openSession.createSQLQuery(zuot2).uniqueResult();
		Object bycgjt = openSession.createSQLQuery(jint2).uniqueResult();
		Object jin = openSession.createSQLQuery(UV).uniqueResult();
		Object tdrszt = openSession.createSQLQuery(zuot).uniqueResult();
		Object tdrsjt = openSession.createSQLQuery(jint).uniqueResult();
		List srzt = openSession.createSQLQuery(zuotian1).list();
		List srjt = openSession.createSQLQuery(sql).list();
		Iterator iterator = srzt.iterator();
		ShouRuDateVO srdvo = new ShouRuDateVO();
		while (iterator.hasNext()) {
			if (iterator.next() != null) {
				Object[] o;
				try {
					o = (Object[]) iterator.next();
					for (int i = 0; i < o.length; i++) {
						srdvo.setFee(Double.valueOf((o[0].toString())));
						srdvo.setPeople(Integer.parseInt(o[1].toString()));
					}
				} catch (Exception e) {
					srdvo.setFee(Double.valueOf(0));
					srdvo.setPeople(0);
				}
				/*
				 * for (int i = 0; i < o.length; i++) {
				 * srdvo.setFee(Double.valueOf((o[0].toString())));
				 * srdvo.setPeople(Integer.parseInt(o[1].toString())); }
				 */
			}
		}
		if (tdrszt == null) {
			tdrszt = 0;
		}
		srdvo.setUnpeople((int) (Double.parseDouble(tdrszt.toString()) + 0.0));
		Double a = Double.valueOf(bysbjt.toString());
		Double b = Double.valueOf(bycgzt.toString());
		Double c = b / a;
		// System.out.println("a:"+a+"b:"+b+"c:"+c);
		if (Double.isNaN(c)) {
			srdvo.setRate("0%");
		} else {
			DecimalFormat decimalFormat = new DecimalFormat("###################");
			String format5 = decimalFormat.format(c);
			String f = format5 + "%";
			srdvo.setRate(f);
		}

		Iterator iterator1 = srjt.iterator();
		ShouRuDateVO srdvo1 = new ShouRuDateVO();
		while (iterator1.hasNext()) {
			Object[] o;
			try {
				o = (Object[]) iterator1.next();
				for (int i = 0; i < o.length; i++) {
					srdvo1.setFee(Double.valueOf((o[0].toString())));
					srdvo1.setPeople(Integer.parseInt(o[1].toString()));
				}
			} catch (Exception e) {
				srdvo1.setFee(Double.valueOf(0));
				srdvo1.setPeople(0);
			}

		}
		if (tdrsjt == null) {
			tdrsjt = 0;
		}
		srdvo1.setUnpeople((int) (Double.parseDouble(tdrsjt.toString()) + 0.0));
		Double a1 = Double.valueOf(jin.toString());
		Double b1 = Double.valueOf(bycgjt.toString());
		Double c1 = b1 / a1;
		// System.out.println("a1:"+a1+"b1:"+b1+"c1:"+c1);
		if (Double.isNaN(c1)) {
			srdvo1.setRate("0%");
		} else {
			DecimalFormat decimalFormat1 = new DecimalFormat("###################");
			String format51 = decimalFormat1.format(c1);
			String f1 = format51 + "%";
			srdvo1.setRate(f1);
		}
		List<ShouRuDateVO> newDateVOs = new ArrayList<ShouRuDateVO>();
		newDateVOs.add(srdvo);
		newDateVOs.add(srdvo1);
		for (ShouRuDateVO shouRuDateVO : newDateVOs) {
			System.out.println(shouRuDateVO.getDate());
		}
		openSession.close();
		return newDateVOs;
	}

	@Override
	public List<ShouRuDateVO> findSevenDay(String day, String code) {
		// TODO Auto-generated method stub
		String da = null;
		String xiao = null;
		Date date3 = null;
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
		String shouru, tuiding, chenggong, shibai, cgUser = null;
		if (code.equals("")) {
			shouru = "select date_format(createTime,'%Y-%m-%d'), " + "sum(total_fee),count(userId) "
					+ "from t_bill_month where createTime<='" + da + "' and createTime>='" + xiao + "' "
					+ "group by date_format(createTime,'%Y-%m-%d')";
			/*
			 * tuiding = "select date_format(endTime,'%Y-%m-%d')," +
			 * "count(*) from t_bill_month where endTime<='"+da+"' and endTime>='"+xiao+"'"
			 * + "group by date_format(endTime,'%Y-%m-%d')";
			 */
			/*
			 * tuiding = "select date_format(createDateTime,'%Y-%m-%d')," +
			 * "sum(unsubscribeMonth) " +
			 * "from renew_log where createDateTime<='"+da+"' and createDateTime>= '"
			 * +xiao+"' " + "group by date_format(createDateTime,'%Y-%m-%d')";
			 */
			/* 新增人数 */
			tuiding = "select date_format(createTime,'%Y-%m-%d'), count(*) from t_bill_month " + "where createTime<='"
					+ da + "' and createTime>='" + xiao + "' and isParent=1 "
					+ "group by date_format(createTime,'%Y-%m-%d')";
			chenggong = "select date_format(createTime,'%Y-%m-%d')," + "count(*) from t_bill_month where createTime<='"
					+ da + "' and createTime>='" + xiao + "' " + "group by date_format(createTime,'%Y-%m-%d')";
			/* shibai = "select count(*) from t_bill_month_log"; */
			/* 订购用户数 */
			cgUser = "select date_format(createTime,'%Y-%m-%d'),count(distinct userId) "
					+ "from t_bill_month where createTime<='" + da + "' and createTime>='" + xiao + "' "
					+ "group by date_format(createTime,'%Y-%m-%d')";
			/* shibai = "select count(*) from t_bill_month_log "; */
			/* UV */
			shibai = "select date_format(visitTime,'%Y-%m-%d'),count(distinct userId) "
					+ "from count_music_visit where visitTime<='" + da + "' and visitTime>='" + xiao + "' "
					+ "group by date_format(visitTime,'%Y-%m-%d')";
		} else {
			shouru = "select date_format(createTime,'%Y-%m-%d'), " + "sum(total_fee),count(userId) "
					+ "from t_bill_month where createTime<='" + da + "' and createTime>='" + xiao + "' and productID='"
					+ code + "'" + "group by date_format(createTime,'%Y-%m-%d')";
			/*
			 * tuiding = "select date_format(endTime,'%Y-%m-%d')," +
			 * "count(*) from t_bill_month where endTime<='"+da+"' and endTime>='"
			 * +xiao+"' and productID='"+code+"'" +
			 * "group by date_format(endTime,'%Y-%m-%d')";
			 */
			/* 新增人数 */
			tuiding = "select date_format(createTime,'%Y-%m-%d'), count(*) from t_bill_month " + "where createTime<='"
					+ da + "' and createTime>='" + xiao + "' and isParent=1 "
					+ "group by date_format(createTime,'%Y-%m-%d')";
			chenggong = "select date_format(createTime,'%Y-%m-%d')," + "count(*) from t_bill_month where createTime<='"
					+ da + "' and createTime>='" + xiao + "' and productID='" + code + "'"
					+ "group by date_format(createTime,'%Y-%m-%d')";
			/* shibai = "select count(*) from t_bill_month_log"; */
			/* 订购用户数 */
			cgUser = "select date_format(createTime,'%Y-%m-%d'),count(distinct userId) "
					+ "from t_bill_month where createTime<='" + da + "' and createTime>='" + xiao + "'"
					+ "group by date_format(createTime,'%Y-%m-%d')";
			/* shibai = "select count(*) from t_bill_month_log "; */
			/* UV */
			shibai = "select date_format(visitTime,'%Y-%m-%d'),count(distinct userId) "
					+ "from count_music_visit where visitTime<='" + da + "' and visitTime>='" + xiao + "' "
					+ "group by date_format(visitTime,'%Y-%m-%d')";
		}
		System.out.println(cgUser);
		System.out.println(shibai);
		// shouru
		List list = openSession.createSQLQuery(shouru).list();
		List<ShouRuDateVO> list2 = new ArrayList<ShouRuDateVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ShouRuDateVO srdvo = new ShouRuDateVO();
			for (int i = 0; i < o.length; i++) {
				srdvo.setDate(o[0].toString());
				srdvo.setFee(Double.valueOf(o[1].toString()));
				srdvo.setPeople(Integer.parseInt(o[2].toString()));
			}
			list2.add(srdvo);
		}
		List<ShouRuDateVO> list3 = new ArrayList<ShouRuDateVO>();
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
			ShouRuDateVO srd = new ShouRuDateVO();
			srd.setDate(format);
			srd.setFee(Double.valueOf(0));
			srd.setPeople(0);
			list3.add(srd);
			for (ShouRuDateVO srdv : list2) {
				if (srdv.getDate().equals(format)) {
					list3.remove(i);
					list3.add(srdv);
				}
			}
		} // list3 ����

		// tuiding
		List listtd = openSession.createSQLQuery(tuiding).list();
		List<ShouRuDateVO> list2td = new ArrayList<ShouRuDateVO>();
		Iterator iteratortd = listtd.iterator();
		while (iteratortd.hasNext()) {
			ShouRuDateVO srdvo = new ShouRuDateVO();
			Object[] o = (Object[]) iteratortd.next();
			for (int i = 0; i < o.length; i++) {
				srdvo.setDate(o[0].toString());
				srdvo.setUnpeople((int) (Double.parseDouble(o[1].toString()) + 0.0));
			}
			list2td.add(srdvo);
		}
		List<ShouRuDateVO> list3td = new ArrayList<ShouRuDateVO>();
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
			ShouRuDateVO srd = new ShouRuDateVO();
			srd.setDate(format);
			srd.setUnpeople(0);
			list3td.add(srd);
			for (ShouRuDateVO srdv : list2td) {
				if (srdv.getDate().equals(format)) {
					list3td.remove(i);
					list3td.add(srdv);
				}
			}
		} // list3td �˶�

		// chenggong
		List listcg = openSession.createSQLQuery(chenggong).list();
		List<ShouRuDateVO> list2cg = new ArrayList<ShouRuDateVO>();
		Iterator iteratorcg = listcg.iterator();
		while (iteratorcg.hasNext()) {
			ShouRuDateVO srdvo = new ShouRuDateVO();
			Object[] o = (Object[]) iteratorcg.next();
			for (int i = 0; i < o.length; i++) {
				srdvo.setDate(o[0].toString());
				srdvo.setPeople(Integer.parseInt(o[1].toString()));
			}
			list2cg.add(srdvo);
		}
		List<ShouRuDateVO> list3cg = new ArrayList<ShouRuDateVO>();
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
			ShouRuDateVO srd = new ShouRuDateVO();
			srd.setDate(format);
			srd.setPeople(0);
			list3cg.add(srd);
			for (ShouRuDateVO srdv : list2cg) {
				if (srdv.getDate().equals(format)) {
					list3cg.remove(i);
					list3cg.add(srdv);
				}
			}
		} // list3td �ɹ�

		// UV
		List list4 = openSession.createSQLQuery(shibai).list();
		List list5 = openSession.createSQLQuery(cgUser).list();
		Iterator iterator2 = list4.iterator();
		Iterator iterator3 = list5.iterator();
		List<ShouRuDateVO> arrayList1 = new ArrayList<ShouRuDateVO>();
		List<ShouRuDateVO> arrayList2 = new ArrayList<ShouRuDateVO>();
		while (iterator2.hasNext()) {
			Object[] object = (Object[]) iterator2.next();
			ShouRuDateVO srdvo = new ShouRuDateVO();
			srdvo.setDate(object[0].toString());
			srdvo.setRate(object[1].toString());
			arrayList1.add(srdvo);
		}
		while (iterator3.hasNext()) {
			Object[] object = (Object[]) iterator3.next();
			ShouRuDateVO srdvo = new ShouRuDateVO();
			srdvo.setDate(object[0].toString());
			srdvo.setRate(object[1].toString());
			arrayList2.add(srdvo);
		}
		for (ShouRuDateVO s1 : arrayList1) {
			for (ShouRuDateVO s2 : arrayList2) {
				if (s1.getDate().equals(s2.getDate())) {
					Double a1 = Double.valueOf(s1.getRate());
					Double b1 = Double.valueOf(s2.getRate());
					Double c1 = (b1 / a1) * 100;
					/*
					 * System.out.println("b--"+b1); System.out.println("a--"+a1);
					 * System.out.println("c--"+c1);
					 */
					if (Double.isNaN(c1)) {
						s1.setRate("0");
					} else {
						DecimalFormat decimalFormat1 = new DecimalFormat("###################0.00");
						String format51 = decimalFormat1.format(c1);
						String f1 = format51;
						s1.setRate(f1);
					}
				}
			}
		}
		for (ShouRuDateVO s1 : list3) {
			for (ShouRuDateVO s2 : arrayList1) {
				if (s1.getDate().equals(s2.getDate())) {
					s1.setRate(s2.getRate());
				}
			}
			if (s1.getRate() == null) {
				s1.setRate("0");
			}
			// System.out.println("s1.getd"+s1.getDate()+"s1.get"+s1.getRate());
		}
		/*
		 * for (ShouRuDateVO s1 : list3) { for (ShouRuDateVO s2 : list3cg) { if
		 * (s1.getDate().equals(s2.getDate())) { Double a1 =
		 * Double.valueOf(uniqueResult.toString()); Double b1 =
		 * Double.valueOf(s2.getPeople()); Double c1 = b1/a1*100; if(Double.isNaN(c1)){
		 * s1.setRate("0%"); }else{ DecimalFormat decimalFormat1 = new
		 * DecimalFormat("###################"); String format51 =
		 * decimalFormat1.format(c1); String f1 = format51+"%"; s1.setRate(f1); } } } }
		 */

		for (ShouRuDateVO s1 : list3) {
			for (ShouRuDateVO s2 : list3td) {
				if (s1.getDate().equals(s2.getDate())) {
					s1.setUnpeople(s2.getUnpeople());
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<ShouRuDateVO> findMon() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONDAY, -1);
		Date sevenDate = instance.getTime();
		String seven = sdf.format(sevenDate);
		Date date = new Date();
		String today = sdf.format(date);
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();

		String shouru = "select date_format(createTime,'%Y-%m-%d')," + "sum(total_fee),count(userId) "
				+ "from t_bill_month where createTime<='" + today + "' and createTime>='" + seven + "'"
				+ "group by date_format(createTime,'%Y-%m-%d')";
		String tuiding = "select date_format(endTime,'%Y-%m-%d')," + "count(*) from t_bill_month where endTime<='"
				+ today + "' and endTime>='" + seven + "'" + "group by date_format(endTime,'%Y-%m-%d')";
		String chenggong = "select date_format(createTime,'%Y-%m-%d'),"
				+ "count(*) from t_bill_month where createTime<='" + today + "' and createTime>='" + seven + "'"
				+ "group by date_format(createTime,'%Y-%m-%d')";
		String shibai = "select count(*) from t_bill_month_log";

		// shouru
		List<ShouRuDateVO> list2 = new ArrayList<ShouRuDateVO>();
		List list = openSession.createSQLQuery(shouru).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			ShouRuDateVO srdvo = new ShouRuDateVO();
			srdvo.setDate(o[0].toString());
			srdvo.setFee(Double.valueOf(o[1].toString()));
			srdvo.setPeople(Integer.parseInt(o[2].toString()));
			list2.add(srdvo);
		}
		List<ShouRuDateVO> list3 = new ArrayList<ShouRuDateVO>();
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
			ShouRuDateVO srdvo = new ShouRuDateVO();
			srdvo.setDate(format);
			srdvo.setFee(Double.valueOf(0));
			srdvo.setPeople(0);
			list3.add(srdvo);
			for (ShouRuDateVO sr : list2) {
				if (sr.getDate().equals(format)) {
					list3.remove(i);
					list3.add(sr);
				}
			}
		} // ����

		// tuiding
		List listtd = openSession.createSQLQuery(tuiding).list();
		List<ShouRuDateVO> list2td = new ArrayList<ShouRuDateVO>();
		Iterator iteratortd = listtd.iterator();
		while (iteratortd.hasNext()) {
			ShouRuDateVO srdvo = new ShouRuDateVO();
			Object[] o = (Object[]) iteratortd.next();
			for (int i = 0; i < o.length; i++) {
				srdvo.setDate(o[0].toString());
				srdvo.setUnpeople(Integer.parseInt(o[1].toString()));
			}
			list2td.add(srdvo);
		}
		List<ShouRuDateVO> list3td = new ArrayList<ShouRuDateVO>();
		for (int i = 0; i < day; i++) {
			Calendar time = Calendar.getInstance();
			time.add(Calendar.DAY_OF_MONTH, -i);
			Date date2 = time.getTime();
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
			String format = sdft.format(date2);
			ShouRuDateVO srd = new ShouRuDateVO();
			srd.setDate(format);
			srd.setUnpeople(0);
			list3td.add(srd);
			for (ShouRuDateVO srdv : list2td) {
				if (srdv.getDate().equals(format)) {
					list3td.remove(i);
					list3td.add(srdv);
				}
			}
		} // list3td �˶�

		// chenggong
		List listcg = openSession.createSQLQuery(chenggong).list();
		List<ShouRuDateVO> list2cg = new ArrayList<ShouRuDateVO>();
		Iterator iteratorcg = listcg.iterator();
		while (iteratorcg.hasNext()) {
			ShouRuDateVO srdvo = new ShouRuDateVO();
			Object[] o = (Object[]) iteratorcg.next();
			for (int i = 0; i < o.length; i++) {
				srdvo.setDate(o[0].toString());
				srdvo.setPeople(Integer.parseInt(o[1].toString()));
			}
			list2cg.add(srdvo);
		}
		List<ShouRuDateVO> list3cg = new ArrayList<ShouRuDateVO>();
		for (int i = 0; i < day; i++) {
			Calendar time = Calendar.getInstance();
			time.add(Calendar.DAY_OF_MONTH, -i);
			Date date2 = time.getTime();
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
			String format = sdft.format(date2);
			ShouRuDateVO srd = new ShouRuDateVO();
			srd.setDate(format);
			srd.setPeople(0);
			list3cg.add(srd);
			for (ShouRuDateVO srdv : list2cg) {
				if (srdv.getDate().equals(format)) {
					list3cg.remove(i);
					list3cg.add(srdv);
				}
			}
		} // list3td �ɹ�
			// zongshu
		Object uniqueResult = openSession.createSQLQuery(shibai).uniqueResult();
		for (ShouRuDateVO s1 : list3) {
			for (ShouRuDateVO s2 : list3cg) {
				if (s1.getDate().equals(s2.getDate())) {
					Double a1 = Double.valueOf(uniqueResult.toString());
					Double b1 = Double.valueOf(s2.getPeople());
					Double c1 = b1 / a1 * 100;
					if (Double.isNaN(c1)) {
						s1.setRate("0%");
					} else {
						DecimalFormat decimalFormat1 = new DecimalFormat("###################");
						String format51 = decimalFormat1.format(c1);
						String f1 = format51 + "%";
					}
				}
			}
		}
		for (ShouRuDateVO s1 : list3) {
			for (ShouRuDateVO s2 : list3td) {
				if (s1.getDate().equals(s2.getDate())) {
					s1.setUnpeople(s2.getUnpeople());
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public ShouRuDateVO findAll(String code, String day) {
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
		String shouru, tuiding, chenggong, shibai, zong, xinzeng = null;
		if (code.equals("")) {
			shouru = "select sum(total_fee),count(userId) " + "from t_bill_month where createTime<='" + da
					+ "' and createTime>='" + xiao + "'";
			/*
			 * tuiding = "select count(*) " +
			 * "from t_bill_month where endTime<='"+da+"' and endTime>='"+xiao+"'";
			 */
			tuiding = "select sum(unsubscribeMonth) " + "from renew_log where createDateTime<='" + da
					+ "' and createDateTime>='" + xiao + "'";
			/*
			 * chenggong = "select count(*) " +
			 * "from t_bill_month where createTime<='"+da+"' and createTime>='"+xiao+"'";
			 */
			/* 订购用户数 */
			chenggong = "select count(distinct userId) " + "from t_bill_month where createTime<='" + da
					+ "' and createTime>='" + xiao + "'";
			/* shibai = "select count(*) from t_bill_month_log "; */
			/* UV */
			shibai = "select count(distinct userId) " + "from count_music_visit where visitTime<='" + da
					+ "' and visitTime>='" + xiao + "'";
			zong = "select count(userId) " + "from t_bill_month where createTime<='" + da + "' and createTime>='" + xiao
					+ "'";
			xinzeng = "select count(distinct userId) from t_bill_month " + "where createTime<='" + da
					+ "' and createTime>='" + xiao + "' and isParent=1";

		} else {
			shouru = "select sum(total_fee),count(userId) " + "from t_bill_month where createTime<='" + da
					+ "' and createTime>='" + xiao + "' and productID='" + code + "'";
			tuiding = "select count(*) " + "from t_bill_month where endTime<='" + da + "' and endTime>='" + xiao
					+ "' and productID='" + code + "'";
			/*
			 * chenggong = "select count(*) " +
			 * "from t_bill_month where createTime<='"+da+"' and createTime>='"
			 * +xiao+"' and productID='"+code+"'";
			 */
			/* 订购用户数 */
			chenggong = "select count(distinct userId) " + "from t_bill_month where createTime<='" + da
					+ "' and createTime>='" + xiao + "' and productID='" + code + "'";
			/* shibai = "select count(*) from t_bill_month_log"; */
			/* UV */
			shibai = "select count(distinct userId) " + "from count_music_visit where visitTime<='" + da
					+ "' and visitTime>='" + xiao + "' ";
			zong = "select count(userId) " + "from t_bill_month where createTime<='" + da + "' and createTime>='" + xiao
					+ "' and productID='" + code + "'";
			xinzeng = "select count(distinct userId) from t_bill_month " + "where createTime<='" + da
					+ "' and createTime>='" + xiao + "' and productID='" + code + "' and isParent=1";
		}
		List list = openSession.createSQLQuery(shouru).list();
		List<ShouRuDateVO> ckvClickVOs = new ArrayList<ShouRuDateVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			ShouRuDateVO ckvo = new ShouRuDateVO();
			Object[] object;
			try {
				object = (Object[]) iterator.next();
				for (int i = 0; i < object.length; i++) {
					ckvo.setFee(Double.valueOf(object[0].toString()));
					ckvo.setPeople(Integer.parseInt(object[1].toString()));
				}
			} catch (Exception e) {
				ckvo.setFee(Double.valueOf(0));
				ckvo.setPeople(0);
			}
			ckvClickVOs.add(ckvo);
		}
		ShouRuDateVO cVo = new ShouRuDateVO();
		for (ShouRuDateVO clickVO : ckvClickVOs) {
			cVo.setFee(clickVO.getFee());
			cVo.setPeople(clickVO.getPeople());
		}
		String uniqueResult = openSession.createSQLQuery(tuiding).uniqueResult().toString();
		String uniqueResult4 = openSession.createSQLQuery(xinzeng).uniqueResult().toString();
		Object uniqueResult1 = openSession.createSQLQuery(chenggong).uniqueResult();
		Object uniqueResult2 = openSession.createSQLQuery(shibai).uniqueResult();
		Object uniqueResult3 = openSession.createSQLQuery(zong).uniqueResult();
		cVo.setUnpeople((int) (Double.parseDouble(uniqueResult) + 0.0));
		cVo.setRens(Integer.parseInt(uniqueResult3.toString()));
		cVo.setDate(uniqueResult4);
		Double a1 = Double.valueOf(uniqueResult2.toString());
		Double b1 = Double.valueOf(uniqueResult1.toString());
		Double c1 = b1 / a1;
		if (Double.isNaN(c1)) {
			cVo.setRate("0%");
		} else {
			DecimalFormat decimalFormat1 = new DecimalFormat("###################");
			String format51 = decimalFormat1.format(c1);
			String f1 = format51 + "%";
			cVo.setRate(f1);
		}
		// System.out.println("a1:"+a1+"b1:"+b1+"c1:"+c1);
		openSession.close();
		return cVo;
	}

	@Override
	public List<MonthlyMusicCategory> findClassAll() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from monthly_music_category order by id";
		List<MonthlyMusicCategory> list = openSession.createSQLQuery(sql).addEntity(MonthlyMusicCategory.class).list();
		openSession.close();
		return list;
	}

	@Override
	public MonthlyType findProduct(String code) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from monthly_type where productID='" + code + "'";
		MonthlyType uniqueResult = (MonthlyType) openSession.createSQLQuery(sql).addEntity(MonthlyType.class)
				.uniqueResult();
		openSession.close();
		return uniqueResult;
	}

	@Override
	public List<MonthlyType> findSamllclassAll() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from monthly_type";
		List<MonthlyType> list = openSession.createSQLQuery(sql).addEntity(MonthlyType.class).list();
		openSession.close();
		return list;
	}

	@Override
	public Integer findBillMonthLogsCount(String orderID, String userID) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql, sql1, sql2 = null;
		sql = "select count(*) from t_bill_month_log";
		if (orderID.trim().equals("") && userID.trim().equals("")) {
			sql2 = sql;
		} else if (orderID.equals("")) {
			sql2 = sql + " where userId like '%" + userID + "%'";
		} else if (userID.equals("")) {
			sql2 = sql + " where orderNo like '%" + orderID + "%'";
		} else {
			sql2 = sql + " where orderNo like '%" + orderID + "%'";
		}
		Object uniqueResult = openSession.createSQLQuery(sql2).uniqueResult();
		String string = uniqueResult.toString();
		Integer valueOf = Integer.valueOf(string);
		openSession.close();
		return valueOf;
	}

	@Override
	public List<TBillMonthLog> findBillMonthLogs(String orderID, String userID, Integer page) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql, sql1, sql2 = null;
		sql = "select * from t_bill_month_log";
		sql1 = " order by orderNo desc limit " + page + ", 20";
		if (orderID.trim().equals("") && userID.trim().equals("")) {
			sql2 = sql + sql1;
		} else if (orderID.equals("")) {
			sql2 = sql + " where userId like '%" + userID + "%'" + sql1;
		} else if (userID.equals("")) {
			sql2 = sql + " where orderNo like '%" + orderID + "%'" + sql1;
		} else {
			sql2 = sql + " where orderNo like '%" + orderID + "%'" + sql1;
		}
		System.out.println(sql2);
		List<TBillMonthLog> list = openSession.createSQLQuery(sql2).addEntity(TBillMonthLog.class).list();
		openSession.close();
		return list;
	}

	@Override
	public Integer findTDAllCount(String orderID, String userID) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql, sql1, sql2 = null;
		sql = "select count(*) from t_bill_unsbmonth";
		if (orderID.trim().equals("") && userID.trim().equals("")) {
			sql2 = sql;
		} else if (orderID.equals("")) {
			sql2 = sql + " where userId like '%" + userID + "%'";
		} else if (userID.equals("")) {
			sql2 = sql + " where orderNo like '%" + orderID + "%'";
		} else {
			sql2 = sql + " where orderNo like '%" + orderID + "%'";
		}
		System.out.println(sql2);
		Object uniqueResult = openSession.createSQLQuery(sql2).uniqueResult();
		String string = uniqueResult.toString();
		Integer valueOf = Integer.valueOf(string);
		openSession.close();
		return valueOf;
	}

	@Override
	public List<TBillUnsmonth> findTDAll(String orderID, String userID, Integer page) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql, sql1, sql2 = null;
		sql = "select * from t_bill_unsbmonth";
		sql1 = " order by orderNo desc limit " + page + ", 20";
		if (orderID.trim().equals("") && userID.trim().equals("")) {
			sql2 = sql + sql1;
		} else if (orderID.equals("")) {
			sql2 = sql + " where userId like '%" + userID + "%'" + sql1;
		} else if (userID.equals("")) {
			sql2 = sql + " where orderNo like '%" + orderID + "%'" + sql1;
		} else {
			sql2 = sql + " where orderNo like '%" + orderID + "%'" + sql1;
		}
		System.out.println(sql2);
		List<TBillUnsmonth> list = openSession.createSQLQuery(sql2).addEntity(TBillUnsmonth.class).list();
		openSession.close();
		return list;
	}

	@Override
	public List<MonthlyMusicCategory> findBaoYue(String productId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from monthly_music_category where cpId = '" + productId + "' order by id asc ";
		List<MonthlyMusicCategory> list = openSession.createSQLQuery(sql).addEntity(MonthlyMusicCategory.class).list();
		openSession.close();
		return list;
	}

	@Override
	public List<CPShouRuVO> findCpShouRuVOs(String day) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String da = null;
		String xiao = null;
		if (!day.equals("0")) {
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
				xiao = split[0] + " 00:00:00";
				da = split[1] + " 23:59:59";
			}
		}
		String zongsql = null;
		if (day.equals("0")) {
			zongsql = "select sum(t.total_fee) from t_bill_month t,monthly_type m where t.monthlyNo=m.productId";
		} else {
			zongsql = "select sum(t.total_fee) from t_bill_month t,monthly_type m where t.monthlyNo=m.productId "
					+ "and t.createTime<='" + da + "' and t.createTime>='" + xiao + "'";
		}
		Object uniqueResult = openSession.createSQLQuery(zongsql).uniqueResult();
		List<CPShouRuVO> cpShouRuVOs = new ArrayList<CPShouRuVO>();
		List<MonthlyType> findSamllclassAll = this.findSamllclassAll();
		for (MonthlyType monthlyType : findSamllclassAll) {
			String sql = null;
			if (day.equals("0")) {
				sql = "select sum(t.total_fee) from t_bill_month t,monthly_type m "
						+ "where t.monthlyNo=m.productId and m.productId='" + monthlyType.getProductId() + "'";
			} else {
				sql = "select sum(t.total_fee) from t_bill_month t,monthly_type m "
						+ "where t.monthlyNo=m.productId and m.productId='" + monthlyType.getProductId() + "' "
						+ " and t.createTime<='" + da + "' and t.createTime>='" + xiao + "'";
			}
			Object uniqueResult2 = openSession.createSQLQuery(sql).uniqueResult();
			if (uniqueResult2 == null) {
				uniqueResult2 = 0.0;
			}
			if (uniqueResult == null) {
				uniqueResult = 0.0;
			}
			CPShouRuVO cpShouRuVO = new CPShouRuVO();
			Double a = Double.valueOf(uniqueResult.toString());
			Double b = Double.valueOf(uniqueResult2.toString());
			Double c = b / a * 100;
			if (Double.isNaN(c)) {
				cpShouRuVO.setTotl("0%");
			} else {
				DecimalFormat decimalFormat = new DecimalFormat("###0.00");
				String format5 = decimalFormat.format(c);
				String f = format5 + "%";
				cpShouRuVO.setTotl(f);
			}
			cpShouRuVO.setJin2(Double.parseDouble(uniqueResult2.toString()));
			cpShouRuVO.setCpName(monthlyType.getMemo1());
			cpShouRuVOs.add(cpShouRuVO);
		}
		openSession.close();
		return cpShouRuVOs;
	}

	@Override
	public String findZDJ(String day) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String da = null;
		String xiao = null;
		if (!day.equals("0")) {
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
		}
		String zongsql = null;
		if (day.equals("0")) {
			// zongsql = "select sum(t.total_fee) from t_bill_month t,monthly_type m where
			// t.monthlyNo=m.productId";
			zongsql = "SELECT sum(t.total_fee) FROM t_bill_month t WHERE STATUS=1";
		} else {
			// zongsql = "select sum(t.total_fee) from t_bill_month t,monthly_type m where
			// t.monthlyNo=m.productId"
			// + " and t.createTime between '" + xiao + "' and '" + da + "'";
			zongsql = "SELECT sum(t.total_fee) FROM t_bill_month t WHERE STATUS=1" + " and t.createTime between '"
					+ xiao + "' and '" + da + "'";
		}
		System.out.println(zongsql);
		Object uniqueResult = openSession.createSQLQuery(zongsql).uniqueResult();
		openSession.close();
		return String.valueOf(uniqueResult);
	}

	@Override
	public Integer findDDCount(String stat, String end, String productId, String status) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select count(*) from t_bill_month_log";
		String hsql = "";
		String date = " and createTime>='" + stat + "' and createTime<='" + end + "'";
		/* List<TBillMonth> list2 = new ArrayList<TBillMonth>(); */
		if (stat.equals("") || end.equals("")) {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'";
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					hsql = sql + " where status!='0' and status!='1'";
				} else if (status.equals("1")) {
					hsql = sql + " where status='1'";
				} else if (status.equals("2")) {
					hsql = sql + " where isParent='2'";
				} else if (status.equals("3")) {
					hsql = sql + " where isParent='1' and status='1'";
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'";
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'";
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'";
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'";
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'";
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'";
				}
			} else {
				hsql = sql;
			}
		} else {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'" + date;
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					// 失败
					hsql = sql + " where status!='0' and status!='1'" + date;
				} else if (status.equals("1")) {
					// 成功
					hsql = sql + " where status='1'" + date;
				} else if (status.equals("2")) {
					// 续订
					hsql = sql + " where isParent='2'" + date;
				} else if (status.equals("3")) {
					// 订购
					hsql = sql + " where isParent='1' and status='1'" + date;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'" + date;
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'" + date;
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'" + date;
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'" + date;
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'" + date;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'" + date;
				}
			} else {
				hsql = sql + " where createTime>='" + stat + "' and createTime<='" + end + "'";
			}
		}
		Object uniqueResult = openSession.createSQLQuery(hsql).uniqueResult();
		String string = uniqueResult.toString();
		openSession.close();
		return Integer.valueOf(string);
	}

	@Override
	public List<TBillMonthLog> findDD(String stat, String end, String productId, String status, Integer page) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from t_bill_month_log";
		String sql1 = " order by orderNo desc limit " + page + ", 20";
		String hsql = "";
		String date = " and createTime>='" + stat + "' and createTime<='" + end + "'";
		/* List<TBillMonth> list2 = new ArrayList<TBillMonth>(); */
		if (stat.equals("") || end.equals("")) {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'" + sql1;
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					hsql = sql + " where status!='0' and status!='1'" + sql1;
				} else if (status.equals("1")) {
					hsql = sql + " where status='1'" + sql1;
				} else if (status.equals("2")) {
					hsql = sql + " where isParent='2'" + sql1;
				} else if (status.equals("3")) {
					hsql = sql + " where isParent='1' and status='1'" + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'" + sql1;
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'" + sql1;
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'" + sql1;
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'" + sql1;
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'" + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'" + sql1;
				}
			} else {
				hsql = sql + sql1;
			}
		} else {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'" + date + sql1;
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					// 失败
					hsql = sql + " where status!='0' and status!='1'" + date + sql1;
				} else if (status.equals("1")) {
					// 成功
					hsql = sql + " where status='1'" + date + sql1;
				} else if (status.equals("2")) {
					// 续订
					hsql = sql + " where isParent='2'" + date + sql1;
				} else if (status.equals("3")) {
					// 订购
					hsql = sql + " where isParent='1' and status='1'" + date + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'" + date + sql1;
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'" + date + sql1;
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'" + date + sql1;
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'" + date + sql1;
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'" + date + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'" + date + sql1;
				}
			} else {
				hsql = sql + " where createTime>='" + stat + "' and createTime<='" + end + "'" + sql1;
			}
		}
		List<TBillMonthLog> list = openSession.createSQLQuery(hsql).addEntity(TBillMonthLog.class).list();
		openSession.close();
		return list;
	}

	@Override
	public ShouRuDateVO findZdd(String state, String end, String productId, String status) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select count(*),sum(total_fee) from t_bill_month_log";
		String sql2 = "select count(*) from t_bill_month_log";
		String hsql = "";
		String cg = "";
		String xd = "";
		String dg = "";
		String date = " and createTime>='" + state + "' and createTime<='" + end + "'";
		if (state.equals("") || end.equals("")) {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'";
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					hsql = sql + " where status!='0' and status!='1'";
				} else if (status.equals("1")) {
					hsql = sql + " where status='1'";
				} else if (status.equals("2")) {
					hsql = sql + " where isParent='2'";
				} else if (status.equals("3")) {
					hsql = sql + " where isParent='1' and status='1'";
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'";
				}
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
			} else if (!(status.equals("") && productId.equals(""))) {
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'";
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'";
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'";
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'";
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'";
				}
			} else {
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
				hsql = sql;
			}
		} else {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'" + date;
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
			} else if (!status.equals("") && productId.equals("")) {
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
				if (status.equals("00")) {
					// 失败
					hsql = sql + " where status!='0' and status!='1'" + date;
				} else if (status.equals("1")) {
					// 成功
					hsql = sql + " where status='1'" + date;
				} else if (status.equals("2")) {
					// 续订
					hsql = sql + " where isParent='2'" + date;
				} else if (status.equals("3")) {
					// 订购
					hsql = sql + " where isParent='1' and status='1'" + date;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'" + date;
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				cg = sql2 + " where status='1'";
				xd = sql2 + " where isParent='2'";
				dg = sql2 + " where isParent='1' and status='1'";
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'" + date;
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'" + date;
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'" + date;
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'" + date;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'" + date;
				}
			} else {
				hsql = sql + " where createTime>='" + state + "' and createTime<='" + end + "'";
				cg = sql2 + " where status='1'" + date;
				xd = sql2 + " where isParent='2'" + date;
				dg = sql2 + " where isParent='1' and status='1'" + date;
			}
		}
		String strCG = "";
		String strXD = "";
		String strDG = "";
		strCG = openSession.createSQLQuery(cg).uniqueResult().toString();
		strXD = openSession.createSQLQuery(xd).uniqueResult().toString();
		strDG = openSession.createSQLQuery(dg).uniqueResult().toString();

		List list = openSession.createSQLQuery(hsql).list();
		Iterator iterator = list.iterator();
		ShouRuDateVO srd = new ShouRuDateVO();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			srd.setPeople(Integer.parseInt(object[0].toString()));
			if (strCG.equals("") || strXD.equals("") || strDG.equals("")) {
				srd.setRate(strCG);
				srd.setRens(0);
				srd.setUnpeople(0);
			} else {
				srd.setRate(strCG);
				srd.setRens(Integer.parseInt(strXD));
				srd.setUnpeople(Integer.parseInt(strDG));
			}

			Double a = null;
			try {
				object[1].toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				a = 0.0;
				e.printStackTrace();
			}
			if (a != null) {
				srd.setFee(Double.parseDouble("0.0"));
			} else {
				srd.setFee(Double.parseDouble(object[1].toString()));
			}
		}
		openSession.close();
		return srd;
	}

	@Override
	public ShouRuDateVO findzd(String orderId, String userId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql, sql2 = null;
		sql = "select count(*),sum(total_fee) from t_bill_month_log";
		if (orderId.trim().equals("") && userId.trim().equals("")) {
			sql2 = sql;
		} else if (orderId.equals("")) {
			sql2 = sql + " where userId='" + userId + "'";
		} else if (userId.equals("")) {
			sql2 = sql + " where orderNo='" + orderId + "'";
		} else {
			sql2 = sql + " where orderNo='" + orderId + "'";
		}
		List list = openSession.createSQLQuery(sql2).list();
		Iterator iterator = list.iterator();
		ShouRuDateVO srd = new ShouRuDateVO();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			srd.setPeople(Integer.parseInt(object[0].toString()));
			Double a = null;
			try {
				object[1].toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				a = 0.0;
				e.printStackTrace();
			}
			if (a != null) {
				srd.setFee(Double.parseDouble("0.0"));
			} else {
				srd.setFee(Double.parseDouble(object[1].toString()));
			}
		}
		openSession.close();
		return srd;
	}

	@Override
	public List<TBillMonthLog> findDG(String stat, String end, String productId, String status) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from t_bill_month_log";
		String sql1 = " order by orderNo desc";
		String hsql = "";
		String date = " and createTime>='" + stat + "' and createTime<='" + end + "'";
		if (stat.equals("") || end.equals("")) {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'" + sql1;
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					hsql = sql + " where status!='0' and status!='1'" + sql1;
				} else if (status.equals("1")) {
					hsql = sql + " where status='1'" + sql1;
				} else if (status.equals("2")) {
					hsql = sql + " where isParent='2'" + sql1;
				} else if (status.equals("3")) {
					hsql = sql + " where isParent='1' and status='1'" + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'" + sql1;
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'" + sql1;
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'" + sql1;
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'" + sql1;
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'" + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'" + sql1;
				}
			} else {
				hsql = sql + sql1;
			}
		} else {
			if (!productId.equals("") && status.equals("")) {
				hsql = sql + " where productID='" + productId + "'" + date + sql1;
			} else if (!status.equals("") && productId.equals("")) {
				if (status.equals("00")) {
					// 失败
					hsql = sql + " where status!='0' and status!='1'" + date + sql1;
				} else if (status.equals("1")) {
					// 成功
					hsql = sql + " where status='1'" + date + sql1;
				} else if (status.equals("2")) {
					// 续订
					hsql = sql + " where isParent='2'" + date + sql1;
				} else if (status.equals("3")) {
					// 订购
					hsql = sql + " where isParent='1' and status='1'" + date + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where status='0'" + date + sql1;
				}
			} else if (!(status.equals("") && productId.equals(""))) {
				if (status.equals("00")) {
					hsql = sql + " where productID='" + productId + "' and status!='0' and status!='1'" + date + sql1;
				} else if (status.equals("1")) {
					hsql = sql + " where productID='" + productId + "' and status='1'" + date + sql1;
				} else if (status.equals("2")) {
					hsql = sql + " where productID='" + productId + "' and isParent='2'" + date + sql1;
				} else if (status.equals("3")) {
					hsql = sql + " where productID='" + productId + "' and status='1' and isParent='1'" + date + sql1;
				} else if (status.equals("0")) {
					// 下单
					hsql = sql + " where productID='" + productId + "' and status='0'" + date + sql1;
				}
			} else {
				hsql = sql + " where createTime>='" + stat + "' and createTime<='" + end + "'" + sql1;
			}
		}
		List<TBillMonthLog> list = openSession.createSQLQuery(hsql).addEntity(TBillMonthLog.class).list();
		openSession.close();
		return list;
	}

	@Override
	public RenewLog findAllLog(String day) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String da = null;
		String xiao = null;
		if (!day.equals("0")) {
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
				xiao = split[0] + " 00:00:00";
				da = split[1] + " 23:59:59";
			}
		}
		String sql = null;
		if (day.equals("0")) {
			sql = "select sum(renewMonth),sum(unsubscribeMonth) from renew_log";
		} else {
			sql = "select sum(renewMonth),sum(unsubscribeMonth) from renew_log " + "where createDateTime between '"
					+ xiao + "' and '" + da + "'";
		}
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		RenewLog renewLog = new RenewLog();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			if (object[0] == null) {
				renewLog.setRenewMonth("");
			} else {
				renewLog.setRenewMonth(object[0].toString());
			}
			if (object[1] == null) {
				renewLog.setUnsubscribeMonth("");
			} else {
				renewLog.setUnsubscribeMonth(object[1].toString());
			}
		}
		return renewLog;
	}

}
