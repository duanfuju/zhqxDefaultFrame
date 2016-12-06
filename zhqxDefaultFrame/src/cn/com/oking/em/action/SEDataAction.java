package cn.com.oking.em.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.em.dao.SEDataDao;

@Component
public class SEDataAction {

	@Resource
	private SEDataDao dao;
	
	@Transactional
	@DataProvider 	
	public List<Map<String, Object>> getData(){
		return dao.findPData();
	}
}
