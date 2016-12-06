package cn.com.oking.em.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.web.DoradoContext;

/**
 * Servlet implementation class MapCoordinatesServlet
 */
public class MapCoordinatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapCoordinatesServlet() {
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
		response.reset();
		response.setContentType("application/x-download");
		request.setCharacterEncoding("gbk");
		String longitude=request.getParameter("longitude");
		String latitude=request.getParameter("latitude");
		ContextHolder.getRequest().getSession().setAttribute("longitude",longitude);
		ContextHolder.getRequest().getSession().setAttribute("latitude",latitude);
	}

}
