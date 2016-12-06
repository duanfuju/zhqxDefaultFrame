package cn.com.oking.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


public class SystemControListener  {

	@Resource
	private MonitorMsgDao monitorMsgDao;
	

	@Transactional
	public void pushErrorMessage() {
		System.out.println("------开始扫描异常日志------");
		List<MonitorMsg> ml = monitorMsgDao.getSendList(); 
		if(ml!=null && ml.size()>0){
			System.out.println("------发现数据异常---开始发送短信------");
			for(MonitorMsg mm:ml){
				String list = mm.getPhonenum();
				String msg = mm.getContent();
				CmccSend.sendCmcc(list,msg);
				monitorMsgDao.push(mm.getMessageid());
			}
			System.out.println("------异常短信提醒发布结束------");
		}else{
			System.out.println("------未发现数据异常------");
		}
	}

}
