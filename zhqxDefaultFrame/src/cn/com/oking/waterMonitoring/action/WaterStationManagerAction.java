package cn.com.oking.waterMonitoring.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;

import cn.com.oking.entity.WaterStationManager;
import cn.com.oking.waterMonitoring.dao.WaterStationManagerDao;

@Component
public class WaterStationManagerAction {
	
		@Resource
		private WaterStationManagerDao dao;
		
		
		@Resource(name = "jdbcsqlserver")
		private JdbcTemplate jdbcsqlserver;
		
		@DataProvider
		@Transactional	
		public List<WaterStationManager> findAll(){
			List<WaterStationManager> list=dao.getAll();
			return list;
		}
		
		
		@DataProvider
		@Transactional		
		public List<Map<String, Object>> findByIdWithSS(String id){//根据站点的编号获取sqlserver数据库的水位数据
			String sql = "select CONVERT(varchar(100),tm,120)tm,rz from ST_RTU80SWFB_RSVR_H where STCD='"+id+"' order by TM desc";	//tm rz
			List<Map<String, Object>> list = jdbcsqlserver.queryForList(sql);
			return list;
		}
		
		@DataProvider
		@Transactional		
		public List<Map<String, Object>> findPicWithSS(String id){//根据站点的编号获取sqlserver数据库的图片数据
			//DT 时间    Scanid 摄像头
			String sql = "select CONVERT(varchar(100),DT,120)DT,Scanid,pic,STCD from ST_RVU90_PIC_H where STCD='"+id+"'";
			//String sql = "select * from ST_RVU90_PIC_H where STCD='"+id+"'";
			List<Map<String, Object>> list = jdbcsqlserver.queryForList(sql);
			return list;
		}
		
}
