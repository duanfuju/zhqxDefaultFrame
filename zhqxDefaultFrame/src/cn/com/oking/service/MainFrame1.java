package cn.com.oking.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.dao.Bdf2UrlDao;
import cn.com.oking.entity.Bdf2Url;

import com.bstek.dorado.annotation.Expose;

@Component
public class MainFrame1 {
	
	@Resource
	private Bdf2UrlDao dao;

	@Transactional
	@Expose
	public List<Bdf2Url> ShowDialog(String parentId) {
		List<Bdf2Url> list=dao.find("from Bdf2Url where parentId='"+parentId+"' order by order_");
		return list;
	}
}
