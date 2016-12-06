package cn.com.oking.dataInterface.dao;

import org.springframework.stereotype.Repository;
import cn.com.oking.dataInterface.entity.MonitorList;
import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class MonitorListDao extends HibernateDao<MonitorList, Long>{}
