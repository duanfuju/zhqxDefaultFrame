package cn.com.oking.nk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.nk.dao.NkXmkzRecordDao;
import cn.com.oking.nk.entity.NkXmkzRecord;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

/**
 * 
 * @author �θ���
 *
 * ����ļ�������	��Ŀ����֮��Ŀ��¼	����Ҫ�ķ���
 */
@Component
public class NkXmkzRecordAction{

		@Resource	
		private NkXmkzRecordDao dao;
		
		@DataProvider
		@Transactional	
		public void getData(Page<NkXmkzRecord> page){
			dao.find(page,"from NkXmkzRecord");
		}
		
		
		@DataResolver
		@Transactional 
		public void save(List<NkXmkzRecord> infos){
			for (int i = 0; i < infos.size(); i++) {
				NkXmkzRecord entity=infos.get(i);
				if (!StringUtil.isNotEmpty(entity.getNkId())) {
					String key=KeyUtil.getKey();
					entity.setNkId(key);
				}
			}
			dao.persistEntities(infos);
		}
}
