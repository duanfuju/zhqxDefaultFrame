/** @Bind #sibClose.onClick */
!function(fpShows){	
	fpShows.close();
};
function pushauto(){
	var pushAuto=view.get("#pushAuto");
	var data=pushAuto.getData();
	if (data.get("key")=="have") {
		//���Ϳ���ʾ����
		var fpShows=view.get("#fpShows");
		fpShows.show({
			anchorTarget: 'body',
			align: 'innerright',
			vAlign: 'innerbottom',
			offsetLeft: -10,
			direction: 'b2t'
		});
	}
}


/** @Bind #openMenuFrame.onReady */
!function(dsCheckUser,openMenuFrame){	
	var name=dsCheckUser.getData();
	if (name=='����̨') {
		openMenuFrame.set("path",'portal/portalA/portal.html');
	}else if (name=='ҵ����Ա') {
		openMenuFrame.set("path",'portal/portalA/portal.html');
	}else if (name=='ϵͳ����Ա') {
		openMenuFrame.set("path",'portal/portalB/portal.html');
	}else if (name=='��ͨ����û�') {
		openMenuFrame.set("path",'portal/portalC/portal.html');
	}else{
		openMenuFrame.set("path",'portal/portalA/portal.html');
	}
};



//window.setTimeout(pushauto,10000);
//window.setInterval(pushauto,60000);
