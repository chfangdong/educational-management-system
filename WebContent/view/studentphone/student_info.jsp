<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/jquery.mobile-1.3.2.min.css" rel="stylesheet">
<script src="resources/js/jquery-1.8.3.min.js"></script>
<script src="resources/js/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>

<div data-role="page">

  <div data-role="header">
      <a href="view/studentphone/student_index.jsp"  data-ajax="false" data-role="button">首页</a>
       <h1>个人信息</h1>
       <a href="<%=basePath%>studentphone/loadlogin.do"  data-ajax="false" data-role="button">退出</a>

  </div>
    <div data-role="content">
    <ul data-role="listview" >
      <li>
        <img src="resources/img/student.png" width="100%" height="100%">
            <h2>${stuinfo.studentName }</h2>
           
         <p><b>性别：</b>${stuinfo.studentSex }  <b>年龄：</b>${stuinfo.studentAge }  </p>
         <p><b>电话号码：</b>${stuinfo.studentTellphone }</p>		
		 <p><b>电子邮件：</b>${stuinfo.studentEmail }  </p>
		 <p><b>身份证号码：</b>${stuinfo.studentIdcard } </p>
         <p><b>家庭地址：</b>${stuinfo.studentAddress }</p>
         <p><b>出生日期：</b>${stuinfo.studentBirthday }  </p>
         <p><b>学院：</b>${stuinfo.studentSchool }  </p>
         <p><b>QQ：</b>${stuinfo.studentQq }  </p>
         <p><b>省份：</b>${stuinfo.studentPro }  </p>
          <p><b>备注：</b>${stuinfo.studentDesc }  </p>
      </li>      


    </ul>
    </div>
  <div data-role="footer" data-position="fixed">
    <h1>版权所有</h1>
  </div>

</div>
</body>
</html>