//�����ϴ��ķ�����һ��������ֻ�ܵ���һ�Σ�������һ��ȫ�ֱ������ж�
var isType="0";



/*********************�����ļ�ҳǩ start****************************/




//@Bind #dsZcwj.onReady 
!function(dsZcwj){
	dsZcwj.set('parameter',{type:"xmkz"});
	dsZcwj.flushAsync();
};

//@Bind #tbbZcwj.onClick 
!function(dsZcwj){
	dsZcwj.insert({
		'zcwjType':'xmkz'
	});
};

//@Bind #btnFileWithZcwj.onClick 
!function(fileDialog,fileIFrame,dgZcwj){
	isType="-1";
	doUp(fileDialog,fileIFrame,dgZcwj);
};





/**********************�����ļ�ҳǩ end***************************/






/***********************ctFirst start**************/

var _id="";

/** @Bind #btnAdd.onClick   */
!function(dsRecord,dgRecord){
	dgRecord.set("readOnly",false);
	dsRecord.insert();
};

/** @Bind #tbbSave.onClick   */
!function(updateAction2,dgRecord){
	dgRecord.set("readOnly",true);
	updateAction2.execute();
};



//@Bind #dgRecord.onDataRowDoubleClick 
!function(dgRecord,tcShow,ctSecond,dsGckz){
	var dataset =dgRecord.get("dataSet");
	var row = dataset.getData("#");
	_id= row.get("nkId");
	var param={
			id:_id
	};
	dsGckz.set("parameter",param);
	dsGckz.flushAsync();
	tcShow.set('currentTab',ctSecond);
};


/***********************ctFirst end**************/




/** @Bind #tbbAdd1.onClick   */
!function(dsGckz){
	dsGckz.insert({
		"nkNum":_id
	});
};


/** @Bind #tbbSave1.onClick   */
!function(updateAction0){
	updateAction0.execute();
};



/** @Bind #btnFile.onClick   */
!function(fileDialog,fileIFrame,dgGckz){//����ǵڶ���ҳǩ�ĵ��
	isType="1";
	doUp(fileDialog,fileIFrame,dgGckz);
};



/**------�ϴ� start---------*/

function doUp(fileDialog,fileIFrame,datagrid){
	var dataset =datagrid.get("dataSet");
	var data = dataset.getData("#");
	var fileid = "";
	if(data != null){
		try{
			fileid = data.get("id");
		}catch(e){
			alert("���ȱ�������ӵ����ݣ�Ȼ���ٴν����ϴ�...");
			return;
		}
	}
	var _type = "fileShowPath";   //����config.xml
	var _pathType = "xls";   //����FileUtils�ļ�
	var _exec = "*";     //�����ϴ���ʽ
	var _size= "10MB";    //�����ϴ��ļ���С
	fileIFrame.set("path","cn.com.oking.upload.upload.d?fileid="+fileid+
			"&type="+ _type+   //showPath����
			"&pathType="+_pathType+        //�����ļ���
			"&exec="+_exec+        //�ϴ��ļ���ʽ
			"&size="+_size);       //�ļ���С
	fileDialog.show();
	fileIFrame.reload();
}



window.setUploadParam = function(fileid,filename){
	if(fileid != null && fileid != "" && fileid != undefined && 
			filename != null && filename != "" && filename != undefined){
		dorado.MessageBox.alert("�ļ��ϴ��ɹ���  \n \t�ļ���:"+filename+"\n\t����ID:"+fileid);
		var datagrid=null;
		var action=null;
		 if (isType=="1") {
			datagrid = view.get("#dgGckz");
			action=view.get("#updateAction0");
		}else if (isType=="-1") {
			datagrid = view.get("#dgZcwj");
			action=view.get("#updateAction1");
		}
		
		
		
		var dataset =datagrid.get("dataSet");
		var data = dataset.getData("#");
		data.set("fileid",fileid);
		data.set("content",filename);
		view.get("#fileDialog").hide();
		action.execute();
	}
};

/**------�ϴ� end---------*/