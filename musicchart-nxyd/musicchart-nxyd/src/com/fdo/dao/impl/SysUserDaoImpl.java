package com.fdo.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdo.dao.SysUserDao;
import com.fdo.hum.MusicCp;
import com.fdo.hum.SysUser;
import com.fdo.vo.UserInfoVO;

public class SysUserDaoImpl extends HibernateDaoSupport implements SysUserDao {

	@Override
	public SysUser findLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from sys_user where loginName='" + name + "' and password='" + pwd + "'";
		SysUser uniqueResult = null;
		try {
			uniqueResult = (SysUser) openSession.createSQLQuery(sql).addEntity(SysUser.class).uniqueResult();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uniqueResult;
	}

	@Override
	public void addUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		String sql = "insert into sys_user(userName,loginName,password,orgId,userType,userDesc,userSex,birth,status,createDateTime,modifyDateTime,cpId) values('"
				+ sysUser.getUserName() + "','" + sysUser.getLoginName() + "','" + sysUser.getPassword() + "','"
				+ sysUser.getCpId() + "','3','" + sysUser.getUserDesc() + "','" + sysUser.getUserSex() + "','"
				+ sysUser.getBirth() + "','0',now(),now(),'" + sysUser.getCpId() + "')";
		openSession.createSQLQuery(sql).addEntity(SysUser.class).executeUpdate();
		beginTransaction.commit();
		openSession.close();
	}

	@Override
	public void updateUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "update sys_user set userName='" + sysUser.getUserName() + "',password='" + sysUser.getPassword()
				+ "',loginName='" + sysUser.getLoginName() + "',orgId='" + sysUser.getOrgId() + "',cpId='"
				+ sysUser.getCpId() + "',modifyDateTime='" + sysUser.getModifyDateTime() + "',birth='"
				+ sysUser.getBirth() + "',userSex='" + sysUser.getUserSex() + "',userDesc='" + sysUser.getUserDesc()
				+ "' where userId='" + sysUser.getUserId() + "'";
		Transaction beginTransaction = openSession.beginTransaction();
		System.out.println(sql);
		openSession.createSQLQuery(sql).addEntity(SysUser.class).executeUpdate();
		beginTransaction.commit();
		openSession.close();
	}

	@Override
	public void deleUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "delete from sys_user where userId='" + sysUser.getUserId() + "'";
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.createSQLQuery(sql).addEntity(SysUser.class).executeUpdate();
		beginTransaction.commit();
		openSession.close();
	}

	@Override
	public List<UserInfoVO> findAllUserInfo() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select s.userName,s.loginName,m.cpid,m.cpName,s.modifyDateTime,s.userId "
				+ "from sys_user s,music_cp m  where s.userType='3' and s.cpid= m.cpid  order by s.createDateTime desc";
		List list2 = openSession.createSQLQuery(sql).list();
		Iterator iterator = list2.iterator();
		List<UserInfoVO> list = new ArrayList<UserInfoVO>();
		while (iterator.hasNext()) {
			Object[] object = (Object[]) iterator.next();
			UserInfoVO users = new UserInfoVO();
			for (int i = 0; i < object.length; i++) {
				users.setUserName(object[0].toString());
				users.setLoginName(object[1].toString());
				users.setCpId(object[2].toString());
				users.setCpName(object[3].toString());
				users.setDate(object[4].toString());
				users.setUserId(Integer.parseInt(object[5].toString()));
			}
			list.add(users);
		}
		openSession.close();
		return list;
	}

	@Override
	public List<MusicCp> findAllCP() {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from music_cp order by id";
		List<MusicCp> list = openSession.createSQLQuery(sql).addEntity(MusicCp.class).list();
		openSession.close();
		return list;
	}

	@Override
	public UserInfoVO findUserId(String userId) {
		// TODO Auto-generated method stub
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from sys_user where userId = '" + userId + "'";
		List list = openSession.createSQLQuery(sql).list();
		List<UserInfoVO> infoVOs = new ArrayList<UserInfoVO>();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			UserInfoVO uVo = new UserInfoVO();
			Object[] object = (Object[]) iterator.next();
			for (int i = 0; i < object.length; i++) {

			}
		}
		openSession.close();
		return null;
	}

	@Override
	public SysUser findSysUser(String userId) {
		Session openSession = this.getHibernateTemplate().getSessionFactory().openSession();
		String sql = "select * from sys_user where userId = '" + userId + "'";
		SysUser uniqueResult = (SysUser) openSession.createSQLQuery(sql).addEntity(SysUser.class).uniqueResult();
		return uniqueResult;
	}
}
