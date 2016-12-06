package cn.com.oking.fzjz.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.fzjz.dao.MnylCommonlinkDao;
import cn.com.oking.fzjz.entity.MnylCaselibrary;
import cn.com.oking.fzjz.entity.MnylCommonlink;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MnylCommonlinkAction {
	@Resource
	private MnylCommonlinkDao dao;
	
	@Transactional
	@DataProvider	
	public List<MnylCommonlink> findByRoleId(String roleId){
		List<MnylCommonlink> list=dao.find("from MnylCommonlink where roleId='"+roleId+"'");
		return list;
	}
	
	@DataProvider
	@Transactional	
	public void getAll(Page<MnylCommonlink> page){
		dao.getAll(page);
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylCommonlink> commonLink){
		
		for(int i=0;i<commonLink.size();i++){
			MnylCommonlink link = commonLink.get(i);
			if (!StringUtil.isNotEmpty(link.getLinkId())) {
				link.setLinkId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(commonLink);
	}
}
