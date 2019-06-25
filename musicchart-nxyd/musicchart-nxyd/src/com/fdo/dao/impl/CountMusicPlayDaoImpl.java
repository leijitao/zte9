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

import com.fdo.dao.CountMusicPlayDao;
import com.fdo.hum.MusicCp;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.FindMusicInfoVO;
import com.fdo.vo.SongDateVO;
import com.fdo.vo.SongVO;

public class CountMusicPlayDaoImpl extends HibernateDaoSupport implements CountMusicPlayDao {

	@Override
	public SongVO findCountMusicPlayDay() {
		// 宁夏移动歌曲数据库由运营商维护，我们无法获取信息，所以music_info表里的数据无效
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
		// ��Ŀ����
		// String sumSongSQL = "select count(*) from music_info " + "where
		// createDateTime<='" + format2 + "'";
		// ������Ŀ����
		// String todaySQL = "select count(*) from music_info " + "where
		// createDateTime<='" + format2
		// + "' and createDateTime>='" + format + "'";
		// �㲥�ܴ�����������
		String clickSQL = "select count(*),count(distinct userId) " + "from count_music_play where palyTime <='"
				+ format2 + "' and palyTime >='" + format + "'";
		// Object uniqueResult = openSession.createSQLQuery(sumSongSQL).uniqueResult();
		// Object uniqueResult2 = openSession.createSQLQuery(todaySQL).uniqueResult();
		List list3 = openSession.createSQLQuery(clickSQL).list();
		SongVO svo = new SongVO();
		Iterator iterator = list3.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			svo.setSumClick(Integer.parseInt(String.valueOf(o[0])));
			svo.setSumClickRen(Integer.parseInt(String.valueOf(o[1])));
			svo.setSumSong(0);
			svo.setNewSong(0);
		}
		openSession.close();
		return svo;
	}

	@Override
	public SongVO findCountMusicPlayYesterday() {
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
		// ��Ŀ����
		// String sumSongSQL = "select count(*) from music_info " + "where
		// createDateTime<='" + format4 + "'";
		// // ������Ŀ����
		// String todaySQL = "select count(*) from music_info " + "where
		// createDateTime<='" + format4
		// + "' and createDateTime>='" + format3 + "'";
		// �㲥�ܴ�����������
		String clickSQL = "select count(*),count(distinct userId) " + "from count_music_play where palyTime<='"
				+ format4 + "' and palyTime>='" + format3 + "'";
		// Object uniqueResult = openSession.createSQLQuery(sumSongSQL).uniqueResult();
		// Object uniqueResult2 = openSession.createSQLQuery(todaySQL).uniqueResult();
		List list2 = openSession.createSQLQuery(clickSQL).list();
		Iterator iterator2 = list2.iterator();
		SongVO svo = new SongVO();
		while (iterator2.hasNext()) {
			Object[] o = (Object[]) iterator2.next();
			svo.setSumClick(Integer.parseInt(o[0].toString()));
			svo.setSumClickRen(Integer.parseInt(o[1].toString()));
			svo.setSumSong(0);
			svo.setNewSong(0);
		}
		return svo;
	}

	@Override
	public List<SongDateVO> findSevenDay(String day) {
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
		String sql = "select date_format(palyTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_play where palyTime<='" + da + "' and palyTime>='" + xiao + "'"
				+ "group by date_format(palyTime,'%Y-%m-%d')";
		String sql2 = "select date_format(createDateTime,'%Y-%m-%d'),count(*) "
				+ "from music_info where createDateTime<='" + da + "' and createDateTime>='" + xiao + "'"
				+ "group by date_format(createDateTime,'%Y-%m-%d')";
		List list = openSession.createSQLQuery(sql).list();
		// List list4 = openSession.createCriteria(sumSongSQL).list();
		List<SongDateVO> list2 = new ArrayList<SongDateVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			SongDateVO sdvo = new SongDateVO();
			Object[] o = (Object[]) iterator.next();
			for (int i = 0; i < o.length; i++) {
				sdvo.setClickDate(o[0].toString());
				sdvo.setSumClick(Integer.parseInt(o[1].toString()));
				sdvo.setSumClickRen(Integer.parseInt(o[2].toString()));
			}
			list2.add(sdvo);
		}
		List<SongDateVO> list3 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setSumClick(0);
			sdvo.setSumClickRen(0);
			list3.add(sdvo);
			for (SongDateVO acdvo : list2) {
				if (acdvo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(acdvo);
				}
			}
		}
		List list4 = openSession.createSQLQuery(sql2).list();
		List<SongDateVO> lis2 = new ArrayList<SongDateVO>();
		Iterator iterator2 = list4.iterator();
		while (iterator2.hasNext()) {
			SongDateVO sdvo = new SongDateVO();
			Object[] o = (Object[]) iterator2.next();
			for (int i = 0; i < o.length; i++) {
				sdvo.setClickDate(o[0].toString());
				sdvo.setNewSong(Integer.parseInt(o[1].toString()));
			}
			lis2.add(sdvo);
		}
		List<SongDateVO> list5 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setNewSong(0);
			list5.add(sdvo);
			for (SongDateVO acdvo : lis2) {
				if (acdvo.getClickDate().equals(format)) {
					list5.remove(i);
					list5.add(acdvo);
				}
			}
		}
		for (SongDateVO s3 : list3) {
			for (SongDateVO s5 : list5) {
				if (s3.getClickDate().equals(s5.getClickDate())) {
					s3.setNewSong(s5.getNewSong());
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<SongDateVO> findMon() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONDAY, -1);
		Date sevenDate = instance.getTime();
		String seven = sdf.format(sevenDate);
		Date date = new Date();
		String today = sdf.format(date);
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select date_format(palyTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_play where palyTime<='" + date + "' and palyTime>='" + seven + "'"
				+ "group by date_format(palyTime,'%Y-%m-%d') ";

		List<SongDateVO> list2 = new ArrayList<SongDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(object[0].toString());
			sdvo.setSumClick(Integer.parseInt(object[1].toString()));
			sdvo.setSumClickRen(Integer.parseInt(object[2].toString()));
			list2.add(sdvo);
		}
		List<SongDateVO> list3 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setSumClick(0);
			sdvo.setSumClickRen(0);
			list3.add(sdvo);
			for (SongDateVO sgdvo : list2) {
				if (sgdvo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(sgdvo);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public SongVO findAll(String day) {
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
		String sql = "select count(*),count(distinct userId) " + "from count_music_play " + "where palyTime<='" + da
				+ "' and palyTime>='" + xiao + "'";

		String sql2 = "select count(*) " + "from music_info " + "where createDateTime<='" + da
				+ "' and createDateTime>='" + xiao + "'";
		List list = openSession.createSQLQuery(sql).list();
		Object uniqueResult = openSession.createSQLQuery(sql2).uniqueResult();
		Iterator iterator = list.iterator();
		SongVO svo = new SongVO();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			svo.setSumClick(Integer.parseInt(o[0].toString()));
			svo.setSumClickRen(Integer.parseInt(o[1].toString()));
			svo.setNewSong(Integer.parseInt(uniqueResult.toString()));
		}
		openSession.close();
		return svo;
	}

	@Override
	public List<SongDateVO> findYesrMon(String year) {
		// TODO Auto-generated method stub
		String[] split = year.split(",");
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
		String sql = "select date_format(palyTime,'%Y-%m-%d')," + "count(*),count(distinct userId) "
				+ "from count_music_play where palyTime<='" + end + "' and palyTime>='" + start + "'"
				+ "group by date_format(palyTime,'%Y-%m-%d') ";

		List<SongDateVO> list2 = new ArrayList<SongDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(object[0].toString());
			sdvo.setSumClick(Integer.parseInt(object[1].toString()));
			sdvo.setSumClickRen(Integer.parseInt(object[2].toString()));
			list2.add(sdvo);
		}
		List<SongDateVO> list3 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setSumClick(0);
			sdvo.setSumClickRen(0);
			list3.add(sdvo);
			for (SongDateVO sgdv : list2) {
				if (sgdv.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(sgdv);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<SongDateVO> findMon2() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONDAY, -1);
		Date sevenDate = instance.getTime();
		String seven = sdf.format(sevenDate);
		Date date = new Date();
		String today = sdf.format(date);
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sumSongSQL = "select date_format(createDateTime,'%Y-%m-%d'),count(*)  "
				+ "from music_info where createDateTime<='" + date + "' and createDateTime>='" + seven + "'"
				+ "group by date_format(createDateTime,'%Y-%m-%d')";

		List<SongDateVO> list2 = new ArrayList<SongDateVO>();
		List list = openSession.createSQLQuery(sumSongSQL).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(object[0].toString());
			sdvo.setNewSong(Integer.parseInt(object[1].toString()));
			list2.add(sdvo);
		}
		List<SongDateVO> list3 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setNewSong(0);
			list3.add(sdvo);
			for (SongDateVO sgdvo : list2) {
				if (sgdvo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(sgdvo);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<SongDateVO> findYesrMon2(String year) {
		// TODO Auto-generated method stub
		String[] split = year.split(",");
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
		String sql = "select date_format(createDateTime,'%Y-%m-%d')," + "count(*) "
				+ "from music_info where createDateTime<='" + end + "' and createDateTime>='" + start + "'"
				+ "group by date_format(createDateTime,'%Y-%m-%d') ";

		List<SongDateVO> list2 = new ArrayList<SongDateVO>();
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(object[0].toString());
			sdvo.setNewSong(Integer.parseInt(object[1].toString()));
			list2.add(sdvo);
		}
		List<SongDateVO> list3 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setNewSong(0);
			list3.add(sdvo);
			for (SongDateVO sgdv : list2) {
				if (sgdv.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(sgdv);
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public List<FindMusicInfoVO> findMusicInfoVOs() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		// nin
		String sql = "SELECT musicId,count(*) AS clickCount,count(DISTINCT userId) userCount FROM count_music_play GROUP BY musicId ORDER BY clickCount DESC LIMIT 20";
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			FindMusicInfoVO fmvo = new FindMusicInfoVO();
			for (int i = 0; i < o.length; i++) {
				// fmvo.setMusicId(Integer.parseInt(o[5].toString()));
				fmvo.setClicks(Integer.parseInt(o[1].toString()));
				fmvo.setClickRens(Integer.parseInt(o[2].toString()));
				fmvo.setMusicName(String.valueOf(o[0]));
				fmvo.setPlayerName("未知");
			}
			findMusicInfoVOs.add(fmvo);
		}
		// String sql = "select b.*,m.musicName,m.playerName from "
		// + "(select musicId,count(*) as bb,count(distinct userId) "
		// + "from count_music_play group by musicId) b,music_info m " + "where
		// b.musicId=m.musicName "
		// + "order by b.bb desc limit 20";
		// List list = openSession.createSQLQuery(sql).list();
		// Iterator iterator = list.iterator();
		// List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
		// while (iterator.hasNext()) {
		// Object[] o = (Object[]) iterator.next();
		// FindMusicInfoVO fmvo = new FindMusicInfoVO();
		// for (int i = 0; i < o.length; i++) {
		// // fmvo.setMusicId(Integer.parseInt(o[5].toString()));
		// fmvo.setClicks(Integer.parseInt(o[1].toString()));
		// fmvo.setClickRens(Integer.parseInt(o[2].toString()));
		// fmvo.setMusicName(String.valueOf(o[3]));
		// if (o[4] == null || o[4].equals("")) {
		// fmvo.setPlayerName("未知");
		// } else {
		// fmvo.setPlayerName(o[4].toString());
		// }
		// }
		// findMusicInfoVOs.add(fmvo);
		// }
		openSession.close();
		return findMusicInfoVOs;
	}

	@Override
	public List<FindMusicInfoVO> findLikesMusicInfoVOs(String musiceName, String playerName, Integer page) {
		// TODO Auto-generated method stub
		if (page == null) {
			page = 0;
		}
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql3 = "";
		String sql1 = "select musicId,count(*) count,count(distinct userId) from count_music_play where 1=1";
		String sql2 = " group by musicId order by count desc limit " + page + ", 20";
		if (musiceName.equals("") && playerName.equals("")) {
			sql3 = sql1 + sql2;
		} else if (!musiceName.equals("") && playerName.equals("")) {
			sql3 = sql1 + " and musicId like '%" + musiceName + "%' " + sql2;
			// } else if (!playerName.equals("") && musiceName.equals("")) {
			// sql3 = sql1 + " and m.playerName like '%" + playerName + "%' " + sql2;
			// } else {
			// sql3 = sql1 + " and m.musicName like '%" + musiceName + "%' and m.playerName
			// like '%" + playerName + "%' "
			// + sql2;
		}
		System.out.println(sql3);
		List list = openSession.createSQLQuery(sql3).list();
		Iterator iterator = list.iterator();
		List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			FindMusicInfoVO fmvo = new FindMusicInfoVO();
			for (int i = 0; i < o.length; i++) {
				fmvo.setMusicId(null);
				fmvo.setClicks(Integer.parseInt(String.valueOf(o[1])));
				fmvo.setClickRens(Integer.parseInt(String.valueOf(o[2])));
				fmvo.setMusicName(String.valueOf(o[0]));
				fmvo.setPlayerName("未知");
			}
			findMusicInfoVOs.add(fmvo);
		}
		openSession.close();
		return findMusicInfoVOs;
	}

	@Override
	public Integer findLikesMusicInfoVOsCount(String musiceName, String playerName) {
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql3 = "";
		String sql1 = "select count(*) from " + "(select musicId,count(*) as bb,count(distinct userId) "
				+ "from count_music_play group by musicId) b,music_info m " + "where b.musicId=m.musicName ";
		String sql2 = "";
		if (musiceName.equals("") && playerName.equals("")) {
			sql3 = sql1 + sql2;
		} else if (!musiceName.equals("") && musiceName != null) {
			sql3 = sql1 + " and m.musicName like '%" + musiceName + "%' " + sql2;
		} else if (!playerName.trim().equals("") && playerName.trim() != null) {
			sql3 = sql1 + " and m.playerName like '%" + playerName + "%' " + sql2;
		} else {
			sql3 = sql1 + " and m.musicName like '%" + musiceName + "%'  and m.playerName like '%" + playerName + "%' "
					+ sql2;
		}
		Object uniqueResult = openSession.createSQLQuery(sql3).uniqueResult();
		String string = uniqueResult.toString();
		Integer result = Integer.valueOf(string);
		openSession.close();
		return result;
	}

	@Override
	public SongVO findUserCPCountMusicPlayDay(String cpId, String musicId) {
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
		// ��Ŀ����
		String sumSongSQL = null;
		String todaySQL = null;
		String clickSQL = null;
		if (cpId.trim().equals("")) {
			// sumSongSQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format2 + "' and musicId='"
			// + musicId + "'";
			// // ������Ŀ����
			// todaySQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format2
			// + "' and createDateTime>='" + format + "' and musicId='" + musicId + "'";
			// �㲥�ܴ�����������
			clickSQL = "select count(*),count(distinct userId) from count_music_play cc where cc.palyTime<= '" + format2
					+ "' and cc.palyTime>= '" + format + "' and cc.musicId='" + musicId + "'";
		} else if (musicId.trim().equals("")) {
			// sumSongSQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format2 + "' and cpId='"
			// + cpId + "'";
			// // ������Ŀ����
			// todaySQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format2
			// + "' and createDateTime>='" + format + "' and cpId='" + cpId + "'";
			// �㲥�ܴ�����������
			clickSQL = "select count(*),count(distinct userId) from count_music_play cc where cc.palyTime<='" + format2
					+ "' and cc.palyTime>= '" + format + "' ";
		} else {
			// sumSongSQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format2 + "' and cpId='"
			// + cpId + "' and musicId='" + musicId + "'";
			// // ������Ŀ����
			// todaySQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format2
			// + "' and createDateTime>='" + format + "' and cpId='" + cpId + "' and
			// musicId='" + musicId + "'";
			// �㲥�ܴ�����������
			clickSQL = "select count(*),count(distinct userId) from count_music_play cc  where cc.palyTime<= '"
					+ format2 + "' and cc.palyTime>= '" + format + "' and cc.musicId='" + musicId + "'";
		}
		// Object uniqueResult = openSession.createSQLQuery(sumSongSQL).uniqueResult();
		// Object uniqueResult2 = openSession.createSQLQuery(todaySQL).uniqueResult();
		List list3 = openSession.createSQLQuery(clickSQL).list();
		SongVO svo = new SongVO();
		Iterator iterator = list3.iterator();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			svo.setSumClick(Integer.parseInt(o[0].toString()));
			svo.setSumClickRen(Integer.parseInt(o[1].toString()));
			svo.setSumSong(0);
			svo.setNewSong(0);
			// svo.setSumSong(Integer.parseInt(uniqueResult.toString()));
			// svo.setNewSong(Integer.parseInt(uniqueResult2.toString()));
		}
		openSession.close();
		return svo;
	}

	@Override
	public SongVO findUserCPCountMusicPlayYesterday(String cpId, String musicId) {
		// TODO Auto-generated method stub
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
		String sumSongSQL = null;
		String todaySQL = null;
		String clickSQL = null;
		if (cpId.trim().equals("")) {
			// sumSongSQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format4 + "' and musicId='"
			// + musicId + "'";
			// todaySQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format4
			// + "' and createDateTime>='" + format3 + "' and musicId='" + musicId + "'";
			clickSQL = "select count(*),count(distinct userId) " + "from count_music_play cc" + " where cc.palyTime<='"
					+ format4 + "' and cc.palyTime>='" + format3 + "' " + "and cc.musicId='" + musicId + "'";
		} else if (musicId.trim().equals("")) {
			// ��Ŀ����
			// sumSongSQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format4 + "' and cpId='"
			// + cpId + "'";
			// // ������Ŀ����
			// todaySQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format4
			// + "' and createDateTime>='" + format3 + "' and cpId='" + cpId + "'";
			// �㲥�ܴ�����������
			clickSQL = "select count(*),count(distinct userId) " + "from count_music_play cc,music_info m "
					+ " where cc.palyTime<='" + format4 + "' and cc.palyTime>='" + format3 + "' "
					+ "and cc.musicId=m.musicName and m.cpId='" + cpId + "'";
		} else {
			// sumSongSQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format4 + "' and cpId='"
			// + cpId + "' and musicId='" + musicId + "'";
			// todaySQL = "select count(*) from music_info " + "where createDateTime<='" +
			// format4
			// + "' and createDateTime>='" + format3 + "' and cpId='" + cpId + "' and
			// musicId='" + musicId + "'";
			clickSQL = "select count(*),count(distinct userId) " + "from count_music_play cc,music_info m "
					+ " where cc.palyTime<='" + format4 + "' and cc.palyTime>='" + format3 + "' "
					+ "and cc.musicId=m.musicName and m.cpId='" + cpId + "' and m.musicName='" + musicId + "'";
		}

		// Object uniqueResult = openSession.createSQLQuery(sumSongSQL).uniqueResult();
		// Object uniqueResult2 = openSession.createSQLQuery(todaySQL).uniqueResult();
		List list2 = openSession.createSQLQuery(clickSQL).list();
		Iterator iterator2 = list2.iterator();
		SongVO svo = new SongVO();
		while (iterator2.hasNext()) {
			Object[] o = (Object[]) iterator2.next();
			svo.setSumClick(Integer.parseInt(o[0].toString()));
			svo.setSumClickRen(Integer.parseInt(o[1].toString()));
			svo.setSumSong(0);
			svo.setNewSong(0);
		}
		return svo;
	}

	@Override
	public List<SongDateVO> findUserCPSevenDay(String day, String cpId, String musicId) {
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
		// String sql2 = null;
		// if (cpId.trim().equals("")) {
		// sql = "select date_format(palyTime,'%Y-%m-%d'),count(*),count(distinct
		// cc.userId) "
		// + "from count_music_play cc,music_info m " + "where cc.palyTime<='" + da + "'
		// and cc.palyTime>='"
		// + xiao + "' " + "and cc.musicId=m.musicName and m.musicName='" + musicId
		// + "' group by date_format(palyTime,'%Y-%m-%d')";
		// sql2 = "select date_format(createDateTime,'%Y-%m-%d'),count(*) " + "from
		// music_info where createDateTime<='"
		// + da + "' and createDateTime>='" + xiao + "' and musicId='" + musicId + "' "
		// + "group by date_format(createDateTime,'%Y-%m-%d')";
		// } else if (musicId.trim().equals("")) {
		// sql2 = "select date_format(createDateTime,'%Y-%m-%d'),count(*) " + "from
		// music_info where createDateTime<='"
		// + da + "' and createDateTime>='" + xiao + "' and cpId='" + cpId + "' "
		// + "group by date_format(createDateTime,'%Y-%m-%d')";
		// sql = "select date_format(palyTime,'%Y-%m-%d'),count(*),count(distinct
		// cc.userId) "
		// + "from count_music_play cc,music_info m " + "where cc.palyTime<='" + da + "'
		// and cc.palyTime>='"
		// + xiao + "' " + "and cc.musicId=m.musicName and m.cpId='" + cpId
		// + "' group by date_format(palyTime,'%Y-%m-%d')";
		// } else {
		sql = "select date_format(palyTime,'%Y-%m-%d'),count(*),count(distinct cc.userId) from count_music_play cc where cc.palyTime <= '"
				+ da + "' and cc.palyTime >= '" + xiao + "' and cc.musicId='" + musicId
				+ "' group by date_format(palyTime,'%Y-%m-%d')";
		// sql2 = "select date_format(createDateTime,'%Y-%m-%d'),count(*) " + "from
		// music_info where createDateTime<='"
		// + da + "' and createDateTime>='" + xiao + "' and cpId='" + cpId + "' and
		// musicId='" + musicId + "' "
		// + "group by date_format(createDateTime,'%Y-%m-%d')";
		// }
		List list = openSession.createSQLQuery(sql).list();
		// List list4 = openSession.createCriteria(sumSongSQL).list();
		List<SongDateVO> list2 = new ArrayList<SongDateVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			SongDateVO sdvo = new SongDateVO();
			Object[] o = (Object[]) iterator.next();
			for (int i = 0; i < o.length; i++) {
				sdvo.setClickDate(o[0].toString());
				sdvo.setSumClick(Integer.parseInt(o[1].toString()));
				sdvo.setSumClickRen(Integer.parseInt(o[2].toString()));
			}
			list2.add(sdvo);
		}
		List<SongDateVO> list3 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setSumClick(0);
			sdvo.setSumClickRen(0);
			list3.add(sdvo);
			for (SongDateVO acdvo : list2) {
				if (acdvo.getClickDate().equals(format)) {
					list3.remove(i);
					list3.add(acdvo);
				}
			}
		}
		// List list4 = openSession.createSQLQuery(sql2).list();
		List<SongDateVO> lis2 = new ArrayList<SongDateVO>();
		// Iterator iterator2 = list4.iterator();
		// while (iterator2.hasNext()) {
		// SongDateVO sdvo = new SongDateVO();
		// Object[] o = (Object[]) iterator2.next();
		// for (int i = 0; i < o.length; i++) {
		// sdvo.setClickDate(o[0].toString());
		// sdvo.setNewSong(Integer.parseInt(o[1].toString()));
		// }
		// lis2.add(sdvo);
		// }
		List<SongDateVO> list5 = new ArrayList<SongDateVO>();
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
			SongDateVO sdvo = new SongDateVO();
			sdvo.setClickDate(format);
			sdvo.setNewSong(0);
			list5.add(sdvo);
			for (SongDateVO acdvo : lis2) {
				if (acdvo.getClickDate().equals(format)) {
					list5.remove(i);
					list5.add(acdvo);
				}
			}
		}
		for (SongDateVO s3 : list3) {
			for (SongDateVO s5 : list5) {
				if (s3.getClickDate().equals(s5.getClickDate())) {
					s3.setNewSong(s5.getNewSong());
				}
			}
		}
		openSession.close();
		return list3;
	}

	@Override
	public SongVO findUserCPAll(String day, String cpId, String musicId) {
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
		String sql2 = null;
		// if (cpId.trim().equals("")) {
		// sql = "select count(*),count(distinct cc.userId) " + "from count_music_play
		// cc,music_info m "
		// + "where cc.palyTime<='" + da + "' and cc.palyTime>='" + xiao + "' "
		// + "and cc.musicId=m.musicName and m.musicName='" + musicId + "'";
		// sql2 = "select count(*) " + "from music_info " + "where createDateTime<='" +
		// da + "' and createDateTime>='"
		// + xiao + "' and musicId='" + musicId + "'";
		// } else if (musicId.trim().equals("")) {
		// sql = "select count(*),count(distinct cc.userId) " + "from count_music_play
		// cc,music_info m "
		// + "where cc.palyTime<='" + da + "' and cc.palyTime>='" + xiao + "' "
		// + "and cc.musicId=m.musicName and m.cpId='" + cpId + "'";
		// sql2 = "select count(*) " + "from music_info " + "where createDateTime<='" +
		// da + "' and createDateTime>='"
		// + xiao + "' and cpId='" + cpId + "'";
		// } else {
		// sql = "select count(*),count(distinct cc.userId) " + "from count_music_play
		// cc,music_info m "
		// + "where cc.palyTime<='" + da + "' and cc.palyTime>='" + xiao + "' "
		// + "and cc.musicId=m.musicName and m.cpId='" + cpId + "' and m.musicName='" +
		// musicId + "'";
		// sql2 = "select count(*) " + "from music_info " + "where createDateTime<='" +
		// da + "' and createDateTime>='"
		// + xiao + "' and cpId='" + cpId + "' and musicId='" + musicId + "'";
		// }
		sql = "select count(*),count(distinct cc.userId) from count_music_play cc where cc.palyTime<='" + da
				+ "' and cc.palyTime >='" + xiao + "' " + " and cc.musicId='" + musicId + "'";
		List list = openSession.createSQLQuery(sql).list();
		// Object uniqueResult = openSession.createSQLQuery(sql2).uniqueResult();
		Iterator iterator = list.iterator();
		SongVO svo = new SongVO();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			svo.setSumClick(Integer.parseInt(o[0].toString()));
			svo.setSumClickRen(Integer.parseInt(o[1].toString()));
			svo.setNewSong(0);
		}
		openSession.close();
		return svo;
	}

	@Override
	public List<FindMusicInfoVO> findUserCPMusicInfoVOs(String cpId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		// String sql = "select b.*,m.musicName,m.playerName from "
		// + "(select musicId,count(*) as bb,count(distinct userId) "
		// + "from count_music_play group by musicId) b,music_info m " + "where
		// b.musicId=m.musicName and m.cpId='"
		// + cpId + "' " + "order by b.bb desc limit 20";
		// List list = openSession.createSQLQuery(sql).list();
		// Iterator iterator = list.iterator();
		// List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
		// while (iterator.hasNext()) {
		// Object[] o = (Object[]) iterator.next();
		// FindMusicInfoVO fmvo = new FindMusicInfoVO();
		// for (int i = 0; i < o.length; i++) {
		// fmvo.setMusicId(Integer.parseInt(o[0].toString()));
		// fmvo.setClicks(Integer.parseInt(o[1].toString()));
		// fmvo.setClickRens(Integer.parseInt(o[2].toString()));
		// fmvo.setMusicName(o[3].toString());
		// try {
		// fmvo.setPlayerName(o[4].toString());
		// } catch (Exception e) {
		// // TODO: handle exception
		// fmvo.setPlayerName("未知");
		// }
		// }
		// findMusicInfoVOs.add(fmvo);
		// }
		String sql = "SELECT musicId,count(*) AS clickCount,count(DISTINCT userId) userCount FROM count_music_play GROUP BY musicId ORDER BY clickCount DESC LIMIT 20";
		List list = openSession.createSQLQuery(sql).list();
		Iterator iterator = list.iterator();
		List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			FindMusicInfoVO fmvo = new FindMusicInfoVO();
			for (int i = 0; i < o.length; i++) {
				// fmvo.setMusicId(Integer.parseInt(o[5].toString()));
				fmvo.setClicks(Integer.parseInt(o[1].toString()));
				fmvo.setClickRens(Integer.parseInt(o[2].toString()));
				fmvo.setMusicName(String.valueOf(o[0]));
				fmvo.setPlayerName("未知");
			}
			findMusicInfoVOs.add(fmvo);
		}
		openSession.close();
		return findMusicInfoVOs;
	}

	@Override
	public List<FindMusicInfoVO> findUserCPLikesMusicInfoVOs(String musiceName, String playerName, String cpId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql3 = "";
		String sql1 = "select b.*,m.musicName,m.playerName from "
				+ "(select musicId,count(*) as bb,count(distinct userId) "
				+ "from count_music_play group by musicId) b,music_info m " + "where b.musicId=m.musicName and m.cpId='"
				+ cpId + "' ";
		String sql2 = " order by b.bb desc limit 20";
		if (musiceName.trim().equals("") && playerName.trim().equals("")) {
			sql3 = sql1 + sql2;
		} else if (!musiceName.trim().equals("") && musiceName.trim() != null) {
			sql3 = sql1 + " and m.musicName like '%" + musiceName + "%' " + sql2;
		} else if (playerName.trim() != null && !playerName.trim().equals("")) {
			sql3 = sql1 + " and m.playerName like '%" + playerName + "%' " + sql2;
		} else {
			sql3 = sql1 + " and m.musicName like '%" + musiceName + "%'  and m.playerName like '%" + playerName + "%' "
					+ sql2;
		}
		List list = openSession.createSQLQuery(sql3).list();
		Iterator iterator = list.iterator();
		List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
		while (iterator.hasNext()) {
			Object[] o = (Object[]) iterator.next();
			FindMusicInfoVO fmvo = new FindMusicInfoVO();
			for (int i = 0; i < o.length; i++) {
				fmvo.setMusicId(Integer.parseInt(o[0].toString()));
				fmvo.setClicks(Integer.parseInt(o[1].toString()));
				fmvo.setClickRens(Integer.parseInt(o[2].toString()));
				fmvo.setMusicName(o[3].toString());
				try {
					fmvo.setPlayerName(o[4].toString());
				} catch (Exception e) {
					// TODO: handle exception
					fmvo.setPlayerName("未知");
				}
			}
			findMusicInfoVOs.add(fmvo);
		}
		openSession.close();
		return findMusicInfoVOs;
	}

	@Override
	public List<CPShouRuVO> findObjects(String day, Integer yu) {
		String da = null;
		String xiao = null;
		System.out.println("day:" + day);
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
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String zsql = null;
		if (day.equals("0")) {
			/*
			 * zsql = "select count(*) from count_music_play c , music_info m " +
			 * "where c.musicId=m.musicId";
			 */
			zsql = "select sum(q.md) from (select date_format(c.palyTime,'%Y-%m-%d') ,count(c.musicId) as md "
					+ "from count_music_play c group by c.palyTime having md>" + yu + ") as q";
		} else {
			/*
			 * zsql = "select count(*) from count_music_play c , music_info m " +
			 * "where c.musicId=m.musicId and c.palyTime<='"+da+"' and c.palyTime>='"+xiao+
			 * "'";
			 */
			zsql = "select sum(q.md) from (select date_format(c.palyTime,'%Y-%m-%d') ,count(c.musicId) as md"
					+ " from count_music_play c where  c.palyTime between '" + xiao + "' and '" + da + "'"
					+ " group by c.palyTime having md>" + yu + ") as q ";
		}
		Object uniqueResult = openSession.createSQLQuery(zsql).uniqueResult();
		List<CPShouRuVO> arr = new ArrayList<CPShouRuVO>();
		List<MusicCp> findAll = this.findAll();
		for (int i = 0; i < findAll.size(); i++) {
			CPShouRuVO cpVo = new CPShouRuVO();
			String sqlString = null;
			if (day.equals("0")) {
				/*
				 * sqlString = "select count(*) from count_music_play c , music_info m " +
				 * "where c.musicId=m.musicId and m.cpId='"+findAll.get(i).getCpId()+"'";
				 */
				sqlString = "select sum(q.md) from (select date_format(c.palyTime,'%Y-%m-%d') ,count(c.musicId) as md"
						+ " from count_music_play c ,music_info m where m.musicName=c.musicId and m.cpId='"
						+ findAll.get(i).getCpId() + "'" + " group by c.palyTime having md>" + yu + ") as q ";
			} else {
				/*
				 * sqlString = "select count(*) from count_music_play c , music_info m " +
				 * "where c.musicId=m.musicId and c.palyTime<='"+da+"' and c.palyTime>='"
				 * +xiao+"' " + " and m.cpId='"+findAll.get(i).getCpId()+"'";
				 */
				sqlString = "select sum(q.md) from (select date_format(c.palyTime,'%Y-%m-%d') ,count(c.musicId) as md"
						+ " from count_music_play c,music_info m where m.musicName=c.musicId and m.cpId='"
						+ findAll.get(i).getCpId() + "'" + " and c.palyTime between '" + xiao + "' and '" + da + "'"
						+ " group by c.palyTime having md>" + yu + ") as q ";
			}
			Object uniqueResult2 = openSession.createSQLQuery(sqlString).uniqueResult();
			if (uniqueResult2 == null) {
				uniqueResult2 = "0";
			}
			Double a = Double.valueOf(String.valueOf(uniqueResult));
			Double b = Double.valueOf(String.valueOf(uniqueResult2));
			Double c = b / a * 100;
			if (Double.isNaN(c)) {
				cpVo.setTotl("0%");
			} else {
				DecimalFormat decimalFormat = new DecimalFormat("###0.00");
				String format5 = decimalFormat.format(c);
				String f = format5 + "%";
				cpVo.setTotl(f);
			}
			cpVo.setJin(Integer.parseInt(String.valueOf(uniqueResult2)));
			cpVo.setCpId(findAll.get(i).getCpId());
			cpVo.setCpName(findAll.get(i).getCpName());
			arr.add(cpVo);
		}
		// List list4 = openSession.createCriteria(sumSongSQL).list();
		return arr;
	}

	@Override
	public List<MusicCp> findAll() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_cp";
		List<MusicCp> list = openSession.createSQLQuery(sql).addEntity(MusicCp.class).list();
		openSession.close();
		return list;
	}

	@Override
	public String findZBY(String day, Integer yu) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String da = null;
		String xiao = null;
		System.out.println("day:" + day);
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
		/*
		 * String zsql = "select count(*) from count_music_play c , music_info m " +
		 * "where c.musicId=m.musicId ";
		 */
		String zsql = "";
		if (day.equals("0")) {
			zsql = "select sum(q.md) from (select date_format(c.palyTime,'%Y-%m-%d') ,count(c.musicId) as md"
					+ " from count_music_play c" + " group by c.palyTime having md>" + yu + ") as q";
		} else {
			zsql = "select sum(q.md) from (select date_format(c.palyTime,'%Y-%m-%d') ,count(c.musicId) as md"
					+ " from count_music_play c where c.palyTime between '" + xiao + "' and '" + da + "'"
					+ " group by c.palyTime having md>" + yu + ") as q";
		}
		System.out.println(zsql);
		Object uniqueResult = openSession.createSQLQuery(zsql).uniqueResult();
		return String.valueOf(uniqueResult);
	}
}
