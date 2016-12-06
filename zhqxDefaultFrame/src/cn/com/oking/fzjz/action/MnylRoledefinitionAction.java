package cn.com.oking.fzjz.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.fzjz.dao.MnylRoledefinitionDao;
import cn.com.oking.fzjz.entity.MnylDeptdefinition;
import cn.com.oking.fzjz.entity.MnylRoledefinition;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Component
public class MnylRoledefinitionAction {
	@Resource
	private MnylRoledefinitionDao dao;
	
	@Transactional
	@DataProvider	
	public List<MnylRoledefinition> getAll(){
		List<MnylRoledefinition> list=dao.getAll();
		return list;
	}
	
	
	@Transactional
	@DataProvider	
	public void getAll(Page<MnylRoledefinition> page){
		dao.getAll(page);
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylRoledefinition> roleDefition){
		
		for(int i=0;i<roleDefition.size();i++){
			MnylRoledefinition role = roleDefition.get(i);
			if (!StringUtil.isNotEmpty(role.getRoleId())) {
				role.setRoleId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(roleDefition);
	}
}
