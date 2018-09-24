<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>数据字典</title>
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
    	<li><a href="#">营销管理</a></li>
        <li>短信邮件模板</li>
    </ul>
</div>
<form action="template/list.do" class="form-horizontal">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

	<div class="col-sm-2">标题:</div>
    <div class="col-sm-3">
    	<input type="text" name="templateTitle"  class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="view/marketing/template/template_add.jsp"   >添加模板</a>
  
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="template/list.do">
		<display:column property="templateId" title="编号"/>
		<display:column  property="templateTitle" title="标题"/>
		<display:column property="templateContent" title="内容"/>
		<display:column property="templateType" title="类别"/>
		<display:column href="template/load.do" paramId="templateId" paramProperty="templateId" value="修改"  title="修改"/>
		<display:column href="template/delete.do"  paramId="templateId" paramProperty="templateId"  value="删除"  title="删除"/>
	</display:table>
</div>

  </form>

</body>
</html>