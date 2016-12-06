package cn.com.oking.waterMonitoring.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.entity.WaterPicture;
import cn.com.oking.waterMonitoring.dao.WaterPictureDao;

@Component
public class WaterPictureAction {
	
    @Resource
	private WaterPictureDao dao;
    
    @Transactional
    @DataProvider
    public List<WaterPicture> getDate(){
    	List<WaterPicture> list=dao.find("from WaterPicture order by filetime desc");
    	return list;
    }
}
