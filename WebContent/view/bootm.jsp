<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<base href="<%=basePath%>">
<title>Insert title here</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/highcharts.js" type="text/javascript"></script>
<script src="resources/js/jquery.highchartTable.js" type="text/javascript"></script>
<script language="javascript">
$(document).ready(function() {
  $('table.highchart').highchartTable();
});
</script>

</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style=" padding:0px; padding-left:20px;" >
  <li ><a href="#">首页</a></li>
  <li>工作台</li>
</ul>
</div>

<div  style="padding:1px; margin:0px;"  >
<div class="row" >
	<div class="col-sm-8">
        <div class="panel panel-default" >
          <div class="panel-heading" style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>学生意向状态
          </div>
              <div class="panel-body">
              <table class="highchart" style="display:none; "  
                  data-graph-container-before="1"  data-graph-height="250" data-graph-type="column" >
              
                  <thead>
                      <tr>
                          <th >类别</th>
                          <th >意向状态</th>
                      </tr>
                   </thead>
                   <tbody>
                   <c:forEach items="${reportInfo.studentSateList }"  var="studentsate">
                      <tr >
                          <td>${studentsate.data_content }</td>
                          <td >${studentsate.total }</td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
        </div>
    </div>
 	<div class="col-sm-4">
            <div class="panel panel-default">
          <div class="panel-heading"  style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>学生意向数量
          </div>
           <table class="table table-bordered">
                <thead>
                      <tr>
                          <th >意向状态</th>
                          <th >人数</th>
                      </tr>
                   </thead>
                   <tbody>
                     <c:forEach items="${reportInfo.studentSateList }"  var="studentsate">
                      <tr >
                          <td>${studentsate.data_content }</td>
                          <td >${studentsate.total }</td>
                      </tr>
                    </c:forEach>
                  </tbody>
            </table>  
        </div>
    </div>
</div>
<div class="row" >
	<div class="col-sm-4">
        <div class="panel panel-default" >
          <div class="panel-heading" style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>状态分布图
          </div>
              <div class="panel-body">
                  <table class="highchart" style="display:none; "  
                  data-graph-container-before="1"  data-graph-height="250" data-graph-type="pie" >
              
                  <thead>
                      <tr>
		                <th>模块</th>
		                <th>数量</th>
                      </tr>
                   </thead>
                   <tbody>
                    <c:forEach items="${reportInfo.studentMarkList }"  var="studentMark">
                      <tr >
                          <td>${studentMark.student_mark=='-1'?'学生无效':'' }
                          ${studentMark.student_mark=='0'?'未分配学生':'' }
                          ${studentMark.student_mark=='1'?'已分配学生  ':'' }
                          ${studentMark.student_mark=='2'?'已报名学生  ':'' }
                          </td>
                          <td >${studentMark.total }</td>
                      </tr>
                    </c:forEach>
       
                  </tbody>
                </table>
              </div>
        </div>
    </div>
	<div class="col-sm-8">
        <div class="panel panel-default" >
          <div class="panel-heading" style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>学生学校分布图
          </div>
              <div class="panel-body">
                  <table class="highchart" style="display:none; "  
                  data-graph-container-before="1"  data-graph-height="250" data-graph-type="area" >
              <thead> 
               <tr>
                    <th>数量</th>
                    <th>学校</th>
                </tr>
            </thead>
               <tbody>
            <c:forEach items="${reportInfo.studentSchoolList }"  var="studentSchool">
                      <tr >
                          <td>${studentSchool.student_school }</td>
                          <td >${studentSchool.total }</td>
                      </tr>
                    </c:forEach>
          </tbody>
            </table>  
              </div>
        </div>
    </div>
    </div>
    <div class="row">
 	<div class="col-sm-10">
            <div class="panel panel-default">
          <div class="panel-heading"  style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>今日联系
          </div>
           <table class="table table-bordered" >
            <tr >
                <th>联系人</th>
                <th>微信</th>
                <th>电话号码</th>
             
            </tr>
              <c:forEach items="${reportInfo.studentList }"  var="stu">
                      <tr >
                          <td>${stu.student_name }</td>
                          <td >${stu.student_qq }</td>
                           <td >${stu.student_tellphone }</td>
                      </tr>
                    </c:forEach>
            </table>  
        </div>
    </div>
    </div>

     
</div>



</body>
</html>