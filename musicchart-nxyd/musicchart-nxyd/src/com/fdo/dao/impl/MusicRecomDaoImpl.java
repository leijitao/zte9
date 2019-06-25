package com.fdo.dao.impl;

import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdo.dao.MusicRecomDao;
import com.fdo.hum.MusicRecom;

public class MusicRecomDaoImpl extends HibernateDaoSupport implements MusicRecomDao {

	@Override
	public List<MusicRecom> findSmallClass(String code) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_recom where typeCode='"+code+"'";
		List<MusicRecom> list = openSession.createSQLQuery(sql).addEntity(MusicRecom.class).list();
		openSession.close();
		return list;
	}

}
