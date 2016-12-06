package com.oking.core.frame.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.exception.NoneLoginException;
import com.bstek.bdf2.core.model.DefaultUser;
import com.bstek.bdf2.core.orm.ParseResult;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

@Component("frame.UserMaintain")
public class UserMaintain extends CoreJdbcDao {

	@DataProvider
	public void loadUsers(Page<IUser> page, Criteria criteria) throws Exception {
		IUser user = ContextHolder.getLoginUser();
		if (user == null) {
			throw new NoneLoginException("Please login first");
		}
		String companyId = user.getCompanyId();
		if (StringUtils.isNotEmpty(getFixedCompanyId())) {
			companyId = getFixedCompanyId();
		}
		RowMapper<IUser> mapper = new RowMapper<IUser>() {
			@Override
			public IUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				DefaultUser user = new DefaultUser();
				user.setUsername(rs.getString("USERNAME_"));
				user.setCname(rs.getString("CNAME_"));
				user.setEname(rs.getString("ENAME_"));
				user.setAdministrator(rs.getBoolean("ADMINISTRATOR_"));
				user.setBirthday(rs.getDate("BIRTHDAY_"));
				user.setCompanyId(rs.getString("COMPANY_ID_"));
				user.setEmail(rs.getString("EMAIL_"));
				user.setEnabled(rs.getBoolean("ENABLED_"));
				user.setMale(rs.getBoolean("MALE_"));
				user.setMobile(rs.getString("MOBILE_"));
				user.setPassword(rs.getString("PASSWORD_"));
				user.setSalt(rs.getString("SALT_"));
				user.setAddress(rs.getString("ADDRESS_"));
				user.setCreateDate(rs.getDate("CREATE_DATE_"));
				return user;
			}
		};

		String sql = "SELECT x.USERNAME_,x.CNAME_,x.ENAME_,x.ADMINISTRATOR_,x.BIRTHDAY_,x.COMPANY_ID_,x.EMAIL_,x.ENABLED_,x.MALE_,x.MOBILE_,x.PASSWORD_,x.SALT_,x.ADDRESS_,x.CREATE_DATE_ FROM BDF2_USER x WHERE ";
		ParseResult result = parseCriteria(criteria, false, null);
		if (result != null) {
			StringBuffer sb = result.getAssemblySql();
			Map<String, Object> valueMap = result.getValueMap();
			valueMap.put("companyId", companyId);
			sql = (new StringBuilder()).append(sql).append(sb.toString())
					.append(" and x.COMPANY_ID_=? order by x.USERNAME_").toString();
			pagingQuery(page, sql, valueMap.values().toArray(), mapper);
		} else {
			HashMap<String, Object> valueMap = new HashMap<String, Object>();
			valueMap.put("companyId", companyId);
			sql = (new StringBuilder()).append(sql).append(" x.COMPANY_ID_=? order by x.USERNAME_")
					.toString();
			pagingQuery(page, sql, valueMap.values().toArray(), mapper);
		}
	}
}