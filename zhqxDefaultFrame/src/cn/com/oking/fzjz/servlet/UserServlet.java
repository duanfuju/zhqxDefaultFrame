package cn.com.oking.fzjz.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.context.ContextHolder;

import cn.com.oking.fzjz.action.MnylAnswerAction;
import cn.com.oking.fzjz.action.MnylProblemsAction;
import cn.com.oking.fzjz.action.MnylResultrecordAction;
import cn.com.oking.fzjz.entity.MnylAnswer;
import cn.com.oking.fzjz.entity.MnylProblems;
import cn.com.oking.fzjz.entity.MnylResultrecord;




@Component("userServlet")
public class UserServlet extends HttpServlet   {

	@Resource
	MnylResultrecordAction r_action;
	@Resource
	MnylAnswerAction a_action;
	@Resource
	MnylProblemsAction p_action;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3491871107264863168L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
    	try {
			//获取参数
			String checkboxs=new String(request.getParameter("checkboxs").getBytes("ISO-8859-1"),"UTF-8");
			String ids=new String(request.getParameter("ids").getBytes("ISO-8859-1"),"UTF-8");
			String ylId=new String(request.getParameter("ylId").getBytes("ISO-8859-1"),"UTF-8");
			String[] c=checkboxs.split(",");
			String[] i=ids.split(",");
			
			
			for (int j = 0; j < i.length; j++) {
				MnylAnswer answer=a_action.findById(i[j]);
				MnylProblems problem=p_action.findById(answer.getAnswerId());
				
				MnylResultrecord record=new MnylResultrecord();
				//设置记录表的信息
				//基础信息表的id编号
				record.setYlId(ylId);
				//问题表的标题、问题、问题类型
				record.setTitle(problem.getTitle());
				record.setProblem(problem.getProblem());
				record.setPtype(problem.getPtype());
				//记录表的选择
				record.setOptionChoose(c[j]);
				//选项表的文本、选项类型、选项答案
				record.setOptionText(answer.getOptionText());
				record.setOptionType(answer.getOptionType());
				record.setOptionIstrue(answer.getOptionIstrue());
				//选项表的所属问题id编号
				record.setAnswerId(answer.getAnswerId());
				
				r_action.save(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
