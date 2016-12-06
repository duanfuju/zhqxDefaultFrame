package cn.com.oking.nk.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

import cn.com.oking.nk.dao.NkBalanceOfPaymentDao;
import cn.com.oking.nk.entity.NkBalanceOfPayment;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;
/**
 * 
 * @author 段福举
 *
 * 这个文件的作用	收支控制中收入管理、支出管理、政策文件页签	所需要的方法
 */
@Component
public class NkBalanceOfPaymentAction {
	@Resource
	private NkBalanceOfPaymentDao dao;
	
	
	@Transactional
	@DataProvider	
	public List<NkBalanceOfPayment> getData(Map<String, Object> map){
		List<NkBalanceOfPayment> list=null;
		try {
			list = dao.find("from NkBalanceOfPayment where nkType='"+map.get("type")+"'  order by updateTime desc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@DataResolver
	@Transactional		
	public void save(List<NkBalanceOfPayment> infos){
		for (int i = 0; i < infos.size(); i++) {
			NkBalanceOfPayment nk=infos.get(i);
			String key=KeyUtil.getKey();
			if (!StringUtil.isNotEmpty(nk.getId())) {
				nk.setNkNum(key);
				nk.setId(key);
			}
		}
		dao.persistEntities(infos);
	}
	
}
