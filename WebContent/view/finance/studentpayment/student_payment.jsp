<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
   <script type="text/javascript">
   	function total(){
   		//应交金额
   		var shouldAmount = $("#shouldAmount").val();
   		//优惠金额
   		var discountAmount = $("#discountAmount").val();
   		//实交金额
   		var realAmount = $("#realAmount").val();
   		
   		var amount = shouldAmount-discountAmount-realAmount;
   		$("#debtAmount").val(amount);
   	}
   
   </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>

        <li>学员缴费</li>
    </ul>
</div>

<form action="studentpayment/payment.do" method="post" class="form-horizontal">
<input type="hidden" name="studentId" value="${stuinfo.studentId }"/>
   	<div class="row">
    	<div class="col-sm-9">
 
            <a class="btn btn-warning" href="studentpayment/list.do">返回上一级</a>
        </div>
    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                <p class="form-control-static">${stuinfo.studentId }</p>
                	
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-9">
                 <p class="form-control-static">${stuinfo.studentName }</p>
                	
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
                 <p class="form-control-static">${stuinfo.studentSex }</p>
                
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">年龄</label>
                <div class="col-sm-5">
                 <p class="form-control-static">${stuinfo.studentAge }</p>
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
                  <p class="form-control-static">${stuinfo.studentTellphone }</p>
                     </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">电子邮件</label>
                <div class="col-sm-9">
                <p class="form-control-static">${stuinfo.studentEmail }</p>
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
                  <p class="form-control-static">${stuinfo.studentIdcard }</p>
                	                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">家庭地址</label>
                <div class="col-sm-9">
                 <p class="form-control-static">${stuinfo.studentAddress }</p>
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
                 <p class="form-control-static">${stuinfo.studentBirthday }</p>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">所在院校</label>
                <div class="col-sm-9">
                    <p class="form-control-static">${stuinfo.studentSchool }</p>
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
                   <p class="form-control-static">${stuinfo.studentQq }</p>
                 </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">家长姓名</label>
                <div class="col-sm-9">
                 <p class="form-control-static">${stuinfo.studentParentsName }</p>
                 </div>
            </div>
        </div>
    </div>
   <!--结束 -->
   <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">学员缴费信</h5>
 
       <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费情况</label>
                <div class="col-sm-9">
               		<input type="text" name="paymentSituation" class="form-control input-sm" placeholder="请输入缴费情况"/>
                 </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费方式</label>
                <div class="col-sm-9">
                  <s:select  name="paymentMethod" type="payment_method"></s:select>
                 </div>
            </div>
        </div>
    </div>
   <!--结束 -->
       <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费时间</label>
                <div class="col-sm-9">
               		<input type="text" name="paymentTime" onclick="WdatePicker()" class="form-control input-sm" placeholder="请输入缴费情况"/>
                 </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">应交金额</label>
                <div class="col-sm-9">
                  <input type="text" name="shouldAmount" id="shouldAmount" class="form-control input-sm" placeholder="请输入缴费情况"/>
                 </div>
            </div>
        </div>
    </div>
   <!--结束 -->
       <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">优惠金额</label>
                <div class="col-sm-9">
               		<input type="text" name="discountAmount"  id="discountAmount" class="form-control input-sm" placeholder="请输入缴费情况"/>
                 </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">实交金额</label>
                <div class="col-sm-9">
                  <input type="text" name="realAmount" onblur="total()"  id="realAmount" class="form-control input-sm" placeholder="请输入缴费情况"/>
                 </div>
            </div>
        </div>
    </div>
   <!--结束 -->

       <!--开始 -->
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">欠款</label>
                <div class="col-sm-9">
               		<input type="text" name="debtAmount"  id="debtAmount" class="form-control input-sm" placeholder="请输入缴费情况"/>
                 </div>
            </div>
        </div>

    </div>
   <!--结束 -->
        <!--开始 -->
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
               		<textarea name="paymentRemark" class="form-control"></textarea>
                 </div>
            </div>
        </div>

    </div>
   <!--结束 -->
   	<div class="row">
    	<div class="col-sm-9 ">
    			
 			 <a class="btn btn-warning" href="studentpayment/list.do">返回上一级</a>
 			  <input type="submit" class="btn btn-success"  value="学员缴费"/>
        </div>
    </div>
</form>

</body>
</html>