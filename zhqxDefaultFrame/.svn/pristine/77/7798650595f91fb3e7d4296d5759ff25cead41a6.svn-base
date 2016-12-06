package cn.com.oking.dataInterface.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;

import cn.com.oking.util.StringUtil;

public class Detector {   
	private String message="";

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public  void keepTomcatAlive(String urlsTr) throws NullPointerException {   
		try {
			 message = getFromHttp.getResult(urlsTr);
			 message = getFromHttp.HtmlToTextGb2312(message);
			 message=  message.replaceAll("\r|\n", "");
			 if (!StringUtil.isNotEmpty(message.trim())) {
				message="The connection fails";
			}else{
				message="success";
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
    } 
	public void pingIp(String ip){
		Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行进对象
		  Process process = null; // 声明处理类对象
		  String line = null; // 返回行信息
		  InputStream is = null; // 输入流
		  InputStreamReader isr = null; // 字节流
		  BufferedReader br = null;
		  //String ip = "www.baidu.com";
		  boolean res = false;// 结果
		  try {
		   process = runtime.exec("ping " + ip); // PING

		   is = process.getInputStream(); // 实例化输入流
		   isr = new InputStreamReader(is);// 把输入流转换成字节流
		   br = new BufferedReader(isr);// 从字节中读取文本
		   while ((line = br.readLine()) != null) {
		    if (line.contains("TTL")) {
		     res = true;
		     break;
		    }
		    if (line.contains("请求超时")) {
		    	res = false;
			    break;
			}
		   }
		   is.close();
		   isr.close();
		   br.close();
		   if (res) {
		    //System.out.println("ping 通  ...");
		    message="success";
		   } else {
		   // System.out.println("ping 不通...");
		    message="请求超时";
		   }
		  } catch (IOException e) {
		   //System.out.println(e);
		   message=e.getMessage();
		   runtime.exit(1);
		  }
	}
	public static void main(String[] args) {  
		Detector p = new Detector();  
		p.pingIp("218.2.99.66");
		System.out.println(p.message);
	}
	
	
}   