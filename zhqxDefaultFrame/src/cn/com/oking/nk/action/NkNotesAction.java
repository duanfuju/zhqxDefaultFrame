package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.NkNotesDao;
import cn.com.oking.nk.entity.NkNotes;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	收支管理菜单	票据管理页签中	所需要的方法
 */
@Component
public class NkNotesAction {
	
		@Resource
		private NkNotesDao dao;
		
		
		@DataProvider
		@Transactional	
		public void getData(Page<NkNotes> page){
			dao.find(page,"from NkNotes");
		}
		
		
		@DataResolver
		@Transactional 
		public void save(List<NkNotes> infos){
			for (int i = 0; i < infos.size(); i++) {
				NkNotes entity=infos.get(i);
				if (!StringUtil.isNotEmpty(entity.getNkId())) {
					String key=KeyUtil.getKey();
					entity.setNkId(key);
					entity.setNkNum(key);
				}
			}
			dao.persistEntities(infos);
		}
}
