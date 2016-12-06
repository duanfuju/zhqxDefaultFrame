package cn.com.oking.nk.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.NkCgkzGckzDao;
import cn.com.oking.nk.entity.NkCgkzGckz;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	采购控制之过程控制	所需要的方法
 */
@Component
public class NkCgkzGckzAction {
	@Resource
	private NkCgkzGckzDao dao;
	
	
	@DataProvider
	@Transactional	
	public void getData(Page<NkCgkzGckz> page,Map<String, Object> param){
		if (param.size()>0) {
			dao.find(page,"from NkCgkzGckz where nkNum='"+param.get("id")+"'");
		}else{
			dao.find(page,"from NkCgkzGckz");
		}
	}
	
	
	@DataResolver
	@Transactional 
	public void save(List<NkCgkzGckz> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkCgkzGckz entity=infos.get(i);
			if (!StringUtil.isNotEmpty(entity.getId())) {
				String key=KeyUtil.getKey();
				entity.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
}
