<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mulu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="css/my.css" href="styles.css">
<style type="text/css">
a {
	text-decoration: none;
	out-line: none;
	color: black;
}

td {
	border-bottom: 1px #AEEEEE solid;
	border-left: 1px #AEEEEE solid;
}
</style>
</head>

<body>
	<div>
		<div
			style="width: 90%; border: 1px #AEEEEE solid; padding: 10px 0px 0px 10px; font-size: 14px; background-color: #f0ffff; height: 30px;">
		</div>
		<div style="padding-top: 10px;">
			<table cellpadding="0" cellspacing="0" style="width: 91%; text-align: center; background-color: #f0ffff;">
				<tr style="font-size: 16px; line-height: 30px; height: 30px;">
					<td style="width: 15%;">序号</td>
					<td style="width: 20%">目录名称</td>
					<td style="width: 20%">创建时间</td>
					<td style="width: 40%">操作</td>
				</tr>
				<c:forEach items="${fkList}" var="f" varStatus="ff">
					<tr style="line-height: 25px; height: 25px;">
						<td>${ff.index + 1}</td>
						<td><a href="FindFirstfileAction?id=${f.fdoFilefirstInfo.fileFirstId }">${f.fdoFilefirstInfo.fileFirstName}</a></td>
						<td><fmt:formatDate value="${f.fdoFilefirstInfo.createDateTime}" type="both" /></td>
						<td><a href="FindFirstfileAction?id=${f.fdoFilefirstInfo.fileFirstId }">查看详情</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div></div>
	</div>
</body>
</html>
