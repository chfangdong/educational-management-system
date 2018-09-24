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
      <h1>${stuinfo.studentName }，欢迎您</h1>
      <a href="<%=basePath%>studentphone/loadlogin.do"  data-ajax="false" data-role="button">退出</a>
  </div>
    <div data-role="content">
        
           <div class="ui-grid-a">
               <div class="ui-block-a"><a href="studentscore/list.do?studentId=${stuinfo.studentId }" data-ajax="false" data-role="button"><img src="<%=basePath%>resources/img/ckcj.png" width="100%" height="100%"/></a></div>
               <div class="ui-block-b"><a href="studentphone/studentpayment/list.do?studentId=${stuinfo.studentId }" data-ajax="false" data-role="button"><img src="<%=basePath%>resources/img/jfxx.png" width="100%" height="100%"/></a></div>
           </div>
              <div class="ui-grid-a">
               <div class="ui-block-a"><a href="evaluationphone/list.do?studentId=${stuinfo.studentId }" data-ajax="false" data-role="button"><img src="<%=basePath%>resources/img/pjxx.png" width="100%" height="100%"/></a></div>
               <div class="ui-block-b"><a href="view/studentphone/student_info.jsp" data-ajax="false" data-role="button"><img src="<%=basePath%>resources/img/grxx.png" width="100%" height="100%"/></a></div>
           </div>	
    </div>
  <div data-role="footer" data-position="fixed">
   <h1>版权所有</h1>
  </div>

</div>
<body>

</body>
</html>