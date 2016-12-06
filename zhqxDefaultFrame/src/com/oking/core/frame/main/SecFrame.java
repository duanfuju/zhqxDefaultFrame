package com.oking.core.frame.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreHibernateDao;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.exception.NoneLoginException;
import com.bstek.bdf2.core.model.Url;
import com.bstek.dorado.annotation.DataProvider;

@Component("frame.SecFrame")
public class SecFrame extends CoreHibernateDao {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcT;
	@Resource(name = "bdf2.mainFrame")
	private com.bstek.bdf2.core.view.frame.main.MainFrame mainFrame;

	@DataProvider
	public Collection<Url> loadMeunUrls(String parentId) {
		IUser user = ContextHolder.getLoginUser();
		if (user == null) {
			throw new NoneLoginException("Please login first");
		}
		List<Url> cacheUrls = (List<Url>) mainFrame.loadMeunUrls(null);
		Collection<Url> urls = getCacheUrls(cacheUrls, parentId);
		return urls;
	}

	@DataProvider
	public Map<String, Object> getUrl(String id) throws Exception {
		IUser user = ContextHolder.getLoginUser();
		if (user == null) {
			throw new NoneLoginException("Please login first");
		}
		String querySql = "select t.id_ id, t.icon_ icon, t.name_ name, t.url_ url from bdf2_url t "
				+ "where t.for_navigation_ = '1' and t.id_ = '" + id + "'";
		System.out.println(querySql);
		Map<String, Object> rs = jdbcT.queryForMap(querySql);
		return rs;
	}

	private List<Url> getCacheUrls(List<Url> urls, String parentId) {
		List<Url> resultUrls = new ArrayList<Url>();
		buildCacheUrls(urls, resultUrls, parentId);
		return resultUrls;
	}

	private void buildCacheUrls(List<Url> urls, List<Url> resultUrls,
			String parentId) {
		Iterator<Url> i$ = urls.iterator();
		do {
			if (!i$.hasNext()) {
				break;
			} else {
				Url url = (Url) i$.next();
				if (StringUtils.isEmpty(parentId)) {
					resultUrls.add(url);
				} else if (url.getId().equals(parentId)) {
					resultUrls.add(url);
				} else {
					if (url.getChildren() != null) {
						buildCacheUrls(url.getChildren(), resultUrls, parentId);
					}
				}
			}
		} while (true);
	}

}
