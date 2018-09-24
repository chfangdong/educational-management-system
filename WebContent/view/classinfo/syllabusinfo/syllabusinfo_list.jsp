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
<title>管理</title>
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
        <li>课程表</li>
    </ul>
</div>
<form action="syllabusinfo/list.do" method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

    <div class="form-group">
         <label class="" for="syllabusName">课程表名称：</label>
        <input type="text" name="syllabusName" class="form-control" id="syllabusName" placeholder="请输入课程表名称">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="view/classinfo/syllabusinfo/syllabusinfo_add.jsp">添加课程表</a>
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="syllabusinfo/list.do">
		<display:column property="syllabusId" title="编号" />
		<display:column  property="syllabusName" title="课程表名称"/>
		<display:column  property="syllabusYi" title="星期一"/>
		<display:column property="syllabusEr" title="星期二"/>
		<display:column  property="syllabusSan" title="星期三"/>
		<display:column property="syllabusSi" title="星期四"/>
		<display:column  property="syllabusWu" title="星期五"/>
		<display:column property="syllabusLiu" title="星期六"/>
		<display:column property="syllabusQi" title="星期天"/>
		<display:column href="syllabusinfo/load.do" paramId="syllabusId" paramProperty="syllabusId" value="修改"  title="查看"/>
		<display:column href="syllabusinfo/delete.do"  paramId="syllabusId" paramProperty="syllabusId"  value="删除"  title="删除"/>
	</display:table>
</div>

</form>
</body>
</html>