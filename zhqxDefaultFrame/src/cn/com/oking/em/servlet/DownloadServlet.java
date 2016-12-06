package cn.com.oking.em.servlet;


import java.io.FileInputStream;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.com.oking.entity.SysFileInformation;
import cn.com.oking.service.FileInformationAction;

import com.bstek.bdf2.core.context.ContextHolder;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.reset();
		response.setContentType("application/x-download");
		request.setCharacterEncoding("UTF-8");
		
		OutputStream outputStream=null;
		FileInputStream inStream =null;
		try {
			//��ȡ�ļ�id����
			String filedid = request.getParameter("filedid");
			//��ȡ����
			FileInformationAction action=ContextHolder.getBean("fileInformationAction");
			//�����ļ���id��ѯ�ļ��ְ����ݿ��е���������
			SysFileInformation info = action.getInformationByAss(filedid);
			//׼�����ص��ļ��Ĵ��·��
			String filedownloadpath=null;
			String fileName  = info.getFileName(); 
			//  �ļ���·����Ĭ�ϱ�����(��ʵ����)
			filedownloadpath=info.getSavaPath()+"\\"+info.getRealName();
			fileName = URLEncoder.encode(fileName,"UTF-8");
			response.addHeader("Content-Disposition","attachment;filename="+ fileName );
			inStream = new FileInputStream(filedownloadpath);
			
			outputStream = response.getOutputStream();
			InputStream inputStream = inStream;
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
			 outputStream.write(buffer, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			 outputStream.flush();
		     outputStream.close();
		     inStream.close();
		}
       
	}
}
