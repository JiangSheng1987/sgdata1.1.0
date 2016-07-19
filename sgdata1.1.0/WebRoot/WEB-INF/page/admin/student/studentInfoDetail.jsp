<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>学生详细信息</title>
    <link rel="stylesheet" href="source/admin/css/index.css">
    <link rel="stylesheet" href="source/admin/css/admin.css">
    <script src="source/admin/js/jquery-1.11.0.js"></script>
    <script src="source/admin/js/index.js"></script>
    <script src="source/admin/js/respond.js"></script>
    <script src="source/admin/js/admin.js"></script>
    
    <link type="image/x-icon" href="/favicon.ico" rel="shortcut icon" />
    <link href="/favicon.ico" rel="bookmark icon" />
</head>

<body>
<div class="lefter">
    <div class="logo"><a href="#" target="_blank"><img src="source/admin/images/logo.png" alt="后台管理系统" /></a></div>
</div>
<div class="righter nav-navicon" id="admin-nav">
    <div class="mainer">
        <div class="admin-navbar">
            <span class="float-right">
            	<a class="button button-little bg-main" href="#" target="_blank">前台首页</a>
                <a class="button button-little bg-yellow" href="gotoLoginAction.action">注销登录</a>
            </span>
            <ul class="nav nav-inline admin-nav">
                <li class="active"><a href="indexAction.action" class="icon-home"> 开始</a>
                    <ul>
                    	<li>&nbsp;</li>
                    	<li class="active"><a href="getAllStuInfoAction">学生信息管理</a></li>
                    	<li><a href="getAllCourseInfoAction">学校开设课程</a></li>
                    	<li><a href="getAllTeaInfoAction">教师信息管理</a></li>
                    	<li><a href="getAllMatchInfoAction">比赛情况</a></li>
                    </ul>
                </li>
                <li><a href="#" class="icon-cog"> 系统</a></li>
                <li><a href="#" class="icon-file"> 文件</a></li>
            </ul>
        </div>
        <div class="admin-bread">
            <span>您好，admin，欢迎您的光临。</span>
            <ul class="bread">
                <li><a href="indexAction.action" class="icon-home"> 开始</a></li>
                <li><a href="getAllStuInfoAction">学生信息管理</a></li>
                <li>学生详细信息</li>
            </ul>
        </div>
    </div>
</div>

<div class="admin">
	<form action="updateStuInfoAction" method="post" >
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>学生详细信息</strong></div>
        <table class="table table-hover">
        	 <s:iterator value="student" id="sifs" >
        	<tr><th width="120">学号</th><td><input type="text" name="stuID" value="<s:property value="#sifs.stuID" />" /></td></tr>
        	<tr><th width="120">姓名</th><td><input type="text" name="stuName" value="<s:property value="#sifs.stuName" />" /></td></tr>
        	<tr><th width="120">性别</th><td><input type="text" name="stuSex" value="<s:property value="#sifs.stuSex" />" /></td></tr>
        	<tr><th width="120">电话</th><td><input type="text" name="stuTel" value="<s:property value="#sifs.stuTel" />" /></td></tr>
        	<tr><th width="120">邮箱</th><td><input type="text" name="stuEmail" value="<s:property value="#sifs.stuEmail" />" /></td></tr>
        	<tr><th width="120">系部</th><td><input type="text" name="departName" value="<s:property value="#sifs.department.departName" />" /></td></tr>
        	<tr><th width="120">身份证</th><td><input type="text" name="stuIDCard" value="<s:property value="#sifs.stuIDCard" />" /></td></tr>
        	<tr><th width="120">班级</th><td><input type="text" name="classID" value="<s:property value="#sifs.mclass.className" />" /></td></tr>
        	<tr><th width="120">密码</th><td><input type="text" name="password" value="<s:property value="#sifs.password" />" /></td></tr>
        	<tr><th width="100">出生年月</th><td><input type="text" name="stuBirth" value="<s:property value="#sifs.stuBirth" />" /></td></tr>
        	<tr><th width="100">操作</th>
        		<td>
            		<input type="submit" class="button border-blue button-little" value="修改" onclick="{alert('修改成功！');}"/>
            		<input type="button" class="button border-green button-little" onclick="window.history.back()" value="返回">
            	</td>
            </tr>
            </s:iterator>
        </table>
      
    </div>
    </form>
    <br />
</div>

</body>
</html>