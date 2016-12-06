var bodyWidth;
var bodyHeight;

var urls = ["zhjc","ybyc","pgyj","ggfw","fxgl","jczc"];

$(document).ready(function(){
	//$("#flashContent").hide();
	initSize();
	//$("#info").hide();
	openInfo(0);
	
	initKeyword();
	
});

function initKeyword(){
	$(document).keyup(function(e){
        var key =  e.which;
        if(key >48&&key<55){
			var index = key - 49;
            window.location.href = urls[index]+".html";
        }
    });
}

function initSize(){
	$("iframe:not('.block')").hide();
	
	bodyWidth = $("body").width();
	bodyHeight = $("body").height();

	$("#flashContent").width(bodyWidth);
	$("#info").width(bodyWidth);
	$("#flashContent").height(bodyHeight);
	$("#info").height(bodyHeight);
}

function openInfo(index){
	var html = $("#info"+index).html();
	$("#infoContent").html(html);
	
	initHomeBtn();
	initWindows();
	$("#flashContent").css("top",bodyHeight+"px");
	//$("#info div").hide();
	/*addAnim("bounceIn",$("#info"),function(){
									initFreewall();
								});*/
	
	initFreewall();
}

function closeInfo(){
	addAnim("bounceOut",$("#info"),function(){
									$("#info").hide();
									$("#flashContent").css("top","0px");
								});
}

var picIndex = 0;
var picLength;
function initFreewall(){
	setTimeout(freewallEffect,0);
}

function freewallEffect(){
	//alert("1");
	$("#infoContent div iframe").each(function(i){
										$(this).show();
										var src = $(this).attr("src");
										$(this).attr("src",src);
										
										$(this).on("load",function(){
											//加载完成，需要执行的代码
											var bodyObj = $(this).contents().find("body");
											if(bodyObj[0]){
												//alert("pics::"+ bodyObj.html());
												bodyObj.css("margin","0px");
												bodyObj.css("padding","0px");
												var imgObj = bodyObj.find("img");
												var imgLen = imgObj.length;
												if(imgObj[0]){
													var w = imgObj.width();
													var h = imgObj.height();
													var toH = $(this).height();
													var toW = toH/h * w;
													var toL = ($(this).width()-toW)/2;
													imgObj.width(toW).height(toH).css("marginLeft",toL+"px");
												}
												var tableObj = bodyObj.find("table");
												if(tableObj[0]){
													tableObj.css("marginLeft","0px");
												}
											}else{
												//alert("no");
											}
										});
									});
}

function isPic(src){
	var srcTemp = src.replace(".jpg","");
	srcTemp = srcTemp.replace(".gif","");
	srcTemp = srcTemp.replace(".png","");
	if(src==srcTemp){
		return false;
	}else{
		return true;
	}
}

var oneEnd = "webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend";
function addAnim(x,obj,fun) {
	if(!obj[0])return;
	obj.show();
    obj.addClass(x + ' animated').one(oneEnd, function(){
      $(this).removeClass(x + ' animated');
	  if(fun){
			fun();
		}
    });
};

function initHomeBtn(){
	$("#info div").mouseover(function(){
										if(!$("#homeBtn").is(':animated')){
											//alert($(this).eq(picIndex).attr("class"));
											var hSize = $("#homeBtn").width();
											var nowTop = parseInt($("#homeBtn").css("top"));
											var nowLeft = parseInt($("#homeBtn").css("left"));
											//var toTop = parseInt($(this).css("top"))-(hSize/2);
											var toTop = (bodyHeight*2/3)-(hSize/2);
											var toLeft = parseInt($(this).css("left"))-(hSize/2);
											if(toTop>0){
												$("#homeBtn").animate({"top":toTop},500);
											}
											if(toLeft>0&&(Math.abs(toLeft-nowLeft)>(bodyWidth/6))){
												$("#homeBtn").animate({"left":toLeft},500);
											}
										}
									});
	$("#homeBtn").click(function(){
					closeInfo();
				});
}

function initWindows(){
	var firstSrc = $("#infoContent div:first p").attr("to");
	bigIframe.location.href = firstSrc;
	showBig();
	
	$("#infoContent .s span").click(function(){
								var src = $(this).attr("to");
								bigIframe.location.href = src;
								showBig();
							});
	
	$("#infoContent .ss span").click(function(){
								var src = $(this).attr("to");
								bigIframe.location.href = src;
								showBig();
							});
	
	$("#infoContent p").click(function(){
					var src = $(this).attr("to");
					if(src==0){
						openInfo(src);
					}else if(src==1){
						openInfo(src);
					}else{
						bigIframe.location.href = src;
						showBig();
					}
				});
	$("#moreIcon p").click(function(){
		var src = $(this).attr("to");
		if(src==0){
			openInfo(src);
		}else if(src==1){
			openInfo(src);
		}else{
			bigIframe.location.href = src;
			showBig();
		}
	});
}

function showBig(){
		 $("#bigIframe").on("load",function(){
			$(this).show();
			//加载完成，需要执行的代码
			var bodyObj = $(this).contents().find("body");
											if(bodyObj[0]){
												bodyObj.css("margin","0px");
												bodyObj.css("padding","0px");
												var imgObj = bodyObj.find("img");
												if(imgObj[0]){
													var w = imgObj.width();
													var h = imgObj.height();
													var toH = $(this).height();
													var toW = toH/h * w;
													var toL = ($(this).width()-toW)/2;
													imgObj.width(toW).height(toH).css("marginLeft",toL+"px");
												}
											}else{
												//alert("no");
											}
			//alert(bodyObj.html());
		});
}


