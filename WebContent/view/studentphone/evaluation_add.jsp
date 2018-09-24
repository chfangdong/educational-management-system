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
        <a href="<%=basePath%>view/studentphone/student_index.jsp"  data-ajax="false" data-role="button">首页</a>
       <h1>添加评价信息</h1>
      <a href="<%=basePath%>evaluationphone/list.do?studentId=${stuinfo.studentId }"  data-ajax="false" data-role="button">返回上一级</a>

  </div>
         <div data-role="content">
        		<form action="<%=basePath%>evaluationphone/add.do" data-ajax="false" method="get">
                	<div data-role="fieldcontain">
                	<label for="evaluationTitle">主题:</label>
                    <input type="text" id="evaluationTitle" placeholder="请输入主题" name="evaluationTitle"/>
                    <label for="evaluationCourse">课程名称:</label>
                    <input type="text" name="evaluationCourse"    placeholder="请输入课程名称" id="evaluationCourse"/>
                    <label for="evaluationTeacher">老师姓名:</label>
                    <input type="text" name="evaluationTeacher"    placeholder="请输入老师姓名" id="evaluationTeacher"/>
                   	<label for="evaluationContent">评价内容:</label>
                    <textarea name="evaluationContent" id="evaluationContent"></textarea>
      
                    
                    </div>
                    
                	<input type="submit" value="添加评价"/>
                </form>
        </div>
  <div data-role="footer" data-position="fixed">
    <h1>版权所有</h1>
  </div>

</div>
</body>
</html>