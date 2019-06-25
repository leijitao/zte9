package com.fdo.service.impl;

import java.util.List;

import com.fdo.dao.SysUserDao;
import com.fdo.hum.MusicCp;
import com.fdo.hum.SysUser;
import com.fdo.service.SysUserService;
import com.fdo.vo.UserInfoVO;

public class SysUserServiceImpl implements SysUserService {

	private SysUserDao sysUserDao;
	
	public SysUserDao getSysUserDao() {
		return sysUserDao;
	}
	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	@Override
	public SysUser findLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		return sysUserDao.findLogin(name, pwd);
	}
	@Override
	public void addUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.addUserInfo(sysUser);
	}
	@Override
	public void updateUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.updateUserInfo(sysUser);
	}
	@Override
	public void deleUserInfo(SysUser sysUser) {
		// TODO Auto-generated method stub
		sysUserDao.deleUserInfo(sysUser);
	}
	@Override
	public List<UserInfoVO> findAllUserInfo() {
		// TODO Auto-generated method stub
		return sysUserDao.findAllUserInfo();
	}
	@Override
	public List<MusicCp> findAllCP() {
		// TODO Auto-generated method stub
		return sysUserDao.findAllCP();
	}
	@Override
	public UserInfoVO findUserId(String userId) {
		// TODO Auto-generated method stub
		return sysUserDao.findUserId(userId);
	}
	@Override
	public SysUser findSysUser(String userId) {
		// TODO Auto-generated method stub
		return sysUserDao.findSysUser(userId);
	}

}
