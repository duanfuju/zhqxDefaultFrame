package com.oking.core.frame.main;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.exception.NoneLoginException;
import com.bstek.dorado.annotation.DataProvider;

@Component("frame.MainFrame")
public class MainFrame {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;

	@DataProvider
	public List<Map<String, Object>> loadDsUrls(Map<String, Object> parameter)
			throws Exception {
		IUser user = ContextHolder.getLoginUser();
		if (user == null) {
			throw new NoneLoginException("Please login first");
		}
		String querySql = "select t.id_ id, t.icon_ icon, t.name_ name, t.url_ url from bdf2_url t where t.for_navigation_ = '1' and t.url_ is not null ";
		List<Map<String, Object>> rs = jdbcT.queryForList(querySql);
		return rs;
	}

	@DataProvider
	public Map<String, Object> getUrl(String id) throws Exception {
		IUser user = ContextHolder.getLoginUser();
		if (user == null) {
			throw new NoneLoginException("Please login first");
		}
		String querySql = "select t.id_ id, t.icon_ icon, t.name_ name, t.url_ url from bdf2_url t "
				+ "where t.for_navigation_ = '1' and t.id_ = '"
				+ id + "'";
		System.out.println(querySql);
		Map<String, Object> rs = jdbcT.queryForMap(querySql);
		return rs;
	}
}