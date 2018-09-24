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
    	<li><a href="#">学员管理</a></li>
        <li>学员评价</li>
    </ul>
</div>
<form action="evaluationinfo/list.do" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="studentName">学员姓名：</label>
        <input type="text" name="studentName" class="form-control" id="studentName" placeholder="请输入学员姓名">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="evaluationinfo/loadadd.do">添加评价</a>
    
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="evaluationinfo/list.do">
		<display:column property="evaluationId" title="编号" />
		<display:column  property="studentName" title="学员姓名"/>
		<display:column  property="evaluationTitle" title="主题"/>
		<display:column  property="evaluationContent" title="评价内容"/>
		<display:column  property="evaluationCourse" title="课程名称"/>
		<display:column  property="evaluationTeacher" title="教师"/>
		<display:column  property="evaluationTime" format="{0,date,yyyy年MM月dd日}"  title="评价时间"/>
		<display:column href="evaluationinfo/loadupdate.do" paramId="evaluationId" paramProperty="evaluationId" value="修改"  title="查看"/>
		<display:column href="evaluationinfo/delete.do"  paramId="evaluationId" paramProperty="evaluationId"  value="删除"  title="删除"/>
	</display:table>
</div>
</form>





</body>
</html>