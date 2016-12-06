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
		 //��ȡ��Ч������
		 List<Map<String, Object>> list=dao.getEffectiveData();
		 for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map=list.get(i);
			//�����ݿ��л�ȡ��ǰ�Ķ���
			MonitorSysList msl=(MonitorSysList)dao.find("from MonitorSysList where dataid='"+(String) map.get("dataid")+"'").get(0);
			if (StringUtil.isNotEmpty(msl.getTesturl())){//�ж�ϵͳ�ĵ�ַ�Ƿ�Ϊ��
					Detector detector=new Detector();//̽����
					detector.keepTomcatAlive((String) map.get("testurl"));//ʹ��̽�����鿴�Ƿ����ӵ�ͨ
					//detector.pingIp(map.get("ipaddress").toString());
					if (!detector.getMessage().equalsIgnoreCase("success")) {
						List<MonitorSysLog> mslList=logdao.find("from MonitorSysLog where dataid='"+msl.getDataid()+"' and lifted='N'");
						if (mslList.size()<1) {
							//�������쳣ʱ
							MonitorSysLog log=new MonitorSysLog();
							log.setLogid(KeyUtil.getKey());//����
							log.setLifted("N");//�Ƿ���
							log.setDescription(detector.getMessage());//������Ϣ
							log.setWarningtime(new Date());//Ԥ��ʱ��
							log.setLastdate(msl.getLastdate());//�����������ʱ�䣨���ݼ���б���ȡ�ã�
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
				log.setDescription("ϵͳ��ַΪ��");
				log.setWarningtime(new Date());
				log.setLastdate(msl.getLastdate());
				log.setDataid(msl.getDataid());
				logdao.save(log);
			}
			dao.save(msl);
		}
	 }
}
