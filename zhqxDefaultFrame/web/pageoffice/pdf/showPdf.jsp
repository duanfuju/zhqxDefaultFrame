<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";  
%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pdf展示</title>
<base href="<%=basePath%>">
</head>
<%  
   String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
   out.clear();  
   out = pageContext.pushBody();  
   response.setContentType("application/pdf");  
   
   String realpath=request.getSession().getServletContext().getRealPath("pageoffice")+"/pdf/";
   System.out.print(realpath);
   try {  
    String strPdfPath = new String(realpath+id);  
    //判断该路径下的文件是否存在  
    File file = new File(strPdfPath);  
    if (file.exists()) {  
     DataOutputStream temps = new DataOutputStream(response  
       .getOutputStream());  
     DataInputStream in = new DataInputStream(new FileInputStream(strPdfPath));  
     byte[] b = new byte[2048];  
     while ((in.read(b)) != -1) {  
      temps.write(b);  
      temps.flush();  
     }  
     in.close();  
     temps.close();  
    } else {  
     out.print(strPdfPath + " 文件不存在!");  
    }  
  
   } catch (Exception e) {  
    out.println(e.getMessage());  
   }  
%>  
<body>  
   <br>  
</body>  
</html> 