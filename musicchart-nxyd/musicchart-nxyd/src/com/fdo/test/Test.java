package com.fdo.test;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.fdo.hum.CountMusicRec;
import com.fdo.hum.MonthlyMusicCategory;
import com.fdo.hum.MonthlyType;
import com.fdo.hum.MusicRecom;
import com.fdo.hum.MusicType;
import com.fdo.hum.RenewLog;
import com.fdo.hum.SysRole;
import com.fdo.hum.SysUser;
import com.fdo.hum.SysUserRole;
import com.fdo.hum.SysUserRoleId;
import com.fdo.hum.TBillMonth;
import com.fdo.hum.TBillMonthLog;
import com.fdo.service.CountBillMonthService;
import com.fdo.service.CountMusicCategoryService;
import com.fdo.service.CountMusicPlayService;
import com.fdo.service.CountMusicRecService;
import com.fdo.service.CountMusicVisitService;
import com.fdo.service.MuSicTypeService;
import com.fdo.service.MusicRecomService;
import com.fdo.service.SysUserService;
import com.fdo.vo.ActiveDateVO;
import com.fdo.vo.ActiveVO;
import com.fdo.vo.CPShouRuVO;
import com.fdo.vo.ClickDateVO;
import com.fdo.vo.ClickVO;
import com.fdo.vo.DeleFileName;
import com.fdo.vo.FindMusicInfoVO;
import com.fdo.vo.ShouRuDateVO;
import com.fdo.vo.SongDateVO;
import com.fdo.vo.SongVO;



public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		MuSicTypeService bean = (MuSicTypeService) cxt.getBean("muSicTypeService");
		MusicRecomService bean2 = (MusicRecomService) cxt.getBean("musicRecomService");
		CountMusicRecService bean3 = (CountMusicRecService) cxt.getBean("countMusicRecService");
		CountMusicVisitService bean4 = (CountMusicVisitService) cxt.getBean("countMusicVisitService");
		CountMusicCategoryService bean5 = (CountMusicCategoryService) cxt.getBean("countMusicCategoryService");
		CountMusicPlayService bean6 = (CountMusicPlayService) cxt.getBean("countMusicPlayService");
		CountBillMonthService bean7 = (CountBillMonthService) cxt.getBean("countBillMonthService");
		SysUserService bean8 = (SysUserService) cxt.getBean("sysUserService");
		
		List<ShouRuDateVO> findSevenDay = bean7.findSevenDay("7", "");
		for (ShouRuDateVO shouRuDateVO : findSevenDay) {
			System.out.println(shouRuDateVO.getRate());
		}
		/*List<ShouRuDateVO> findSRfeeAndPeopleDay = bean7.findSRfeeAndPeopleDay(null);
		for (ShouRuDateVO shouRuDateVO : findSRfeeAndPeopleDay) {
			System.out.println(shouRuDateVO.getRate());
		}*/
		/*ShouRuDateVO findAll = bean7.findAll("", "7");
		System.out.println(findAll.getRate());*/
		/*ShouRuDateVO findAll = bean7.findAll("", "7");
		System.out.println(findAll.getDate()+"dfs");*/
		/*RenewLog findAllLog = bean7.findAllLog();
		System.out.println(findAllLog.getRenewMonth()+"--"+findAllLog.getUnsubscribeMonth());*/
		/*File file = new File("");
		System.out.println(file);
		System.out.println("123");*/
		
		/*ShouRuDateVO findZdd = bean7.findZdd("", "", "", "0");
		System.out.println(findZdd.getPeople()+"--"+findZdd.getFee());*/
		/*List<TBillMonth> findDG = bean7.findDG("", "", "", "1");
		for (TBillMonth tBillMonth : findDG) {
			System.out.println(tBillMonth.getIsParent());
		}*/
		/*List<TBillMonthLog> findBillMonthLogs = bean7.findDD("", "", "", "1");
		for (TBillMonthLog tBillMonthLog : findBillMonthLogs) {
			System.out.println(tBillMonthLog.getDescription()+tBillMonthLog.getStatus());
		}*/
		//DeleFileName deleFileName = new DeleFileName();
		// deleFileName.deleFile(new File("C:\\Users\\waibao\\AppData\\Local\\MyEclipse 2016 CI\\演唱会推荐位统计表_20171024170900.xls"));
		/*BufferedImage image = new BufferedImage(70, 35,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文  
		Graphics g = image.getGraphics();
		System.out.println(g);
		*/
		/*List<ClickDateVO> findSevenDayTJW = bean3.findSevenDayTJW("2017-09-19,2017-09-24", "100310001000");
		for (ClickDateVO clickDateVO : findSevenDayTJW) {
			System.out.println(clickDateVO.getClickDate()+"--"+clickDateVO.getClicks());
		}
		System.out.println("======");
		List<ClickDateVO> findAllSevenDay = bean3.findAllSevenDay("2017-09-19,2017-09-24", "100310001000");
		for (ClickDateVO clickDateVO : findAllSevenDay) {
			System.out.println(clickDateVO.getClickDate()+"--"+clickDateVO.getClicks()+"--"+clickDateVO.getClickRen());
		}*/
		/*List<ActiveDateVO> findSevenDay = bean4.findSevenDay("7");
		for (ActiveDateVO activeDateVO : findSevenDay) {
			System.out.println(activeDateVO.getTotalUser());
		}*/
		/*ClickVO findAllTJW = bean3.findAllTJW("7", "100110001000");
		System.out.println(findAllTJW.getClicks());*/
		/*MusicRecom findMusicRecom = bean3.findMusicRecom("100110001000");
		System.out.println(findMusicRecom.getOnwClassName());*/
		/*List<ClickVO> findfzd = bean3.findfzd("100310001000");
		for (ClickVO clickVO : findfzd) {
			System.out.println(clickVO.getClicks());
		}*/
		/*List<ClickVO> findCountMusicRecs = bean3.findClickVOs("0");
		for (ClickVO clickVO : findCountMusicRecs) {
			System.out.println(clickVO.getClicks());
		}*/
		/*List<CPShouRuVO> findCpShouRuVOs = bean7.findCpShouRuVOs("7");
		for (CPShouRuVO cpShouRuVO : findCpShouRuVOs) {
			System.out.println(cpShouRuVO.getCpId()+"--"+cpShouRuVO.getCpName()+"--"+cpShouRuVO.getTotl()+"--"+cpShouRuVO.getId()+"--"+cpShouRuVO.getJin2());
		}*/
		/*List<CPShouRuVO> findObjects = bean6.findObjects("30");
		for (CPShouRuVO cpShouRuVO : findObjects) {
			System.out.println(cpShouRuVO.getCpId()+"--"+cpShouRuVO.getCpName()+"--"+cpShouRuVO.getTotl()+"--"+cpShouRuVO.getId()+"--"+cpShouRuVO.getJin());
		}*/
		/*SongVO findUserCPAll = bean6.findUserCPAll("30", "","1042735");
		System.out.println(findUserCPAll.getSumClick());*/
		/*SysUser findSysUser = bean8.findSysUser("52");
		findSysUser.setModifyDateTime(new Timestamp(new Date().getTime()));
		findSysUser.setLoginName("小鸡猜猜");
		bean8.updateUserInfo(findSysUser);*/
		/*SongVO findUserCPAll = bean6.findUserCPAll("7", "PC003","");
		System.out.println(findUserCPAll.getSumClick());*/
		/*List<SongDateVO> findUserCPSevenDay = bean6.findUserCPSevenDay("7", "CP003", "1042735");
		for (SongDateVO songDateVO : findUserCPSevenDay) {
			System.out.println(songDateVO.getSumClick());
		}*/
		/*List<FindMusicInfoVO> findUserCPLikesMusicInfoVOs = bean6.findUserCPLikesMusicInfoVOs("修炼", "", "CP003");
		for (FindMusicInfoVO findMusicInfoVO : findUserCPLikesMusicInfoVOs) {
			System.out.println(findMusicInfoVO.getMusicName());
		}*/
		/*SysUser findSysUser = bean8.findSysUser("39");
		System.out.println(findSysUser.getLoginName());
		bean8.deleUserInfo(findSysUser);
		System.out.println("1");*/
		/*SysUser sysUser = new SysUser();
		sysUser.setUserId(Integer.parseInt("39"));
		bean8.deleUserInfo(sysUser);*/
		/*List<UserInfoVO> findAllUserInfo = bean8.findAllUserInfo();
		for (UserInfoVO sysUser : findAllUserInfo) {
			System.out.println(sysUser.getLoginName());
		}*/
		/*SysUser sysUser = new SysUser();
		sysUser.setBirth("1112");
		sysUser.setCpId("cp123");
		sysUser.setLoginName("jo33h");
		sysUser.setOrgId("cp123");
		sysUser.setPassword("123");
		sysUser.setUserDesc("中九研发");
		sysUser.setCreateDateTime(new Timestamp(new Date().getTime()));
		sysUser.setModifyDateTime(new Timestamp(new Date().getTime()));
		sysUser.setUserSex(Short.parseShort("0"));
		sysUser.setStatus(Short.parseShort("0"));
		sysUser.setUserType(Short.parseShort("3"));
		sysUser.setUserName("xiong");
		bean8.addUserInfo(sysUser);*/
		/*List<TBillMonth> findBillMonths = bean7.findBillMonths("", "HH005823481002@VOD");
		for (TBillMonth tBillMonth : findBillMonths) {
			System.out.println(tBillMonth.getProductName());
		}*/
		/*MonthlyType findProduct = bean7.findProduct("packageIDa1000000000000000000071");
		System.out.println(findProduct.getTitle());*/
		/*List<ShouRuDateVO> findSRfeeAndPeopleDay = bean7.findSRfeeAndPeopleDay("packageIDa1000000000000000000071");
		for (ShouRuDateVO shouRuDateVO : findSRfeeAndPeopleDay) {
			System.out.println(shouRuDateVO.getFee());
		}*/
		/*List<MonthlyType> findSamllclassAll = bean7.findSamllclassAll();
		for (MonthlyType monthlyType : findSamllclassAll) {
			System.out.println(monthlyType.getTitle());
		}*/
		/*MonthlyMusicCategory findClass = bean7.findClass("packageIDa1000000000000000000071");
		System.out.println(findClass.getMonthlyCategoryName());*/
		/*List<MonthlyMusicCategory> findAll = bean7.findAll();
		for (MonthlyMusicCategory monthlyMusicCategory : findAll) {
			System.out.println(monthlyMusicCategory.getMonthlyCategoryName());
		}*/
		/*ShouRuDateVO findAll = bean7.findAll("7");
		System.out.println(findAll.getRate());*/
		/*List<SongDateVO> findSevenDay = bean6.findSevenDay("30");
		for (SongDateVO songDateVO : findSevenDay) {
			System.out.println(songDateVO.getClickDate()+"---"+songDateVO.getNewSong()+"---"+songDateVO.getSumClick());
		}*/
		/*List<ClickDateVO> findSevenDay = bean5.findSevenDay("180", "100110011000");
		for (ClickDateVO clickDateVO : findSevenDay) {
			System.out.println(clickDateVO.getClickDate()+clickDateVO.getClicks());
		}*/
		/*String seven = "7";
		String day = "2017-09-05 09:52:35,2017-09-22 09:52:33";
		List<ActiveDateVO> findSevenDay = bean4.findSevenDay(day);
		for (ActiveDateVO activeDateVO : findSevenDay) {
			System.out.println(activeDateVO.getClickDate()+activeDateVO.getTotalUser());
		}*/
		/*JFileChooser fd = new JFileChooser();  
		  //fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
		  fd.showOpenDialog(null);  
		  File f = fd.getSelectedFile();  
		  if(f != null){}*/
	      /*JFileChooser jFileChooser = new JFileChooser();  */
	       /* 
			这是尤为重要的。因为JFileChooser默认的是选择文件，而需要选目录。 
			        故要将DIRECTORIES_ONLY装入模型 
			        另外，若选择文件，则无需此句 
			 */  
	       /*jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
	       //设置文件选择器的默认路径  
	        jFileChooser.setCurrentDirectory(new java.io.File("D:\\"));  
	        //设置窗口标题  
	        jFileChooser.setDialogTitle("选择保存目录");  
	        jFileChooser.setFont(new java.awt.Font("新宋体", 0, 14)); // NOI18N  
	       int i = jFileChooser.showSaveDialog(null);  
	       if (i == JFileChooser.APPROVE_OPTION) {  
	           //jFileChooser.show(true);  
	           //输出绝对路径  
	          System.out.println(jFileChooser.getSelectedFile().getAbsolutePath());   
	       }*/
	      
	      /*JFileChooser c = new JFileChooser();
	      c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	      c.setDialogTitle("Select path to save");
	      int result = c.showOpenDialog(null);
	      if (result == JFileChooser.APPROVE_OPTION) {
	    	  String path = c.getSelectedFile().getAbsolutePath();
	    	  System.out.println(path);
	      }*/
		
		/*JFileChooser jf = new JFileChooser();  
		  jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
		  //jf.showDialog(null, "保存");//这行代码取代showOpenDialog和showSaveDialog
		  Component comp = getLabelForInChooser(jf, "FileChooser.fileNameLabelText");  
		  int showSaveDialog = jf.showSaveDialog(comp);
		  if(showSaveDialog==JFileChooser.APPROVE_OPTION){ 
			  File fi = jf.getSelectedFile();  
			  String f1 = fi.getAbsolutePath()+"\\test.txt";  
			  System.out.println("save: "+f1);  
			  try{  
			      FileWriter out = new FileWriter(f1);  
			      out.write("successful!!!");  
			      out.close();  
			  }  
			  catch(Exception e){}
		  }else {
			System.out.println("取消");
		}*/
		  
		/*System.out.println("123");
		String day = "2017-09-05 09:52:35,2017-09-22 09:52:33";
		List<ShouRuDateVO> findSevenDay = bean7.findSevenDay(day);
		for (int i = 0; i < findSevenDay.size(); i++) {
			System.out.println(findSevenDay.get(i).getDate());
		}*/
		/*Date date3 = null;
		Date date = null;
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd"); 
		String da = "2017-09-22 09:52:35";
		String x = "2017-08-05 09:52:33";
		int b = 7;
		date3 = format2.parse(da);
		date = format2.parse(x);
		int a = (int) ((date3.getTime() - date.getTime()) / (1000*3600*24)); 
		long b1 = (long)(1000*3600*24)*30;
		for (int i = 0; i < a; i++) {
			long time = date3.getTime() - (long)(1000*60*60*24)*i;
			Date date2 = new Date(time);
			String format = format2.format(date2);
			System.out.println("format----"+format);
		}
		System.out.println("a--"+a);*/
		/*if (b==7) {
			Calendar time = Calendar.getInstance();
			time.add(Calendar.DAY_OF_MONTH, -i);
			Date date2 = time.getTime();
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = sdft.format(date2);
		}
		for (int i = 0; i <= a; i++) {
			SimpleDateFormat sdDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long time = date3.getTime() - (1000*60*60*24)*i;
			Date date2 = new Date(time);
			String format3 = sdDateFormat.format(date2);
			System.out.println(format3);
		}*/
		/*
		String seven = "7";
		String day = "2017-09-22 09:52:35,2017-09-05 09:52:33";
		List<ShouRuDateVO> findSevenDay = bean7.findSevenDay(day);
		for (int i = 0; i < findSevenDay.size(); i++) {
			System.out.println(findSevenDay.get(i).getDate());
		}*/
		/*String dateStr = "2008-1-1 1:21:28";
        String dateStr2 = "2010-1-2 1:21:28";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try 
        {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);
            int days = (int) ((date2.getTime() - date.getTime()) / (1000*3600*24));
            System.out.println("days"+days);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
		/*List<ShouRuDateVO> findSevenDay = bean7.findSevenDay("7");*/
		/*List<ShouRuDateVO> findMon = bean7.findMon();*/
		/*List<ShouRuDateVO> findYesrMon = bean7.findYesrMon("2017,08");*/
		/*ShouRuDateVO shouRuDateVO = bean7.findAll();
		List<ShouRuDateVO> findMon = bean7.findMon();
		System.out.println("����:"+shouRuDateVO.getDate()+"��ң�"+shouRuDateVO.getFee()+"������"+shouRuDateVO.getPeople()+"ת���ʣ�"+shouRuDateVO.getRate()+"�˶���"+shouRuDateVO.getUnpeople());
		*/
		/*double a1 = 1.0;
		double b1 = 3.0;
		double c1 = ((b1/a1)*100);
		if (Double.isNaN(c1)) {
			System.out.println("nnnnnnnnnnnn");
		}else {
			System.out.println("yyyyyyyyyyyyy");
		}
		System.out.println(c1);
		DecimalFormat decimalFormat1 = new DecimalFormat("###################");  
		String format51 = decimalFormat1.format(c1);
		String f1 = format51+"%";
		System.out.println("a1:"+a1+"b1:"+b1+"c1:"+c1+"for51:"+format51+"f1:"+f1);*/
		/*List<ShouRuDateVO> findSRfeeAndPeopleDay = bean7.findSRfeeAndPeopleDay();
		System.out.println(findSRfeeAndPeopleDay.get(0).getFee());
		System.out.println(findSRfeeAndPeopleDay.get(1).getFee());*/
		/*List<FindMusicInfoVO> findLikesMusicInfoVOs = bean6.findLikesMusicInfoVOs("", "2");
		for (FindMusicInfoVO findMusicInfoVO : findLikesMusicInfoVOs) {
			System.out.println(findMusicInfoVO.getMusicName());
		}*/
		/*List<FindMusicInfoVO> findMusicInfoVOs = bean6.findMusicInfoVOs();
		for (FindMusicInfoVO findMusicInfoVO : findMusicInfoVOs) {
			System.out.println(findMusicInfoVO.getMusicName()+findMusicInfoVO.getPlayerName());
		}*/
		/*SongVO findAll = bean6.findAll();
		System.out.println(findAll.getSumClick()+":"+findAll.getSumClickRen()+":"+findAll.getNewSong());*/
		/*List<SongDateVO> findYesrMon2 = bean6.findYesrMon2("2017,09");
		for (SongDateVO songDateVO : findYesrMon2) {
			System.out.println(songDateVO.getClickDate()+":"+songDateVO.getNewSong());
		}*/
		/*List<SongDateVO> findYesrMon = bean6.findYesrMon("2017,09");
		for (SongDateVO songDateVO : findYesrMon) {
			System.out.println(songDateVO.getClickDate()+":"+songDateVO.getSumClick()+":"+songDateVO.getSumClickRen());
		}*/
		/*List<SongDateVO> findMon2 = bean6.findMon2();
		for (SongDateVO songDateVO : findMon2) {
			System.out.println(songDateVO.getClickDate()+":"+songDateVO.getNewSong());
		}*/
		/*List<SongDateVO> findMon = bean6.findMon();
		for (SongDateVO songDateVO : findMon) {
			System.out.println(songDateVO.getClickDate()+":"+songDateVO.getSumClick()+":"+songDateVO.getSumClickRen());
		}*/
		/*List<MusicType> findBigClass = bean.findBigClass();
		for (MusicType musicType : findBigClass) {
			System.out.println(musicType.getPcode());
		}*/
		/*List<SongDateVO> findSevenDay = bean6.findSevenDay("30");
		List<SongDateVO> findSevenDay2 = bean6.findSevenDay2("30");
		List<SongDateVO> f3 = new ArrayList<SongDateVO>();
		for (SongDateVO songDateVO : findSevenDay2) {
			System.out.println("��:"+songDateVO.getNewSong());
		}
		for (SongDateVO s1 : findSevenDay) {
			SongDateVO s = new SongDateVO();
			for (SongDateVO s2 : findSevenDay2) {
				if (s1.getClickDate().equals(s2.getClickDate())) {
					s1.setNewSong(s2.getNewSong());
				}
			}
			
		}
		for (SongDateVO songDateVO : findSevenDay) {
			System.out.println(songDateVO.getClickDate()+"xing:"+songDateVO.getNewSong()+"dianji:"+songDateVO.getSumClick());
		}*/
		/*SongVO findCountMusicPlayDay = bean6.findCountMusicPlayDay();
		System.out.println("��Ŀ����:"+findCountMusicPlayDay.getSumSong()+"����Ŀ��"+findCountMusicPlayDay.getNewSong()+"���Ŵ�����"+findCountMusicPlayDay.getSumClick()+"����������"+findCountMusicPlayDay.getSumClickRen());
		*//*List<SongVO> findCountMusicPlayDay = bean6.findCountMusicPlayDay();
		System.out.println(findCountMusicPlayDay);*/
		/*MusicType findTypeCode = bean.findTypeCode("100510141000");
		System.out.println("xiaoleide : "+findTypeCode.getTypeName() );
		System.out.println("typeCode : "+findTypeCode.getPcode());
		MusicType findTypeCode2 = bean.findTypeCode(findTypeCode.getPcode());
		System.out.println("daleide : "+findTypeCode2.getTypeName());*/
		/*List<ClickDateVO> findYesrMon = bean5.findYesrMon("100710011000,2017,08");
		for (ClickDateVO clickDateVO : findYesrMon) {
			System.out.println(clickDateVO.getClickDate()+"--"+clickDateVO.getClicks());
		}*/
		/*List<ClickDateVO> findMon = bean5.findMon("100710011000");
		for (ClickDateVO clickDateVO : findMon) {
			System.out.println(clickDateVO.getClickDate()+"--"+clickDateVO.getClicks());
		}*/
		/*List<ClickDateVO> findSevenDay = bean5.findSevenDay("7", "100710011000");
		for (ClickDateVO clickDateVO : findSevenDay) {
			System.out.println(clickDateVO.getClickDate()+"--"+clickDateVO.getClicks());
		}*/
		
		/*List<ClickVO> findCountMusicCategoryYesterday = bean5.findCountMusicCategoryYesterday("100810011000");
		for (ClickVO clickVO : findCountMusicCategoryYesterday) {
			System.out.println(clickVO.getClicks()+"+"+clickVO.getClickRen());
		}*/
		/*List<ClickVO> findCountMusicCategoryDay = bean5.findCountMusicCategoryDay("100810011000");
		for (ClickVO clickVO : findCountMusicCategoryDay) {
			System.out.println(clickVO.getClicks()+"+"+clickVO.getClickRen());
		}*/
/*		List<ClickDateVO> findMon = bean3.findMon("420");
		for (ClickDateVO clickDateVO : findMon) {
			System.out.println(clickDateVO.getClickDate()+"---"+clickDateVO.getClicks());
		}*/
/*		List<ActiveDateVO> findMon = bean4.findMon();
		for (ActiveDateVO activeDateVO : findMon) {
			System.out.println(activeDateVO.getClickDate()+"----"+activeDateVO.getRatio());
		}*/
/*		ActiveVO findAll = bean4.findAll();
		System.out.println("�ܴ�����"+findAll.getTotalUser()+"��������"+findAll.getActiveUser());
		*/
		/*List<ActiveDateVO> findSevenDay = bean4.findSevenDay("7");
		for (ActiveDateVO activeDateVO : findSevenDay) {
			System.out.println("ʱ�䣺"+activeDateVO.getClickDate()+"���û�����"+activeDateVO.getTotalUser()+"��Ծ�û�����"+activeDateVO.getActiveUser());
		}*/
/*		List<ActiveVO> findCountMuSicVisitDay = bean4.findCountMuSicVisitDay();
		List<ActiveVO> findCountMuSicVisitYesterday = bean4.findCountMuSicVisitYesterday();
		for (ActiveVO activeVO : findCountMuSicVisitDay) {
			System.out.println("���û�����"+activeVO.getTotalUser()+"  ��Ծ�û�����"+activeVO.getActiveUser()+"  �ٷֱȣ�"+activeVO.getRatio());
		}
		for (ActiveVO activeVO : findCountMuSicVisitYesterday) {
			System.out.println("���û�����"+activeVO.getTotalUser()+"  ��Ծ�û�����"+activeVO.getActiveUser()+"  �ٷֱȣ�"+activeVO.getRatio());
		}*/
		
/*		System.out.println("------");
		ActiveVO aVo = new ActiveVO();
		int a = 120;
		int b = 30;
		Double valueOf = Double.valueOf(a);
		Double valueOf2 = Double.valueOf(b);
		aVo.setTotalUser(120);
		aVo.setActiveUser(30);
		int c = b/a;
		int d = c*100;
		System.out.println(c);*/
		/*List<ClickDateVO> findSevenDay = bean3.findSevenDay("30", "420");
		for (ClickDateVO clickDateVO : findSevenDay) {
			System.out.println("day:"+clickDateVO.getClickDate()+"cishu:"+clickDateVO.getClicks()+"renshu"+clickDateVO.getClickRen());
		}*/
		/*List<ClickDateVO> findYesrMon = bean3.findYesrMon("420,2016,9");
		for (ClickDateVO clickDateVO : findYesrMon) {
			System.out.println("riqi "+clickDateVO.getClickDate()+"dianjicis "+clickDateVO.getClicks()+"dianjirenshu "+clickDateVO.getClickRen());
		}*/
	/*	String yearString = "1999";
		String monString = "09";
		for (int j = 0; j < 7; j++) {
			SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
			String ri = yearString+"-"+monString+"-"+j+" ";
			Date date = sdft.parse(ri);
			String format = sdft.format(date);
			System.out.println(format);
		}*/
		/*String yearString = "1999";
		String monString = "09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, Integer.parseInt(yearString));  
        a.set(Calendar.MONTH, Integer.parseInt(monString) - 1);  
        a.set(Calendar.DATE, 1);  
        a.roll(Calendar.DATE, -1);  
        int maxDate = a.get(Calendar.DATE); 
        String riqi1 = yearString+"-"+monString+"-"+"01 00:00:00";
        String riqi2 = yearString+"-"+monString+"-"+maxDate+" 23:59:59";
        Date parse = sdf.parse(riqi1);
        Date fdDate = sdf.parse(riqi2);
        String format = sdf.format(parse);
        String format2 = sdf.format(fdDate);
        System.out.println(format);
        System.out.println(format2);*/
		/*Date date = new Date();
		System.out.println(date.getDate());*/
/*		List<ClickVO> findAll = bean3.findAll("420");
		for (ClickVO clickVO : findAll) {
			System.out.println(clickVO.getClicks()+":"+clickVO.getClickRen());
		}*/
/*		List<ClickVO> findCountMusicRecs = bean3.findCountMusicRecs("420");
		List<ClickVO> findClickVOs = bean3.findClickVOs("420");
		for (ClickVO clickVO : findCountMusicRecs) {
			System.out.println(clickVO.getClicks()+"=="+clickVO.getClickRen());
		}
		for (ClickVO clickVO : findClickVOs) {
			System.out.println(clickVO.getClicks()+"=="+clickVO.getClickRen());
		}*/
/*		List<ClickDateVO> findMon = bean3.findMon("420");
		for (ClickDateVO clickDateVO : findMon) {
			System.out.println(clickDateVO.getClickDate()+":"+clickDateVO.getClicks()+","+clickDateVO.getClickRen());
		}*/
		
		
		/*List<ClickDateVO> findSevenDay = bean3.findSevenDay("420");
		for (ClickDateVO clickDateVO : findSevenDay) {
			System.out.println(clickDateVO.getClickDate()+"��"+clickDateVO.getClicks()+","+clickDateVO.getClickRen());
		}*/
/*		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_MONTH, -13);
		Date day = instance.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sevenDay = sdf.format(day);
		System.out.println(sevenDay);*/
/*		List<MusicType> findBigClass = bean.findBigClass();
		List<MusicType> findSmal = new ArrayList<MusicType>();
		
		List<Map<MusicType,List<MusicType>>> m3 = new ArrayList<Map<MusicType,List<MusicType>>>();
		for (MusicType musicType : findBigClass) {
			//System.out.println("bigClass:"+musicType.getTypeName());
			Map<MusicType,List<MusicType>> map2 = new HashMap<MusicType, List<MusicType>>();
			findSmal = bean.findSmaClass(musicType.getTypeCode());
			map2.put(musicType, findSmal);
			m3.add(map2);
		}
		for (Map<MusicType, List<MusicType>> map : m3) {
			Set<MusicType> get = map.keySet(); 
			for (MusicType musicType : get) {
				System.out.println(musicType.getTypeName());
				for (MusicType m21 : map.get(musicType)) {
					System.out.println(m21.getTypeName());
				}
			}	
		}*/
		
/*		for (MusicType musicType : m1) {
			System.out.println("-------"+musicType.getTypeName());
			for (MusicType mu : m2) {
				System.out.println(mu.getTypeName());
			}
		}*/
		
/*		for (MusicType m1 : findBigClass) {
			System.out.println("dalei:"+m1.getTypeName());
			for (MusicType m2 : findSmal) {
				System.out.println("xiaolei:"+m2.getTypeName());
			}
		}*/
/*		List<Map<MusicType,List<MusicType>>> list = new ArrayList<Map<MusicType,List<MusicType>>>();
		List<MusicType> findBigClass = bean.findBigClass();
		for (MusicType musicType : findBigClass) {
			Map<MusicType,List<MusicType>> map = new HashMap<MusicType, List<MusicType>>();
			List<MusicType> findSmaClass = bean.findSmaClass(musicType.getTypeCode());
			map.put(musicType, findSmaClass);
			list.add(map);
		}
		for (Map<MusicType, List<MusicType>> musicType : list) {
			for (int i = 0; i < musicType.keySet().size(); i++) {
				System.out.println(musicType.get(MusicType.class).get(i).getTypeName());
			}
		}*/
		
		
		/*List<MusicType> findClass = bean.findClass("25");
		for (MusicType musicType : findClass) {
			System.out.println(musicType.getId());
		}*/
		
		/*List<ClickVO> findClickVOs = bean3.findClickVOs("414");
		for (ClickVO clickVO : findClickVOs) {
			System.out.println("zuotian"+clickVO.getClicks());
		}
		List<ClickVO> findCountMusicRecs = bean3.findCountMusicRecs("414");
		for (ClickVO clickVO : findCountMusicRecs) {
			System.out.println("jintian"+clickVO.getClicks());
		}*/
		
		/*List<ClickVO> findCountMusicRecs = bean3.findCountMusicRecs("414");
		System.out.println(findCountMusicRecs.size());*/
		/*MusicType findObjectClass = bean.findObjectClass("25");
		System.out.println(findObjectClass.getTypeName());*/
		/*Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)  + 1; // Jan = 0, not 1
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(calendar);
		
		for (int i = 1; i <= dayOfMonth; i++)
		{
		System.out.println(year + "/" + month + "/" + i);
		}*/
/*		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String   dateStr1="2017-9-11"; 
		String      dateStr2="2017-9-30"; 
		java.util.Date dateBegin=formater.parse(dateStr1);
		java.util.Date dateEnd=formater.parse(dateStr2);  
		System.out.println(dateBegin);
		System.out.println(dateEnd);
		Calendar   ca=Calendar.getInstance(); 
		while(dateBegin.compareTo(dateEnd)<=0){             
		             ca.setTime(dateBegin);   
		              ca.add(ca.DATE,1);//��dateBegin����1��Ȼ�����¸�ֵ��date1   
		              dateBegin=ca.getTime();   
		              String dateString = new SimpleDateFormat("yyyy-MM-dd").format(dateBegin);
		              System.out.println(dateString);
		       }
		//2��Java��ȡ���µĵ�һ������һ��
		Calendar cal = Calendar.getInstance(); 
		SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
		             //��ǰ�µ����һ��   
		             cal.set( Calendar.DATE, 1 );
		             cal.roll(Calendar.DATE, - 1 );
		             Date endTime=cal.getTime();
		             String endTime1=datef.format(endTime)+" 23:59:59";
		              //��ǰ�µĵ�һ��          
		             cal.set(GregorianCalendar.DAY_OF_MONTH, 1); 
		              Date beginTime=cal.getTime();
		             String beginTime1=datef.format(beginTime)+" 00:00:00";
		             System.out.println(endTime1);
		             System.out.println(beginTime1);
		             while(beginTime.compareTo(endTime)<=0){
		            	 ca.setTime(beginTime);
		            	 ca.add(ca.DATE,1);
		            	 Date time = ca.getTime();
		            	 String dateString = new SimpleDateFormat("yyyy-MM-dd").format(time);
			              System.out.println(dateString);
		             }
		*/
		/*List<ClickVO> findCountMusicRecs = bean3.findCountMusicRecs("412");
		for (ClickVO clickVO : findCountMusicRecs) {
			System.out.println("�������"+clickVO.getClicks());
			System.out.println("�������"+clickVO.getClickRen());
		}*/
		//System.out.println(findCountMusicRecs.size());
		//Date today = new Date();
		//Date start = new Date();
		//Date end = new Date();
	    //SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
	    //SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    //start = formater2.parse(formater.format(new Date())+ " 00:00:00");
	    //end = formater2.parse(formater.format(new Date())+ " 23:59:59");
	    //System.out.println(start);
	    //System.out.println(end);
	    //Calendar   cal   =   Calendar.getInstance();
	    //cal.add(Calendar.DATE,   -1);
	    //String yesterday = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	    //System.out.println(yesterday);
		/* System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(today));
		System.out.println(today.getTime());
		System.out.println(1477058241633L-86400000L);*/
		//Date yesterday = new Date(today.getTime() - 86400000L);//86400000L��������˼��˵1���ʱ��=24Сʱ x 60���� x 60�� x 1000���� ��λ��L��
		//��86400000L����д�� 24*60*60*1000L
		//System.out.println(24*60*60*1000L);
		//System.out.println(today);
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(yesterday));
		//List<MusicRecom> findSmallClass = bean2.findSmallClass("100610001000");
		//System.out.println(findSmallClass.size());
		//List<MusicType> findClass = bean.findClass();
		/*for(MusicType mt : findClass){
			System.out.println(mt.getTypeName());
		}*/
	}

}
