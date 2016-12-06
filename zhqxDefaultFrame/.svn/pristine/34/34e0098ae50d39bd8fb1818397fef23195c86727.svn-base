<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@page import="cn.com.oking.dbMonitoring.getListOfDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据库监控</title>
<style type="text/css" >
    *{
        padding: 0px;
        margin: 0px;
        font-size: 1em;
    }
    body{
        background-color: #eeeeee;
    }
    .container{
        margin:1% auto;
        width:90%;
        height:100%;
    }
    .left{
        width: 30%;
        height: 500px;
        float:left;
    }
    .right{
        width: 69%;
        height: 500px;
        float:left;
    }
    ul{
        list-style: none;
        height: 80%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .shadow{
        -webkit-box-shadow:5px 2px 6px #000;-moz-box-shadow:5px 2px 6px #000;padding:4px 10px;
    }
    .textshadow{
        text-shadow:5px 2px 6px #666666;
        font-weight: bold;
    }
    .title{
        background: -ms-linear-gradient(top,#b8c4cb,#f6f6f8);        /* IE 10 */
        background:-moz-linear-gradient(top,#b8c4cb,#f6f6f8);/*火狐*/
        background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#b8c4cb), to(#f6f6f8));/*谷歌*/
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#b8c4cb), to(#f6f6f8));      /* Safari 4-5, Chrome 1-9*/
        background: -webkit-linear-gradient(top,#b8c4cb,#f6f6f8);   /*Safari5.1 Chrome 10+*/
        background: -o-linear-gradient(top, #b8c4cb,#f6f6f8);  /*Opera 11.10+*/
    }
    .left_top_li{
        height: 20%;
        width: 100%;
    }
    .name{
        width: 30%;
        float: left;
        margin-left: 10%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .value{
        float: left;
        width: 50%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .left_bottom_li{
        height: 25%;
        width: 100%;
    }
    .right_top_li{
        width: 45%;
        height: 70px;
        line-height: 70px;
        float: left;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .top{
        height: 50px;
        width: 90%;
        line-height: 50px;
        margin-left: 5%;
    }
</style>
<%  
		String user=new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
		getListOfDB d=(getListOfDB) ContextHolder.getApplicationContext().getBean(getListOfDB.class);
		List<Map<String, Object>> list = d.findByUser(user);
		String host="";
		String cpu_num="";
		if(list.get(4).get("value").equals(0)){
			host="获取信息失败";
			cpu_num="获取信息失败";
		}else{
			//主机利用率AVG_BUSY_TIME/(AVG_IDLE_TIME+AVG_BUSY_TIME)		
			double AVG_BUSY_TIME=Double.valueOf(list.get(4).get("value").toString());
			double AVG_IDLE_TIME=Double.valueOf(list.get(5).get("value").toString());
			double h=((double)((int)(AVG_BUSY_TIME/(AVG_IDLE_TIME+AVG_BUSY_TIME)*10000)))/100;
			host=h+"%";
			cpu_num=list.get(6).get("value").toString();
		}
			//数据缓冲区命中率
			double db=Double.valueOf(list.get(13).get("Buffer_Cache_Hit_Ratio").toString());
	 		double b=((double)((int)(db*10000))/100);
	 		String dataBuffer=b+"%";
		
%>
<script type="text/javascript" src="../js/jquery-1.8.0.js" ></script>
<script>
	window.onload=function(){
		//sessionStorage当浏览器关闭才会消失
		if(sessionStorage.select){//提取本地缓存
			$(".selector").val(sessionStorage.select);
		 }
	};
    function getSelectIndex(val){
        location.href="index.jsp?user="+val;
        //设置本地存储  select
        sessionStorage.select=val;
    }
</script>
</head>
<body>
<div class="top">
    <label class="textshadow">选择当前数据库</label>
    <select class="selector" onchange="getSelectIndex(this[selectedIndex].value);">
        <option value="zhqx">zhqx</option>
        <option value="pub_svc">pub_svc</option>
        <option value="sqpt">sqpt</option>
    </select>
</div>
<div class="container">
    <div class="left">
        <div style="width: 100%;height: 50%;margin:5px 0px;border: 1px solid #8A99B4;">
            <div style="height: 20px;width: 100%;line-height: 20px;text-align: center;border: 1px solid #8A99B4;" class="textshadow title">常规信息</div>
            <ul>
                <li class="left_top_li" style="margin-top: 7%"><div class="name">Oracle DB版本</div><div class="value">：<%=list.get(0).get("version")%></div></li>
                <li class="left_top_li"><div class="name">Oracle实例名称</div><div class="value">：<%=list.get(2).get("Instance_name")%></div></li>
                <li class="left_top_li"><div class="name">创建时间</div><div class="value">：<%=list.get(2).get("db_created_time")%></div></li>
                <li class="left_top_li"><div class="name">运行时间</div><div class="value">：<%=list.get(3).get("started_at")%></div></li>
            </ul>
        </div>
        <div style="width: 100%;height: 35%;margin:10px auto;border: 1px solid #8A99B4;">
            <div style="height: 20px;width: 100%;line-height: 20px;text-align: center;border: 1px solid #8A99B4;" class="textshadow title">系统信息</div>
            <ul>
                <li class="left_bottom_li" style="margin-top: 5%"><div class="name">操作系统</div><div class="value">：<%=list.get(1).get("product")%></div></li>
                <li class="left_bottom_li"><div class="name">主机利用率</div><div class="value">：<%=host %></div></li>
                <li class="left_bottom_li"><div class="name">CPU数量</div><div class="value">：<%=cpu_num%></div></li>
            </ul>
        </div>
    </div>
    <div class="right">
        <div style="width: 90%;height: 20%;border:1px solid #8A99B4;margin: 5px auto">
            <div style="height: 20px;width: 100%;line-height: 20px;text-align: center;border: 1px solid #8A99B4;" class="textshadow title">数据库</div>
            <ul>
                <li class="right_top_li" style="padding-left: 5%">数据库允许的最大连接数：<%=list.get(7).get("db_allow_max_connect_num")%></li>
                <li class="right_top_li">当前数据库连接数：<%=list.get(8).get("db_connect_num")%></li>
            </ul>
        </div>
        <div style="width: 90%;height: 20%;border:1px solid #8A99B4;margin: 5px auto">
            <div style="height: 20px;width: 100%;line-height: 20px;text-align: center;border: 1px solid #8A99B4;" class="textshadow title">表空间</div>
            <ul style="float: left;width: 45%;padding-left: 5%;">
                <li>总大小：<%=list.get(22).get("sum_mb")%>MB</li>
                <li>已使用：<%=list.get(22).get("used_mb")%>MB</li>
                <li>未使用：<%=list.get(22).get("free_mb")%>MB</li>
            </ul>
            <ul style="float: left;width: 45%;">
                <li style="height:100px;line-height: 80px;">使用率：<%=list.get(22).get("percent_used")%>%</li>
            </ul>
        </div>
        <div style="width: 90%;height: 20%;border:1px solid #8A99B4;margin: 5px auto">
            <div style="height: 20px;width: 100%;line-height: 20px;text-align: center;border: 1px solid #8A99B4;" class="textshadow title">会话</div>
            <ul>
                <li style="float: left;width: 45%;height: 70px;line-height: 70px;padding-left: 5%;">当前连接的会话数：<%=list.get(9).get("current_connect_session")%></li>
                <li style="float: left;width: 45%;height: 70px;line-height: 70px;">当前打开的游标数：<%=list.get(10).get("current_open_cursor")%></li>
            </ul>
        </div>
        <div style="width: 90%;height: 30%;border:1px solid #8A99B4;margin: 5px auto">
            <div style="height: 20px;width: 100%;line-height: 20px;text-align: center;border: 1px solid #8A99B4;" class="textshadow title">SGA</div>
            <ul style="float: left;width: 30%;padding-left: 5%;height: 100px;line-height: 50px;">
                <li>高速缓冲区：<%=list.get(11).get("active_num")%></li>
                <li>数据缓冲区命中率：<%=dataBuffer%></li>
            </ul>
            <ul style="float: left;width: 30%;height: 120px;line-height: 30px;">
                <li>日志缓冲区：<%=list.get(14).get("log_buffer")%></li>
                <li>大型池：<%=list.get(15).get("large_pool_size")%></li>
                <li>共享池：<%=list.get(16).get("shared_pool_size")%></li>
                <li>java池：<%=list.get(17).get("java_pool_size")%></li>
            </ul>
            <ul style="float: left;width: 30%;height: 120px;line-height: 30px;">
                <li>固定大小：<%=list.get(18).get("value")%></li>
                <li>变量大小：<%=list.get(19).get("value")%></li>
                <li>数据库缓冲区：<%=list.get(20).get("value")%></li>
                <li>重做缓冲区：<%=list.get(21).get("value")%></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>