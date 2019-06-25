<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>音乐大厅统计系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="音乐大厅统计系统">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">

<style type="text/css">
a {
	cursor: pointer;
}

a:hover {
	color: black;
	font-weight: bold;
}
</style>

<%!int a = 0;%>
</head>

<body>
	<div class="all1">
		<div class="head">
			<div class="logo">
				<img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" style="color: black;" />
			</div>
			<div class="head_1">音乐大厅统计系统</div>
			<div align="right">
				欢迎：<b>${sysUser.userName}</b> <a class="login_out" onclick="loginOut()"><u>注销</u></a>
			</div>
		</div>
		<div class="center">
			<div class="left">
				<div class="left_menu">
					<ul class="umenu_1">
						<li class="limenu_1"><i class="icon-caret-down"></i>&nbsp;<span style="font-size: 16px; font-weight: bold;"><a>数据统计</a></span>
							<ul class="umenu_2">
								<li class="limenu_2"><i class="icon-caret-down"></i>&nbsp;<span><a>界面统计</a></span>
									<ul class="umenu_3">
										<c:forEach items="${map2}" var="lkey">
											<li class="limenu_3"><i class="icon-caret-right"></i>&nbsp;<span><a>${lkey.key.typeName}</a></span>
												<ul class="umenu_4" style="display: none;">
													<li class="limenu_4"><span><a target="right" href="RTAllAction?className=${lkey.key.typeCode}">全部</a></span>
													</li>
													<li class="limenu_4"><span><a target="right"
															href="RTTJWTwoAction?className=${lkey.key.typeCode}">推荐位</a></span></li>
													<c:forEach items="${lkey.value}" var="lvalue">
														<li class="limenu_4"><span><a target="right" href="EJJDTJAction?className=${lvalue.typeCode}">${lvalue.typeName}</a></span>
														</li>
													</c:forEach>
												</ul></li>
										</c:forEach>
										<li class="limenu_3"><i class="icon-caret-right"></i>&nbsp;<span><a>专题</a></span>
											<ul class="umenu_4" style="display: none;">
												<li class="limenu_4"><span><a target="right" href="RTTJWAction">推荐位</a></span></li>
											</ul></li>
									</ul></li>
								<li class="limenu_2"><i class="icon-caret-right"></i>&nbsp;<span><a>活跃统计</a></span>
									<ul class="umenu_3" style="display: none;">
										<li><span><a href="HYTJAction" target="right">全部</a></span></li>
									</ul></li>
								<li class="limenu_2"><i class="icon-caret-right"></i>&nbsp;<span><a>曲目统计</a></span>
									<ul class="umenu_3" style="display: none;">
										<li><span><a href="QMTJAction" target="right">综合统计</a></span></li>
										<li><span><a href="FindMusicAllAction" target="right">查看曲目</a></span></li>
									</ul></li>
								<li class="limenu_2"><i class="icon-caret-right"></i>&nbsp;<span><a>收入统计</a></span>
									<ul class="umenu_3" style="display: none;">
										<c:forEach items="${categories}" var="c">
											<li class="limenu_3"><i class="icon-caret-right"></i>&nbsp;<span><a>${c.monthlyCategoryName}</a></span>
												<ul class="umenu_4" style="display: none;">
													<c:forEach items="${monthlyTypes}" var="m">
														<c:if test="${m.monthlyCategoryId==c.id}">
															<li class="limenu_4"><span><a target="right" href="SRTJxxAction?className=${m.productId}">${m.memo1}</a></span>
															</li>
														</c:if>
													</c:forEach>
												</ul></li>
										</c:forEach>
										<li><span><a href="SRTJAction" target="right">全部</a></span></li>
										<li><span><a href="SRTJDGAction" target="right">订购记录</a></span></li>
										<li><span><a href="FindTBillMonthInfo?page=0" target="right">订单查询</a></span></li>
										<li><span><a href="SRTDJLAction?page=0" target="right">退订记录</a></span></li>
										<li><span><a href="SRTJJSGLAction" target="right">结算管理</a></span></li>
									</ul></li>
								<li class="limenu_2"><i class="icon-caret-right"></i>&nbsp;<span><a>用户管理</a></span>
									<ul class="umenu_3" style="display: none;">
										<li><span><a href="NewUserAction" target="right">CP管理</a></span></li>
									</ul></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<div class="rigth"></div>
		</div>
	</div>
	<div class="homepage">
		<iframe scrolling="auto" rameborder="0" src="admin/info.jsp" name="right" width="100%" height="100%"></iframe>
	</div>
	<script type="text/javascript">
		/**
		 * 注销
		 */
		function loginOut() {
			window.top.location.href = "/musicchart_nxyd/login.jsp";
		}
	</script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/home_menu.js"></script>
</body>
</html>
