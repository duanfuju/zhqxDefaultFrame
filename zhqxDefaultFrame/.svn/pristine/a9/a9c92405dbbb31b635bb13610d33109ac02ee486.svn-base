/** @Bind #dsESData.onReady */
!function(dsESData,cBtns,hcShow,lbShow){	
	cBtns.removeAllChildren();
	var listArray = [];
	var data=dsESData.getData();
	var firstpath="";
	var firsttime="";
	if (data) {
    	var count=0;
    	data.each(function(entity){
    		var button=new dorado.widget.toolbar.Button();
    		button.set("caption",entity.get("filename"));
    		button.set("toggleable",true);
    		button.set("toggled",false);
    		button.set("onClick",function(){
    			listArray.each(function(b){
    				b.set("toggled",false);			
    			});
    			button.set("toggled",true);
				hcShow.set("content",
					"<center><img src='"+entity.get("filedir")+"' align='center' width='700px' height='450px' /></center>");
				lbShow.set("text",entity.get("filetime"));
				hcShow.reload();
    		});
    		cBtns.addChild(button);
    		listArray.push(button);
    		if (count==0) {
    			firstpath=entity.get("filedir");
    			firsttime=entity.get("filetime");
			}
    		count++;
    	});
    listArray[0].set("toggled",true);
	hcShow.set("content","<center><img src='"+firstpath+"' align='center' width='700px' height='450px' /></center>");
	lbShow.set("text",firsttime);
	}
};