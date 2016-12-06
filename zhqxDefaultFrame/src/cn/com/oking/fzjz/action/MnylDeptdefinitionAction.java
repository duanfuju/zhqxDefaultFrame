package cn.com.oking.fzjz.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.fzjz.dao.MnylDeptdefinitionDao;
import cn.com.oking.fzjz.entity.MnylCommonlink;
import cn.com.oking.fzjz.entity.MnylDeptdefinition;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Component
public class MnylDeptdefinitionAction {
	@Resource
	private MnylDeptdefinitionDao dao;
	
	
	@Transactional
	@DataProvider	
	public List<MnylDeptdefinition> getAll(){
		List<MnylDeptdefinition> list=dao.getAll();
		return list;
	}
	
	@DataProvider
	@Transactional	
	public void getAll(Page<MnylDeptdefinition> page){
		dao.getAll(page);
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylDeptdefinition> deptDefition){
		
		for(int i=0;i<deptDefition.size();i++){
			MnylDeptdefinition dept = deptDefition.get(i);
			if (!StringUtil.isNotEmpty(dept.getDeptId())) {
				dept.setDeptId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(deptDefition);
	}
}
