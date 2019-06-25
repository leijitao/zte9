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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fdo.hum.MusicRecom;
import com.fdo.hum.MusicType;
import com.fdo.service.CountMusicRecService;
import com.fdo.service.MuSicTypeService;
import com.fdo.service.MusicRecomService;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;
import com.fdo.vo.RecClicksStatVO;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RTAction {

	private static final Logger logger = LoggerFactory.getLogger(RTAction.class);

	private MusicRecomService musicRecomService;
	private MuSicTypeService muSicTypeService;
	private CountMusicRecService countMusicRecService;
	private List<ClickVO> clickVOs = new ArrayList<ClickVO>();
	private List<ClickVO> toClickVOs = new ArrayList<ClickVO>();
	private List<MusicType> bigClass = new ArrayList<MusicType>();
	private List<MusicRecom> musicRecoms = new ArrayList<MusicRecom>();
	private List<ClickDateVO> clickMonVos = new ArrayList<ClickDateVO>();
	private List<ClickDateVO> clickDateVOs = new ArrayList<ClickDateVO>();
	private Map<String, Object> session = ActionContext.getContext().getSession();
	private JSONArray result = new JSONArray();
	private ClickVO clickVO = new ClickVO();
	private ClickVO clickVO2 = new ClickVO();
	private MusicType musicType = new MusicType();
	private MusicRecom musicRecom = new MusicRecom();
	private String typeCode; // 类别id
	private String yesrMon; // 年，月
	private String className; // 类名
	private String code;
	// mub是封装的日期信息，可能是“7、15、30”这样的，也可能是“2017-3-4,2018-3-4”这样的
	private String mub;
	private String zcode; // 总分id
	private InputStream image;
	private String filename;
	// 音乐推荐栏点击量统计
	List<RecClicksStatVO> recClicks = null;

	public List<RecClicksStatVO> getRecClicks() {
		return recClicks;
	}

	public void setRecClicks(List<RecClicksStatVO> recClicks) {
		this.recClicks = recClicks;
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

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

	public ClickVO getClickVO2() {
		return clickVO2;
	}

	public void setClickVO2(ClickVO clickVO2) {
		this.clickVO2 = clickVO2;
	}

	public String getZcode() {
		return zcode;
	}

	public void setZcode(String zcode) {
		this.zcode = zcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMub() {
		return mub;
	}

	public void setMub(String mub) {
		this.mub = mub;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ClickDateVO> getClickDateVOs() {
		return clickDateVOs;
	}

	public void setClickDateVOs(List<ClickDateVO> clickDateVOs) {
		this.clickDateVOs = clickDateVOs;
	}

	public ClickVO getClickVO() {
		return clickVO;
	}

	public void setClickVO(ClickVO clickVO) {
		this.clickVO = clickVO;
	}

	public List<ClickDateVO> getClickMonVos() {
		return clickMonVos;
	}

	public void setClickMonVos(List<ClickDateVO> clickMonVos) {
		this.clickMonVos = clickMonVos;
	}

	public MusicType getMusicType() {
		return musicType;
	}

	public void setMusicType(MusicType musicType) {
		this.musicType = musicType;
	}

	public MusicRecom getMusicRecom() {
		return musicRecom;
	}

	public void setMusicRecom(MusicRecom musicRecom) {
		this.musicRecom = musicRecom;
	}

	public List<ClickVO> getToClickVOs() {
		return toClickVOs;
	}

	public void setToClickVOs(List<ClickVO> toClickVOs) {
		this.toClickVOs = toClickVOs;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getYesrMon() {
		return yesrMon;
	}

	public void setYesrMon(String yesrMon) {
		this.yesrMon = yesrMon;
	}

	public CountMusicRecService getCountMusicRecService() {
		return countMusicRecService;
	}

	public void setCountMusicRecService(CountMusicRecService countMusicRecService) {
		this.countMusicRecService = countMusicRecService;
	}

	public List<ClickVO> getClickVOs() {
		return clickVOs;
	}

	public void setClickVOs(List<ClickVO> clickVOs) {
		this.clickVOs = clickVOs;
	}

	public List<MusicRecom> getMusicRecoms() {
		return musicRecoms;
	}

	public void setMusicRecoms(List<MusicRecom> musicRecoms) {
		this.musicRecoms = musicRecoms;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public MusicRecomService getMusicRecomService() {
		return musicRecomService;
	}

	public void setMusicRecomService(MusicRecomService musicRecomService) {
		this.musicRecomService = musicRecomService;
	}

	public List<MusicType> getBigClass() {
		return bigClass;
	}

	public void setBigClass(List<MusicType> bigClass) {
		this.bigClass = bigClass;
	}

	public MuSicTypeService getMuSicTypeService() {
		return muSicTypeService;
	}

	public void setMuSicTypeService(MuSicTypeService muSicTypeService) {
		this.muSicTypeService = muSicTypeService;
	}

	/**
	 * 首页
	 * @return
	 */
	public String bigClass() {
		bigClass = muSicTypeService.findClass();
		/*
		 * musicType = muSicTypeService.findObjectClass(className);//һ������ musicRecoms
		 * = musicRecomService.findSmallClass(musicType.getTypeCode());
		 * //System.out.println(musicRecoms.get(0).getId().toString()+
		 * "musicRecoms.get(0).getId().toString()"); toClickVOs =
		 * countMusicRecService.findCountMusicRecs(musicRecoms.get(0).getId().toString()
		 * ); clickVOs =
		 * countMusicRecService.findClickVOs(musicRecoms.get(0).getId().toString());
		 * 
		 * clickMonVos =
		 * countMusicRecService.findMon(musicRecoms.get(0).getId().toString());
		 * 
		 * clickVO =
		 * countMusicRecService.findAll(musicRecoms.get(0).getId().toString());
		 */
		return "success";
	}

	/**
	 * 类目
	 * @return
	 */
	public String smallClass() {
		musicRecoms = musicRecomService.findSmallClass(typeCode);
		return "success";
	}

	/**
	 * 统计图表
	 * @return
	 */
	public String tongji() {
		List<ClickVO> findCountMusicRecs = countMusicRecService.findCountMusicRecs(typeCode);
		ClickVO ck1 = new ClickVO();
		for (ClickVO clickVO : findCountMusicRecs) {
			ck1.setClicks(clickVO.getClicks());
			ck1.setClickRen(clickVO.getClickRen());
			clickVOs.add(ck1);
		}
		List<ClickVO> findClickVOs = countMusicRecService.findClickVOs(typeCode);
		ClickVO ck2 = new ClickVO();
		for (ClickVO clickVO : findClickVOs) {
			ck2.setClicks(clickVO.getClicks());
			ck2.setClickRen(clickVO.getClickRen());
			clickVOs.add(ck2);
		}
		return "success";
	}

	/**
	 * 导出报表
	 * @return
	 */
	public String tjwExcel() {
		Object object = session.get("riqi");
		Object object2 = session.get("bianhao");
		String string = object.toString();
		String string2 = object2.toString();
		List<ClickDateVO> findSevenDay = countMusicRecService.findSevenDay(string, string2);
		ClickVO findAll = countMusicRecService.findAll(string, string2);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("推荐位明细统计表");
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
		cell.setCellValue("点击次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点击人数");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDay.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDay.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDay.get(i).getClicks());
			row.createCell(2).setCellValue(findSevenDay.get(i).getClickRen());
		}
		row = sheet.createRow(findSevenDay.size() + 2);
		row.createCell(0).setCellValue("点击总次数:" + findAll.getClicks());
		row.createCell(1).setCellValue("点击总人数:" + findAll.getClickRen());
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
		 * sdf.format(date); Object object3 = session.get("code"); String f1 = null; if
		 * (!object3.toString().equals("0")) { MusicType findObjectClass =
		 * muSicTypeService.findObjectClass(object3.toString()); f1 =
		 * fi.getAbsolutePath()+"\\"+findObjectClass.getTypeName()+"明细统计表_"+format+".xls
		 * "; }else { f1 = fi.getAbsolutePath()+"\\"+"推荐位明细统计表_"+format+".xls"; } Object
		 * object3 = session.get("class"); //System.out.println("save: "+f1); try{
		 * OutputStream outputStream = new FileOutputStream(f1); wb.write(outputStream);
		 * outputStream.close(); } catch(Exception e){} }else { //取消保存 }
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
	 * 页尾
	 * @return
	 */
	public String tjwAss() {
		if (code.equals("")) {
			code = "0";
		}
		session.put("code", code);
		clickVO = countMusicRecService.findAll(mub, code);
		return "success";
	}

	/**
	 * 推荐位2
	 * @return
	 */
	public String tjwtwo() {
		if (className.equals("")) {
			Object object = session.get("code");
			className = object.toString();
		} else {
			session.put("code", className);
		}
		zcode = "推荐位";
		musicType = muSicTypeService.findTypeCode(className);
		clickVO = countMusicRecService.findfzd(className);
		clickVO2 = countMusicRecService.findfzy(className);
		return "success";
	}

	/**
	 * 界面推荐位统计图表
	 * @return
	 */
	public String jmtjwtjtb() {
		session.put("day", mub);
		List<ClickDateVO> findSevenDayTJW = countMusicRecService.findSevenDayTJW(mub, code);
		for (ClickDateVO clickDateVO : findSevenDayTJW) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", clickDateVO.getClickDate());
			jObject.put("data", clickDateVO.getClicks());
			jObject.put("data2", clickDateVO.getClickRen());
			result.add(jObject);
		}
		return "success";
	}

	public String recClicksStat() {
		session.put("day", mub);
		try {
			recClicks = countMusicRecService.selectRecClicks(className, mub);
		} catch (Exception e) {
			logger.error("推荐位点击量统计出错：{}", e);
		}
		return "success";
	}

	/**
	 * 界面统计推荐位总计
	 * @return
	 */
	public String jmtjwzj() {
		clickVO = countMusicRecService.findAllTJW(mub, code);
		return "success";
	}

	/**
	 * 界面推荐位统计导出
	 * @return
	 */
	public String jmtjdc() {
		String day = session.get("day").toString();
		String code = session.get("code").toString();
		List<ClickDateVO> findSevenDayTJW = countMusicRecService.findSevenDayTJW(day, code);
		ClickVO findAllTJW = countMusicRecService.findAllTJW(day, code);
		MusicType findTypeCode = muSicTypeService.findTypeCode(code);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet(findTypeCode.getTypeName() + "推荐位统计表");
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
		cell.setCellValue("点击次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点击人数");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDayTJW.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDayTJW.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDayTJW.get(i).getClicks());
			row.createCell(2).setCellValue(findSevenDayTJW.get(i).getClickRen());
		}
		row = sheet.createRow(findSevenDayTJW.size() + 2);
		row.createCell(0).setCellValue("点击总次数:" + findAllTJW.getClicks());
		row.createCell(1).setCellValue("点击总人数:" + findAllTJW.getClickRen());
		/**
		 * 保存文件
		 */
		/*
		 * JFileChooser jf = new JFileChooser();
		 * jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG |
		 * JFileChooser.DIRECTORIES_ONLY); int showSaveDialog = jf.showSaveDialog(null);
		 * if(showSaveDialog==JFileChooser.APPROVE_OPTION){
		 */
		// 保存
		File fi = new File("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String format = sdf.format(date);
		String f1 = fi.getAbsolutePath() + "\\" + format + ".xls";
		System.out.println(f1);
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
		System.out.println(filename);
		// dele
		File f = new File(f1);
		f.delete();

		// }else {
		// 取消保存
		// }
		return "success";
	}

	/**
	 * 二级菜单全部统计
	 * @return
	 */
	public String erjiAll() {
		if (className.equals("")) {
			Object object = session.get("code");
			className = object.toString();
		} else {
			session.put("code", className);
		}
		zcode = "全部";
		musicType = muSicTypeService.findTypeCode(className);
		clickVO = countMusicRecService.findAllzd(className);
		clickVO2 = countMusicRecService.findAllzy(className);
		return "success";
	}

	/**
	 * 二级菜单全部统计图表
	 * @return
	 */
	public String ejAlltb() {
		session.put("day", mub);
		List<ClickDateVO> findSevenDayTJW = countMusicRecService.findAllSevenDay(mub, code);
		for (ClickDateVO clickDateVO : findSevenDayTJW) {
			JSONObject jObject = new JSONObject();
			jObject.put("name", clickDateVO.getClickDate());
			jObject.put("data", clickDateVO.getClicks());
			jObject.put("data2", clickDateVO.getClickRen());
			result.add(jObject);
		}
		return "success";
	}

	/**
	 * 二级菜单全部总计
	 * @return
	 */
	public String ejAllZJ() {
		clickVO = countMusicRecService.findAllClickVO(mub, code);
		return "success";
	}

	/**
	 * 二级菜单全部统计导出
	 * @return
	 */
	public String ejAllDC() {
		String day = session.get("day").toString();
		String code = session.get("code").toString();
		List<ClickDateVO> findSevenDayTJW = countMusicRecService.findAllSevenDay(day, code);
		ClickVO findAllTJW = countMusicRecService.findAllClickVO(day, code);
		MusicType findTypeCode = muSicTypeService.findTypeCode(code);
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet(findTypeCode.getTypeName() + "全部统计表");
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
		cell.setCellValue("点击次数");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("点击人数");
		cell.setCellStyle(style);

		// 循环将数据写入Excel
		for (int i = 0; i < findSevenDayTJW.size(); i++) {
			row = sheet.createRow(i + 1);
			// 创建单元格，设置值
			row.createCell(0).setCellValue(findSevenDayTJW.get(i).getClickDate());
			row.createCell(1).setCellValue(findSevenDayTJW.get(i).getClicks());
			row.createCell(2).setCellValue(findSevenDayTJW.get(i).getClickRen());
		}
		row = sheet.createRow(findSevenDayTJW.size() + 2);
		row.createCell(0).setCellValue("点击总次数:" + findAllTJW.getClicks());
		row.createCell(1).setCellValue("点击总人数:" + findAllTJW.getClickRen());
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
		 * fi.getAbsolutePath()+"\\"+findTypeCode.getTypeName()+"全部统计表_"+format+".xls";
		 * try{ OutputStream outputStream = new FileOutputStream(f1);
		 * wb.write(outputStream); outputStream.close(); } catch(Exception e){} }else {
		 * //取消保存 }
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

}
