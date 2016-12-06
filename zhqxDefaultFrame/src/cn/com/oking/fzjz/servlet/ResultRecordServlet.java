package cn.com.oking.fzjz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bstek.bdf2.core.context.ContextHolder;

import cn.com.oking.fzjz.action.MnylAnswerAction;
import cn.com.oking.fzjz.action.MnylProblemsAction;
import cn.com.oking.fzjz.action.MnylResultrecordAction;
import cn.com.oking.fzjz.entity.MnylAnswer;
import cn.com.oking.fzjz.entity.MnylProblems;
import cn.com.oking.fzjz.entity.MnylResultrecord;

/**
 * Servlet implementation class ResultRecordServlet
 */
public class ResultRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultRecordServlet() {
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
    	MnylResultrecordAction r_action=ContextHolder.getBean("mnylResultrecordAction");//��¼��
    	MnylProblemsAction p_action=ContextHolder.getBean("mnylProblemsAction");//�����
    	try {
			//��ȡ����
			String checkboxs=new String(request.getParameter("checkboxs").getBytes("ISO-8859-1"),"UTF-8");
			String ids=new String(request.getParameter("ids").getBytes("ISO-8859-1"),"UTF-8");
			String ylId=new String(request.getParameter("ylId").getBytes("ISO-8859-1"),"UTF-8");
			String[] c=checkboxs.split(",");
			String[] i=ids.split(",");
			for (int j = 0; j < i.length; j++) {
				MnylResultrecord record=r_action.findById(i[j]);
				MnylProblems problem=p_action.findById(record.getAnswerId());
				//���ü�¼�����Ϣ
				//������Ϣ���id���
				record.setYlId(ylId);
				//�����ı��⡢���⡢��������
				record.setTitle(problem.getTitle());
				record.setProblem(problem.getProblem());
				record.setPtype(problem.getPtype());
				//��¼���ѡ��
				record.setOptionChoose(c[j]);
				r_action.save(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
