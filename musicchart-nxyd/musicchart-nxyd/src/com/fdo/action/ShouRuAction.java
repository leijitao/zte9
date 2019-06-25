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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;

import com.fdo.hum.MonthlyType;
import com.fdo.hum.RenewLog;
import com.fdo.hum.TBillMonthLog;
import com.fdo.hum.TBillUnsmonth;
import com.fdo.service.CountBillMonthService;
import com.fdo.service.CountMusicPlayService;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.ShouRuDateVO;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShouRuAction {

	private CountBillMonthService countBillMonthService;
	private CountMusicPlayService countMusicPlayService;
	private List<ShouRuDateVO> shouRuDateVOs = new ArrayList<ShouRuDateVO>();
	private List<ShouRuDateVO> monShouRuDateVOs = new ArrayList<ShouRuDateVO>();
	private List<ShouRuDateVO> yearMonsr = new ArrayList<ShouRuDateVO>();
	private List<TBillMonthLog> billMonthLogs = new ArrayList<TBillMonthLog>();
	private List<MonthlyType> findSamllclassAll = new ArrayList<MonthlyType>();
	private List<TBillUnsmonth> findTBillUnsmonths = new ArrayList<TBillUnsmonth>();
	private ShouRuDateVO srdvoDateVO = new ShouRuDateVO();
	private MonthlyType monthlyType = new MonthlyType();
	private RenewLog renewLog = new RenewLog();
	private JSONArray result = new JSONArray();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private String yearMon; // 年,月
	private String day; // 日期
	private String className;
	private String productName;
	private String orderId = ""; // 订购编号
	private String userId = ""; // 订购用户编号
	private String money; // 包月总价
	private String onclicks; // 点击总次数
	private InputStream image;
	private String filename;
	private String state; // 开始时间
	private String end; // 结束时间
	private String productID;
	private String status;
	private String allString;
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

	public List<TBillUnsmonth> getFindTBillUnsmonths() {
		return findTBillUnsmonths;
	}

	public void setFindTBillUnsmonths(List<TBillUnsmonth> findTBillUnsmonths) {
		this.findTBillUnsmonths = findTBillUnsmonths;
	}

	public Integer getPa() {
		return pa;
	}

	public void setPa(Integer pa) {
		this.pa = pa;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public RenewLog getRenewLog() {
		return renewLog;
	}

	public void setRenewLog(RenewLog renewLog) {
		this.renewLog = renewLog;
	}

	public String getAllString() {
		return allString;
	}

	public void setAllString(String allString) {
		this.allString = allString;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<TBillMonthLog> getBillMonthLogs() {
		return billMonthLogs;
	}

	public void setBillMonthLogs(List<TBillMonthLog> billMonthLogs) {
		this.billMonthLogs = billMonthLogs;
	}

	public List<MonthlyType> getFindSamllclassAll() {
		return findSamllclassAll;
	}

	public void setFindSamllclassAll(List<MonthlyType> findSamllclassAll) {
		this.findSamllclassAll = findSamllclassAll;
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

	public CountMusicPlayService getCountMusicPlayService() {
		return countMusicPlayService;
	}

	public void setCountMusicPlayService(CountMusicPlayService countMusicPlayService) {
		this.countMusicPlayService = countMusicPlayService;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getOnclicks() {
		return onclicks;
	}

	public void setOnclicks(String onclicks) {
		this.onclicks = onclicks;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MonthlyType getMonthlyType() {
		return monthlyType;
	}

	public void setMonthlyType(MonthlyType monthlyType) {
		this.monthlyType = monthlyType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ShouRuDateVO getSrdvoDateVO() {
		return srdvoDateVO;
	}

	public void setSrdvoDateVO(ShouRuDateVO srdvoDateVO) {
		this.srdvoDateVO = srdvoDateVO;
	}

	public List<ShouRuDateVO> getYearMonsr() {
		return yearMonsr;
	}

	public void setYearMonsr(List<ShouRuDateVO> yearMonsr) {
		this.yearMonsr = yearMonsr;
	}

	public String getYearMon() {
		return yearMon;
	}

	public void setYearMon(String yearMon) {
		this.yearMon = yearMon;
	}

	public List<ShouRuDateVO> getMonShouRuDateVOs() {
		return monShouRuDateVOs;
	}

	public void setMonShouRuDateVOs(List<ShouRuDateVO> monShouRuDateVOs) {
		this.monShouRuDateVOs = monShouRuDateVOs;
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

	public CountBillMonthService getCountBillMonthService() {
		return countBillMonthService;
	}

	public void setCountBillMonthService(CountBillMonthService countBillMonthService) {
		this.countBillMonthService = countBillMonthService;
	}

	public List<ShouRuDateVO> getShouRuDateVOs() {
		return shouRuDateVOs;
	}

	public void setShouRuDateVOs(List<ShouRuDateVO> shouRuDateVOs) {
		this.shouRuDateVOs = shouRuDateVOs;
	}

	/**
	 * 收入主页面
	 * @return
	 */
	public String zhuye1() {
		shouRuDateVOs = countBillMonthService.findSRfeeAndPeopleDay(className);
		if (className != null) {
			monthlyType = countBillMonthService.findProduct(className);
			productName = monthlyType.getTitle();
		} else {
			productName = "全部";
		}
		// monShouRuDateVOs = countBillMonthService.findMon();
		// srdvoDateVO = countBillMonthService.findAll();
		return "success";
	}

	public String zhuye2() {
		shouRuDateVOs = countBillMonthService.findSRfeeAndPeopleDay(className);
		if (className != null) {
			monthlyType = countBillMonthService.findProduct(className);
			productName = monthlyType.getTitle();
		} else {
			productName = "全部";
		}
		// monShouRuDateVOs = countBillMonthService.findMon();
		// srdvoDateVO = countBillMonthService.findAll();
		return "success";
	}

	/**
	 * 收入统计图表
	 * @return
	 */
	public String tongji() {
		session.put("riqi", day);
		session.put("productId", className);
		List<ShouRuDateVO> findSevenDay = countBillMonthService.findSevenDay(day, className);
		for (ShouRuDateVO srdvo : findSevenDay) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", srdvo.getDate());
			jObject.put("data", srdvo.getFee());
			jObject.put("data2", srdvo.getPeople());
			jObject.put("data3", srdvo.getRate());
			jObject.put("data4", srdvo.getUnpeople());
			/* System.out.println(srdvo.getRate()+"--rate"); */
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * 包月饼图
	 */
	public String shourubt() {
		List<CPShouRuVO> findCpShouRuVOs = countBillMonthService.findCpShouRuVOs(day);
		for (CPShouRuVO cpvo : findCpShouRuVOs) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", cpvo.getCpName());
			jObject.put("value", cpvo.getJin2());
			result.add(jObject);
		}
		return "success";
	}

	public String btExcel() {
		Object object = session.get("riqi");
		Object object2 = session.get("productId");
		String string = object.toString();
		List<CPShouRuVO> findCpShouRuVOs = countBillMonthService.findCpShouRuVOs(string);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("包月收入占比统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("包月名称");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("金额");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("占比");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findCpShouRuVOs.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findCpShouRuVOs.get(i).getCpName());
			row.createCell(1).setCellValue(findCpShouRuVOs.get(i).getJin2());
			row.createCell(2).setCellValue(findCpShouRuVOs.get(i).getTotl());
		}
		/**
		 * 保存文件
		 */
		/*
		 * JFileChooser jf = new JFileChooser();
		 * jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG |
		 * JFileChooser.DIRECTORIES_ONLY); int showSaveDialog = jf.showSaveDialog(null);
		 * if(showSaveDialog==JFileChooser.APPROVE_OPTION){ File fi =
		 * jf.getSelectedFile(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyyMMddHHmmss"); Date date = new Date(); String format =
		 * sdf.format(date); String f1 =
		 * fi.getAbsolutePath()+"\\包月收入占比统计表_"+format+".xls";
		 * //System.out.println("save: "+f1); try{ OutputStream outputStream = new
		 * FileOutputStream(f1); wb.write(outputStream); outputStream.close(); }
		 * catch(Exception e){} }else { //取消保存 }
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
	 * 导出Excel
	 * @return
	 */
	public String mxExcel() {
		Object object = session.get("riqi");
		Object object2 = session.get("productId");
		String string = object.toString();
		List<ShouRuDateVO> findSevenDay = countBillMonthService.findSevenDay(string, object2.toString());
		ShouRuDateVO findAll = countBillMonthService.findAll(object2.toString(), string);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("收入明细统计表");
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
		cell.setCellValue("收入金额");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("订单数");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("新增订购人数");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("转化率%");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getFee());
			row.createCell(2).setCellValue(findSevenDay.get(i).getPeople());
			row.createCell(3).setCellValue(findSevenDay.get(i).getUnpeople());
			row.createCell(4).setCellValue(findSevenDay.get(i).getRate());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("总收入:" + findAll.getFee() + "元");
		row.createCell(1).setCellValue("总订单数:" + findAll.getRens());
		row.createCell(2).setCellValue("总订购人数:" + findAll.getPeople() + "人");
		row.createCell(3).setCellValue("合总转化率:" + findAll.getRate());
		row.createCell(4).setCellValue("总退订人数:" + findAll.getUnpeople() + "人");
		row.createCell(5).setCellValue("总新增人数:" + findAll.getDate() + "人");
		/**
		 * 保存文件
		 */
		/*
		 * JFileChooser jf = new JFileChooser();
		 * jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG |
		 * JFileChooser.DIRECTORIES_ONLY); int showSaveDialog = jf.showSaveDialog(null);
		 * if(showSaveDialog==JFileChooser.APPROVE_OPTION){ File fi =
		 * jf.getSelectedFile(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyyMMddHHmmss"); Date date = new Date(); String format =
		 * sdf.format(date); String f1 =
		 * fi.getAbsolutePath()+"\\收入明细统计表_"+format+".xls";
		 * //System.out.println("save: "+f1); try{ OutputStream outputStream = new
		 * FileOutputStream(f1); wb.write(outputStream); outputStream.close(); }
		 * catch(Exception e){} }else { //取消保存 }
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
	 * 总计
	 * @return
	 */
	public String assAll() {
		srdvoDateVO = countBillMonthService.findAll(className, day);
		return "success";
	}

	/**
	 * 订购
	 * @return
	 */
	// 订购记录页面跳转
	public String dinggou() {
		page = 0;
		billMonthLogs = countBillMonthService.findBillMonthLogs(orderId, userId, 0);
		findSamllclassAll = countBillMonthService.findSamllclassAll();
		state = "";
		end = "";
		productID = "";
		status = "";
		count = countBillMonthService.findDDCount("", "", "", "");
		count = count / 20 * 20;
		pg = page / 20 + 1;
		pa = count / 20 + 1;
		if (pg > pa) {
			pg = pa;
		}
		if (pg < 1) {
			pg = 1;
		}
		session.put("findSamllclassAll", findSamllclassAll);
		// System.out.println("state:"+state+"end:"+end+"productID:"+productID+"status:"+status);
		srdvoDateVO = countBillMonthService.findZdd(state, end, productID, status);
		return "success";
	}

	public String findTBMI() {
		return "success";
	}

	// 第一个查询
	public String dingGouInfo() {
		if (page < 0) {
			page = 0;
		}
		billMonthLogs = countBillMonthService.findBillMonthLogs(orderId, userId, page);
		count = countBillMonthService.findBillMonthLogsCount(orderId, userId);
		count = count / 20 * 20;
		pg = page / 20 + 1;
		pa = count / 20 + 1;
		if (pg > pa) {
			pg = pa;
		}
		if (pg < 1) {
			pg = 1;
		}
		/* srdvoDateVO = countBillMonthService.findzd(orderId, userId); */
		return "success";
	}

	// 第二个查询
	public String dingGouLogInfo() {
		findSamllclassAll = countBillMonthService.findSamllclassAll();
		if (productID.equals("ALL")) {
			productID = "";
		}
		if (status.equals("ALL")) {
			status = "";
		}
		if (!state.equals("")) {
			state = state + " 00:00:00";
		}
		if (!end.equals("")) {
			end = end + " 23:59:59";
		}
		// System.out.println("state:"+state);
		// System.out.println("end:"+end);
		session.put("state", state);
		session.put("end", end);
		session.put("productID", productID);
		session.put("status", status);
		count = countBillMonthService.findDDCount(state, end, productID, status);
		count = count / 20 * 20;
		pg = page / 20 + 1;
		pa = count / 20 + 1;
		if (pg > pa) {
			pg = pa;
		}
		if (pg < 1) {
			pg = 1;
		}
		if (page < 0) {
			page = 0;
		}
		billMonthLogs = countBillMonthService.findDD(state, end, productID, status, page);
		srdvoDateVO = countBillMonthService.findZdd(state, end, productID, status);
		return "success";
	}

	/**
	 * 退订记录
	 */
	public String tdjl() {
		if (page < 0) {
			page = 0;
		}
		findTBillUnsmonths = countBillMonthService.findTDAll(orderId, userId, page);
		count = countBillMonthService.findTDAllCount(orderId, userId);
		count = count / 20 * 20;
		pg = page / 20 + 1;
		pa = count / 20 + 1;
		if (pg > pa) {
			pg = pa;
		}
		if (pg < 1) {
			pg = 1;
		}
		return "success";
	}

	/**
	 * 结算管理
	 * @return
	 */
	public String srtjjsgl() {
		money = countBillMonthService.findZDJ("0");
		renewLog = countBillMonthService.findAllLog("0");
		if (yu == null) {
			yu = 0;
		}
		onclicks = countMusicPlayService.findZBY("0", yu);
		return "success";
	}

	/**
	 * 结算阈值
	 */
	public String jiesuan() {
		session.put("state", state);
		session.put("end", end);
		money = countBillMonthService.findZDJ(state + "," + end);
		renewLog = countBillMonthService.findAllLog(state + "," + end);
		renewLog.setStatus(money);
		return "success";
	}

	public String yuzhi() {
		session.put("state", state);
		session.put("end", end);
		session.put("yu", yu);
		onclicks = countMusicPlayService.findZBY(state + "," + end, yu);
		return "success";
	}

	/**
	 * 包月导出
	 * @return
	 */
	public String jsglExcel() {
		Object s = session.get("state");
		Object ed = session.get("end");
		Object y = session.get("yu");
		money = countBillMonthService.findZDJ(s.toString() + "," + ed.toString());
		onclicks = countMusicPlayService.findZBY(s.toString() + "," + ed.toString(), Integer.valueOf(y.toString()));
		List<CPShouRuVO> findCpShouRuVOs = countBillMonthService.findCpShouRuVOs(s.toString() + "," + ed.toString());
		List<CPShouRuVO> findObjects = countMusicPlayService.findObjects(s.toString() + "," + ed.toString(),
				Integer.valueOf(y.toString()));
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("点击统计表");
		HSSFSheet sheet2 = wb.createSheet("包月收入统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		HSSFRow row2 = sheet2.createRow(0);
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

		HSSFCell cell2 = row2.createCell(0);
		cell2.setCellValue("包月名称");
		cell2.setCellStyle(style);

		cell2 = row2.createCell(1);
		cell2.setCellValue("包月收入金额");
		cell2.setCellStyle(style);

		cell2 = row2.createCell(2);
		cell2.setCellValue("包月收入占比");
		cell2.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findObjects.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findObjects.get(i).getCpId());
			row.createCell(1).setCellValue(findObjects.get(i).getCpName());
			row.createCell(2).setCellValue(findObjects.get(i).getJin());
			row.createCell(3).setCellValue(findObjects.get(i).getTotl());
		}
		row = sheet.createRow(findObjects.size() + 1);
		row.createCell(0).setCellValue("总点击量:" + onclicks);

		for (int i = 0; i < findCpShouRuVOs.size(); i++) {
			row2 = sheet2.createRow(i + 1);
			// 创建单元格，设置值
			row2.createCell(0).setCellValue(findCpShouRuVOs.get(i).getCpName());
			row2.createCell(1).setCellValue(findCpShouRuVOs.get(i).getJin2());
			row2.createCell(2).setCellValue(findCpShouRuVOs.get(i).getTotl());
		}
		row2 = sheet2.createRow(findCpShouRuVOs.size() + 1);
		row2.createCell(0).setCellValue("总包月收入:" + money);
		/**
		 * 保存文件
		 */
		/*
		 * JFileChooser jf = new JFileChooser();
		 * jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG |
		 * JFileChooser.DIRECTORIES_ONLY); int showSaveDialog = jf.showSaveDialog(null);
		 * if(showSaveDialog==JFileChooser.APPROVE_OPTION){ File fi =
		 * jf.getSelectedFile(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyyMMddHHmmss"); Date date = new Date(); String format =
		 * sdf.format(date); String f1 =
		 * fi.getAbsolutePath()+"\\收入结算管理统计表_"+format+".xls";
		 * //System.out.println("save: "+f1); try{ OutputStream outputStream = new
		 * FileOutputStream(f1); wb.write(outputStream); outputStream.close(); }
		 * catch(Exception e){} }else { //取消保存 }
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

	// 订购记录导出
	public String dgExcel() throws Exception {
		state = session.get("state").toString();
		end = session.get("end").toString();
		productID = session.get("productID").toString();
		status = session.get("status").toString();
		if (state == null) {
			state = "";
		} else {
			state = session.get("state").toString();
		}
		if (end == null) {
			end = "";
		} else {
			end = session.get("end").toString();
		}
		if (productID == null) {
			productID = "";
		} else {
			productID = session.get("productID").toString();
		}
		if (status == null) {
			status = "";
		} else {
			status = session.get("status").toString();
		}
		// System.out.println("state:"+state+"end:"+end+"productID:"+productID+"status:"+status);
		List<TBillMonthLog> findDD = countBillMonthService.findDG(state, end, productID, status);
		// System.out.println(findDD.size());
		ShouRuDateVO findZdd = countBillMonthService.findZdd(state, end, productID, status);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("订购记录统计表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 固定时间格式
		CellStyle cellStyle = wb.createCellStyle();
		CreationHelper creationHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd hh:mm:ss"));

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("序号");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("订单编号");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("用户ID");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("产品编号");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("产品名称");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("价格");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("状态");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("订购时间");
		cell.setCellStyle(style);

		cell = row.createCell(8);
		cell.setCellValue("ipAddress");
		cell.setCellStyle(style);

		cell = row.createCell(9);
		cell.setCellValue("备注");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findDD.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(i + 1);
			row.createCell(1).setCellValue(findDD.get(i).getOrderNo());
			row.createCell(2).setCellValue(findDD.get(i).getUserId());
			row.createCell(3).setCellValue(findDD.get(i).getProductId());
			row.createCell(4).setCellValue(findDD.get(i).getProductName());
			row.createCell(5).setCellValue(findDD.get(i).getTotalFee());
			if (findDD.get(i).getStatus() == 1) {
				row.createCell(6).setCellValue("成功");
			} else if (findDD.get(i).getStatus() == 0) {
				row.createCell(6).setCellValue("下单");
			} else {
				row.createCell(6).setCellValue(findDD.get(i).getStatus());
			}
			HSSFCell createCell = row.createCell(7);
			createCell.setCellValue(findDD.get(i).getCreateTime());
			createCell.setCellStyle(cellStyle);
			// row.createCell(7).setCellValue(findDD.get(i).getCreateTime());
			row.createCell(8).setCellValue(findDD.get(i).getIpAddress());
			row.createCell(9).setCellValue(findDD.get(i).getDescription());
		}
		row = sheet.createRow(findDD.size() + 2);
		row.createCell(0).setCellValue("订单总量:" + findZdd.getPeople());
		row.createCell(1).setCellValue("金额:" + findZdd.getFee());
		row.createCell(2).setCellValue("成功数:" + findZdd.getRate());
		row.createCell(3).setCellValue("续订数:" + findZdd.getRens());
		row.createCell(4).setCellValue("订购数:" + findZdd.getUnpeople());
		/**
		 * 保存文件
		 */
		/*
		 * JFileChooser jf = new JFileChooser();
		 * jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG |
		 * JFileChooser.DIRECTORIES_ONLY); int showSaveDialog = jf.showSaveDialog(null);
		 * if(showSaveDialog==JFileChooser.APPROVE_OPTION){ File fi =
		 * jf.getSelectedFile(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyyMMddHHmmss"); Date date = new Date(); String format =
		 * sdf.format(date); String f1 =
		 * fi.getAbsolutePath()+"\\收入结算管理统计表_"+format+".xls";
		 * //System.out.println("save: "+f1); try{ OutputStream outputStream = new
		 * FileOutputStream(f1); wb.write(outputStream); outputStream.close(); }
		 * catch(Exception e){} }else { //取消保存 }
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		OutputStream outputStream = new FileOutputStream(f1);
		wb.write(outputStream);
		outputStream.close();
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
}
