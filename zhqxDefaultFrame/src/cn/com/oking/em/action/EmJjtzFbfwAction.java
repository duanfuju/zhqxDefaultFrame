package cn.com.oking.em.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.em.dao.EmJjtzFbDao;
import cn.com.oking.em.dao.EmJjtzFbfwDao;
import cn.com.oking.em.entity.EmJjtzFb;
import cn.com.oking.em.entity.EmJjtzFbfw;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class EmJjtzFbfwAction {

	@Resource
	private EmJjtzFbfwDao fbfwdao;
	@Resource
	private EmJjtzFbDao fbdao;
	
	
	@Transactional
	@DataProvider
	public List<EmJjtzFbfw> getData(String id){
		return  fbfwdao.find("from EmJjtzFbfw where jjtzId='"+id+"'");
	}
	
	
	
	/**
	 * 发布
	 * @param fb
	 */
	@Transactional
	@DataResolver
	public void publish(EmJjtzFb fb){
		fb.setPubdate(new Date());
		fb.setStatus("已发布");
		IUser user = ContextHolder.getLoginUser();
		fb.setPubby(user.getCname());
		fbdao.save(fb);
	}
	
	/**
	 * 保存发布范围
	 * @param infos
	 */
	@DataResolver
	@Transactional
	public void save(List<EmJjtzFbfw> infos) {
		for (int i = 0; i < infos.size(); i++) {
			EmJjtzFbfw em=infos.get(i);
			if (!StringUtil.isNotEmpty(em.getId())) {
				String key=KeyUtil.getKey();
				em.setId(key);
			}
		}
		fbfwdao.persistEntities(infos);
	}
	
	
	
	
	/**
	 * datagrid查询或根据条件查询数据			
	 * @param page
	 * @param params
	 */
	@Transactional		
	@DataProvider			
	public void getData(Page<EmJjtzFb> page,Map<String, Object> params){
		if (params!=null) {
			try {
				//subject紧急通知主题    zhlx灾害类型    content紧急通知内容
				fbdao.find(page,"from EmJjtzFb where status!='拟稿' " 
											+" and subject like '%"+params.get("zt").toString()
											+"%' and zhlx like '%"+params.get("zhlx").toString()
											+"%' and content like '%"+params.get("jjtz").toString()+"%'");
			} catch (Exception e) {
				e.printStackTrace();
				fbdao.find(page,"from EmJjtzFb where status!='拟稿'");
			}
		}else{
			fbdao.find(page,"from EmJjtzFb where status!='拟稿'");
			IUser user = ContextHolder.getLoginUser();
			if (user!=null) {
				ContextHolder.getRequest().getSession().setAttribute("username", user.getCname());
			}
		}
	}
}
