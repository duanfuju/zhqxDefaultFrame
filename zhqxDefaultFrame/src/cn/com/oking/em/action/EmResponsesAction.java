package cn.com.oking.em.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmResponsesDao;
import cn.com.oking.em.entity.EmResponses;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmResponsesAction {
	@Resource
	private EmResponsesDao dao;
	
	@DataProvider
	@Transactional
	public void getDataByName(Page<EmResponses> page,String name){
		  dao.find(page," from EmResponses where disastertype='"+name+"' order by alarmstandardnum");
	}
	@DataResolver
	@Transactional
	public void save11(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("干旱");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save10(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("霜冻");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save9(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("连阴雨");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save8(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("大雾");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save7(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("高温");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save6(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("寒潮");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save5(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("大风");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save4(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("强对流");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save3(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("暴雪");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save2(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("台风");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save1(List<EmResponses> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmResponses em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAlarmstandardnum(key);
				em.setDisastertype("暴雨");
			}
		}
		dao.persistEntities(infos);
	}
}
