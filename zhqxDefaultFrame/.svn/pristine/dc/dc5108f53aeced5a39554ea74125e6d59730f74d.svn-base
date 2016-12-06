var arrayList=[];
/** @Bind #dtgGrid.onDataRowClick  */
!function(dtgGrid,ifShow,saveListAction){
	var obj=dtgGrid.get("currentNode");
	var entity=obj._data._data;
	arrayList=[];
	
	arrayList.push(entity);
	saveListAction.set("parameter", arrayList).execute(function(){
		ifShow.reload();
		 ifShow.set("path","em/map/yjwz.jsp");
	 });
};
//@Bind #dtgGrid.#description.onRenderCell
!function(arg) {
	var entity = arg.data;
	arg.dom.innerText = entity.get("description") +  entity.get("quantity") + entity.get("unit");
};


/** @Bind #btnLikeSearch.onClick  */
!function(txtDescription,txtContraces,dsmaintain){
	var description= txtDescription.get("text");
	var contraces= txtContraces.get("text");
	if (!description) {
		description='%';
	}
	if (!contraces) {
		contraces='%';
	}
	var parameter={
			description:description,
			contraces:contraces
	};
	dsmaintain.set('parameter',parameter);
	dsmaintain.flushAsync();
};



	




/** @Bind #txtSearch.onKeyDown  */
!function(txtSearch,dsTree,arg){
	if(arg.keyCode==13){
		var parameter= txtSearch.get("text");
		dsTree.set('parameter',parameter);
		dsTree.flushAsync();
	}
};


/** @Bind #btnSearch.onClick  */
!function(txtSearch,dsTree){
	var parameter= txtSearch.get("text");
	dsTree.set('parameter',parameter);
	dsTree.flushAsync();
};
/** @Bind #tcShow.onTabChange  */
!function(dsTree,dsmaintain){
	dsTree.flushAsync();
	dsmaintain.flushAsync();
};





/** @Bind #dataSetDropDown1.onValueSelect */
!function(dsList,hcShow,txtContraces,dgShow){
	var entity = dsList.getData().current;
	var contraces=entity.get("contraces");
	var phone=entity.get("phone");
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	row.set({
		contraces:contraces,
		phone:phone
	});
	
};