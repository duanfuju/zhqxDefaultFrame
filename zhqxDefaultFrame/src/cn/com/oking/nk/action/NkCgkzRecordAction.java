package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.NkCgkzRecordDao;
import cn.com.oking.nk.entity.NkCgkzRecord;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	采购控制之采购记录	所需要的方法
 */
@Component
public class NkCgkzRecordAction {
	@Resource
	private NkCgkzRecordDao dao;
	
	@DataProvider
	@Transactional	
	public void getData(Page<NkCgkzRecord> page){
		dao.find(page,"from NkCgkzRecord");
	}
	
	
	@DataResolver
	@Transactional 
	public void save(List<NkCgkzRecord> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkCgkzRecord entity=infos.get(i);
			if (!StringUtil.isNotEmpty(entity.getNkId())) {
				String key=KeyUtil.getKey();
				entity.setNkId(key);
				entity.setNkNum(key);
			}
		}
		dao.persistEntities(infos);
	}
}
