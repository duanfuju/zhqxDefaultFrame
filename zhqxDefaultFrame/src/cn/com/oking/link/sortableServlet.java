package cn.com.oking.link;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bstek.bdf2.core.context.ContextHolder;

/**
 * Servlet implementation class sortableServlet
 */
public class sortableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sortableServlet() {
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
		String[] id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8").split(",");
		String[] order =new String(request.getParameter("order").getBytes("ISO-8859-1"),"UTF-8").split(",");
	    update u=(update) ContextHolder.getApplicationContext()
				.getBean(update.class);
	    try {
			u.updateBatch(id, order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
