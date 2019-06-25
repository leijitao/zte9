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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fdo.service.CountMusicVisitService;
import com.fdo.vo.ActiveDateVO;
import com.fdo.vo.ActiveVO;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ActiveStatAction {

	private CountMusicVisitService countMusicVisitService;
	private List<ActiveVO> today = new ArrayList<ActiveVO>();
	private List<ActiveVO> yesterday = new ArrayList<ActiveVO>();
	private List<ActiveDateVO> activeDateVOs = new ArrayList<ActiveDateVO>();
	private ActiveVO activeVO = new ActiveVO();
	private JSONArray result = new JSONArray();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String mub;
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

	public String getYesrMon() {
		return yesrMon;
	}

	public void setYesrMon(String yesrMon) {
		this.yesrMon = yesrMon;
	}

	public List<ActiveDateVO> getActiveDateVOs() {
		return activeDateVOs;
	}

	public void setActiveDateVOs(List<ActiveDateVO> activeDateVOs) {
		this.activeDateVOs = activeDateVOs;
	}

	public ActiveVO getActiveVO() {
		return activeVO;
	}

	public void setActiveVO(ActiveVO activeVO) {
		this.activeVO = activeVO;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	public String getMub() {
		return mub;
	}

	public void setMub(String mub) {
		this.mub = mub;
	}

	public CountMusicVisitService getCountMusicVisitService() {
		return countMusicVisitService;
	}

	public void setCountMusicVisitService(CountMusicVisitService countMusicVisitService) {
		this.countMusicVisitService = countMusicVisitService;
	}

	public List<ActiveVO> getToday() {
		return today;
	}

	public void setToday(List<ActiveVO> today) {
		this.today = today;
	}

	public List<ActiveVO> getYesterday() {
		return yesterday;
	}

	public void setYesterday(List<ActiveVO> yesterday) {
		this.yesterday = yesterday;
	}

	/**
	 * 活跃统计首页
	 * @return
	 */
	public String zheye() {
		today = countMusicVisitService.findCountMuSicVisitDay();
		yesterday = countMusicVisitService.findCountMuSicVisitYesterday();
		activeDateVOs = countMusicVisitService.findMon();
		/* activeVO = countMusicVisitService.findAll(); */
		return "success";
	}

	/**
	 * 活跃统计图表
	 * @return
	 */
	public String activeTongji() {
		session.put("riqi", mub);
		List<ActiveDateVO> findSevenDay = countMusicVisitService.findSevenDay(mub);
		for (ActiveDateVO advo : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", advo.getClickDate());
			jObject.put("data", advo.getTotalUser());
			jObject.put("data2", advo.getActiveUser());
			jObject.put("data3", advo.getRatio());
			jObject.put("wpv", advo.getWpv());
			jObject.put("wuv", advo.getWuv());
			jObject.put("ypv", advo.getYpv());
			jObject.put("yuv", advo.getYuv());
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * 导出Excel
	 * @return
	 */
	public String activeExcel() {
		Object object = session.get("riqi");
		String string = object.toString();
		List<ActiveDateVO> findSevenDay = countMusicVisitService.findSevenDay(string);
		ActiveVO findAll = countMusicVisitService.findAll(string);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("活跃统计表");
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
		cell.setCellValue("总(PV)");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("未订购(PV)");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("已订购(PV)");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("总(UV)");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("未订购(UV)");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("已订购(UV)");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("占比%");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getTotalUser());
			row.createCell(2).setCellValue(findSevenDay.get(i).getWpv());
			row.createCell(3).setCellValue(findSevenDay.get(i).getYpv());
			row.createCell(4).setCellValue(findSevenDay.get(i).getActiveUser());
			row.createCell(5).setCellValue(findSevenDay.get(i).getWuv());
			row.createCell(6).setCellValue(findSevenDay.get(i).getYuv());
			row.createCell(7).setCellValue(findSevenDay.get(i).getRatio());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("总访问量(PV)：" + findAll.getTotalUser());
		row.createCell(1).setCellValue("总未订购访问量(PV):" + findAll.getWpvInteger());
		row.createCell(2).setCellValue("总已订购访问量(PV):" + findAll.getYpvInteger());
		row.createCell(3).setCellValue("总访问人数(UV)：" + findAll.getActiveUser());
		row.createCell(4).setCellValue("总未订购访问人数(UV):" + findAll.getWuvInteger());
		row.createCell(5).setCellValue("总已订购访问人数(UV):" + findAll.getYuvInteger());
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

	public String activeAss() {
		activeVO = countMusicVisitService.findAll(mub);
		return "success";
	}

	/**
	 * 活跃明细
	 * @return
	 */
	public String mingxi() {
		activeDateVOs = countMusicVisitService.findYesrMon(yesrMon);
		return "success";
	}
}
