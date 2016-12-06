package cn.com.oking.em.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.em.dao.EmAlarmstandardDao;
import cn.com.oking.em.entity.EmAlarmstandard;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmAlarmstandardAction {
	@Resource
	private EmAlarmstandardDao dao;
	
	
	@DataProvider			
	@Transactional
	public EmAlarmstandard getDataById(String id){
		List<EmAlarmstandard> list=null;
		try {
			list=dao.find("from EmAlarmstandard where id='"+id+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list.get(0);
	}
	
	@DataProvider			
	@Transactional
	public List<EmAlarmstandard> getDataByName(String name){
		List<EmAlarmstandard> list=	dao.find("from EmAlarmstandard where disastertype='"+name+"'");
		return list;
	}

	@DataProvider			
	@Transactional
	public List<EmAlarmstandard> getData(){
		List<EmAlarmstandard> list=	dao.find("from EmAlarmstandard ");
		return list;
	}
	
	
	@DataResolver
	@Transactional
	public void save11(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("干旱");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save10(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("霜冻");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save9(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("连阴雨");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save8(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("大雾");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save7(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("高温");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save6(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("寒潮");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save5(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("大风");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save4(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("强对流");
			}
		}
		dao.persistEntities(infos);
	}
	
	
	@DataResolver
	@Transactional
	public void save3(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("暴雪");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save2(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("台风");
			}
		}
		dao.persistEntities(infos);
	}
	
	@DataResolver
	@Transactional
	public void save1(List<EmAlarmstandard> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmAlarmstandard em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
				em.setAnumber(key);
				em.setDisastertype("暴雨");
			}
		}
		dao.persistEntities(infos);
	}
}
