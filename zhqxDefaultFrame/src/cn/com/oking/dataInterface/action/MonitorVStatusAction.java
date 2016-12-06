package cn.com.oking.dataInterface.action;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.dataInterface.dao.MonitorVStatusDao;

@Component
public class MonitorVStatusAction {
	@Resource
	private MonitorVStatusDao dao;
	/**
	 * monitorVStatusAction#getData
	 * @return
	 */
	@Transactional
	@DataProvider
	public List<Map<String, Object>> getData(){
		return dao.getData(); 
	}
	@Transactional
	@DataProvider
	public List<Map<String, Object>> getErrorData(){
		List<Map<String, Object>> list=dao.getErrorData();
		if (list.size()>0) {
			return list;
		}
		return null;
	}
	@Transactional
	@DataProvider
	public int getErrorDataCount(){
		List<Map<String, Object>> list=dao.getErrorData();
		if (list.size()>0) {
			return list.size();
		}
		return 0;
	}
}
