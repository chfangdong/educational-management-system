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
    	<li><a href="#">教务管理</a></li>
        <li>班级事务</li>
    </ul>
</div>
<form action="classtransactioninfo/list.do"  method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="classTransactionTitle">主题：</label>
        <input type="text" class="form-control" name="classTransactionTitle" id="classTransactionTitle" placeholder="请输入主题">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="classtransactioninfo/loadadd.do">添加班级事务</a>
    
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="classtransactioninfo/list.do">
		<display:column property="classTransactionId" title="编号" />
		<display:column  property="className" title="班级"/>
		<display:column  property="classTransactionTitle" title="主题"/>
		<display:column  property="classTransactionContent" title="内容"/>
		<display:column  property="classTransactionPerson" title="组织人"/>
		<display:column  property="classTransactionTime" format="{0,date,yyyy年MM月dd日}" title="活动日期"/>
		<display:column href="classtransactioninfo/loadupdate.do" paramId="classTransactionId" paramProperty="classTransactionId" value="修改"  title="查看"/>
		<display:column href="classtransactioninfo/delete.do"  paramId="classTransactionId" paramProperty="classTransactionId"  value="删除"  title="删除"/>
	</display:table>
</div>

</form>




</body>
</html>