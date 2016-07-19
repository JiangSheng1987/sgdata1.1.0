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
    <title>学生信息管理</title>
    <link rel="stylesheet" href="source/admin/css/index.css">
    <link rel="stylesheet" href="source/admin/css/admin.css">
    <script src="source/admin/js/jquery-1.11.0.js"></script>
    <script src="source/admin/js/index.js"></script>
    <script src="source/admin/js/respond.js"></script>
    <script src="source/admin/js/admin.js"></script>
    <script type="text/javascript">
    	function getInfoById(){
    		 window.location="getInfoByIdAction?stuID=" + escape(document.getElementById('id').value);
    	
    	}
    </script>
    
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
                <li>学生信息管理</li>
            </ul>
        </div>
    </div>
</div>

<div class="admin">
	<form action="getAllStuInfoAction" method="post" >
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>学生信息列表</strong></div>
    	<div class="padding border-bottom">
    		学号:
            <input type="text" id="id" alt="请输入学号" />
            <a class="button border-blue button-little" onClick="getInfoById()">查询</a>
            &nbsp;
                            系别:
           	<s:select list="departmentsInfo" listKey="key" listValue="departName"></s:select>
           	&nbsp;
                          班级:
            <s:select list="{'软件开发1班'}" ></s:select>
            
        </div>
        <table class="table table-hover">
        	<tr>
        		<th width="120">学号</th>
        		<th width="120">姓名</th>
        		<th width="120">性别</th>
        		<th width="120">班级</th>
        		<th width="120">系部</th>
        		<th width="100">出生年月</th>
        		<th width="100">操作</th>
        	</tr>
            <s:iterator value="studentsInfo" id="ssif" >
            <tr>
            	<td><s:property value="#ssif.stuID" /></td>
            	<td><s:property value="#ssif.stuName" /></td>
            	<td><s:property value="#ssif.stuSex" /></td>
            	<td><s:property value="#ssif.mclass.className" /></td>
            	<td><s:property value="#ssif.department.departName" /></td>
            	<td><s:property value="#ssif.stuBirth" /></td>
            	<td>
            		<a class="button border-blue button-little" href="getStuInfoByIdAction?stuID=<s:property value='#ssif.stuID'/>">详情</a> 
            		<a class="button border-yellow button-little" href="getLearnScoresAction?stuID=<s:property value='#ssif.stuID' />" >学习</a>
            		<a class="button border-green button-little" href="getMatchScoresAction?stuID=<s:property value='#ssif.stuID' />">比赛</a> 
            	</td>
            </tr>
            </s:iterator>
        </table>
        <s:iterator value="pageBean">
        <div class="panel-foot text-center">
        	 共<s:property value="allRow"/>条记录    
       		 共<s:property value="totalPage"/>页    
          	当前第<s:property value="currentPage"/>页<br>
          	<s:if test="%{currentPage == 1}">
      		      
         	</s:if>
          	<!-- currentPage为当前页 -->
	        <s:else>
	           <ul class="pagination"><li><a href="getAllStuInfoAction.action?page=1">第一页</a></li></ul>
	           <ul class="pagination"><li><a href="getAllStuInfoAction.action?page=<s:property value="%{currentPage-1}"/>">上一页</a></li></ul>
	        </s:else>
          	
          	<s:if test="%{currentPage != totalPage}">
         	 <ul class="pagination"><li><a href="getAllStuInfoAction.action?page=<s:property value="%{currentPage+1}"/>">下一页</a></li></ul>
         	 <ul class="pagination"><li><a href="getAllStuInfoAction.action?page=<s:property value="totalPage"/>">最后一页</a></li></ul>
            </s:if>
     
          	<s:else>
        	 
         	</s:else>
         	<!--  
          	 <ul class="pagination pagination-group">
                <li><a href="#">1</a></li>
                <li class="active"><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            </ul>
            -->
        </div>
        </s:iterator>
    </div>
    </form>
    <br/>
</div>

</body>
</html>