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
<link href="<%=basePath%>resources/css/jquery.mobile-1.3.2.min.css" rel="stylesheet">
<script src="<%=basePath%>resources/js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>resources/js/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>

<form action="<%=basePath%>studentphone/login.do" data-ajax="false" method="post">
<div data-role="page">

  <div data-role="header">
    <h1>杰帮教育</h1>
  </div>

  <div data-role="content">
  	  <div align="center">
      	<img src="<%=basePath%>resources/img/login.png" width="150" height="120" />
      </div>	
      <div data-role="fieldcontain">
            <br/>
            <input type="text" id="studentNumber" placeholder="请输入账号" name="studentNumber"/>
           <br/>
            <input type="password" name="studentPassword"    placeholder="请输入密码" id="studentPassword"/>
           
        
    </div>
   
    <div align="center">
    <input type="submit" value="登录" data-role="button"/>
   
    </div>
  </div>

  <div data-role="footer" data-position="fixed">
    <h1>版权所有</h1>
  </div>

</form>
</body>
</html>