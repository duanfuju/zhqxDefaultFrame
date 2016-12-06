package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.nk.dao.NkBudgetDao;
import cn.com.oking.nk.entity.NkBudget;
import cn.com.oking.nk.entity.NkNotes;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	预算控制菜单年度预算页签		所需要的方法
 */
@Component
public class NkBudgetAction {

	@Resource
	private NkBudgetDao dao;
	
	@DataProvider
	@Transactional	
	public List<NkBudget> getData(){
		List<NkBudget> list=null;
		try {
			list = dao.find("from NkBudget");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@DataProvider
	@Transactional
	public NkBudget findBynkId(String nkId){
		NkBudget single=null;
		try {
			single = (NkBudget) dao.find("from NkBudget where nkId='"+nkId+"'").get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return single;
	}
	
	
	@DataResolver
	@Transactional
	public void save(NkBudget entity){
		if (!StringUtil.isNotEmpty(entity.getNkId())) {
			String key=KeyUtil.getKey();
			entity.setNkId(key);
			entity.setNkNum(key);
		}
		dao.save(entity);
	}
	@DataResolver
	@Transactional
	public void save(List<NkBudget> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkBudget entity=infos.get(i);
			if (!StringUtil.isNotEmpty(entity.getNkId())) {
				String key=KeyUtil.getKey();
				entity.setNkId(key);
				entity.setNkNum(key);
			}
		}
		dao.persistEntities(infos);
	}
	
}
