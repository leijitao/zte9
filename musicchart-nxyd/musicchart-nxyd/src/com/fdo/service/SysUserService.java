package com.fdo.service;

import java.util.List;

import com.fdo.hum.MusicCp;
import com.fdo.hum.SysUser;
import com.fdo.vo.UserInfoVO;

public interface SysUserService {

	public SysUser findLogin(String name,String pwd);
	
	public void addUserInfo(SysUser sysUser);		//新增用户
	
	public void updateUserInfo(SysUser sysUser);	//修改
	
	public void deleUserInfo(SysUser sysUser);		//删除
	
	public List<UserInfoVO> findAllUserInfo();		//查找所有
	
	public List<MusicCp> findAllCP();		//查找所有cp
	
	public UserInfoVO findUserId(String userId); 	//查找用户对象
	
	public SysUser findSysUser(String userId);
}
