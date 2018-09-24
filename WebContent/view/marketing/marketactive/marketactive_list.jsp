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
    	<li><a href="#">营销管理</a></li>
        <li>营销活动</li>
    </ul>
</div><form method="post" action="marketactive/list.do" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activeName">活动名称：</label>
        <input type="text" class="form-control" name="activeName" id="activeName" placeholder="请输入活动名称">
      </div>
      <div class="form-group">
         <label class="" for="activstate">活动状态：</label>
		 <s:select type="active_state"  name="activeState"  />
                
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="view/marketing/marketactive/marketactive_add.jsp">添加活动</a>
 
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="marketactive/list.do">
		<display:column property="activeId" title="编号" />
		<display:column  property="activeName" title="活动名称"/>
		<display:column  property="staffName" title="负责人"/>
		<display:column property="activeStart" format="{0,date,yyyy年MM月dd日}"  title="开始时间"/>
			<display:column property="activeEnd" format="{0,date,yyyy年MM月dd日}"  title="结束时间"/>
		<display:column property="dataContent" title="活动状态"/>
		<display:column href="marketactive/load.do" paramId="activeId" paramProperty="activeId" value="修改"  title="查看"/>
		<display:column href="marketactive/delete.do"  paramId="activeId" paramProperty="activeId"  value="删除"  title="删除"/>
	</display:table>
</div>

   </form>
</body>
</html>