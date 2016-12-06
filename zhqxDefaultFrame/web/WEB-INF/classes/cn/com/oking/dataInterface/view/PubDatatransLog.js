var curpage=1;
var pagesize=1;

//@Bind #dsSelect.onReady
!function(dsSelect){
	dsSelect.insert();
};

//@Bind #btQuery.onClick
!function(teEt,dsPDL,dsPage){
	var transtime = teEt.get("text");
	var param = {
			transtime:transtime,
			curpage:curpage,
	};
	dsPage.set("parameter",param);
	dsPDL.set("parameter",param);
	dsPage.flushAsync();
	dsPDL.flushAsync();
};

//@Bind #btUp.onClick
!function(teEt,dsPDL,dsPage){
	curpage=curpage-1;
	if(curpage<1){
		curpage=1;
	}
	var transtime = teEt.get("text");
	var param = {
			transtime:transtime,
			curpage:curpage
	};
	dsPDL.set("parameter",param);
	dsPDL.flushAsync();
};

//@Bind #btDown.onClick
!function(teEt,dsPDL,dsPage){
	var data=dsPage.getData();
	var allpage=data.get("allpage");
	
	curpage=curpage+1;
	if(curpage>allpage){
		curpage=allpage;
	}
	var transtime = teEt.get("text");
	var param = {
			transtime:transtime,
			curpage:curpage,
	};
	dsPDL.set("parameter",param);
	dsPDL.flushAsync();
};

//@Bind #tePage.onTextEdit
!function(tePage,teEt,dsPDL,dsPage){	
	var data=dsPage.getData();
	var allpage=data.get("allpage");
	
	curpage=tePage.get("text");
	if(curpage==""){
		curpage=1;
	}
	if(curpage>allpage){
		curpage=allpage;
	}
	
	var transtime = teEt.get("text");
	var param = {
			transtime:transtime,
			curpage:curpage,
	};
	
	dsPDL.set("parameter",param);
	dsPDL.flushAsync();
};

//@Bind #dsPDL.onLoadData
!function(dsPage,lPage){
	var data=dsPage.getData();

	var count=data.get("allcount");
	var page=data.get("allpage");
	var size=data.get("pagesize");
	
	lPage.set("text","共有"+count+"条数据	第"+curpage+"页\\共"+page+"页");
	
};
