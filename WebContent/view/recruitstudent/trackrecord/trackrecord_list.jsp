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
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">招生管理</a></li>
        <li>跟踪记录</li>
    </ul>
</div>
<form action="trackrecordinfo/list.do" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="studentName">学员姓名：</label>
        <input type="text" class="form-control" name="studentName" id="studentName" placeholder="请输入学员姓名">
      </div>
    <div class="form-group">
         <label class="" for="activename">学员意向：</label>
		<s:select name="enrollment" type="student_sate"/>
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="trackrecordinfo/loadadd.do">添加纪录</a>
    
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
		<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="trackrecordinfo/list.do">
		<display:column property="trackRecordId" title="编号" />
		<display:column property="trackRecordTitle" title="主题" />
		<display:column  href="recruitstudent/show.do" paramId="studentId" paramProperty="studentId" property="studentName" title="学员姓名" />
		<display:column property="trackRecordContent" title="内容" />
		<display:column property="dataContent" title="意向状态" />
		<display:column property="staffName" title="负责人" />
		<display:column property="trackRecordTime" title="联系时间" format="{0,date,yyyy年MM月dd日}" />
		<display:column property="nextRecordTime" title="下次联系时间" format="{0,date,yyyy年MM月dd日}"/>	
		<display:column href="trackrecordinfo/load.do" paramId="trackRecordId" paramProperty="trackRecordId" value="修改"  title="修改"/>
		<display:column href="trackrecordinfo/delete.do"  paramId="trackRecordId" paramProperty="trackRecordId"  value="删除"  title="删除"/>
</display:table>               	                
</div>
</form>
</body>
</html>