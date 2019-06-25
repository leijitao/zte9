<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订购记录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="订购记录">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/home.css">
	
    <style type="text/css">
    	.a_q {
			text-decoration: none;
			color: black;
			display: block;
			width: 80px;
			text-align: center;
		}
		.a_q a:hover {
			font-weight: bold;
		}
		.page {
			cursor: pointer;
		}
		@charset "utf-8";
		* { outline:none; margin:0; padding:0; font-family:microsoft yahei; }
		ul, li { list-style:none; }
		.inputElem { width:198px; height:22px; line-height:22px; border:1px solid #ccc; }
		.parentCls { width:200px; height:auto; margin:0 auto; }
		.auto-tip li { width:100%; text-align:left; height:22px; line-height:22px; font-size:14px; }
		.auto-tip li.hoverBg { background:#ddd; cursor:pointer; }
		.auto-tip li em { font-style:normal; }
		.red { color:#333; }
		.hidden { display:none; }
    </style>
  </head>
  
  <body>
    <div>
    	<div class="tui_1_tongji" style="height: 150px;">
    		<div class="tui_1_tongji_head"><span>订购记录</span></div>
    		<!-- <div class="tui_1_table_div">
    		<form action="FindTBillMonthInfo" method="post">
    		<table class="tui_1_table_1">
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td></td>
    				<td>订单编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="orderId" /></td>
    				<td style="text-align: left;">用户编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="parentCls"><input type="text" name="userId" id="mail" class="inputElem" /></span>
    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" />
    				</td>
    				<td></td>
    			</tr>
    		</table>
    		</form>
    		</div> -->
    		<div class="tui_1_table_div">
    		<div style="padding-top: 30px;"></div>
    		<form  action="FindTBillMonthLogInfo" method="post" id="number">
    			<table>
    				<tr class="tui_1_table_1_tr" style="border: 0px;">
    					<td style="padding-left: 100px;"><span>开始：<input id="state" name="state" class="Wdate" size="10" type="text" value="${state}" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></span>
    						<span>结束：<input id="end" name="end" class="Wdate" size="10" type="text" value="${end}" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></span></td>
    					<td style="padding-left: 70px;"><input type="hidden" name="page" value="0" id="page"></td>
    					<td>
    						<span>产品名称：</span>
    						<select name="productID" id="productID">
    							<option selected="selected">ALL</option>
    							<c:forEach items="${findSamllclassAll}" var="a">
    								<option value="${a.productId}">${a.memo1}</option>
    							</c:forEach>
    						</select>
    					</td>
    					<td>
    						<span style="padding-left: 20px;">状态：</span>
    						<select name="status" id="status">
    							<option selected="selected">ALL</option>
    							<option value="1">成功</option>
    							<option value="2">续订</option>
    							<option value="3">订购</option>
    							<option value="00">失败</option>
    							<option value="0">下单</option>
    						</select>
    					</td>
    					<td style="padding-left: 20px;"><input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" /></td>
    				</tr>
    				<tr>
    					<td class="zongji">
    						<span>订单总量：<span>${srdvoDateVO.people}</span></span>
    						<c:choose>
								<c:when test="${status == 0}">
									
								</c:when>
								<c:when test="${isParent == 2}">
									<span style="padding-left: 20px;">金额总数：<span>${srdvoDateVO.fee}￥</span></span>
								</c:when>
								<c:when test="${status == 1}">
									<span style="padding-left: 20px;">金额总数：<span>${srdvoDateVO.fee}￥</span></span>
								</c:when>
								<c:otherwise>
									<span style="padding-left: 20px;">金额总数：<span>${srdvoDateVO.fee}￥</span></span>
								</c:otherwise>
							</c:choose>
    						<%-- <span style="padding-left: 20px;">金额总数：<span>${srdvoDateVO.fee}￥</span></span> --%>
    					</td>
    					<td class="zongji">
    						<span style="padding-left: 20px;">成功总数：<span>${srdvoDateVO.rate}</span></span>
    					</td>
    					<td class="zongji">
    						<span style="padding-left: 20px;">续订总数：<span>${srdvoDateVO.rens}</span></span>
    					</td>
    					<td class="zongji">
    						<span style="padding-left: 20px;">订购总数：<span>${srdvoDateVO.unpeople}</span></span>
    					</td>
    				</tr>
    			</table>
    		</form>
    		</div>
    	</div>
    	<div class="tui_1_mingxi">
    		<div class="tui_1_tongji_head">
    			<span style="float: left;">订购</span>
    			<div style="float:left;padding-left: 90%">
    				<input type="button" onclick="query()" value="导出" />
    			</div>
    		</div>
    		</div>
    		<div>
    			<table style="border: 1px Gainsboro solid;width: 100%;text-align: center;line-height: 30px;"  cellpadding="0px" cellspacing="0px">
    				<tr style="border: 1px Gainsboro solid;">
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">序号</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">订单编号</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">用户ID</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">产品名称</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">价格</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">状态</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">订购时间</td>
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">备注</td>
    				</tr>
    				<c:forEach items="${billMonthLogs}" var="l" varStatus="va">
    					<tr id="${va.index+1}"  style="border: 1px Gainsboro solid;">
    						<td style="border: 1px Gainsboro solid;">${va.index+1}</td>
    						<td style="border: 1px Gainsboro solid;">${l.orderNo}</td>
    						<td style="border: 1px Gainsboro solid;">${l.userId }</td>
    						<td style="border: 1px Gainsboro solid;">${l.productName}</td>
    						<td style="border: 1px Gainsboro solid;">${l.totalFee}</td>
    						<c:choose>
								<c:when test="${l.status == 0}">
									<td style="border: 1px Gainsboro solid;">下单</td>
								</c:when>
								<c:when test="${l.isParent == 2}">
									<td style="border: 1px Gainsboro solid;">续订</td>
								</c:when>
								<c:when test="${l.isParent == 1 && l.status == 1}">
									<td style="border: 1px Gainsboro solid;">订购</td>
								</c:when>
								<c:when test="${l.status == 1}">
									<td style="border: 1px Gainsboro solid;">成功</td>
								</c:when>
								<c:otherwise>
									<td style="border: 1px Gainsboro solid;">${l.status}</td>
								</c:otherwise>
							</c:choose>
    						<td style="border: 1px Gainsboro solid;"><fmt:formatDate value="${l.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
    						<c:choose>
								<c:when test="${l.status == 0}">
									<td style="border: 1px Gainsboro solid;">下单</td>
								</c:when>
								<c:when test="${l.isParent == 2}">
									<td style="border: 1px Gainsboro solid;">续订</td>
								</c:when>
								<c:when test="${l.isParent == 1 && l.status == 1}">
									<td style="border: 1px Gainsboro solid;">订购</td>
								</c:when>
								<c:when test="${l.status == 1}">
									<td style="border: 1px Gainsboro solid;">成功</td>
								</c:when>
								<c:otherwise>
									<td style="border: 1px Gainsboro solid;">${l.description}</td>
								</c:otherwise>
							</c:choose>
    					</tr>
    				</c:forEach>
    			</table>
    		</div>
    		<div class="food">
    			<div><span onclick="hpage()" class="page">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="on()" class="page">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span>${pg}/${pa}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="next()" class="page">下一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="back()" class="page">尾页</span></div>
    		</div>
    	</div>
    	<script language="javascript" type="text/javascript" src="js/WdatePicker.js"></script>
    	<script language="javascript" type="text/javascript" src="js/jquery-1.8.3.js"></script>
    	<script language="javascript" type="text/javascript" src="js/emailAutoComplete.js"></script>
    	<script>
    		function query(){
     			window.location='SRMXDCExcelAction.action';
    		} 
    		function on(){
    			var productID = $('#productID').val();
    			var status = $('#status').val();
    			var page = ${page-20};
    			$('#page').val(page);
    			$('#number').submit();
    		}
    		function next(){
    			var productID = $('#productID').val();
    			var status = $('#status').val();
    			var page = ${page+20};
    			$('#page').val(page);
    			$('#number').submit();
    		}
    		function hpage(){
    			var productID = $('#productID').val();
    			var status = $('#status').val();
    			var page = 0;
    			$('#page').val(page);
    			$('#number').submit();
    		}
    		function back(){
    			var productID = $('#productID').val();
    			var status = $('#status').val();
    			var page = ${count};
    			$('#page').val(page);
    			$('#number').submit();
    		}
    	</script>
  </body>
</html>
