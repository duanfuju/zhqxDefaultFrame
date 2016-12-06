
var curpage=1;
var pagesize=1;

//@Bind #dsSelect.onReady
!function(dsSelect){
	dsSelect.insert();
};

//@Bind #btQuery.onClick
!function(teEt,dsSelect,dsPage,dsTOAA){
	var bjTime = teEt.get("text");
	var data=dsSelect.getData();
	var obtid = data.get("obtid");
	if (!obtid) {
		obtid = '%';
	}
	var param = {
			obtid:obtid,
			bjTime:bjTime,
			curpage:curpage
	};
	dsPage.set("parameter",param);
	dsTOAA.set("parameter",param);
	dsPage.flushAsync();
	dsTOAA.flushAsync();
};

//@Bind #btUp.onClick
!function(teEt,dsTOAA,dsPage,dsSelect){
	var data=dsSelect.getData();
	var obtid=data.get("obtid");
	if (!obtid) {
		obtid = '%';
	}
	
	curpage=curpage-1;
	if(curpage<1){
		curpage=1;
	}
	var bjTime = teEt.get("text");
	var param = {
			obtid:obtid,
			bjTime:bjTime,
			curpage:curpage
	};
	dsTOAA.set("parameter",param);
	dsTOAA.flushAsync();
};

//@Bind #btDown.onClick
!function(teEt,dsTOAA,dsPage,dsSelect){
	var data=dsPage.getData();
	var allpage=data.get("allpage");
	
	var data0=dsSelect.getData();
	var obtid=data0.get("obtid");
	if (!obtid) {
		obtid = '%';
	}
	
	curpage=curpage+1;
	if(curpage>allpage){
		curpage=allpage;
	}
	var bjTime = teEt.get("text");
	var param = {
			obtid:obtid,
			bjTime:bjTime,
			curpage:curpage
	};
	dsTOAA.set("parameter",param);
	dsTOAA.flushAsync();
};

//@Bind #tePage.onTextEdit
!function(tePage,teEt,dsTOAA,dsPage,dsSelect){	
	var data=dsPage.getData();
	var allpage=data.get("allpage");
	
	var data0=dsSelect.getData();
	var obtid=data0.get("obtid");
	if (!obtid) {
		obtid = '%';
	}
	
	curpage=tePage.get("text");
	if(curpage==""){
		curpage=1;
	}
	if(curpage>allpage){
		curpage=allpage;
	}
	var bjTime = teEt.get("text");
	var param = {
			obtid:obtid,
			bjTime:bjTime,
			curpage:curpage
	};
	dsTOAA.set("parameter",param);
	dsTOAA.flushAsync();
};

//@Bind #dsTOAA.onLoadData
!function(dsPage,lPage){
	var data=dsPage.getData();

	var count=data.get("allcount");
	var page=data.get("allpage");
	var size=data.get("pagesize");
	
	lPage.set("text","共有"+count+"条数据	第"+curpage+"页\\共"+page+"页");
	
};
