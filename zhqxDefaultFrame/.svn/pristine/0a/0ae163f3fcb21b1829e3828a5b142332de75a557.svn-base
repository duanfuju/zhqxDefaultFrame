package cn.com.oking.caiyun;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;



@Component
public class CaiYunPush {
	@Resource
	private CaiyunYjDao dao;
	
	@Resource
	private getList getList;
	
	@DataProvider
	@Transactional	
	public Map<String, Object>  isExists(){
		Map<String, Object> map = new HashMap<String, Object>();
		IUser user = ContextHolder.getLoginUser();
		String name=dao.UserAuthentication(user.getUsername());
		List<Map<String, Object>> list=null;
		try {
			 list=getList.newdate();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		if (list.size()>0) {
			if (name.equals("yes")) {
				String value=dao.isExists();
				map.put("key", value);
				return map;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}
