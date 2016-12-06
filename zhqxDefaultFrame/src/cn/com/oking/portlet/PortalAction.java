package cn.com.oking.portlet;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;

@Component
public class PortalAction {
	@Resource
	private PortalDao dao;
	
	@DataProvider
	@Transactional	
	public String checkUser(){
		IUser user = ContextHolder.getLoginUser();
		String info="";
		if (user!=null) {
			info=dao.checkUser(user.getEname());
			if (info.equals("error")) {
				return null;
			}else{
				return info;
			}
			
		}
		return null;
	}
}
