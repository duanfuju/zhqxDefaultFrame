<%@page import="cn.com.oking.fzjz.entity.MnylBaseinfo"%>
<%@page import="cn.com.oking.fzjz.action.MnylBaseinfoAction"%>
<%@page import="cn.com.oking.fzjz.action.MnylResultrecordAction"%>
<%@page import="cn.com.oking.fzjz.entity.MnylResultrecord"%>
<%@page import="cn.com.oking.fzjz.entity.MnylProblems"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.fzjz.action.MnylProblemsAction"%>
<%@ page language="java"
	import="java.util.*,java.lang.*,com.zhuozhengsoft.pageoffice.*"
	pageEncoding="gb2312"%>
<%@page import="com.zhuozhengsoft.pageoffice.excelwriter.*"%>
<%@page import="java.awt.Color"%>
<%@page import="java.text.*"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>

<%!
String changNull(Object obj){
	String s = "-";
	if(obj != null ){
		s = (String)obj;
	}
	return s;
}
%>
<%
	//设置PageOfficeCtrl控件的服务页面
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.do"); //此行必须

	
	//获取演练记录的主键编号
	String ylId=new String(request.getParameter("ylId").getBytes("ISO-8859-1"),"UTF-8");
	MnylProblemsAction action=(MnylProblemsAction) ContextHolder.getApplicationContext().getBean(MnylProblemsAction.class);
	MnylResultrecordAction r_action=(MnylResultrecordAction) ContextHolder.getApplicationContext().getBean(MnylResultrecordAction.class);
	MnylBaseinfoAction info_action=(MnylBaseinfoAction) ContextHolder.getApplicationContext().getBean(MnylBaseinfoAction.class);
	//根据主键编号获取演练基本信息
	MnylBaseinfo info=info_action.findById(ylId);
	
	//根据主键编号查询问题数据
	List<MnylProblems> list=action.findByYlId(ylId);
	
	
	
	poCtrl1.setCaption("模拟演练结果");
	//定义Workbook对象
	Workbook workBook = new Workbook();
	//定义Sheet对象，"Sheet1"是打开的Excel表单的名称
	Sheet sheet = workBook.openSheet("Sheet1");
	if(info!=null){
		//定义Cell对象
		Cell cellB2 = sheet.openCell("B2");
		Cell cellB3 = sheet.openCell("B3");
		Cell cellB4 = sheet.openCell("B4");
		Cell cellB5 = sheet.openCell("B5");
		Cell cellB6 = sheet.openCell("B6");
		//给单元格赋值
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cellB2.setValue(info.getYlPerson());
		cellB3.setValue(changNull(info.getDept()));
		cellB4.setValue(sdf.format(info.getYlStartTime()));
		cellB5.setValue(sdf.format(info.getYlEndTime()));
		cellB6.setValue(info.getDrillMode());
	}
	
	
	
	
	//定义Table对象
	Table table = sheet.openTable("A8:D9");
   /*  for(int i=0; i < 50; i++)
    { 
        table.getDataFields().get(0).setValue("产品 " + i);
        table.getDataFields().get(1).setValue("100");
        table.getDataFields().get(2).setValue(String.valueOf(100+i));
        table.nextRow();
    } */
    if(list.size()>0){
		for(MnylProblems m :list){
			//设置问题的内容
			table.getDataFields().get(0).setValue(m.getProblem());
			//根据问题获取参考答案
			List<MnylResultrecord> mlist=r_action.findByAnswerId(m.getId());
			//首先将参考答案拼接成字符串，然后将演练人选择的答案选择出来
			String zq_answer="";
			String ylr_answer="";
			for(MnylResultrecord r :mlist){
				//实际选项
				if(r.getOptionChoose().equalsIgnoreCase("true")){
					ylr_answer+=r.getOptionText()+"	;	";
				}
				//正确选项
				if(r.getOptionIstrue().equalsIgnoreCase("true")){
					zq_answer+=r.getOptionText()+"	;	";
				}
			}
			table.getDataFields().get(1).setValue(zq_answer);
	        table.getDataFields().get(2).setValue(ylr_answer);
	        table.nextRow();
		}
    }
    
    table.close();
    	
	poCtrl1.setWriter(workBook);
	
	//隐藏菜单栏
	poCtrl1.setMenubar(true);
	//隐藏工具栏
	poCtrl1.setCustomToolbar(false);
	//打开Word文件
	String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") + "\\excel\\";
	poCtrl1.webOpen(path+"mnyl.xlsx", OpenModeType.xlsNormalEdit, "张三");
	poCtrl1.setTagId("PageOfficeCtrl1"); //此行必须
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<div style="width: 100%; height: 800px;">
			<po:PageOfficeCtrl id="PageOfficeCtrl1"></po:PageOfficeCtrl>
		</div>
	</body>
</html>
