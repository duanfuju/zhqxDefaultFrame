package cn.com.oking.nk.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.nk.dao.NkRecordDao;
import cn.com.oking.nk.entity.NkRecord;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	预算控制	菜单中预算执行页签中	所需要的方法
 */
@Component
public class NkRecordAction {

	@Resource
	private NkRecordDao dao;
	
	
	
	@Transactional
	@DataProvider	
	public List<NkRecord> getData(Map<String, Object> map){
		List<NkRecord> list=null;
		try {
			list = dao.find("from NkRecord where nkType='"+map.get("type")+"' and nkNum='"+map.get("id")+"' order by updateTime desc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	@DataResolver
	@Transactional	
	public void save(List<NkRecord> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkRecord nk=infos.get(i);
			String key=KeyUtil.getKey();
			if (!StringUtil.isNotEmpty(nk.getId())) {
				nk.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
	
	@Transactional
	@DataProvider	
	public NkRecord getDataById(String id){
		List<NkRecord> list=null;
		try {
			list = dao.find("from NkRecord where nkNum='"+id+"' and nkType='0'  order by updateTime desc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(0);
	}
}
