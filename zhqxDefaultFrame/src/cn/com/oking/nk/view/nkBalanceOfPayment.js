//�����ϴ��ķ�����һ��������ֻ�ܵ���һ�Σ�������һ��ȫ�ֱ������ж�
var isType="0";

/** @Bind #dsNp0.onReady  */
!function(dsNp0,dsNp1,dsNp2){
	//Ϊ��һ��ҳǩ���������
	var param0={type:"0"};
	dsNp0.set("parameter",param0);
	dsNp0.flushAsync();
	
	//Ϊ������ҳǩ���������
	var param1={type:"1"};
	dsNp1.set("parameter",param1);
	dsNp1.flushAsync();
	
	//Ϊ���ĸ�ҳǩ���������
	var param2={type:"2"};
	dsNp2.set("parameter",param2);
	dsNp2.flushAsync();
};




/*************************the first tab start**********************************/
/** @Bind #tbbAdd0.onClick  */
!function(dsNp0){
	dsNp0.insert({nkType:"0"});
};
/*************************the first tab end**********************************/
/*************************the second tab start**********************************/
/** @Bind #tbbAdd1.onClick  */
!function(dsNp1){
	dsNp1.insert({nkType:"1"});
};
/*************************the second tab end**********************************/
/*************************the fouth tab start**********************************/
/** @Bind #tbbAdd2.onClick  */
!function(dsNp2){
	dsNp2.insert({nkType:"2"});
};
/*************************the fouth tab end**********************************/



















/**------�ϴ� start---------*/
/** @Bind #btnFile0.onClick   */
!function(fileDialog,fileIFrame,dgNp0){//����ǵ�һ��ҳǩ�ĵ��
	isType="0";
	doUp(fileDialog,fileIFrame,dgNp0);
};

/** @Bind #btnFile1.onClick   */
!function(fileDialog,fileIFrame,dgNp1){//����ǵ�����ҳǩ�ĵ��
	isType="1";
	doUp(fileDialog,fileIFrame,dgNp1);
};

/** @Bind #btnFile2.onClick   */
!function(fileDialog,fileIFrame,dgNp2){//����ǵ��ĸ�ҳǩ�ĵ��
	isType="2";
	doUp(fileDialog,fileIFrame,dgNp2);
};



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
		var datagrid="" ;//��ȡdatagrid����֮�����
		var action="";//��ȡaction����֮�󱣴�
		if (isType=="0") {
			datagrid =  view.get("#dgNp0");
			action = view.get("#Np0Action");
		}else if (isType=="1") {
			datagrid =  view.get("#dgNp1");
			 action = view.get("#Np1Action");
		}else if (isType=="2") {
			datagrid = view.get("#dgNp2");
			 action = view.get("#Np2Action");
		}
		var dataset =datagrid.get("dataSet");
		var data = dataset.getData("#");
		data.set("fileid",fileid);
		data.set("nkName",filename);
		view.get("#fileDialog").hide();
		action.execute();
	}
};

/**------�ϴ� end---------*/

