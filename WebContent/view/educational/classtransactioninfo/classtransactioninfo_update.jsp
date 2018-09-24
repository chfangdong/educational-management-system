<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
         <li>修改班级事务</li>
    </ul>
</div>

<form action="classtransactioninfo/update.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="classTransactionId" readonly="readonly" value="${transactinfo.classTransactionId }" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" name="classTransactionTitle" value="${transactinfo.classTransactionTitle }" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">组织人</label>
                <div class="col-sm-9">
               			<input type="text" name="classTransactionPerson" value="${transactinfo.classTransactionPerson }" class="form-control input-sm" placeholder="请输入组织人"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">活动日期</label>
                <div class="col-sm-9">
               		 <input type="text" name="classTransactionTime"  value='<fmt:formatDate value="${transactinfo.classTransactionTime }"/>'  onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入活动日期"/>
                </div>
            </div>
        
        </div>

    </div>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">组班级</label>
                <div class="col-sm-9">
                		<select name="classId" class="form-control input-sm">
                			<c:forEach items="${classlist }" var="classinfo">
                			<option  value="${classinfo.classId }" ${classinfo.classId==transactinfo.classId?'selected':'' } >${classinfo.className }</option>
                			</c:forEach>
                		</select>

                </div>
            </div>
        </div>
    

    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">主要内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">内容</label>
                <div class="col-sm-9">
                	<textarea name="classTransactionContent" class="form-control">${transactinfo.classTransactionContent }</textarea>
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
                	<textarea name="classTransactionRemark" class="form-control">${transactinfo.classTransactionRemark }</textarea>
                </div>
            </div>
        
        </div>

    </div>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="classtransactioninfo/list.do">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>