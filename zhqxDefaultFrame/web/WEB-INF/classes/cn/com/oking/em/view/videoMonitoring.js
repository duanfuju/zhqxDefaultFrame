var arrayList=[];
/** @Bind #dtGrid.onDataRowDoubleClick  */
!function(dtGrid,htmlDetail,ifShow,saveListAction){
	var obj=dtGrid.get("currentNode");
	var entity=obj._data._data;
	htmlDetail.set("content","<center>"
									+" <h3>详细信息</h3>"
						        	+" <table>"
							        	+" <tr><td>位  置：</td><td>"+entity.location+"</td></tr>"
							        	+" <tr><td>主管部门：</td><td>"+entity.dept+"</td></tr>"
							        	+" <tr><td>负责人：</td><td>"+entity.contraces+"</td></tr>"
							        	+" <tr><td>联系电话：</td><td>"+entity.phone+"</td></tr>"
						        	+" </table>"
					        	+" </center>");	
	arrayList=[];
	arrayList.push(entity);
	saveListAction.set("parameter", arrayList).execute(function(){
		ifShow.reload();
		 ifShow.set("path","em/map/spjk.jsp");
	 });
};

/** @Bind #updateAction1.onSuccess   */
!function(dsEmMonitoring){
	dsEmMonitoring.flushAsync();
};

/** @Bind #dtGrid.onSelectionChange   */
!function(dtGrid,ifShow,saveListAction,htmlDetail){
	arrayList=[];
	var se=dtGrid.get("selection");
	if (se) {
		htmlDetail.set("content","");
		se.each(function(entity){
			var data= entity._data._data;
			arrayList.push(data);
		});
		saveListAction.set("parameter", arrayList).execute(function(){
			ifShow.reload();
			 ifShow.set("path","em/map/spjk.jsp");
		 });
	}
};

/** @Bind #btnAdd.onClick   */
!function(dialogAdd,dsAdd){
	dsAdd.clear();
	dsAdd.insert();
	dialogAdd.show();
};


/** @Bind #btnPick.onClick   */
!function(dialogPick){
	dialogPick.show();
};



/** @Bind #dialogPick.onClose   */
!function(dsAdd,afeX,afeY,autoAjaxAction){
	autoAjaxAction.execute(function(info){
		var json=eval('(' + info + ')');
		afeX.set("text",json.longitude);
		afeY.set("text",json.latitude);
	 });
};