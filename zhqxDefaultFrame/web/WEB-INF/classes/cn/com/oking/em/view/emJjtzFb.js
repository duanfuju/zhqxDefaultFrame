/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};




/** @Bind #btnPrintPreview.onClick  */
!function(dsInformSingle){
	var id=dsInformSingle.getData().get("id");
	//window.open("reportJsp/jjtz_fb.jsp?sqlwhere_num=f.id='"+id+"'");	��Ǭ
	window.open("pageoffice/word_jjtz_fb.jsp?id="+id);
};



//@Bind #dgShow.onDataRowDoubleClick 
!function(dgShow,dsInformSingle,tcShow,ctinfo,iframeEmbed){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
		iframeEmbed.set('path',"pageoffice/word_jjtz_fb.jsp?id="+_id);
		iframeEmbed.reload();
	}
	tcShow.set('currentTab',ctinfo);
};


//@Bind #btnCreate.onClick
!function(doSomeThingAction,dsInformSingle){
	var status=dsInformSingle.getData().get("status");
	if (status) {
		if (status=='���') {
			var username='${session.getAttribute("username")}';
			dsInformSingle.getData().set('appby',username);
			doSomeThingAction.execute();
		}else if (status=='����׼') {
			alert('֪ͨ�Ѿ���׼');
		}else if (status=='�ѷ���') {
			alert('֪ͨ�Ѿ�����');
		} 
	}
};


/** @Bind #btnLikeSearch.onClick  */
!function(txtzt,txtzhlx,txtjjtznr,dsInformList){
	var zt= txtzt.get("text");
	var zhlx= txtzhlx.get("text");
	var jjtz= txtjjtznr.get("text");
	if (!zt) {
		zt='%';
	}
	if (!jjtz) {
		jjtz='%';
	}
	if (!zhlx) {
		zhlx='%';
	}
	var parameter={
			zt:zt,
			zhlx:zhlx,
			jjtz:jjtz
	};
	dsInformList.set('parameter',parameter);
	dsInformList.flushAsync();
};