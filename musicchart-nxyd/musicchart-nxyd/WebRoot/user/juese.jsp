<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ZTE9文档管理中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="css/my.css" href="styles.css">
	<style type="text/css">
		a{
			text-decoration:none;
    		out-line: none;
    		color:black;
		}
		td{
			border-bottom:  1px #AEEEEE solid;
			border-left: 1px #AEEEEE solid;
		}
	</style>
	<script type="text/javascript">
		function yanzhen(){
			var pwd1 = document.getElementById("pwd1").value;
			var pwd2 = document.getElementById("pwd2").value;
			if(pwd1!=(pwd2)){
				alert("两次密码不一致");
			}else{
				document.getElementById("myform").submit();
			}
		}
	</script>
  </head>
  
  <body>
  	<div>
  		<div style="width: 90%;border: 1px #AEEEEE solid;padding: 10px 0px 0px 10px;font-size: 14px; background-color: #f0ffff;height: 30px;">
  			<div style="display: block; float: left;">
  				<span>编辑用户</span>
    		</div>
    	</div>
    	<div style="padding-top: 10px;">
    		<form action="EdUserInfoAction" method="post" id="myform">
    		<input type="hidden" name="id" value="${fdoUserInfo.userId }" />
    			<table cellpadding="0" cellspacing="0" style="width: 91%;background-color: #f0ffff;line-height: 30px;">
    				<tr>
    					<td style="width: 15%;text-align: right;">用户名：</td>
    					<td><input type="text" name="fdoUserInfo.loginName" value="${fdoUserInfo.loginName}" readonly style="background:#CCCCCC"/><span style="color: red;">${tishi}</span></td>
    				</tr>
    				<tr>
    					<td style="width: 15%;text-align: right;">密码：</td>
    					<td><input type="password" name="pwd1" value="${fdoUserInfo.pwd}" id="pwd1" /></td>
    				</tr>
    				<tr>
    					<td style="width: 15%;text-align: right;">重复密码：</td>
    					<td><input type="password" name="fdoUserInfo.pwd" value="${fdoUserInfo.pwd}" id="pwd2" /></td>
    				</tr>
    				<tr>
    					<td></td>
    					<td><input type="button" value="提交" onclick="yanzhen()"/></td>
    				</tr>
    			</table>
    		</form>
    	</div>
    	<div>
    		
    	</div>
    </div>
  </body>
</html>
