/**
 * 
 */
package cn.com.oking.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
 
/** 
* @ClassName: 	DateUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2015-2-6 上午11:51:22 
* Company:		OKING 广东奥博信息产业有限公司  版权所有
* QQContact:    点击链接加入群【ITTeam】：http://jq.qq.com/?_wv=1027&k=WTydpC 
*/
public class DateUtil {
	
	//MMM d,yyyy K:mm:ss aa
	/**
	 *  英文 将字符串格式化回Date类型
	 * @param dateStr  时间字符串
	 * @param formatStr  格式化字符
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
