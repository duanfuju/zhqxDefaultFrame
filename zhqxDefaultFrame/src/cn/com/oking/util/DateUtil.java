/**
 * 
 */
package cn.com.oking.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
 
/** 
* @ClassName: 	DateUtil 
* @Description: TODO(������һ�仰��������������) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2015-2-6 ����11:51:22 
* Company:		OKING �㶫�²���Ϣ��ҵ���޹�˾  ��Ȩ����
* QQContact:    ������Ӽ���Ⱥ��ITTeam����http://jq.qq.com/?_wv=1027&k=WTydpC 
*/
public class DateUtil {
	
	//MMM d,yyyy K:mm:ss aa
	/**
	 *  Ӣ�� ���ַ�����ʽ����Date����
	 * @param dateStr  ʱ���ַ���
	 * @param formatStr  ��ʽ���ַ�
	 * @return
	 */
	public static Date englishParse(String dateStr,String formatStr){
		try {
			SimpleDateFormat sf = new SimpleDateFormat(formatStr,Locale.ENGLISH);
			return sf.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
