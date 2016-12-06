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
		Runtime runtime = Runtime.getRuntime(); // ��ȡ��ǰ��������н�����
		  Process process = null; // �������������
		  String line = null; // ��������Ϣ
		  InputStream is = null; // ������
		  InputStreamReader isr = null; // �ֽ���
		  BufferedReader br = null;
		  //String ip = "www.baidu.com";
		  boolean res = false;// ���
		  try {
		   process = runtime.exec("ping " + ip); // PING

		   is = process.getInputStream(); // ʵ����������
		   isr = new InputStreamReader(is);// ��������ת�����ֽ���
		   br = new BufferedReader(isr);// ���ֽ��ж�ȡ�ı�
		   while ((line = br.readLine()) != null) {
		    if (line.contains("TTL")) {
		     res = true;
		     break;
		    }
		    if (line.contains("����ʱ")) {
		    	res = false;
			    break;
			}
		   }
		   is.close();
		   isr.close();
		   br.close();
		   if (res) {
		    //System.out.println("ping ͨ  ...");
		    message="success";
		   } else {
		   // System.out.println("ping ��ͨ...");
		    message="����ʱ";
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