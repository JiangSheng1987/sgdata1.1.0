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
    <title>课程信息管理</title>
    <script src="source/admin/js/jquery-1.11.0.js"></script>
    <script src="source/admin/js/bootstrap.min.js"></script>
    <script src="source/admin/js/index.js"></script>
    <script src="source/admin/js/respond.js"></script>
    <script src="source/admin/js/admin.js"></script>
    
    <script src="source/admin/js/bootstrap-datepicker.js"></script>
     <link rel="stylesheet" href="source/admin/css/index.css">
    <link rel="stylesheet" href="source/admin/css/admin.css">
    
    <link href="source/admin/css/font-awesome.min.css" rel="stylesheet">
    <link href="source/admin/css/datepicker.css" rel="stylesheet">
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
                    	<li class="active"><a href="getAllCourseInfoAction">学校开设课程</a></li>
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
                <li><a href="getAllCourseInfoAction">学习开设课程</a></li>
                <li>新开课程</li>
            </ul>
        </div>
    </div>
</div>

<div class="admin">
	<form method="post" action="addCourseInfoAction">
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>学生信息列表</strong></div>
				<div class="form-group">
                    <div class="label"><label for="courseID">课程代码</label></div>
                    <div class="field">
                    	<input type="text" class="input" id="courseID" name="courseID" size="50" placeholder="课程代码" data-validate="required:请填写课程的代码" />
                    </div>
                </div>
         		<div class="form-group">
                    <div class="label"><label for="coursename">课程名称</label></div>
                    <div class="field">
                    	<input type="text" class="input" id="courseName" name="courseName" size="50" placeholder="课程名称" data-validate="required:请填写课程的名称" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="label"><label for="credit">学分</label></div>
                    <div class="field">
                    	<input type="text" class="input" id="credit" name="credit" size="50" placeholder="请填写课程学分" data-validate="required:请填写课程学分(0.5、1.0、2.0、3.0、4.0、6.0)" />
                    </div>
                </div>
                <div class="form-group">
                   <div class="label"><label for="credit">课程类型</label></div>
                    <div class="field">
                    	<input type="text" class="input" id="type" name="type" size="50" placeholder="请填写课程类型" data-validate="required:请填写课程类型(选修、必修)" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="label"><label for="title">开课时间</label></div>
         			   <div class="well">
                 		<fieldset>
                 		 <div class="control-group">
                  		  <div class="controls">
	                   		  <div class="input-prepend input-group">
	                      		 <span class="add-on input-group-addon">
	                      		 <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
	                      		 </span>
	                      		 <input type="date" readonly style="width: 200px" name="time" id="datepicker" class="datepicker" value="2015-5-21" /> 
	                   		  </div>
                    	   </div>
                  		</div>
                 		</fieldset>
           		   </div>
				</div>

         
              
                <div class="form-button"><button class="button bg-main" type="submit">提交</button></div>
        
    </div>
    </form>
    <br />
</div>

</body>
</html>