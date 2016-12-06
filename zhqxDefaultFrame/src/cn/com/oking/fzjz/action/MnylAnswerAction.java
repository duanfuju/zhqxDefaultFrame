package cn.com.oking.fzjz.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.fzjz.dao.MnylAnswerDao;
import cn.com.oking.fzjz.entity.MnylAnswer;
import cn.com.oking.fzjz.entity.MnylDeptdefinition;
import cn.com.oking.fzjz.entity.MnylProblems;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Component
public class MnylAnswerAction {
	@Resource
	private MnylAnswerDao dao;
	
	@DataProvider
	@Transactional
	public List<MnylAnswer> findByAnswerId(String answerId){
		List<MnylAnswer> list=null;
		try {
			list = dao.find("from MnylAnswer where answerId='"+answerId+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	@DataProvider
	@Transactional
	public MnylAnswer findById(String id){
		List<MnylAnswer> m=null;
		try {
			m = dao.find("from MnylAnswer where id='"+id+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return m.get(0);
	}
	
	@Transactional
	@DataProvider	
	public void findData(Page<MnylAnswer> page,Map<String, Object> params){
		dao.find(page,"from MnylAnswer where answerId='"+params.get("answerId")+"'");
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylAnswer> answers){
		
		for(int i=0;i<answers.size();i++){
			MnylAnswer ans = answers.get(i);
			if (!StringUtil.isNotEmpty(ans.getId())) {
				ans.setId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(answers);
	}
	
}
