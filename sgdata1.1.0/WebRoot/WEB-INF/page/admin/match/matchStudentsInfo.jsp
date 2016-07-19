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
    <title>参赛学生名单</title>
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
                    	<li><a href="getAllStuInfoAction">学生信息管理</a></li>
                    	<li><a href="getAllCourseInfoAction">学校开设课程</a></li>
                    	<li><a href="getAllTeaInfoAction">教师信息管理</a></li>
                    	<li class="active"><a href="getAllMatchInfoAction">比赛情况</a></li>
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
                <li><a href="getAllMatchInfoAction">比赛情况管理</a></li>
                <li>参赛学生名单</li>
            </ul>
        </div>
    </div>
</div>

<div class="admin">
	<form action="getAllStuInfoAction" method="post" >
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>参赛学生名单</strong></div>
    	
        <table class="table table-hover">
        	<tr>
        		<th width="120">学号</th>
        		<th width="120">学生姓名</th>
        		<th width="120">性别</th>
        		<th width="120">系别</th>
        		<th width="120">班级</th>
        	</tr>
            <s:iterator value="matchStudentsInfo" id="lss" >
            <tr>
            	<td><s:property value="#lss.student.stuID" /></td>
            	<td><s:property value="#lss.student.stuName" /></td>
            	<td><s:property value="#lss.student.stuSex"/> </td>
            	<td><s:property value="#lss.student.dept" /></td>
            	<td><s:property value="#lss.student.className" /></td>
            </tr>
            </s:iterator>
        </table>
        
    </div>
    </form>
    <br />
</div>

</body>
</html>