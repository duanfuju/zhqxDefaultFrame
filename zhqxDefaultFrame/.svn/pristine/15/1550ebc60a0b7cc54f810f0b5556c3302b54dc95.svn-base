/** @Bind #tcShow.onTabChange  */
!function(dsInformList){
	dsInformList.flushAsync();
};


/** @Bind #btnPrintPreview.onClick  */
!function(dsInformSingle){
	var id=dsInformSingle.getData().get("id");
	/*window.open("reportJsp/czfa_ml_fw.jsp?sqlwhere_num=mla.czfa_jy_id='"+id+"'");*/
	
	window.open("pageoffice/word_czfa_ml.jsp?id="+id);
};






/** @Bind #tbbAdd.onClick  */
!function(dsInformSingle,dsContact){
	var czfajyid=dsInformSingle.getData().get("id");
	dsContact.insert({
		"czfajyid":czfajyid,
	});
};


//@Bind #dgShow.onDataRowDoubleClick 
!function(iframeEmbed,dgShow,dsInformSingle,tcShow,dsContact,ctinfo,dsMlShow,dsMlSupplement){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsInformSingle.set("parameter",_id);
		dsInformSingle.flushAsync();
		var parameter={
				'czfaJyId':_id
		};
		dsMlShow.set("parameter",parameter);
		dsMlShow.flushAsync();
		
		dsMlSupplement.set("parameter",parameter);
		dsMlSupplement.flushAsync();
		
		dsContact.set("parameter",_id);
		dsContact.flushAsync();
		
		iframeEmbed.set('path',"pageoffice/word_czfa_ml.jsp?id="+_id);
		iframeEmbed.reload();
		
	}
	tcShow.set('currentTab',ctinfo);
};


//@Bind #btnCreate.onClick
!function(doSomeThingAction,dsInformSingle,saveAction){
	var status=dsInformSingle.getData().get("status");
	if (status) {
		if (status=='已批准') {
			var username='${session.getAttribute("username")}';
			dsInformSingle.getData().set('appby',username);
			doSomeThingAction.execute();
			saveAction.execute();
		}else if (status=='已发布') {
			alert('通知已经发布');
		} 
	}
};


/** @Bind #btnLikeSearch.onClick  */
!function(txtorderNumber,txtzhlx,dsInformList){
	var zhlx= txtzhlx.get("text");
	var orderNumber= txtorderNumber.get("text");
	if (!orderNumber) {
		orderNumber='%';
	}
	if (!zhlx) {
		zhlx='%';
	}
	var parameter={
			zhlx:zhlx,
			orderNumber:orderNumber
	};
	dsInformList.set('parameter',parameter);
	dsInformList.flushAsync();
};