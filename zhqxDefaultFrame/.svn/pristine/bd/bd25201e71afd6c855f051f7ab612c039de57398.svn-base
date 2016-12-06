/**
 * 
 */
package cn.com.oking.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
/** 
* @ClassName: 	ConfigUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2015-2-4 上午12:46:01 
* Company:		OKING 广东奥博信息产业有限公司  版权所有
* QQContact:    点击链接加入群【ITTeam】：http://jq.qq.com/?_wv=1027&k=WTydpC 
*/
public class ConfigUtil {
	
		public ConfigUtil(){}
		private static Properties props = new Properties(); 
		static{
			try {
				props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static String getValue(String key){
			return props.getProperty(key);
		}

	    public static void updateProperties(String key,String value) {    
	            props.setProperty(key, value); 
	    } 
	
}
