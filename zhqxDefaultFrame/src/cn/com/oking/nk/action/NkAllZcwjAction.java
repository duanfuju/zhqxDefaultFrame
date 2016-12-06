package cn.com.oking.nk.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.nk.dao.NkAllZcwjDao;
import cn.com.oking.nk.entity.NkAllZcwj;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author �θ���
 *
 * ����ļ�������	������֧����ҳ���еģ����в˵�ҳ���������ļ�ҳǩ	����Ҫ�ķ���
 */
@Component
public class NkAllZcwjAction {

		@Resource 
		private NkAllZcwjDao dao;
		
		@Transactional
		@DataProvider	
		public List<NkAllZcwj> getData(Map<String, Object> map){
			List<NkAllZcwj> list=null;
			try {
				list = dao.find("from NkAllZcwj where zcwjType='"+map.get("type")+"'");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		
		@DataResolver
		@Transactional		
		public void save(List<NkAllZcwj> infos){
			for (int i = 0; i < infos.size(); i++) {
				NkAllZcwj nk=infos.get(i);
				String key=KeyUtil.getKey();
				if (!StringUtil.isNotEmpty(nk.getId())) {
					nk.setId(key);
				}
			}
			dao.persistEntities(infos);
		}
		
}
