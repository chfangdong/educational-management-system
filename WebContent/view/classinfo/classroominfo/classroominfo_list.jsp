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
<title>短信管理</title>
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
    	<li><a href="#">班级管理</a></li>
        <li>教室管理</li>
    </ul>
</div>


<form action="classroominfo/list.do" method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="classroomName">教室名称：</label>
        <input type="text" name="classroomName" class="form-control" id="classroomName" placeholder="请输入教室名称">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="view/classinfo/classroominfo/classroominfo_add.jsp">添加教室</a>
    
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="classroominfo/list.do">
		<display:column property="classroomId" title="编号" />
		<display:column  property="classroomName" title="教室名称"/>
		<display:column  property="classroomMax" title="容纳人数"/>
		<display:column property="classroomInfo" title="设备信息"/>
		<display:column href="classroominfo/load.do" paramId="classroomId" paramProperty="classroomId" value="修改"  title="查看"/>
		<display:column href="classroominfo/delete.do"  paramId="classroomId" paramProperty="classroomId"  value="删除"  title="删除"/>
	</display:table>
</div>

</form>
</body>
</html>