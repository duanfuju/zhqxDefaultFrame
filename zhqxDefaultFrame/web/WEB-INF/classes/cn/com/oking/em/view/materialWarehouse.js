var arrayList=[];
/** @Bind #dtGrid.onDataRowClick  */
!function(dtGrid,htmlDetail,ifShow,saveListAction){
	var obj=dtGrid.get("currentNode");
	var entity=obj._data._data;
	htmlDetail.set("content","<center>"
					        	+" <h3>��ϸ��Ϣ</h3>"
						        	+" <table>"
							        	+" <tr><td>λ  �ã�</td><td>"+entity.location+"</td></tr>"
							        	+" <tr><td>���ܲ��ţ�</td><td>"+entity.dept+"</td></tr>"
							        	+" <tr><td>�����ˣ�</td><td>"+entity.contraces+"</td></tr>"
							        	+" <tr><td>��ϵ�绰��</td><td>"+entity.phone+"</td></tr>"
						        	+" </table>"
					        	+" </center>");	
	arrayList=[];
	arrayList.push(entity);
	saveListAction.set("parameter", arrayList).execute(function(){
		 ifShow.set("path","em/map/wzck.jsp");
		 ifShow.reload();
	 });
};

/** @Bind #updateAction1.onSuccess   */
!function(dsEmStore){
	dsEmStore.flushAsync();
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
			ifShow.set("path","em/map/wzck.jsp");
			ifShow.reload();
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
/** @Bind #tcShow.onTabChange  */
!function(dsTree,dsEmStore){
	dsTree.flushAsync();
	dsEmStore.flushAsync();
};


/** @Bind #dialogPick.onClose   */
!function(dsAdd,afeX,afeY,autoAjaxAction){
	autoAjaxAction.execute(function(info){
		var json=eval('(' + info + ')');
		afeX.set("text",json.longitude);
		afeY.set("text",json.latitude);
	 });
};