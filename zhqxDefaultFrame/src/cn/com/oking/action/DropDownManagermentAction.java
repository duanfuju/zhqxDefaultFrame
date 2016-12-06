package cn.com.oking.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.dao.DropdownMenuManageBranchDao;
import cn.com.oking.dao.DropdownMenuManageMainDao;
import cn.com.oking.entity.DropdownMenuManageBranch;
import cn.com.oking.entity.DropdownMenuManageMain;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class DropDownManagermentAction {
	@Resource
	private DropdownMenuManageBranchDao bdao;
	@Resource
	private DropdownMenuManageMainDao mdao;
	
	
	@Transactional	
	@DataProvider	//获取下拉显示字段
	public void getMainData(Page<DropdownMenuManageMain> page){
		mdao.find(page,"from DropdownMenuManageMain order by orderby");
	}
	
	
	@Transactional
	@DataProvider	//根据下拉显示字段表的主键获取所属的下拉框中的值
	public void getBranchData(Page<DropdownMenuManageBranch> page,String id){
		bdao.find(page,"from DropdownMenuManageBranch where associationNumber='"+id+"' order by orderby");
	}
	
	
	@DataResolver	
	@Transactional
	public void saveWithM(List<DropdownMenuManageMain> infos) {
		for (int i = 0; i < infos.size(); i++) {
			DropdownMenuManageMain dd=infos.get(i);
			if (!StringUtil.isNotEmpty(dd.getId())) {
				dd.setId(KeyUtil.getKey());
			}
		}
		mdao.persistEntities(infos);
	}
	@DataResolver
	@Transactional
	public void saveWithB(List<DropdownMenuManageBranch> infos) {
		for (int i = 0; i < infos.size(); i++) {
			DropdownMenuManageBranch dd=infos.get(i);
			if (!StringUtil.isNotEmpty(dd.getId())) {
				dd.setId(KeyUtil.getKey());
			}
		}
		bdao.persistEntities(infos);
	}
	
	
	
}
