
//构建自定义信息窗体   
function createInfoWindow(title,content){  
    var info = document.createElement("div");  
    info.className = "info";  
    // 定义顶部标题  
    var top = document.createElement("div");  
    top.className = "info-top";  
      var titleD = document.createElement("div");  
      titleD.innerHTML = title;  
      var closeX = document.createElement("img");  
      closeX.src = "../../images/close2.gif";  
      closeX.onclick = closeInfoWindow;  
        
    top.appendChild(titleD);  
    top.appendChild(closeX);  
    info.appendChild(top);  
    // 定义中部内容  
    var middle = document.createElement("div");  
    middle.className = "info-middle";  
    middle.innerHTML = content;  
    info.appendChild(middle);  
      
    // 定义底部内容  
    var bottom = document.createElement("div");  
    bottom.className = "info-bottom";  
    var sharp = document.createElement("img");  
    sharp.src = "../../images/sharp.png";  
    bottom.appendChild(sharp);    
    info.appendChild(bottom);  
    return info;  
} 