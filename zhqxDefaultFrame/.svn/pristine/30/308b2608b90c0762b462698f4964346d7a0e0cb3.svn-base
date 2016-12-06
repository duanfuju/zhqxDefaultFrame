package cn.com.oking.em.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.em.dao.EmCzfaJyAdviceDao;
import cn.com.oking.em.dao.EmResponsesDao;
import cn.com.oking.em.entity.EmCzfaJyAdvice;
import cn.com.oking.em.entity.EmResponses;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;


@Component
public class EmCzfaJyAdviceAction {

		@Resource
		private EmCzfaJyAdviceDao dao;
		
		@Resource
		private EmResponsesDao rdao;
		
		@Transactional
		@DataProvider
		public List<EmCzfaJyAdvice> getData(Map<String, Object> params){
			if (params!=null) {
				try {
					List<EmResponses> respList=null;
					List<EmCzfaJyAdvice> list=null;
					if (params.get("bzid")!=null) {
						respList=rdao.find("from EmResponses where disasterlevel='"+params.get("bzid")+"'");
						list=new ArrayList<EmCzfaJyAdvice>();
						for (int i = 0; i < respList.size(); i++) {
							EmResponses responses=respList.get(i);
							EmCzfaJyAdvice em=new EmCzfaJyAdvice();
							em.setDept(responses.getDept());
							em.setResponses(responses.getResponse());
							em.setType("0");
							list.add(em);
						}
					}else if(params.get("czfaJyId")!=null){
						list=dao.find("from EmCzfaJyAdvice where czfaJyId='"+params.get("czfaJyId")+"'");
					}
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
		public void save(List<EmCzfaJyAdvice> list){
			for (int i = 0; i < list.size(); i++) {
				EmCzfaJyAdvice em=list.get(i);
				if (!StringUtil.isNotEmpty(em.getId())) {
					em.setId(KeyUtil.getKey());
				}
			}
			dao.persistEntities(list);
		}
}
