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
<title>c</title>
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
    	<li><a href="#">招生管理</a></li>
        <li>学员池</li>
        <li>修改学员</li>
    </ul>
</div>

<form action="studentpool/update.do" class="form-horizontal">
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="studentpool/list.do">返回上一级</a>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="studentId" value="${stuinfo.studentId }" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-9">
                	<input type="text" name="studentName" value="${stuinfo.studentName }" class="form-control input-sm" placeholder="请输入姓名"/>
                </div>
            </div>
        </div>
    </div>
    	<!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">性别</label>
                <div class="col-sm-4">
                	<select  name="studentSex" class="form-control input-sm" >
                    	<option value="保密" ${stuinfo.studentSex=='保密'?'selected':'' }>保密</option>
                        <option value="男" ${stuinfo.studentSex=='男'?'selected':'' }>男</option>
                        <option value="女" ${stuinfo.studentSex=='女'?'selected':'' }>女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">年龄</label>
                <div class="col-sm-5">
                	<input type="text" name="studentAge" value="${stuinfo.studentAge }" class="form-control input-sm" placeholder="请输入年龄"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
       	<!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">手机号码</label>
                <div class="col-sm-9">
                	<input type="text" name="studentTellphone" value="${stuinfo.studentTellphone }" class="form-control input-sm" placeholder="请输入手机号码"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">电子邮件</label>
                <div class="col-sm-9">
                	<input type="text" name="studentEmail" value="${stuinfo.studentEmail }"  class="form-control input-sm" placeholder="请输入电子邮件"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
    <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">身份证</label>
                <div class="col-sm-9">
                	<input type="text" name="studentIdcard" value="${stuinfo.studentIdcard }"  class="form-control input-sm" placeholder="请输入身份证"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">家庭地址</label>
                <div class="col-sm-9">
                	<input type="text" name="studentAddress"  value="${stuinfo.studentAddress }" class="form-control input-sm" placeholder="请输入家庭地址"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
   <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">出生日期</label>
                <div class="col-sm-9">
                	<input type="text" readonly="readonly"  value="${stuinfo.studentBirthday }" name="studentBirthday" onClick="WdatePicker()" class="form-control input-sm" placeholder="请输入出生日期"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">所在院校</label>
                <div class="col-sm-9">
                	<input type="text" name="studentSchool" value="${stuinfo.studentSchool }" class="form-control input-sm" placeholder="请输入所在院校"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
      <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">QQ号码</label>
                <div class="col-sm-9">
                	<input type="text" name="studentQq" value="${stuinfo.studentQq }" class="form-control input-sm" placeholder="请输入QQ号码"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">家长姓名</label>
                <div class="col-sm-9">
                	<input type="text" name="studentParentsName" value="${stuinfo.studentParentsName }" class="form-control input-sm" placeholder="请输入家长姓名"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
         <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">省份</label>
                <div class="col-sm-9">
                	<input type="text" name="studentPro" value="${stuinfo.studentPro }" class="form-control input-sm" placeholder="请输入省份"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">家长电话</label>
                <div class="col-sm-9">
                	<input type="text" name="studentParentsPhone"  value="${stuinfo.studentParentsPhone }" class="form-control input-sm" placeholder="请输入家长电话"/>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
            <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">城市</label>
                <div class="col-sm-9">
                	<input type="text" name="studentProCity" value="${stuinfo.studentProCity }" class="form-control input-sm" placeholder="请输入城市"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">意向状态</label>
                <div class="col-sm-6">
                	<s:select name="studentSate" type="student_sate" selectedId="${stuinfo.studentSate }"></s:select>
                </div>
            </div>
        </div>
    </div>
   <!--结束 -->
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述信息</label>
                <div class="col-sm-9">
                	<textarea name="studentDesc" class="form-control">${stuinfo.studentDesc }</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="studentpool/list.do">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>