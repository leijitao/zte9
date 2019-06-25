package com.fdo.dao.impl;

import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdo.dao.MuSicTypeDao;
import com.fdo.hum.MusicType;

public class MuSicTypeDaoImpl extends HibernateDaoSupport implements MuSicTypeDao {

	@Override
	public List<MusicType> findClass() {

		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_type where type='1' order by id asc";
		List<MusicType> list = openSession.createSQLQuery(sql).addEntity(MusicType.class).list();
		openSession.close();
		return list;

	}

	@Override
	public MusicType findObjectClass(String id) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_type where type='1' and id = '" + id + "' order by id asc";
		MusicType uniqueResult = (MusicType) openSession.createSQLQuery(sql).addEntity(MusicType.class).uniqueResult();
		openSession.close();
		return uniqueResult;
	}

	@Override
	public List<MusicType> findBigClass() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_type where type='1' order by id asc";
		List<MusicType> list = openSession.createSQLQuery(sql).addEntity(MusicType.class).list();
		openSession.close();
		return list;
	}

	@Override
	public List<MusicType> findSmaClass(String code) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_type where pCode='" + code + "' order by id asc";
		List<MusicType> list = openSession.createSQLQuery(sql).addEntity(MusicType.class).list();
		openSession.close();
		return list;
	}

	@Override
	public MusicType findTypeCode(String typeId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_type where typeCode='" + typeId + "'";
		MusicType uniqueResult = (MusicType) openSession.createSQLQuery(sql).addEntity(MusicType.class).uniqueResult();
		openSession.close();
		return uniqueResult;
	}

}
