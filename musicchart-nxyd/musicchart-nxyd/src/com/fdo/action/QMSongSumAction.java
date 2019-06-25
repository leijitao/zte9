package com.fdo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fdo.hum.SysUser;
import com.fdo.service.CountMusicPlayService;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.FindMusicInfoVO;
import com.fdo.vo.SongDateVO;
import com.fdo.vo.SongVO;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class QMSongSumAction {

	private CountMusicPlayService countMusicPlayService;
	private List<SongDateVO> dateVOs = new ArrayList<SongDateVO>();
	private List<SongDateVO> yearMonDateVOs = new ArrayList<SongDateVO>();
	private List<FindMusicInfoVO> findMusicInfoVOs = new ArrayList<FindMusicInfoVO>();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private JSONArray result = new JSONArray();
	private SongVO todayList = new SongVO();
	private SongVO yesterdayList = new SongVO();
	private SongVO songVO = new SongVO();
	private SysUser sysUser;
	private String day;
	private String yesrMon;
	private String musiceName; // 曲目名
	private String playerName; // 演唱者
	private String cpId; // CPID
	private String musicId; // 曲目id
	private InputStream image;
	private String filename;
	private Integer page;
	private Integer count;
	private Integer pa;
	private Integer pg;
	private Integer yu;

	public Integer getYu() {
		return yu;
	}

	public void setYu(Integer yu) {
		this.yu = yu;
	}

	public Integer getPg() {
		return pg;
	}

	public void setPg(Integer pg) {
		this.pg = pg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPa() {
		return pa;
	}

	public void setPa(Integer pa) {
		this.pa = pa;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getMusicId() {
		return musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMusiceName() {
		return musiceName;
	}

	public void setMusiceName(String musiceName) {
		this.musiceName = musiceName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<FindMusicInfoVO> getFindMusicInfoVOs() {
		return findMusicInfoVOs;
	}

	public void setFindMusicInfoVOs(List<FindMusicInfoVO> findMusicInfoVOs) {
		this.findMusicInfoVOs = findMusicInfoVOs;
	}

	public SongVO getSongVO() {
		return songVO;
	}

	public void setSongVO(SongVO songVO) {
		this.songVO = songVO;
	}

	public List<SongDateVO> getYearMonDateVOs() {
		return yearMonDateVOs;
	}

	public void setYearMonDateVOs(List<SongDateVO> yearMonDateVOs) {
		this.yearMonDateVOs = yearMonDateVOs;
	}

	public String getYesrMon() {
		return yesrMon;
	}

	public void setYesrMon(String yesrMon) {
		this.yesrMon = yesrMon;
	}

	public List<SongDateVO> getDateVOs() {
		return dateVOs;
	}

	public void setDateVOs(List<SongDateVO> dateVOs) {
		this.dateVOs = dateVOs;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public CountMusicPlayService getCountMusicPlayService() {
		return countMusicPlayService;
	}

	public void setCountMusicPlayService(CountMusicPlayService countMusicPlayService) {
		this.countMusicPlayService = countMusicPlayService;
	}

	public SongVO getTodayList() {
		return todayList;
	}

	public void setTodayList(SongVO todayList) {
		this.todayList = todayList;
	}

	public SongVO getYesterdayList() {
		return yesterdayList;
	}

	public void setYesterdayList(SongVO yesterdayList) {
		this.yesterdayList = yesterdayList;
	}

	/**
	 * 曲目首页
	 * @return
	 */
	public String zhuye() {
		// 宁夏移动歌曲数据库由运营商维护，我们无法获取信息，所以music_info表里的数据无效
		todayList.setNewSong(0);
		todayList.setSumSong(0);
		todayList = countMusicPlayService.findCountMusicPlayDay();
		yesterdayList = countMusicPlayService.findCountMusicPlayYesterday();

		/*
		 * dateVOs = countMusicPlayService.findMon(); List<SongDateVO> findMon2 =
		 * countMusicPlayService.findMon2(); for (SongDateVO s1 : dateVOs) { for
		 * (SongDateVO s2 : findMon2) { if(s1.getClickDate().equals(s2.getClickDate())){
		 * s1.setNewSong(s2.getNewSong()); } } } songVO =
		 * countMusicPlayService.findAll();
		 */
		return "success";
	}

	/**
	 * 曲目统计图表
	 * @return
	 */
	public String qumutongji() {
		session.put("riqi", day);
		List<SongDateVO> findSevenDay = countMusicPlayService.findSevenDay(day);
		for (SongDateVO s1 : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", s1.getClickDate());
			jObject.put("data", s1.getNewSong());
			jObject.put("data2", s1.getSumClick());
			jObject.put("data3", s1.getSumClickRen());
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * 曲目统计饼图导出
	 * @return
	 */
	public String qmbtExcel() {
		Object object = session.get("riqi");
		String string = object.toString();
		Object yu = session.get("yu");
		Integer valueOf = Integer.valueOf(yu.toString());
		List<CPShouRuVO> findObjects = countMusicPlayService.findObjects(string, valueOf);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("曲目点击量占比统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("CPID");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("CP名称");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点击量");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("点击占比");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findObjects.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findObjects.get(i).getCpId());
			row.createCell(1).setCellValue(findObjects.get(i).getCpName());
			row.createCell(2).setCellValue(findObjects.get(i).getJin());
			row.createCell(3).setCellValue(findObjects.get(i).getTotl());
		}
		/**
		 * 保存文件
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		try {
			OutputStream outputStream = new FileOutputStream(f1);
			wb.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
		}
		// 下载
		filename = format + ".xls";
		try {
			image = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dele
		File f = new File(f1);
		f.delete();
		return "success";
	}

	/**
	 * 曲目明细导出
	 * @return
	 */
	public String qmExcel() {
		Object object = session.get("riqi");
		String string = object.toString();
		List<SongDateVO> findSevenDay = countMusicPlayService.findSevenDay(string);
		SongVO findAll = countMusicPlayService.findAll(string);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("曲目明细统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("日期");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("点播次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点播人数");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("新增曲目");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getSumClick());
			row.createCell(2).setCellValue(findSevenDay.get(i).getSumClickRen());
			row.createCell(3).setCellValue(findSevenDay.get(i).getNewSong());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("点播总次数:" + findAll.getSumClick());
		row.createCell(1).setCellValue("点播总人数:" + findAll.getSumClickRen());
		row.createCell(2).setCellValue("新增曲目数:" + findAll.getNewSong());
		/**
		 * 保存文件
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		try {
			OutputStream outputStream = new FileOutputStream(f1);
			wb.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
		}
		// 下载
		filename = format + ".xls";
		try {
			image = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dele
		File f = new File(f1);
		f.delete();
		return "success";
	}

	/**
	 * 曲目明细
	 * @return
	 */
	/*
	 * public String mingxi(){ yearMonDateVOs =
	 * countMusicPlayService.findYesrMon(yesrMon); List<SongDateVO> findYesrMon2 =
	 * countMusicPlayService.findYesrMon2(yesrMon); for (SongDateVO s1 :
	 * yearMonDateVOs) { for (SongDateVO s2 : findYesrMon2) {
	 * if(s1.getClickDate().equals(s2.getClickDate())){
	 * s1.setNewSong(s2.getNewSong()); } } } return "success"; }
	 */
	/**
	 * 明细总计
	 * @return
	 */
	public String qmAssAll() {
		songVO = countMusicPlayService.findAll(day);
		return "success";
	}

	/**
	 * 查看前20首歌曲
	 * @return
	 */
	public String findMusic() {
		page = 0;
		findMusicInfoVOs = countMusicPlayService.findMusicInfoVOs();
		count = countMusicPlayService.findLikesMusicInfoVOsCount("", "");
		count = count / 20 * 20;
		/*
		 * if(findLikesMusicInfoVOsCount%20>0){ count = findLikesMusicInfoVOsCount/20+1;
		 * }else { count = findLikesMusicInfoVOsCount/20; };
		 */
		pg = page / 20 + 1;
		pa = count / 20 + 1;
		musiceName = "";
		playerName = "";
		session.put("musiceName", musiceName);
		session.put("playerName", playerName);
		return "success";
	}

	/**
	 * 查找曲目
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String findMusicName() throws UnsupportedEncodingException {
		System.out.println(musiceName + "," + playerName);
		String mName = null;
		String pName = null;
		if (musiceName.equals("")) {
			mName = session.get("musiceName").toString();
		} else {
			mName = musiceName;
		}
		if (playerName.equals("")) {
			pName = session.get("playerName").toString();
		} else {
			pName = playerName;
		}
		session.put("musiceName", musiceName);
		session.put("playerName", playerName);
		System.out.println(mName + "m,p" + pName);
		findMusicInfoVOs = countMusicPlayService.findLikesMusicInfoVOs(mName, pName, page);
		count = countMusicPlayService.findLikesMusicInfoVOsCount(mName, pName);
		count = count / 20 * 20;
		/*
		 * if(findLikesMusicInfoVOsCount%20>0){ count = findLikesMusicInfoVOsCount/20+1;
		 * }else { count = findLikesMusicInfoVOsCount/20; };
		 */
		pg = page / 20 + 1;
		pa = count / 20 + 1;
		System.out.println("page:" + page);
		return "success";
	}

	/**
	 * 单曲详情主页
	 * @return
	 */
	public String findMusicId() {
		session.put("musicId", musicId);
		todayList = countMusicPlayService.findUserCPCountMusicPlayDay("", musicId);
		yesterdayList = countMusicPlayService.findUserCPCountMusicPlayYesterday("", musicId);
		return "success";
	}

	/**
	 * 单曲详情统计图表
	 * @return
	 */
	public String findMusicObject() {
		session.put("riqi", day);
		Object object = session.get("musicId");
		musicId = object.toString();
		List<SongDateVO> findSevenDay = countMusicPlayService.findUserCPSevenDay(day, "", musicId);
		for (SongDateVO s1 : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", s1.getClickDate());
			jObject.put("data", s1.getNewSong());
			jObject.put("data2", s1.getSumClick());
			jObject.put("data3", s1.getSumClickRen());
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * 曲目详情导出
	 * @return
	 */
	public String qmxqExcel() {
		Object object = session.get("riqi");
		String string = object.toString();
		Object object2 = session.get("musicId");
		musicId = object2.toString();
		List<SongDateVO> findSevenDay = countMusicPlayService.findUserCPSevenDay(string, "", musicId);
		SongVO findAll = countMusicPlayService.findUserCPAll(string, "", musicId);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("曲目明细统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("日期");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("点播次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点播人数");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getSumClick());
			row.createCell(2).setCellValue(findSevenDay.get(i).getSumClickRen());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("点播总次数:" + findAll.getSumClick());
		row.createCell(1).setCellValue("点播总人数:" + findAll.getSumClickRen());
		/**
		 * 保存文件
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		try {
			OutputStream outputStream = new FileOutputStream(f1);
			wb.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
		}
		// 下载
		filename = format + ".xls";
		try {
			image = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dele
		File f = new File(f1);
		f.delete();
		return "success";
	}

	/**
	 * 单曲详情总计
	 * @return
	 */
	public String musicZong() {
		Object object = session.get("musicId");
		musicId = object.toString();
		songVO = countMusicPlayService.findUserCPAll(day, "", musicId);
		return "success";
	}

	/**
	 * CP统计
	 * CP统计主页
	 */
	public String UserCPIndex() {
		session.put("cpId", cpId);
		todayList = countMusicPlayService.findUserCPCountMusicPlayDay(cpId, "");
		yesterdayList = countMusicPlayService.findUserCPCountMusicPlayYesterday(cpId, "");
		return "success";
	}

	/**
	 * 统计图表
	 * @return
	 */
	public String UserCPTongji() {
		Object object = session.get("cpId");
		session.put("riqi", day);
		List<SongDateVO> findSevenDay = countMusicPlayService.findUserCPSevenDay(day, object.toString(), "");
		for (SongDateVO s1 : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", s1.getClickDate());
			jObject.put("data", s1.getNewSong());
			jObject.put("data2", s1.getSumClick());
			jObject.put("data3", s1.getSumClickRen());
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * CP综合统计导出
	 * @return
	 */
	public String userCPExcel() {
		Object object = session.get("riqi");
		String string = object.toString();
		Object object2 = session.get("cpId");
		List<SongDateVO> findSevenDay = countMusicPlayService.findUserCPSevenDay(string, object2.toString(), "");
		SongVO findAll = countMusicPlayService.findUserCPAll(string, object2.toString(), "");
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("曲目综合明细统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("日期");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("点播次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点播人数");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("新增曲目");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getSumClick());
			row.createCell(2).setCellValue(findSevenDay.get(i).getSumClickRen());
			row.createCell(3).setCellValue(findSevenDay.get(i).getNewSong());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("点播总次数:" + findAll.getSumClick());
		row.createCell(1).setCellValue("点播总人数:" + findAll.getSumClickRen());
		row.createCell(2).setCellValue("新增曲目数:" + findAll.getNewSong());
		/**
		 * 保存文件
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		try {
			OutputStream outputStream = new FileOutputStream(f1);
			wb.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
		}
		// 下载
		filename = format + ".xls";
		try {
			image = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dele
		File f = new File(f1);
		f.delete();
		return "success";
	}

	/**
	 * 尾汇总
	 * @return
	 */
	public String userCPTo() {
		Object object = session.get("cpId");
		songVO = countMusicPlayService.findUserCPAll(day, object.toString(), "");
		return "success";
	}

	/**
	 * CP前20首点击排行
	 * @return
	 */
	public String findUserCPMusic() {
		findMusicInfoVOs = countMusicPlayService.findUserCPMusicInfoVOs(cpId);
		return "success";
	}

	/**
	 * CP模糊查询
	 * @return
	 */
	public String findUserCPMusics() {
		sysUser = (SysUser) session.get("user");
		cpId = sysUser.getCpId();
		findMusicInfoVOs = countMusicPlayService.findUserCPLikesMusicInfoVOs(musiceName, playerName, cpId);
		return "success";
	}

	/**
	 * CP曲目详情页
	 * @return
	 */
	public String findUCPMId() {
		SysUser object = (SysUser) session.get("user");
		session.put("musicId", musicId);
		todayList = countMusicPlayService.findUserCPCountMusicPlayDay(object.getCpId(), musicId);
		yesterdayList = countMusicPlayService.findUserCPCountMusicPlayYesterday(object.getCpId(), musicId);
		return "success";
	}

	/**
	 * CP单曲详情图表统计
	 * @return
	 */
	public String qmxqtj() {
		cpId = session.get("cpId").toString();
		session.put("riqi", day);
		Object object = session.get("musicId");
		musicId = object.toString();
		List<SongDateVO> findSevenDay = countMusicPlayService.findUserCPSevenDay(day, cpId, musicId);
		for (SongDateVO s1 : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", s1.getClickDate());
			jObject.put("data", s1.getNewSong());
			jObject.put("data2", s1.getSumClick());
			jObject.put("data3", s1.getSumClickRen());
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * CP单曲详情导出
	 * @return
	 */
	public String qmcpxqExcel() {
		Object object = session.get("riqi");
		String string = object.toString();
		Object object2 = session.get("musicId");
		musicId = object2.toString();
		cpId = session.get("cpId").toString();
		List<SongDateVO> findSevenDay = countMusicPlayService.findUserCPSevenDay(string, cpId, musicId);
		SongVO findAll = countMusicPlayService.findUserCPAll(string, cpId, musicId);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("单曲明细统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("日期");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("点播次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点播人数");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getSumClick());
			row.createCell(2).setCellValue(findSevenDay.get(i).getSumClickRen());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("点播总次数:" + findAll.getSumClick());
		row.createCell(1).setCellValue("点播总人数:" + findAll.getSumClickRen());
		/**
		 * 保存文件
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		try {
			OutputStream outputStream = new FileOutputStream(f1);
			wb.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
		}
		// 下载
		filename = format + ".xls";
		try {
			image = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// dele
		File f = new File(f1);
		f.delete();
		return "success";
	}

	/**
	 * CP单曲详情总计
	 * @return
	 */
	public String qmxqzj() {
		cpId = session.get("cpId").toString();
		Object object = session.get("musicId");
		musicId = object.toString();
		songVO = countMusicPlayService.findUserCPAll(day, cpId, musicId);
		return "success";
	}

	/**
	 * 曲目综合统计饼图表
	 * @return
	 */
	public String bttongji() {
		// 前端没有传过来值，造成后台查询报错，先赋一个默认值，以后弄明白再改
		if (null == yu) {
			yu = 1;
		}
		List<CPShouRuVO> findObjects = countMusicPlayService.findObjects(day, yu);
		for (CPShouRuVO cpShouRuVO : findObjects) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", cpShouRuVO.getCpName());
			jObject.put("value", cpShouRuVO.getJin());
			result.add(jObject);
		}
		return "success";
	}

}
