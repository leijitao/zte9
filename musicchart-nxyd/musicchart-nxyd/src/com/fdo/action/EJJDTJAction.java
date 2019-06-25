package com.fdo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fdo.hum.MusicType;
import com.fdo.service.CountMusicCategoryService;
import com.fdo.service.MuSicTypeService;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;
import com.fdo.vo.ShouRuDateVO;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EJJDTJAction {

	private CountMusicCategoryService countMusicCategoryService;
	private MuSicTypeService muSicTypeService;
	private List<ClickVO> clickVOsToday = new ArrayList<ClickVO>();
	private List<ClickVO> yesterdayClickVOs = new ArrayList<ClickVO>();
	private List<ClickDateVO> clickDateVOs = new ArrayList<ClickDateVO>();
	private List<ClickDateVO> clickDateVOs2 = new ArrayList<ClickDateVO>();
	private ClickVO clickVO = new ClickVO();
	private MusicType bigType = new MusicType();
	private MusicType smallType = new MusicType();
	private JSONArray result = new JSONArray();
	private Map<String,Object> session = ActionContext.getContext().getSession();
	private String className;
	private String day;
	private String yesrMon;
	private InputStream image;
	private String filename;
	
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ClickVO getClickVO() {
		return clickVO;
	}
	public void setClickVO(ClickVO clickVO) {
		this.clickVO = clickVO;
	}
	public MuSicTypeService getMuSicTypeService() {
		return muSicTypeService;
	}
	public void setMuSicTypeService(MuSicTypeService muSicTypeService) {
		this.muSicTypeService = muSicTypeService;
	}
	public MusicType getBigType() {
		return bigType;
	}
	public void setBigType(MusicType bigType) {
		this.bigType = bigType;
	}
	public MusicType getSmallType() {
		return smallType;
	}
	public void setSmallType(MusicType smallType) {
		this.smallType = smallType;
	}
	public List<ClickDateVO> getClickDateVOs2() {
		return clickDateVOs2;
	}
	public void setClickDateVOs2(List<ClickDateVO> clickDateVOs2) {
		this.clickDateVOs2 = clickDateVOs2;
	}
	public String getYesrMon() {
		return yesrMon;
	}
	public void setYesrMon(String yesrMon) {
		this.yesrMon = yesrMon;
	}
	public List<ClickDateVO> getClickDateVOs() {
		return clickDateVOs;
	}
	public void setClickDateVOs(List<ClickDateVO> clickDateVOs) {
		this.clickDateVOs = clickDateVOs;
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
	public List<ClickVO> getClickVOsToday() {
		return clickVOsToday;
	}
	public void setClickVOsToday(List<ClickVO> clickVOsToday) {
		this.clickVOsToday = clickVOsToday;
	}
	public List<ClickVO> getYesterdayClickVOs() {
		return yesterdayClickVOs;
	}
	public void setYesterdayClickVOs(List<ClickVO> yesterdayClickVOs) {
		this.yesterdayClickVOs = yesterdayClickVOs;
	}
	public CountMusicCategoryService getCountMusicCategoryService() {
		return countMusicCategoryService;
	}
	public void setCountMusicCategoryService(CountMusicCategoryService countMusicCategoryService) {
		this.countMusicCategoryService = countMusicCategoryService;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * 主显示页面
	 * @return
	 */
	public String zhuye(){
		if (className==null) {
			Object object = session.get("class");
			className = object.toString();
		}else {
			session.put("class", className);
		}
		clickVOsToday = countMusicCategoryService.findCountMusicCategoryDay(className);
		yesterdayClickVOs = countMusicCategoryService.findCountMusicCategoryYesterday(className);
		
		clickDateVOs = countMusicCategoryService.findMon(className);
		smallType = muSicTypeService.findTypeCode(className);
		bigType = muSicTypeService.findTypeCode(smallType.getPcode());
		
		/*clickVO = countMusicCategoryService.findAll(className);*/
		return "success";
	}
	/**
	 * 统计图表
	 * @return
	 */
	public String tubiaotongji(){
		session.put("riqi", day);
		session.put("bianhao", className);
		Object object = session.get("riqi");
		Object object2 = session.get("bianhao");
		List<ClickDateVO> findSevenDay = countMusicCategoryService.findSevenDay(object.toString(),object2.toString());
		for (ClickDateVO clickDateVO : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", clickDateVO.getClickDate());
			jObject.put("data", clickDateVO.getClicks());
			jObject.put("data2", clickDateVO.getClickRen());
			result.add(jObject);
		}
		return "success";
	}
	/**
	 * 导出报表
	 * @return
	 */
	public String rkExcel(){
		Object object = session.get("riqi");
		Object object2 = session.get("bianhao");
		String string = object.toString();
		String string2 = object2.toString();
		List<ClickDateVO> findSevenDay = countMusicCategoryService.findSevenDay(string,string2);
		ClickVO findAll = countMusicCategoryService.findAll(string,string2);
		MusicType samll = muSicTypeService.findTypeCode(string2);
		MusicType big = muSicTypeService.findTypeCode(samll.getPcode());
		// 1.创建一个workbook，对应一个Excel文件
	      HSSFWorkbook wb = new HSSFWorkbook();
	      // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
	      HSSFSheet sheet = wb.createSheet(big.getTypeName()+samll.getTypeName()+"明细统计表");
	      // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
	      HSSFRow row = sheet.createRow((int) 0);
	      // 4.创建单元格，设置值表头，设置表头居中
	      HSSFCellStyle style = wb.createCellStyle();
	      // 居中格式
	      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	 
	      // 设置表头
	      HSSFCell cell = row.createCell(0);
	      cell.setCellValue("日期");
	      cell.setCellStyle(style);
	 
	      cell = row.createCell(1);
	      cell.setCellValue("入口点击次数");
	      cell.setCellStyle(style);
	 
	      cell = row.createCell(2);
	      cell.setCellValue("入口点击人数");
	      cell.setCellStyle(style);
	 
	   // 循环将数据写入Excel
	      for (int i = 0; i < findSevenDay.size(); i++) {
	        row = sheet.createRow((int) i + 1);
	        // 创建单元格，设置值
	        row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
	        row.createCell(1).setCellValue(findSevenDay.get(i).getClicks());
	        row.createCell(2).setCellValue(findSevenDay.get(i).getClickRen());
	      }
	      row = sheet.createRow(findSevenDay.size()+2);
	      row.createCell(0).setCellValue("入口点击总次数:"+findAll.getClicks());
	      row.createCell(1).setCellValue(" 入口点击总人数:"+findAll.getClickRen());
		  /**
		   * 保存文件
		   */
	    //保存
		  File fi = new File("");
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		  Date date = new Date();
		  String format = sdf.format(date);
		  String f1 = fi.getAbsolutePath()+"\\"+format+".xls"; 
		  try{  
		      OutputStream outputStream = new FileOutputStream(f1);
		      wb.write(outputStream);
		      outputStream.close();
		  }  
		  catch(Exception e){} 
		  //下载
		  filename = format+".xls"; 
		  try {
			image = new FileInputStream(f1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //dele
		  File f = new File(f1);
		  f.delete();
		return "success";
	}
	/**
	 * 明细总计
	 * @return
	 */
	public String rkAss(){
		clickVO = countMusicCategoryService.findAll(day,className);
		return "success";
	}
	public String mingxi(){
		clickDateVOs2 = countMusicCategoryService.findYesrMon(yesrMon);
		return "success";
	}
}
