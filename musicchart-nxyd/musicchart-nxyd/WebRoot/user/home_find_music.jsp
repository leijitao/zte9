<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查看曲目</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="查看曲目">

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
</style>
</head>

<body>
	<div>
		<div class="tui_1_tongji">
			<div class="tui_1_tongji_head">
				<span>查看曲目</span>
			</div>
			<div class="tui_1_table_div">
				<form action="FindMusicName" method="post" id="pp">
					<table class="tui_1_table_1">
						<tr class="tui_1_table_1_tr" style="border: 0px;">
							<td><input type="hidden" name="page" value="0" id="page" /></td>
							<td>曲目名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="musiceName" id="musiceName"
								value="${musiceName}" /></td>
							<td style="text-align: left;">演唱者&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="playerName"
								id="playerName" value="${playerName}" /></td>
							<td></td>
						</tr>
						<tr class="tui_1_table_1_tr" style="border: 0px;">

						</tr>
						<tr class="tui_1_table_1_tr" style="border: 0px;">
							<td></td>
							<td><input type="button" value="查询" id="tijiao" onclick="confirm()" />&nbsp;&nbsp;&nbsp;<input type="reset"
								value="重置" /></td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="tui_1_mingxi">
			<div class="tui_1_tongji_head">
				<span style="float: left;">曲目</span>
			</div>
		</div>
		<div>
			<table style="border: 1px Gainsboro solid; width: 100%; text-align: center; line-height: 30px;" cellpadding="0px"
				cellspacing="0px">
				<tr style="border: 1px Gainsboro solid;">
					<td style="font-weight: bold; border: 1px Gainsboro solid;">序号</td>
					<td style="font-weight: bold; border: 1px Gainsboro solid;">曲目名称</td>
					<td style="font-weight: bold; border: 1px Gainsboro solid;">演唱者</td>
					<td style="font-weight: bold; border: 1px Gainsboro solid;">点播次数</td>
					<td style="font-weight: bold; border: 1px Gainsboro solid;">点播人数</td>
					<td style="font-weight: bold; border: 1px Gainsboro solid;">操作</td>
				</tr>
				<c:forEach items="${findMusicInfoVOs}" var="l" varStatus="va">
					<tr id="${va.index+1}" style="border: 1px Gainsboro solid;">
						<td style="border: 1px Gainsboro solid;">${va.index+1+page}</td>
						<td style="border: 1px Gainsboro solid;">${l.musicName}</td>
						<td style="border: 1px Gainsboro solid;">${l.playerName }</td>
						<td style="border: 1px Gainsboro solid;">${l.clicks}</td>
						<td style="border: 1px Gainsboro solid;">${l.clickRens}</td>
						<td style="border: 1px Gainsboro solid;"><a href="FindMusicInfoAction?musicId=${l.musicName}">详情</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="food">
			<div>
				<span onclick="hpage()" class="page">首页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="on()" class="page">上一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span>${pg}/${pa}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span onclick="next()" class="page">下一页</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
					onclick="back()" class="page">尾页</span>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script>
		function on() {
			var musicName = $('#musiceName').val();
			var playerName = $('#playerName').val();
			if (${page} == 0) {
				page = 0;
			} else {
			    page = parseInt(${page}) - 20;
			}
			$('#page').val(page);
			$('#pp').submit();
		}
		function next() {
			var musicName = $('#musiceName').val();
			var playerName = $('#playerName').val();
			var page = parseInt(${page}) + 20;
 			$('#page').val(page);
			$('#pp').submit();
		}
		function hpage() {
			var musicName = $('#musiceName').val();
			var playerName = $('#playerName').val();
			var page = 0;
			$('#page').val(page);
			$('#pp').submit();
		}
		function back() {
			var musicName = $('#musiceName').val();
			var playerName = $('#playerName').val();
			var page = $
			{
				count
			}
			;
			$('#page').val(page);
			$('#pp').submit();
		}
		function confirm() {
			var musicName = $('#musiceName').val();
			var playerName = $('#playerName').val();
			if (musicName.length == 0 && playerName.length == 0) {
				location = 'FindMusicAllAction';
			} else {
				$('#pp').submit();
			}
		}
	</script>
</body>
</html>
