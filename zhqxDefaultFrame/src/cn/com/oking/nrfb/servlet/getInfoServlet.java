package cn.com.oking.nrfb.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bstek.bdf2.core.context.ContextHolder;

import cn.com.oking.nrfb.getWzWz;

/**
 * Servlet implementation class getInfoServlet
 */
public class getInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getInfoServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		getWzWz dao=ContextHolder.getBean("getWzWz");
		int currentPage=1; 
	
		int pageSize=10;
		String currentPageStr=request.getParameter("currentpage");
		String mid=request.getParameter("mid");
		if (currentPageStr==null) {
			currentPage=1; 
		}else{
			currentPage=Integer.valueOf(currentPageStr);
		}
		if (currentPage<1) {
			currentPage=1; 
		}
		
		int allCount=dao.getAllCount(mid);
		int allPages=(allCount-1)/pageSize+1;
		if (currentPage>allPages) {
			currentPage=allPages; 
		}
		
		List<Map<String, Object>> list=null;
		try {
			list = dao.getList(mid,currentPage,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<list.size();i++){  //datetime to date
			Map<String, Object> map=list.get(i);
			String fbsj=map.get("fbsj").toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	        java.util.Date date;
			try {
				date = sdf.parse(fbsj);
				fbsj=sdf.format(date);
				list.get(i).put("fbsj", fbsj);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		request.getSession().setAttribute("newslist",list);
		request.getSession().setAttribute("allPages",allPages);
		request.getSession().setAttribute("currentPageN",currentPage);
		request.getSession().setAttribute("mid", mid);
		response.sendRedirect("nrfb/nrfb_sub.jsp");
	}
}
