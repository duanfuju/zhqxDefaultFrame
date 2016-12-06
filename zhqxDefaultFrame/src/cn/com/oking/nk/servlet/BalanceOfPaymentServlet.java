package cn.com.oking.nk.servlet;

import java.io.*;  
import java.net.URLEncoder;

import javax.servlet.*;  
  
import javax.servlet.http.*;  

import org.apache.commons.lang.StringUtils;

import cn.com.oking.dao.SysFileInformationDao;
import cn.com.oking.entity.SysFileInformation;
import cn.com.oking.nk.action.NkRecordAction;
import cn.com.oking.nk.dao.NkRecordDao;
import cn.com.oking.nk.entity.NkRecord;
import cn.com.oking.service.FileInformationAction;

import com.bstek.bdf2.core.context.ContextHolder;


/**
 * Servlet implementation class ExcelServlet
 */
public class BalanceOfPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BalanceOfPaymentServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		//设置response对象的ContentType  
		response.setContentType("text/html;charset=UTF-8");  
		
		
		//获取点击的数据编号
		String id=request.getParameter("id");  
		//根据数据编号到中间表中寻找下载的关联fielid
		SysFileInformation sysfileinformation=null;
		try {
			FileInformationAction sAction=ContextHolder.getBean("fileInformationAction");
			sysfileinformation = sAction.getInformationByAss(id);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
		
		//从request中取出要下载文件的名字  
		 String filename=sysfileinformation.getRealName();
		 if(filename==null||filename.trim().equals("")){  
			 //输出错误信息  
			 PrintWriter out=response.getWriter();  
			 out.println("<font color=red>输入的文件名无效！</font>");  
			 out.close();  
		 }else{  
		 //下载文件的完整路径名  
		 String fullfilename=sysfileinformation.getSavaPath()+"\\"+filename;  
		 System.out.println("下载文件："+fullfilename);  
		 //根据文件的类型设置response对象的ContentType  
		 String contentType=getServletContext().getMimeType(fullfilename);  
		 if(contentType==null)  
			 contentType="application/octet-stream";  
			 response.setContentType(contentType);  
			 //设置response的头信息  并且对中文名称进行转码（解决中文名乱码）
			 response.setHeader("Content-disposition","attachment;filename=\""+ new String(sysfileinformation.getFileName().getBytes("utf-8"),"ISO-8859-1")+"\"");  
			 InputStream is=null;  
			 OutputStream os=null;  
			 try{  
				 is=new BufferedInputStream(new FileInputStream(fullfilename));  
				 //定义输出字节流  
				 ByteArrayOutputStream baos=new ByteArrayOutputStream();  
				 //定义response的输出流  
				 os=new BufferedOutputStream(response.getOutputStream());  
				 //定义buffer  
				 byte[] buffer=new byte[4*1024]; //4k Buffer  
				 int read=0;  
				 //从文件中读入数据并写到输出字节流中  
				 while((read=is.read(buffer))!=-1){  
					 baos.write(buffer,0,read);  
				 }  
				 //将输出字节流写到response的输出流中  
				 os.write(baos.toByteArray());  
			 }catch(IOException e){  
				 e.printStackTrace();  
			 }finally{  
				 //关闭输出字节流和response输出流  
				 os.close();  
				 is.close();  
			 }  
		 } 
	}
}
