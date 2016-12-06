package cn.com.oking.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


public class SystemControListener  {

	@Resource
	private MonitorMsgDao monitorMsgDao;
	

	@Transactional
	public void pushErrorMessage() {
		System.out.println("------��ʼɨ���쳣��־------");
		List<MonitorMsg> ml = monitorMsgDao.getSendList(); 
		if(ml!=null && ml.size()>0){
			System.out.println("------���������쳣---��ʼ���Ͷ���------");
			for(MonitorMsg mm:ml){
				String list = mm.getPhonenum();
				String msg = mm.getContent();
				CmccSend.sendCmcc(list,msg);
				monitorMsgDao.push(mm.getMessageid());
			}
			System.out.println("------�쳣�������ѷ�������------");
		}else{
			System.out.println("------δ���������쳣------");
		}
	}

}
