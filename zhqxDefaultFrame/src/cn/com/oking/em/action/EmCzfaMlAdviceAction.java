package cn.com.oking.em.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.em.dao.EmCzfaMlAdviceDao;
import cn.com.oking.em.entity.EmCzfaMlAdvice;
import cn.com.oking.util.KeyUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

@Component
public class EmCzfaMlAdviceAction {

	@Resource
	private EmCzfaMlAdviceDao dao;
	
	@Transactional
	@DataProvider
	public List<EmCzfaMlAdvice> getData(Map<String, Object> params){
		if (params!=null) {
			try {
				List<EmCzfaMlAdvice> list=dao.find("from EmCzfaMlAdvice where czfaJyId='"+params.get("czfaJyId")+"'");
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@Transactional
	@DataProvider
	public List<EmCzfaMlAdvice> getDataByNum(Map<String, Object> params){
		if (params!=null) {
			try {
				List<EmCzfaMlAdvice> list=dao.find("from EmCzfaMlAdvice where czfaJyId='"+params.get("czfaJyId")+"' and type='1'");
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	@Transactional
	@DataResolver
	public void save(List<EmCzfaMlAdvice> infos){
		for (int i = 0; i < infos.size(); i++) {
			EmCzfaMlAdvice em=infos.get(i);
			em.setId(KeyUtil.getKey());
			em.setType("1");
		}
		dao.persistEntities(infos);
	}
	
	
}
