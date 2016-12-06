package cn.com.oking.link;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bstek.bdf2.core.context.ContextHolder;

/**
 * Servlet implementation class linkDel
 */
public class linkDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public linkDelServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		response.setCharacterEncoding("utf-8");
		String id=new String(request.getParameter("linkid").getBytes("ISO-8859-1"),"UTF-8");
	    delete d=(delete) ContextHolder.getApplicationContext()
				.getBean(delete.class);
		try {
			int num=d.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
