package cn.com.oking.fzjz.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.fzjz.dao.MnylProblemsStandardLibraryDao;
import cn.com.oking.fzjz.entity.MnylProblemsStandardLibrary;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MnylProblemsStandardLibraryAction {

	@Resource
	private MnylProblemsStandardLibraryDao dao;
	
	@DataProvider
	@Transactional	
	public void getAll(Page<MnylProblemsStandardLibrary> page){
		dao.find(page,"from MnylProblemsStandardLibrary order by id desc");
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylProblemsStandardLibrary> problemsStandardLibrary){
		
		for(int i=0;i<problemsStandardLibrary.size();i++){
			MnylProblemsStandardLibrary standardLibrary = problemsStandardLibrary.get(i);
			if (!StringUtil.isNotEmpty(standardLibrary.getId())) {
				standardLibrary.setId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(problemsStandardLibrary);
	}
	
}
