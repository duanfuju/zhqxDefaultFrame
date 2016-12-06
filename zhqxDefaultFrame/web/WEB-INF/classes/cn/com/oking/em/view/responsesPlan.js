/** @Bind #dsPlan.onReady */
!function(dsPlan){
	dsPlan.insert();
};

//@Bind #dgShow.onDataRowClick 
!function(dgShow,dsPlan){
	var dataset =dgShow.get("dataSet");
	var row = dataset.getData("#");
	var _id= row.get("id");
	if (_id) {
		dsPlan.set("parameter",_id);
		dsPlan.flushAsync();
	}
};



/** @Bind #autoUpdateAction.onSuccess   */
!function(dsPlanList){
	dsPlanList.flushAsync();
};










/**------�ϴ� start---------*/
/** @Bind #btnFile.onClick   */
!function(fileDialog,fileIFrame,dsPlan){
	var data = dsPlan.getData();
	var fileid = "";
	if(data != null){
		fileid = data.get("fileid");
	}
	var _type = "fileShowPath";   //����config.xml
	var _pathType = "DOC";   //����FileUtils�ļ�
	var _exec = "doc";     //�����ϴ���ʽ
	var _size= "2MB";    //�����ϴ��ļ���С
	fileIFrame.set("path","cn.com.oking.upload.upload.d?fileid="+fileid+
			"&type="+ _type+   //showPath����
			"&pathType="+_pathType+        //�����ļ���
			"&exec="+_exec+        //�ϴ��ļ���ʽ
			"&size="+_size);       //�ļ���С
	fileDialog.show();
	fileIFrame.reload();
};

window.setUploadParam = function(fileid,filename){
	if(fileid != null && fileid != "" && fileid != undefined && 
			filename != null && filename != "" && filename != undefined){
		dorado.MessageBox.alert("�ļ��ϴ��ɹ���  \n \t�ļ���:"+filename+"\n\t����ID:"+fileid);
		var data = view.get("#dsPlan").getData();
		data.set("fileid",fileid);
		data.set("filename",filename);
		view.get("#fileDialog").hide();
		var action=view.get("#autoUpdateAction");
		action.execute();
	}
};

/**------�ϴ� end---------*/
/**------���� start---------*/
/** @Bind #btnFileLoad.onClick   */
!function(){
	//Ϊajax���ò���
	//��ȡdatagird��ǰѡ�е������в���ȡ��filedid��ֵ
	var datagrid = this.get("#dgShow");
	var dataset =datagrid.get("dataSet");
	var row = dataset.getData("#");
	var fileid= row.get("fileid");
	if (fileid) {
		location.href='DownloadServlet?filedid='+fileid;		
	}else{
		alert("û���ļ��������ϴ�������");
	}
};
/**------���� end---------*/