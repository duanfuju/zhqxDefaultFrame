package cn.com.oking.em.dao;

import org.springframework.stereotype.Repository;

import cn.com.oking.em.entity.EmStore;

import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class EmStoreDao extends HibernateDao<EmStore, Long>{

}
