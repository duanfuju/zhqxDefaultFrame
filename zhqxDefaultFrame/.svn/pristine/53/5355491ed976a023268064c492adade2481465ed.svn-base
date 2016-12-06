package cn.com.oking.task;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import sun.net.TelnetInputStream;



public class FtpReader {
	
	private  static String localFileDr = "f:\\fromWordToPdf\\word";
	
	public static void read(String path){ 
		String[] strs=path.split("\\");
		String[] type_en={"U:\\nanjing","U:\\taizhou","U:\\yangzhou","U:\\zhenjiang"};
		for (int i = 0; i < type_en.length; i++) {
			if (strs[0].equals("南京")) {
				localFileDr=type_en[i];
				break;
			}else if (strs[0].equals("泰州")) {
				localFileDr=type_en[i];
				break;
			}else if (strs[0].equals("扬州")) {
				localFileDr=type_en[i];
				break;
			}else if (strs[0].equals("镇江")) {
				localFileDr=type_en[i];
				break;
			}
		}
		/*
        // ftp登录用户名  
        String userName = "nanjing";  
        // ftp登录密码  
        String userPassword = "132";  
        // ftp地址:直接IP地址  
        String server = "10.124.102.13";
        */
        int port = 21;
        //测试
        String userName = "duanfuju";  
        String userPassword = "duanfuju";  
        //String server = "10.124.132.231";
        String server = "192.168.0.7";
        
        
          
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;  
            //1.连接服务器  
            ftp.connect(server,port);  
            //2.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器  
            ftp.login(userName, userPassword);  
            //3.判断登陆是否成功  
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
            }   
            //4.指定要下载的目录  
            //boolean isNj = ftp.changeWorkingDirectory(new String("南京\\周报".getBytes(),"ISO-8859-1"));// 转移到FTP服务器目录
            boolean isNj = ftp.changeWorkingDirectory("nj");// 转移到FTP服务器目录
            if(!isNj){
            	System.out.println("目录不存在,请检查！");
            	return;
            } 
            //5.设置下载目录文件夹
           File localDr = new File(localFileDr);
 
           String[] localFileNames = localDr.list();
           List<String> localFileNamesList = new ArrayList<String>();
           if (localFileNames.length!=0) {
        	   for(String aa : localFileNames){
            	   localFileNamesList.add(aa);
               }
           }
          
            
            //5.遍历下载的目录 ,获取目标文件目录集合
            FTPFile[] fs = ftp.listFiles();
            List<String> targetFiles = new ArrayList<String>();
            for (FTPFile ff : fs) {  
                //解决中文乱码问题，两次解码  
                byte[] bytes=ff.getName().getBytes("iso-8859-1");  
                String fn=new String(bytes,"utf8");  
                if(!ff.isDirectory() && fn.endsWith(".doc")){
                	int isContain = localFileNamesList.indexOf(fn);
                	System.out.println(isContain);
                	if(isContain==-1){
                		String localFilePath = localFileDr +File.separator +fn;
                		File localFile = new File(localFilePath);
                		OutputStream is = new FileOutputStream(localFile);
                		ftp.retrieveFile(fn,is);
                		is.close();
                		targetFiles.add(localFilePath);                		
                	}
                } 
            } 
            ftp.logout(); 
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                	ioe.printStackTrace();
                }  
            }  
        }  
	}
 
	
	
	 
	public static void main(String[] args) {
		read("南京/周报");
	}
}
