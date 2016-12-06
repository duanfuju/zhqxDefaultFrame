package cn.com.oking.dataInterface.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import cn.com.oking.dataInterface.dao.MonitorSysListDao;
import cn.com.oking.dataInterface.dao.MonitorSysLogDao;

import cn.com.oking.entity.MonitorSysList;
import cn.com.oking.entity.MonitorSysLog;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;


public class SerchRun {	
	private Logger logger = LoggerFactory.getLogger(SerchRun.class); 
	
	@Resource
	private MonitorSysListDao dao;
	
	@Resource
	private MonitorSysLogDao logdao;
	
	
	@Transactional
	 public void timingMethod(){
		 //获取有效的数据
		 List<Map<String, Object>> list=dao.getEffectiveData();
		 for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map=list.get(i);
			//从数据库中获取当前的对象
			MonitorSysList msl=(MonitorSysList)dao.find("from MonitorSysList where dataid='"+(String) map.get("dataid")+"'").get(0);
			if (StringUtil.isNotEmpty(msl.getTesturl())){//判断系统的地址是否为空
					Detector detector=new Detector();//探测器
					detector.keepTomcatAlive((String) map.get("testurl"));//使用探测器查看是否连接的通
					//detector.pingIp(map.get("ipaddress").toString());
					if (!detector.getMessage().equalsIgnoreCase("success")) {
						List<MonitorSysLog> mslList=logdao.find("from MonitorSysLog where dataid='"+msl.getDataid()+"' and lifted='N'");
						if (mslList.size()<1) {
							//当发生异常时
							MonitorSysLog log=new MonitorSysLog();
							log.setLogid(KeyUtil.getKey());//主键
							log.setLifted("N");//是否解除
							log.setDescription(detector.getMessage());//错误信息
							log.setWarningtime(new Date());//预警时间
							log.setLastdate(msl.getLastdate());//最后正常运行时间（数据监控列表中取得）
							log.setDataid(msl.getDataid());
							logdao.save(log);
						}
					}else{
						msl.setLastdate(new Date());
						List<MonitorSysLog> logList=logdao.find("from MonitorSysLog where dataid="+msl.getDataid()+" and lifted='N'");
						if (logList.size()>0) {
							for (int j = 0; j < logList.size(); j++) {
								MonitorSysLog log=logList.get(j);
								log.setLifted("Y");
							}
							logdao.persistEntities(logList);
						}
					}
			}else{
				MonitorSysLog log=new MonitorSysLog();
				log.setLogid(KeyUtil.getKey());
				log.setLifted("N");
				log.setDescription("系统地址为空");
				log.setWarningtime(new Date());
				log.setLastdate(msl.getLastdate());
				log.setDataid(msl.getDataid());
				logdao.save(log);
			}
			dao.save(msl);
		}
	 }
}
