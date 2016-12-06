package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.NkHtkzRecordDao;
import cn.com.oking.nk.entity.NkHtkzRecord;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	合同控制之合同记录	所需要的方法
 */
@Component
public class NkHtkzRecordAction {
	@Resource
	private NkHtkzRecordDao dao;
	
	
	@DataProvider
	@Transactional	
	public void getData(Page<NkHtkzRecord> page){
		dao.find(page,"from NkHtkzRecord");
	}
	
	
	@DataResolver
	@Transactional 
	public void save(List<NkHtkzRecord> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkHtkzRecord entity=infos.get(i);
			if (!StringUtil.isNotEmpty(entity.getNkId())) {
				String key=KeyUtil.getKey();
				entity.setNkId(key);
			}
		}
		dao.persistEntities(infos);
	}
}
