<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="s" uri="http://beifengwang.com" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>营销活动</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>查询学员</li>
    </ul>
</div>
<form action="student/list.do" method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">学员姓名：</label>
        <input type="text" name="studentName" class="form-control" id="activename" placeholder="请输入学员姓名">
      </div>
  	<div class="form-group">
         <label class="" for="activename">学员意向状态：</label>
         <s:select name="studentSate" type="student_sate" selectedId="${stuinfo.studentSate }"/>
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
  
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">${info }</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; " align="right">
		<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="student/list.do">
		<display:column property="studentId" title="编号" />
		<display:column  href="student/show.do" paramId="studentId" paramProperty="studentId"  property="studentName" title="姓名"/>
		<display:column  property="studentSex" title="性别"/>
		<display:column  property="studentAge" title="年龄"/>
		<display:column  property="studentTellphone" title="手机号码"/>
		<display:column  property="studentEmail" title="电子邮件"/>
		<display:column  property="studentSchool" title="所在院校"/>
		
		<display:column href="student/delete.do"  paramId="studentId" paramProperty="studentId"  value="删除"  title="删除"/>
</display:table>               	                
</div>
</form>
</body>
</html>