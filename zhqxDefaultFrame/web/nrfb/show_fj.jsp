<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String fjbm = new String(request.getParameter("fjbm").getBytes(
			"ISO-8859-1"), "UTF-8");
	String title = new String(request.getParameter("title").getBytes(
			"ISO-8859-1"), "UTF-8");
	String wei = fjbm.substring(fjbm.length() - 3, fjbm.length());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=title%></title>
<script type="text/javascript" src="../js/flexpaper_flash.js"></script>
<script type="text/javascript" src="../js/flexpaper_flash_debug.js"></script>

</head>
<body style="overflow:-Scroll;overflow-y:hidden">
	<div style="margin-top: -10px; margin-left: 200px">

		<%
			if (wei.equals("swf")) {
		%>
		<a id="viewerPlaceHolder"
			style="width: 1000px; height: 650px; display: block"></a>
		<script type="text/javascript">
			var fp = new FlexPaperViewer('FlexPaperViewer', /* 对应FlexPaperViewer.swf文件*/
			'viewerPlaceHolder', {
				config : {
					//SwfFile : '84d8622b-67e3-495e-bbc4-8759971900da.swf',
					SwfFile : 'http://218.2.99.66//sqptwzdz/<%=fjbm%>',
					Scale : 0.6,
					ZoomTransition : 'easeOut',
					ZoomTime : 0.5,
					ZoomInterval : 0.2,
					FitPageOnLoad : true,
					FitWidthOnLoad : true,
					FullScreenAsMaxWindow : false,
					ProgressiveLoading : false,
					MinZoomSize : 0.2,
					MaxZoomSize : 5,
					SearchMatchAll : false,
					InitViewMode : 'Portrait',
					ViewModeToolsVisible : true,
					ZoomToolsVisible : true,
					NavToolsVisible : true,
					CursorToolsVisible : true,
					SearchToolsVisible : true,
					localeChain : 'zh_CN'
				}
			});
		</script>
		<%
			}else{
		%>
		<label>附件格式不是swf</label>
		<%} %>
	</div>
</body>
</html>