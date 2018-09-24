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
    	<li><a href="#">财务管理</a></li>
        <li>员工薪水</li>
    </ul>
</div>
<form action="staffsalary/list.do"  method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="staffName">员工姓名：</label>
        <input type="text" class="form-control" name="staffName" id="staffName" placeholder="请输入员工姓名">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="staffsalary/loadadd.do">添加员工薪水记录</a>
    
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
	<display:table class="table  table-condensed table-striped" name="list"  pagesize="10" requestURI="staffsalary/list.do">
		<display:column property="staffName" title="领取人" />
		<display:column  property="financeName" title="财务人员"/>
		<display:column  property="totalSalary" title="本月薪水"/>
		<display:column  property="deductSalary" title="扣除"/>
		<display:column  property="realSalary" title="实际发放薪水"/>
		<display:column  property="staffSalaryTime" format="{0,date,yyyy年MM月dd日}" title="领取日期"/>
		<display:column  property="staffRemark" title="备注信息"/>
		<display:column   property="url" title="是否领取"/>			
		</display:table>
</div>

</form>




</body>
</html>