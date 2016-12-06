package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.TabControlDao;
import cn.com.oking.nk.entity.TabControl;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	菜单管理界面	所需要的方法
 */
@Component
public class TabControlAction{
	@Resource
	private TabControlDao dao;
	

	@Transactional
	@DataProvider	
	public void getData(Page<TabControl>page){
		dao.find(page,"from TabControl");
	}
	
	
	@DataResolver
	@Transactional		
	public void save(List<TabControl> infos){
		for (int i = 0; i < infos.size(); i++) {
			TabControl tc=infos.get(i);
			String key=KeyUtil.getKey();
			if (!StringUtil.isNotEmpty(tc.getId())) {
				tc.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
}
