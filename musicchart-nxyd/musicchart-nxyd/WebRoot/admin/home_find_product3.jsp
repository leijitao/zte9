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
    
    <title>退订记录</title>
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
    		<div class="tui_1_tongji_head"><span>退订记录</span></div>
    		<div class="tui_1_table_div">
    		<form action="SRTDJLAction" method="post" id="number">
    		<table class="tui_1_table_1">
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td></td>
    				<td>订单编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="orderId" id="orderId" value="${orderId}" /></td>
    				<td style="text-align: left;">用户编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="parentCls"><input type="text" name="userId" value="${userId}" id="mail" class="inputElem" /></span>
    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" />
    				</td>
    				<td><input type="hidden" name="page" id="page" value="0"></td>
    			</tr>
    		</table>
    		</form>
    		</div>
    	</div>
    	<div class="tui_1_mingxi">
    		<div class="tui_1_tongji_head">
    			<span style="float: left;">退订</span>
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
    					<td style="font-weight: bold;border: 1px Gainsboro solid;">订购时间</td>
    				</tr>
    				<c:forEach items="${findTBillUnsmonths}" var="l" varStatus="va">
    					<tr id="${va.index+1}"  style="border: 1px Gainsboro solid;">
    						<td style="border: 1px Gainsboro solid;">${va.index+1}</td>
    						<td style="border: 1px Gainsboro solid;">${l.orderNo}</td>
    						<td style="border: 1px Gainsboro solid;">${l.userId }</td>
    						<td style="border: 1px Gainsboro solid;">${l.productName}</td>
    						<td style="border: 1px Gainsboro solid;">${l.totalFee}</td>
    						<td style="border: 1px Gainsboro solid;"><fmt:formatDate value="${l.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
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
    			var orderId = $('#orderId').val();
    			var mail = $('#mail').val();
    			var page = ${page-20};
    			$('#page').val(page);
    			$('#number').submit();
    		}
    		function next(){
    			var orderId = $('#orderId').val();
    			var mail = $('#mail').val();
    			var page = ${page+20};
    			$('#page').val(page);
    			$('#number').submit();
    		}
    		function hpage(){
    			var orderId = $('#orderId').val();
    			var mail = $('#mail').val();
    			var page = 0;
    			$('#page').val(page);
    			$('#number').submit();
    		}
    		function back(){
    			var orderId = $('#orderId').val();
    			var mail = $('#mail').val();
    			var page = ${count};
    			$('#page').val(page);
    			$('#number').submit();
    		}
    	</script>
  </body>
</html>
