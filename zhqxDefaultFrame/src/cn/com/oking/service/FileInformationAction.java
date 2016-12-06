/**
 * 
 */
package cn.com.oking.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.dao.SysFileInformationDao;
import cn.com.oking.entity.SysFileInformation;
import cn.com.oking.util.KeyUtil;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;

/** 
* @ClassName: 	FileInformationAction 
* @Description: TODO(������һ�仰��������������) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2015-2-3 ����9:21:16 
* Company:		OKING �㶫�²���Ϣ��ҵ���޹�˾  ��Ȩ����
* QQContact:    ������Ӽ���Ⱥ��ITTeam����http://jq.qq.com/?_wv=1027&k=WTydpC 
*/
@Component
public class FileInformationAction {
	
	@Resource
	public SysFileInformationDao sysFileInformationDao;
	
	@DataResolver
	@Transactional
	public void saveInformateion(SysFileInformation informateion){
		if(informateion.getId() == null || informateion.getId().equals("")){
			informateion.setId(KeyUtil.getKeyBefore("file"));
		}
		sysFileInformationDao.save(informateion);
	}
	
	@DataProvider
	@Transactional
	public SysFileInformation getInformationByAss(String assId){
		List<SysFileInformation> sl = sysFileInformationDao.find("from SysFileInformation where associationId = '"+assId+"'");
		if(sl.size()>0){  //fileInformationAction#getInformationByAss
			return sl.get(0);
		}
		return null;
	}
	
	/**
	 * ɾ���ļ�
	 * @param assId
	 */
	@DataResolver
	@Transactional
	public void delfileInformationActionByAss(String assId){
		List<SysFileInformation> sl = sysFileInformationDao.find("from SysFileInformation where associationId = '"+assId+"'");
		if(sl.size()>0){  //fileInformationAction#getInformationByAss
			SysFileInformation s =  sl.get(0);
			delFilePath(s.getSavaPath(),s.getRealName(),s.getAssociationId());
			sysFileInformationDao.delete(s);
		}
	}
	
	/**
	 * ɾ��ͼƬ��ͬ��ɾ������ͼ
	 * @param assId
	 */
	@DataResolver
	@Transactional
	public void delfileInformationActionByAssImg(String assId){
		List<SysFileInformation> sl = sysFileInformationDao.find("from SysFileInformation where associationId = '"+assId+"'");
		if(sl.size()>0){  //fileInformationAction#getInformationByAss
			SysFileInformation s =  sl.get(0);
			delFilePath(s.getSavaPath(),s.getRealName(),s.getAssociationId());
			delFilePath(s.getSavaPath(),"small\\"+s.getRealName(),s.getAssociationId());
			sysFileInformationDao.delete(s);
		}
	}
	
	
	private static void delFilePath(String savePath,String realName,String fileid){
		if(new File(savePath+"\\"+realName).exists()){
			new File(savePath+"\\"+realName).delete();
		}
		if(new File(savePath+"\\"+fileid+".png").exists()){
			new File(savePath+"\\"+fileid+".png").delete();
		}
	}
}
