<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="用户管理">
	
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
    </style>
  </head>
  
  <body>
    <div>
    	<div class="tui_1_tongji_cp">
    		<div class="tui_1_tongji_head"><span>新建用户</span></div>
    		<div class="tui_1_table_div">
    		<form action="UpdateUserAction" method="post" id="new">
    		<table class="tui_1_table_2">
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">用户名：</td>
    				<td style="text-align: left;"><input type="text" name="sysUser.userName" value="${sysUser.userName}" /><i>*</i></td>
    				<!-- <td style="text-align: left;">用户编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userId" /></td> -->
    				<td><input type="hidden" name="sysUser.userId" value="${sysUser.userId}" /></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">登录名：</td>
    				<td><input type="text" name="sysUser.loginName" value="${sysUser.loginName}" /><i>*</i></td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">密码：</td>
    				<td><input type="password" id="p1" name="sysUser.password" value="${sysUser.password}" /><i>*</i></td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">确认密码：</td>
    				<td><input type="password" id="p2" name="password" value="${sysUser.password}" /><i>*</i></td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">CP商：</td>
    				<td>
    					<select name="sysUser.cpId" id="sele">
    						<option selected="selected" disabled="disabled" value="1">---请选择---</option>
    						<c:forEach items="${findAllCP}" var="cp">
    							<option value="${cp.cpId}">${cp.cpName}</option>
    						</c:forEach>
    					</select>
    				<i>*</i></td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">用户描述：</td>
    				<td><input type="text" name="sysUser.userDesc" value="${sysUser.userDesc}" /></td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">性别：</td>
    				<td><span>男</span><input type="radio" value="1" name="sex" checked="checked" />
    					<span>女</span><input type="radio" value="0" name="sex" />
    				</td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td style="text-align: right;">生日：</td>
    				<td><input type="text" name="sysUser.birth" value="${sysUser.birth}" /></td>
    				<td></td>
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				
    			</tr>
    			<tr class="tui_1_table_1_tr" style="border: 0px;">
    				<td></td>
    				<td><input type="button" onclick="deng()" value="确定" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" /></td>
    				<td></td>
    			</tr>
    		</table>
    		</form>
    		</div>
    	</div>
    	</div>
    	    	<script type="text/javascript">
    		function deng(){
    			if($("#p1").val() != $("#p2").val()){
    				alert("密码不一致!")
    			}else if($("#p1").val().length <= 8){
    				alert("密码长度不得低于8位!");
    			}else if($("#sele").val() == 1){
    				alert("请选择CP商");
    			}else{
    				var password=$("#p1").val();
		    		var pwd=$.md5(password);
		    		$("#p1").val(pwd);
    				$("#new").submit();
    			}
    		}
    	</script>
    	<script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script> 
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script> 
	<script type="text/javascript" src="js/jquery.md5.js"></script>
	<script type="text/javascript" src="js/md5Util.js"></script> 
  </body>
</html>
