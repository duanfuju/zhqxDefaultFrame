package cn.com.oking.fzjz.action;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

import cn.com.oking.fzjz.dao.MnylResultrecordDao;
import cn.com.oking.fzjz.entity.MnylResultrecord;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

@Component
public class MnylResultrecordAction {
	@Resource
	private MnylResultrecordDao dao;
	
	
	
	
	@DataProvider
	@Transactional
	public List<MnylResultrecord> findByAnswerId(String answerId){
		List<MnylResultrecord> list=null;
		try {
			list = dao.find("from MnylResultrecord where answerId='"+answerId+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	@DataProvider
	@Transactional
	public MnylResultrecord findByYlId(String ylId){
		List<MnylResultrecord> list=null;
		try {
			list = dao.find("from MnylResultrecord where ylId='"+ylId+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list.get(0);
	}
	@DataProvider
	@Transactional
	public MnylResultrecord findById(String id){
		List<MnylResultrecord> list=null;
		try {
			list = dao.find("from MnylResultrecord where id='"+id+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list.get(0);
	}
	
	@DataResolver
	@Transactional
	public void save(MnylResultrecord info){
		if (!StringUtil.isNotEmpty(info.getId())) {
			info.setId(KeyUtil.getKey());
		}
		dao.save(info);
	}
	
	@DataProvider
	@Transactional	
	public void getAll(Page<MnylResultrecord> page){
		dao.getAll(page);
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylResultrecord> resultRecord){
		
		for(int i=0;i<resultRecord.size();i++){
			MnylResultrecord record = resultRecord.get(i);
			if (!StringUtil.isNotEmpty(record.getId())) {
				record.setId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(resultRecord);
	}
	
	@Transactional
	@DataProvider	
	public void findData(Page<MnylResultrecord> page,Map<String, Object> params){
		dao.find(page,"from MnylResultrecord where answerId='"+params.get("answerId")+"'");
	}
	
}
