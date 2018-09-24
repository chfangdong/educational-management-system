<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://beifengwang.com" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script  type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">教务管理</a></li>
         <li>添加考勤</li>
  
    </ul>
</div>

<form action="attendanceinfo/add.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" readonly="readonly" name="attendanceId" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员姓名</label>
                <div class="col-sm-9">
                	<select name="studentId" class="form-control input-sm" >
                		<c:forEach items="${stulist }" var="stu">
                		
                    	<option value="${stu.studentId }" >${stu.studentName }</option>
                    	</c:forEach>
                    </select>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">状态</label>
                <div class="col-sm-9">
               			<input type="text" name="attendanceState" class="form-control input-sm" placeholder="请输入状态"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">日期</label>
                <div class="col-sm-9">
               		 <input type="text" name="attendanceTime" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入日期"/>
                </div>
            </div>
        
        </div>

    </div>

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                	<textarea name="attendanceDesc" class="form-control"></textarea>
                </div>
            </div>
        
        </div>

    </div>
     <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注信息</label>
                <div class="col-sm-9">
                	<textarea name="attendanceRemark" class="form-control"></textarea>
                </div>
            </div>
        
        </div>

    </div>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="attendanceinfo/list.do">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>