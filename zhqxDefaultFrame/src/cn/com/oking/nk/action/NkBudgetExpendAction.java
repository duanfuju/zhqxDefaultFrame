package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.nk.dao.NkBudgetExpendDao;
import cn.com.oking.nk.entity.NkBudgetExpend;

@Component
public class NkBudgetExpendAction {
	@Resource
	private NkBudgetExpendDao dao;
	
	
	
	@Transactional
	@DataProvider	
	public List<NkBudgetExpend> findById(String aid){
		List<NkBudgetExpend> list=dao.find("from NkBudgetExpend where associateId='"+aid+"'");
		return list;
	}
	
	
	@Transactional
	@DataProvider	
	public List<NkBudgetExpend> findByParentId(String pid){
		List<NkBudgetExpend> list=dao.find("from NkBudgetExpend where parentId='"+pid+"'");
		return list;
	}
}
