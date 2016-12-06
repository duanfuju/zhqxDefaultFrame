package cn.com.oking.nk.dao;

import org.springframework.stereotype.Repository;

import cn.com.oking.nk.entity.NkBudget;

import com.bstek.dorado.hibernate.HibernateDao;

@Repository
public class NkBudgetDao extends HibernateDao<NkBudget, Long>{

}
