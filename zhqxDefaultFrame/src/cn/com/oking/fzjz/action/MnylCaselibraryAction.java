package cn.com.oking.fzjz.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.fzjz.dao.MnylCaselibraryDao;
import cn.com.oking.fzjz.entity.MnylBaseinfo;
import cn.com.oking.fzjz.entity.MnylCaselibrary;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MnylCaselibraryAction {
	@Resource
	private MnylCaselibraryDao dao;
	
	@DataProvider
	@Transactional	
	public void getAll(Page<MnylCaselibrary> page){
		dao.getAll(page);
	}
	
	@DataProvider
	@Transactional	
	public List<MnylCaselibrary> getAll(){
		List<MnylCaselibrary> list=dao.getAll();
		return list;
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylCaselibrary> caseLibrary){
		
		for(int i=0;i<caseLibrary.size();i++){
			MnylCaselibrary library = caseLibrary.get(i);
			if (!StringUtil.isNotEmpty(library.getZhId())) {
				library.setZhId(KeyUtil.getKey());
			}
		}
		
		dao.persistEntities(caseLibrary);
		
	}
}
