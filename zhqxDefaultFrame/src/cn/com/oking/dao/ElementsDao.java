package cn.com.oking.dao;

import org.springframework.stereotype.Repository;

import cn.com.oking.entity.Elements;

import com.bstek.dorado.hibernate.HibernateDao;




@Repository
public class ElementsDao  extends HibernateDao<Elements, Long>{

}
