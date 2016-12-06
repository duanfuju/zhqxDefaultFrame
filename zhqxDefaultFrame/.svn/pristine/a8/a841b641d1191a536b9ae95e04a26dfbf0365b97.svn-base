<%@page import="cn.com.oking.util.GF_JacobUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="com.zhuozhengsoft.pageoffice.*"%>
<%
FileSaver fs = new FileSaver(request, response);
//获取需要保存的文件名
String fileName=fs.getFileName();
String path=request.getSession().getServletContext().getRealPath("pageoffice") + "\\doc\\" + fileName;
//获取文件名（去除文件后缀）
String[] strs=fileName.split("\\.");
//设置word文件转pdf文件的路径
String pdfSaveName=request.getSession().getServletContext().getRealPath("pageoffice") + "\\pdf\\" +strs[0]+".pdf";
fs.saveToFile(path);
//fs.showPage(300,300);
fs.close();
GF_JacobUtil word = new GF_JacobUtil(); 
word.openWord(false);
word.openDocument(path); 
word.wordToPDF(path, pdfSaveName);
word.closeDocument();  
word.closeWord();  
%>

<!DOCTYPE HTML>
<html>
<head>
    <title></title>
</head>
<body>
    
</body>
</html>
