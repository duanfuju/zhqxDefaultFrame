package cn.com.oking.em.action;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmTeamDao;
import cn.com.oking.em.entity.EmTeam;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmTeamAction {
	
	@Resource
	private EmTeamDao dao;
	
	@Transactional
	@DataProvider
	public void getData(Page<EmTeam> page,String teamtype){
		dao.find(page, "from EmTeam where teamtype='"+teamtype+"' order by ordernum");
	}
	
	@DataResolver
	@Transactional
	public void save1(List<EmTeam> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmTeam et=infos.get(i);
			if (!StringUtil.isNotEmpty(et.getEmId())) {
				et.setEmId(KeyUtil.getKey());
				et.setTeamtype("应急领导小组");
				et.setStatus("有效");
				et.setIsdefault("N");
				if (et.getDuties().equals("组长")) {
					et.setOrdernum(new BigDecimal("1"));
				}else if (et.getDuties().equals("副组长")) {
					et.setOrdernum(new BigDecimal("2"));
				}else if (et.getDuties().equals("成员")) {
					et.setOrdernum(new BigDecimal("3"));
				}
			}
			
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional
	public void save2(List<EmTeam> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmTeam et=infos.get(i);
			if (!StringUtil.isNotEmpty(et.getEmId())) {
				et.setEmId(KeyUtil.getKey());
				et.setTeamtype("镇街分管领导");
				et.setStatus("有效");
				et.setIsdefault("N");
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional
	public void save3(List<EmTeam> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmTeam et=infos.get(i);
			if (!StringUtil.isNotEmpty(et.getEmId())) {
				et.setEmId(KeyUtil.getKey());
				et.setTeamtype("部门联络员");
				et.setStatus("有效");
				et.setIsdefault("N");
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional
	public void save4(List<EmTeam> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmTeam et=infos.get(i);
			if (!StringUtil.isNotEmpty(et.getEmId())) {
				et.setEmId(KeyUtil.getKey());
				et.setTeamtype("镇街协理员");
				et.setStatus("有效");
				et.setIsdefault("N");
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional
	public void save5(List<EmTeam> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmTeam et=infos.get(i);
			if (!StringUtil.isNotEmpty(et.getEmId())) {
				et.setEmId(KeyUtil.getKey());
				et.setTeamtype("气象信息员");
				et.setStatus("有效");
				et.setIsdefault("N");
			}
		}
		dao.persistEntities(infos);
	}
	@DataResolver
	@Transactional
	public void save6(List<EmTeam> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmTeam et=infos.get(i);
			if (!StringUtil.isNotEmpty(et.getEmId())) {
				et.setEmId(KeyUtil.getKey());
				et.setTeamtype("单位安全员");
				et.setStatus("有效");
				et.setIsdefault("N");
			}
		}
		dao.persistEntities(infos);
	}
}
