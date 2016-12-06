 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr align="center" width="55%" color="#991111" size="5"/>

<%
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
    request.setCharacterEncoding("UTF-8");
   
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }catch(ClassNotFoundException ce){
        out.println(ce.getMessage());
    }
    try{
        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        conn=DriverManager.getConnection(url,"admin428","123456");
        stmt=conn.prepareStatement("select dataid, dataname, testurl, overtime, lastdate, status from monitor_sys_list");
   
        rs=stmt.executeQuery();
        out.print("<TABLE BORDER='1' width='55%' cellpadding='3' align=center>");
        out.print("<TR><TD>"+"<b>dataid</b>"+"</TD>");
        out.print("<TD>"+"<b>dataname </b>"+"</TD>");
        out.print("<TD>"+"<b>testurl</b>"+"</TD>");
        out.print("<TD>"+"<b>overtime</b>"+"</TD>");
        out.print("<TD>"+"<b>lastdate </b>"+"</TD>");
        out.print("<TD>"+"<b>status</b>"+"</TD></TR>");


        while(rs.next()){
            out.print("<TR><TD>"+rs.getString(1)+"</TD>");
            out.print("<TD>"+rs.getString(2)+"</TD>");
            out.print("<TD >"+rs.getString(3)+"</TD>");
            out.print("<TD>"+rs.getString(4)+"</TD>");
            out.print("<TD>"+rs.getString(5)+"</TD>");
            out.print("<TD>"+rs.getString(6)+"</TD></TR>");
        }

        out.print("</TABLE>");
   
        rs.close();
        stmt.close();
        conn.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
%>
</body>
</html>