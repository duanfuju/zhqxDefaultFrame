var arrayList=[];
/** @Bind #dtGrid.onDataRowClick  */
!function(dtGrid,htmlDetail,ifShow,saveListAction){
	var obj=dtGrid.get("currentNode");
	var level=obj.get("level");
	if (level>1) {
		var entity=obj._data._data;
		htmlDetail.set("content","<center>"
				+" <h3>详细信息</h3>"
		        	+" <table>"
		        		+" <tr><td>场  所：</td><td>"+entity.placename+"</td></tr>"
			        	+" <tr><td>位  置：</td><td>"+entity.location+"</td></tr>"
			        	+" <tr><td>负责人：</td><td>"+entity.contraces+"</td></tr>"
			        	+" <tr><td>联系电话：</td><td>"+entity.phone+"</td></tr>"
		        	+" </table>"
	        	+" </center>");	
		arrayList=[];
		arrayList.push(entity);
		saveListAction.set("parameter", arrayList).execute(function(){
			ifShow.reload();
			 ifShow.set("path","em/map/bncs.jsp");
		 });
	}
};

/** @Bind #updateAction1.onSuccess   */
!function(dsEmShelter,dsTree){
	dsEmShelter.flushAsync();
	dsTree.flushAsync();
};

/** @Bind #saveAction.onSuccess   */
!function(dsEmShelter,dsTree){
	dsEmShelter.flushAsync();
	dsTree.flushAsync();
};



/** @Bind #dtGrid.onReady   */
!function(dtGrid){
	function collapse(nodes) {
		nodes.each(function(node) {
			collapse(node.get("nodes"));
			if (node.get("expanded"))
				node.collapse();
		});
	}
	collapse(dtGrid.get("nodes"));
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

//@Bind #buttonCollapseAll.onClick
!function(dtGrid) {
	function collapse(nodes) {
		nodes.each(function(node) {
			collapse(node.get("nodes"));
			if (node.get("expanded"))
				node.collapse();
		});
	}

	collapse(dtGrid.get("nodes"));
};

// @Bind #buttonExpandAll.onClick
!function(dtGrid) {
	function expand(nodes) {
		nodes.each(function(node) {
			if (!node.get("expanded"))
				node.expand();
			expand(node.get("nodes"));
		});
	}

	expand(dtGrid.get("nodes"));
};

// @Bind #buttonSelectAll.onClick
!function(dtGrid,htmlDetail,dsEmShelter,saveListAction,ifShow) {
	function select(nodes) {
		nodes.each(function(node) {
			select(node.get("nodes"));
			node.set("checked", true);
		});
	}
	select(dtGrid.get("nodes"));
	var data=dsEmShelter.getData();
	arrayList=[];
	htmlDetail.set("content","");
	data.each(function(entity){
		if (entity.get("parentid")) {			
			arrayList.push(entity);
		}
	});
	saveListAction.set("parameter", arrayList).execute(function(){
		 ifShow.set("path","em/map/bncs.jsp");
		 ifShow.reload();
	 });
	
};





// @Bind #buttonUnselectAll.onClick
!function(dtGrid,ifShow) {
	function unselect(nodes) {
		nodes.each(function(node) {
			unselect(node.get("nodes"));
			node.set("checked", false);
		});
	}

	unselect(dtGrid.get("nodes"));
	 ifShow.set("path","em/Map.jsp");
	 ifShow.reload();
};