/** @Bind #sibClose.onClick */
!function(fpShows){	
	fpShows.close();
};
function pushauto(){
	var pushAuto=view.get("#pushAuto");
	var data=pushAuto.getData();
	if (data.get("key")=="have") {
		//推送框显示功能
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
	if (name=='气象台') {
		openMenuFrame.set("path",'portal/portalA/portal.html');
	}else if (name=='业务人员') {
		openMenuFrame.set("path",'portal/portalA/portal.html');
	}else if (name=='系统管理员') {
		openMenuFrame.set("path",'portal/portalB/portal.html');
	}else if (name=='普通浏览用户') {
		openMenuFrame.set("path",'portal/portalC/portal.html');
	}else{
		openMenuFrame.set("path",'portal/portalA/portal.html');
	}
};



//window.setTimeout(pushauto,10000);
//window.setInterval(pushauto,60000);
