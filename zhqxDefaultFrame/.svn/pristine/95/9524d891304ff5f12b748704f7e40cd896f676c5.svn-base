<%@ page language="java" contentType="text/html; charset=GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<lab><strong>视频会商启动</strong></lab><br>
<%
String tocken = request.getParameter("rv")==null?"":request.getParameter("rv");
%>
<form action="http://218.2.99.67/meeting/ci.action?siteId=1&dt=GMT" method="post">
<input type="hidden" name="token" value="<%=tocken%>"/>
<input type="hidden" name="backUrl" value="http://218.2.99.66:8866/newzhqx/cn.com.oking.meeting.view.meetingList.d"/>
</from> 
<script>
document.forms[0].submit();
</script>
</body>
</html>