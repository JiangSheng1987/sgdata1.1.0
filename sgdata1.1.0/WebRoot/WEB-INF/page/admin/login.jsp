<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

<base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<meta charset="utf-8">
	<title>SISE</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<!-- CSS -->
	
	<link rel="stylesheet" href="source/admin/css/supersized.css">
	<link rel="stylesheet" href="source/admin/css/login.css">
	<link href="source/admin/css/bootstrap.min.css" rel="stylesheet">

	
	<script src="source/admin/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="source/admin/js/jquery.form.js"></script>
	<script type="text/javascript" src="source/admin/js/tooltips.js"></script>
	
	<script type="text/javascript" src="source/admin/js/login.js"></script>
	 
	 <script type="text/javascript">
  	function refresh(){
  		document.getElementById("captcha_img").src="common/authImg.jsp?now="+new Date();
  	}
  	
  </script>
  
 <style type="text/css">
 	#captcha_img{
		margin: 0 auto;	
		background: #CCC;
		filter: alpha(opacity=50);
		-khtml-opacity: 0.5;
		-moz-opacity: 0.5;
		opacity: 0.5;
		position: absolute;
		top: 140;
		left: 450;
 	}
 </style>
</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="source/admin/images/logo.png" >
			</div>
		
			<div class="login_form">
				<form action="loginAction" id="login_form" method="post">
					<div class="form-group">
						<label for="j_username" class="t">账　号：</label> 
						<input id="account" value="" name="account" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password" value="" name="password" type="password" 
						class="password form-control x319 in">
					</div>
					
					<div class="form-group">
						<label for="j_captcha" class="t">验证码：</label>
						 <input id="captcha" name="captcha" type="text" class="form-control x164 in">
						<img id="captcha_img" alt="点击更换" title="点击更换" src="common/authImg.jsp" class="m"onclick="refresh()">
					</div>
					
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
						<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
					</div>
					<div class="form-group space">
						<label class="t"></label>　　　
						<button type="submit"  id="submit_btn" 
						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2014 - 2015 <a href="#">系统登陆</a></div>
	</div>
</div>

<!-- Javascript -->

<script src="source/admin/js/supersized.3.2.7.min.js"></script>
<script src="source/admin/js/supersized-init.js"></script>
<script src="source/admin/js/scripts.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>