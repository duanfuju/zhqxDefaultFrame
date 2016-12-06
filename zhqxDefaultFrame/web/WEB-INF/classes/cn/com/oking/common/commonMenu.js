/** @Bind #cBtns.onReady  */
!function(ajax,cBtns,ifShow){
	var parentid=window.parent.tempValue;
	cBtns.removeAllChildren();
	var listArray = [];
    ajax.set("parameter",parentid).execute(function(data){
	    if (data.length>1) {
	    	//迭代生成按钮
	    	var count=0;
	    	data.each(function(url){
	    		var button=new dorado.widget.toolbar.Button();
	    		button.set("caption",url.name);
	    		if(url.desc){
	    			button.set("tip",url.desc);
	    		}
	    		if(url.icon){
	    			button.set("icon",url.icon);
	    		}
	    		button.set("userData",url);
	    		button.set("toggleable",true);
	    		button.set("toggled",false);
	    		button.set("onClick",function(){
	    			listArray.each(function(b){
	    				b.set("toggled",false);			
	    			});
	    			button.set("toggled",true);
					ifShow.set("path",url.url);
					ifShow.reload();
					
	    		});
	    		cBtns.addChild(button);
	    		listArray.push(button);
	    		count++;
	    	});
	    listArray[0].set("toggled",true);
		ifShow.set("path",data[0].url);
		}else{
			ifShow.set("path",data[0].url);
		}
    });
};