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
	//����PageOfficeCtrl�ؼ��ķ���ҳ��
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage(request.getContextPath()+"/poserver.do"); //���б���

	
	//��ȡ������¼���������
	String ylId=new String(request.getParameter("ylId").getBytes("ISO-8859-1"),"UTF-8");
	MnylProblemsAction action=(MnylProblemsAction) ContextHolder.getApplicationContext().getBean(MnylProblemsAction.class);
	MnylResultrecordAction r_action=(MnylResultrecordAction) ContextHolder.getApplicationContext().getBean(MnylResultrecordAction.class);
	MnylBaseinfoAction info_action=(MnylBaseinfoAction) ContextHolder.getApplicationContext().getBean(MnylBaseinfoAction.class);
	//����������Ż�ȡ����������Ϣ
	MnylBaseinfo info=info_action.findById(ylId);
	
	//����������Ų�ѯ��������
	List<MnylProblems> list=action.findByYlId(ylId);
	
	
	
	poCtrl1.setCaption("ģ���������");
	//����Workbook����
	Workbook workBook = new Workbook();
	//����Sheet����"Sheet1"�Ǵ򿪵�Excel��������
	Sheet sheet = workBook.openSheet("Sheet1");
	if(info!=null){
		//����Cell����
		Cell cellB2 = sheet.openCell("B2");
		Cell cellB3 = sheet.openCell("B3");
		Cell cellB4 = sheet.openCell("B4");
		Cell cellB5 = sheet.openCell("B5");
		Cell cellB6 = sheet.openCell("B6");
		//����Ԫ��ֵ
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cellB2.setValue(info.getYlPerson());
		cellB3.setValue(changNull(info.getDept()));
		cellB4.setValue(sdf.format(info.getYlStartTime()));
		cellB5.setValue(sdf.format(info.getYlEndTime()));
		cellB6.setValue(info.getDrillMode());
	}
	
	
	
	
	//����Table����
	Table table = sheet.openTable("A8:D9");
   /*  for(int i=0; i < 50; i++)
    { 
        table.getDataFields().get(0).setValue("��Ʒ " + i);
        table.getDataFields().get(1).setValue("100");
        table.getDataFields().get(2).setValue(String.valueOf(100+i));
        table.nextRow();
    } */
    if(list.size()>0){
		for(MnylProblems m :list){
			//�������������
			table.getDataFields().get(0).setValue(m.getProblem());
			//���������ȡ�ο���
			List<MnylResultrecord> mlist=r_action.findByAnswerId(m.getId());
			//���Ƚ��ο���ƴ�ӳ��ַ�����Ȼ��������ѡ��Ĵ�ѡ�����
			String zq_answer="";
			String ylr_answer="";
			for(MnylResultrecord r :mlist){
				//ʵ��ѡ��
				if(r.getOptionChoose().equalsIgnoreCase("true")){
					ylr_answer+=r.getOptionText()+"	;	";
				}
				//��ȷѡ��
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
	
	//���ز˵���
	poCtrl1.setMenubar(true);
	//���ع�����
	poCtrl1.setCustomToolbar(false);
	//��Word�ļ�
	String path=ContextHolder.getRequest().getSession().getServletContext().getRealPath("pageoffice") + "\\excel\\";
	poCtrl1.webOpen(path+"mnyl.xlsx", OpenModeType.xlsNormalEdit, "����");
	poCtrl1.setTagId("PageOfficeCtrl1"); //���б���
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
