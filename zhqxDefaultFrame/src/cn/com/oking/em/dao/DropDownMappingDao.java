package cn.com.oking.em.dao;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.em.action.EmAlarmstandardAction;
import cn.com.oking.em.entity.EmAlarmstandard;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;

@Component
public class DropDownMappingDao {

	@Resource
	public EmAlarmstandardAction  emAlarmstandardAction;
	
	
	//  ${dorado.getDataProvider("dropDownMappingDao#getLevelMapping").getResult()}
	@DataProvider
	public Map<String,String> getLevelMapping(){
		Map<String,String> map = new HashMap<String,String>();
		//emAlarmstandardAction#getDataByName
		List<EmAlarmstandard>  tl = emAlarmstandardAction.getData();
		for(EmAlarmstandard d:tl){
			map.put(d.getAnumber(), d.getDisastername());
		}
		return map;
	}
	//
	
	
	
}
