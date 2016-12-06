package cn.com.oking.nk.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.NkXmkzGckzDao;
import cn.com.oking.nk.entity.NkXmkzGckz;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

/**
 * 
 * @author �θ���	
 *
 * ����ļ�������	��Ŀ����֮���̿���	����Ҫ�ķ���
 */
@Component
public class NkXmkzGckzAction{
	@Resource
	private NkXmkzGckzDao dao;
	
	@DataProvider	
	@Transactional	
	public void getData(Page<NkXmkzGckz> page,Map<String, Object> param){
		if (param.size()>0) {
			dao.find(page,"from NkXmkzGckz where nkNum='"+param.get("id")+"'");
		}else{
			dao.find(page,"from NkXmkzGckz");
		}
	}
	
	
	@DataResolver
	@Transactional 
	public void save(List<NkXmkzGckz> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkXmkzGckz entity=infos.get(i);
			if (!StringUtil.isNotEmpty(entity.getId())) {
				String key=KeyUtil.getKey();
				entity.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
}
