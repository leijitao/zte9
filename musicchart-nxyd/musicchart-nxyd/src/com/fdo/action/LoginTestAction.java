package com.fdo.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fdo.service.CountMusicRecService;
import com.fdo.vo.ClickDateVO;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LoginTestAction {

	private CountMusicRecService countMusicRecService;
	private JSONArray result = new JSONArray();
	private Map<String,Object> session = ActionContext.getContext().getSession();
	private String code;
	private String mub;
	private String zcode;		//分总 
	
	public String getZcode() {
		return zcode;
	}
	public void setZcode(String zcode) {
		this.zcode = zcode;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getMub() {
		return mub;
	}
	public void setMub(String mub) {
		this.mub = mub;
	}
	public CountMusicRecService getCountMusicRecService() {
		return countMusicRecService;
	}
	public void setCountMusicRecService(CountMusicRecService countMusicRecService) {
		this.countMusicRecService = countMusicRecService;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public JSONArray getResult() {
		return result;
	}
	public void setResult(JSONArray result) {
		this.result = result;
	}

	public String test(){
		session.put("riqi", mub);
		if (code.equals("")) {
			code="0";
		}
		session.put("bianhao", code);
		List<ClickDateVO> findSevenDay = countMusicRecService.findSevenDay(mub,code);
		for (ClickDateVO clickDateVO : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", clickDateVO.getClickDate());
			jObject.put("data", clickDateVO.getClicks());
			jObject.put("data2", clickDateVO.getClickRen());
			result.add(jObject);
		}
		return "success";
	}
}
