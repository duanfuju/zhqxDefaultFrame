/** @Bind #cardBookNav.onClick */
!function(self,arg){	
	var currentC=self.get("currentControl");
    var section=currentC.get("currentSection");
    //获取点击的按钮的父id
    var parentId=section._control._currentNode._userData._data.id;
    window.tempValue = parentId;
};

/** @Bind #hcShow.onReady */
!function(dsMonitor,hcShow,dsSysList){
	var ds1=dsMonitor.getData();
	var ds2=dsSysList.getData();
	var str1="";
	var str2="";
	if (ds1!=0) {
		str1="<a style='text-decoration:none;color:#F00' href='cn.com.oking.dataInterface.view.qxglIndex.d'>数据异常信息("+ds1+")</a><br/>";
	}
	if (ds2!=0) {
		str2="<a style='text-decoration:none;color:#F00' href='cn.com.oking.dataInterface.view.qxglIndex.d'>系统运行异常信息("+ds2+")</a><br/>";
	}
	hcShow.set("content","<body><center style='padding-top:30px'>"
            +str1+str2
        	+" </center></body>");
};



/** @Bind #sibClose.onClick */
!function(fpShow){	
	fpShow.close();
};