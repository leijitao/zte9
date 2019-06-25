package com.fdo.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fdo.hum.MonthlyMusicCategory;
import com.fdo.hum.MonthlyType;
import com.fdo.hum.MusicCp;
import com.fdo.hum.MusicType;
import com.fdo.hum.SysUser;
import com.fdo.service.CountBillMonthService;
import com.fdo.service.MuSicTypeService;
import com.fdo.service.SysUserService;
import com.fdo.vo.UserInfoVO;
import com.opensymphony.xwork2.ActionContext;

public class LoginUserAction {

	private static Logger logger = Logger.getLogger(LoginUserAction.class);

	private MuSicTypeService muSicTypeService;
	private CountBillMonthService countBillMonthService;
	private SysUserService sysUserService;
	private List<MusicType> musicTypes = new ArrayList<MusicType>();
	private List<MusicType> smallClass = new ArrayList<MusicType>();
	private List<MusicCp> findAllCP = new ArrayList<MusicCp>();
	private List<UserInfoVO> uivoInfoVOs = new ArrayList<UserInfoVO>();
	private List<MonthlyMusicCategory> categories = new ArrayList<MonthlyMusicCategory>();
	private List<MonthlyType> monthlyTypes = new ArrayList<MonthlyType>();
	private Map<MusicType, List<MusicType>> map2 = new LinkedHashMap<MusicType, List<MusicType>>();
	private SysUser sysUser;
	private List<MonthlyMusicCategory> category = new ArrayList<MonthlyMusicCategory>();
	private String code;
	private String userName; // 登录名
	private String pwd; // 登录密码
	private String sex; // 性别
	private Map<String, Object> session = ActionContext.getContext().getSession();

	public List<MonthlyMusicCategory> getCategory() {
		return category;
	}

	public void setCategory(List<MonthlyMusicCategory> category) {
		this.category = category;
	}

	public List<UserInfoVO> getUivoInfoVOs() {
		return uivoInfoVOs;
	}

	public void setUivoInfoVOs(List<UserInfoVO> uivoInfoVOs) {
		this.uivoInfoVOs = uivoInfoVOs;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public List<MusicCp> getFindAllCP() {
		return findAllCP;
	}

	public void setFindAllCP(List<MusicCp> findAllCP) {
		this.findAllCP = findAllCP;
	}

	public List<MonthlyType> getMonthlyTypes() {
		return monthlyTypes;
	}

	public void setMonthlyTypes(List<MonthlyType> monthlyTypes) {
		this.monthlyTypes = monthlyTypes;
	}

	public List<MonthlyMusicCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<MonthlyMusicCategory> categories) {
		this.categories = categories;
	}

	public CountBillMonthService getCountBillMonthService() {
		return countBillMonthService;
	}

	public void setCountBillMonthService(CountBillMonthService countBillMonthService) {
		this.countBillMonthService = countBillMonthService;
	}

	public Map<MusicType, List<MusicType>> getMap2() {
		return map2;
	}

	public void setMap2(Map<MusicType, List<MusicType>> map2) {
		this.map2 = map2;
	}

	public List<MusicType> getSmallClass() {
		return smallClass;
	}

	public void setSmallClass(List<MusicType> smallClass) {
		this.smallClass = smallClass;
	}

	public MuSicTypeService getMuSicTypeService() {
		return muSicTypeService;
	}

	public void setMuSicTypeService(MuSicTypeService muSicTypeService) {
		this.muSicTypeService = muSicTypeService;
	}

	public List<MusicType> getMusicTypes() {
		return musicTypes;
	}

	public void setMusicTypes(List<MusicType> musicTypes) {
		this.musicTypes = musicTypes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * login
	 * @param fdoUserInfo
	 */
	/* login */
	public String loginUser() {
		sysUser = sysUserService.findLogin(userName, pwd);
		Object a = session.get("numrand");
		if (sysUser == null || !String.valueOf(a).equals(code)) {
			return "error";
		} else {
			session.put("user", sysUser);
			// 管理员登录
			if (sysUser.getUserType() == 0) {
				List<MusicType> findBigClass = muSicTypeService.findBigClass();
				for (MusicType musicType : findBigClass) {
					List<MusicType> findSmaClass = muSicTypeService.findSmaClass(musicType.getTypeCode());
					map2.put(musicType, findSmaClass);
				}
				categories = countBillMonthService.findClassAll();
				monthlyTypes = countBillMonthService.findSamllclassAll();
				return "success";
			} else if (sysUser.getUserType() == 1) {
				return "success";
			} else if (sysUser.getUserType() == 2) {
				return "success";
				// 内容运营商登录
			} else if (sysUser.getUserType() == 3) {
				List<MusicType> findBigClass = muSicTypeService.findBigClass();
				for (MusicType musicType : findBigClass) {
					List<MusicType> findSmaClass = muSicTypeService.findSmaClass(musicType.getTypeCode());
					map2.put(musicType, findSmaClass);
				}
				category = countBillMonthService.findBaoYue(sysUser.getCpId());
				monthlyTypes = countBillMonthService.findSamllclassAll();
				return "cplogin";
			} else {
				return "cplogin";
			}
		}
	}

	/**
	 * CP管理主页面
	 * @return
	 */
	public String newUser() {
		findAllCP = sysUserService.findAllCP();
		uivoInfoVOs = sysUserService.findAllUserInfo();
		return "success";
	}

	/**
	 * 新建用户
	 * @return
	 */
	public String newUserInfo() {
		sysUser.setUserSex(Short.parseShort(sex));
		sysUser.setUserType(Short.parseShort("3"));
		sysUser.setModifyDateTime(new Timestamp(new Date().getTime()));
		sysUser.setCreateDateTime(new Timestamp(new Date().getTime()));
		sysUserService.addUserInfo(sysUser);
		return "success";
	}

	/**
	 * 删除用户
	 * @return
	 */
	public String deleteUserInfo() {
		sysUserService.deleUserInfo(sysUser);
		return "success";
	}

	/**
	 * 查找用户id修改用户
	 * @return
	 */
	public String updateUserInfo() {
		findAllCP = sysUserService.findAllCP();
		sysUser = sysUserService.findSysUser(sysUser.getUserId().toString());
		return "success";
	}

	/**
	 * 修改用户
	 * @return
	 */
	public String updateUsers() {
		System.out.println(sysUser.getUserId());
		SysUser findSysUser = sysUserService.findSysUser(sysUser.getUserId().toString());
		findSysUser.setModifyDateTime(new Timestamp(new Date().getTime()));
		findSysUser.setBirth(sysUser.getBirth());
		findSysUser.setUserName(sysUser.getUserName());
		findSysUser.setPassword(sysUser.getPassword());
		findSysUser.setLoginName(sysUser.getLoginName());
		findSysUser.setUserSex(Short.parseShort(sex));
		findSysUser.setOrgId(sysUser.getOrgId());
		findSysUser.setCpId(sysUser.getCpId());
		findSysUser.setUserDesc(sysUser.getUserDesc());
		sysUserService.updateUserInfo(findSysUser);
		return "success";
	}
}
