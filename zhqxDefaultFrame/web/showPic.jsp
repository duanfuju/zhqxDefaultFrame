<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String STCD=request.getParameter("STCD");
	String Scanid=request.getParameter("Scanid");
	String DT=request.getParameter("DT");
	DT=DT.replace("%20"," ");
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    response.setContentType("image/jpeg");  
    request.setCharacterEncoding("UTF-8");
    /* String sql="select pic from ST_RVU90_PIC_H where STCD='T01' and Scanid='1' and DT='2015-11-11 16:51:00'"; */
     String sql="select pic from ST_RVU90_PIC_H where STCD='"+STCD+"' and Scanid='"+Scanid+"' and DT='"+DT+"'"; 
    try{
    	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
    	String url="jdbc:sqlserver://192.168.0.7:1433;databaseName=CQ_Res";
        conn=DriverManager.getConnection(url,"sa","123456");
        stmt=conn.prepareStatement(sql);
        rs=stmt.executeQuery();
        rs.next();  
        byte[] bytes=rs.getBytes("pic");
        InputStream in =  new ByteArrayInputStream(bytes); 
        response.reset();  
        response.setContentType("image/jpeg");  
        byte[] b = new byte[1024];  
        int len;  
        while((len=in.read(b)) >0){
	        response.getOutputStream().write(b,0,len);  
        }
        out.clear();
        out = pageContext.pushBody();
    }catch(Exception e){
        System.out.println("请联系管理员"+e.getMessage());
    }finally{
    	 rs.close();
         stmt.close();
         conn.close(); 
    }
   
%>
<%-- <img name="pic" src="showPic.jsp?DT=<%=DT %>&Scanid=<%=Scanid  %>&STCD=<%=STCD%>" /> --%>
</body>
</html>