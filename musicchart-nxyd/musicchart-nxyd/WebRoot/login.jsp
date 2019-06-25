<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">

</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="LoginAction" method="post" id="login">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>音乐大厅后台统计管理</h1>
						</div>
						<div class="panel-body" style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" style="height: 40px;" name="userName" placeholder="登录账号"
										data-validate="required:请填写账号" /> <span class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" style="height: 40px;" id="password" name="pwd"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" style="height: 40px;" id="code" name="code" placeholder="验证码" />
								</div>
							</div>
							<div>
								<img src="Number.jsp" id="safeCode" />&nbsp;<a id="changeCode" href="javascript:;">看不清，换一张</a><br>
							</div>
						</div>
						<div style="padding: 30px;">
							<input onclick="mdjia()" type="submit" class="button button-block bg-main text-big input-big"
								style="background-color: #123456; border: 1px solid width;" value="登录">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/pintuer.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>
	<script type="text/javascript" src="js/jquery.md5.js"></script>
	<script type="text/javascript" src="js/md5Util.js"></script>
	<script type="text/javascript">
		function mdjia() {
			var password = $("#password").val();
			var pwd = $.md5(password);
			$("#password").val(pwd);
		}
	</script>
</body>
</html>
