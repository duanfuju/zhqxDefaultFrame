package cn.com.oking.fzjz.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.fzjz.dao.MnylBaseinfoDao;
import cn.com.oking.fzjz.entity.MnylAnswer;
import cn.com.oking.fzjz.entity.MnylBaseinfo;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MnylBaseinfoAction {
	@Resource
	private MnylBaseinfoDao dao;
	
	@DataResolver
	@Transactional	
	public void save(MnylBaseinfo info){
		if (!StringUtil.isNotEmpty(info.getYlId())) {
			String yl_id=KeyUtil.getKey();
			ContextHolder.getRequest().getSession().setAttribute("yl_id", yl_id);
			info.setYlId(yl_id);
			info.setYlStartTime(new Date());
			info.setYlStatus("ÑÝÁ·½øÐÐÖÐ");
		}else{
			info.setYlEndTime(new Date());
		}
		dao.save(info);
	}
	
	@DataProvider
	@Transactional	
	public void getAll(Page<MnylBaseinfo> page){
		dao.getAll(page);
	}
	
	@DataProvider
	@Transactional	
	public MnylBaseinfo findById(String id){
		MnylBaseinfo info=null;
		try {
			info = (MnylBaseinfo) dao.find("from MnylBaseinfo where ylId='"+id+"'").get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return info;
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylBaseinfo> baseInfo){
		
		for(int i=0;i<baseInfo.size();i++){
			MnylBaseinfo info = baseInfo.get(i);
			if (!StringUtil.isNotEmpty(info.getYlId())) {
				info.setYlId(KeyUtil.getKey());
			}
			dao.save(info);
		}
	}
	
}
