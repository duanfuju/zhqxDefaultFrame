<%@ page contentType="text/html;charset=GBK" %>
<%	String appmap = request.getContextPath();
	String printImage = "<img src='" + appmap + "/images/quieeReport/print.gif' border=no >";
	String excelImage = "<img src='" + appmap + "/images/quieeReport/excel.gif' border=no >";
	String pdfImage = "<img src='" + appmap + "/images/quieeReport/pdf.gif' border=no >";
    String wordImage = "<img src='" + appmap + "/images/quieeReport/doc.gif' border=no >";
	String firstPageImage = "<img src='" + appmap + "/images/quieeReport/firstpage.gif' border=no >";
	String lastPageImage = "<img src='" + appmap + "/images/quieeReport/lastpage.gif' border=no >";
	String nextPageImage = "<img src='" + appmap + "/images/quieeReport/nextpage.gif' border=no >";
	String prevPageImage = "<img src='" + appmap + "/images/quieeReport/prevpage.gif' border=no >";
	String submitImage = "<img src='" + appmap + "/images/quieeReport/savedata.gif' border=no >";
%>

<table id=titleTable width=100% cellspacing=0 cellpadding=0 border=0 ><tr>
	<td height="22" width=100% valign="middle"  style="font-size:13px" background="../images/ta51top.jpg">
		<table width="100%">
			<tr >
				<td width=53% align="left"  style="font-size:13px" >&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="47%" align="center" valign="middle"   style="font-size:12px" >��<span id="t_page_span"></span>ҳ/��<span id="c_page_span"></span>ҳ&nbsp;&nbsp;
				<a href="#" onClick="report1_print();return false;"><%=printImage%></a>
				<a href="#" onClick="report1_saveAsExcel();return false;"><%=excelImage%></a>
				<a href="#" onClick="report1_saveAsPdf();return false;"><%=pdfImage%></a>
				<a href="#" onClick="report1_saveAsWord();return false;"><%=wordImage%></a>
				<a href="#" onClick="_submitTable( report1 );return false;"><%=submitImage%></a>
				<a href="#" onClick="try{report1_toPage( 1 );}catch(e){}return false;"><%=firstPageImage%></a>
				<a href="#" onClick="try{report1_toPage(report1_getCurrPage()-1);}catch(e){}return false;"><%=prevPageImage%></a>
				<a href="#" onClick="try{report1_toPage(report1_getCurrPage()+1);}catch(e){}return false;"><%=nextPageImage%></a>
				<a href="#" onClick="try{report1_toPage(report1_getTotalPage());}catch(e){}return false;"><%=lastPageImage%></a>
			  </td>
			</tr>
	  </table>
	</td>
</table>