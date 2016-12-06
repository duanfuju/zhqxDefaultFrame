/**
 * 
 */
package cn.com.oking.util;
 
import java.io.UnsupportedEncodingException;

/** 
* @ClassName: 	StringChineseUn 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2015-2-4 上午11:04:22 
* Company:		OKING 广东奥博信息产业有限公司  版权所有
* QQContact:    点击链接加入群【ITTeam】：http://jq.qq.com/?_wv=1027&k=WTydpC 
*/
public class StringChineseUn {
	public static void test(String testStr) {
	    try {
	        System.out.println(new String(testStr.getBytes("ISO8859-1"),"UTF-8"));
	    	
	    	// 得到指定编码的字节数组 字符串--->字节数组
	    	
	    	
//	        byte[] t_iso = testStr.getBytes("ISO8859-1");
//	        byte[] t_gbk = testStr.getBytes("GBK");
//	        byte[] t_utf8 = testStr.getBytes("UTF-8");
//	        System.out.println("使用ISO解码..." + t_iso.length);
//	        System.out.println("使用GBK解码..." + t_gbk.length);
//	        System.out.println("使用UTF8解码..." + t_utf8.length);
//	        // 解码后在组装
//	        String ut_iso = new String(t_iso, "ISO8859-1");
//	        String ut_gbk = new String(t_gbk, "GBK");
//	        String ut_utf8 = new String(t_utf8, "UTF-8");
//	        System.out.println("使用ISO解码后再用ISO组装..." + ut_iso);
//	        System.out.println("使用GBK解码后再用GBK组装..." + ut_gbk);
//	        System.out.println("使用UTF8解码后再用UTF8组装..." + ut_utf8);
//	        // 有时候要求必须是iso字符编码类型
//	        // 可以先用GBK/UTF8编码后，用ISO8859-1组装成字符串，解码时逆向即可获得正确中文字符
//	        String t_utf8Toiso = new String(t_utf8, "ISO8859-1");
//	        // 将iso编码的字符串进行还原
//	        String ut_utf8Toiso = new String(t_utf8Toiso.getBytes("ISO8859-1"),"UTF-8");
//	        System.out.println("使用ISO组装utf8编码字符..." + t_utf8Toiso);
//	        System.out.println("使用ISO解码utf8编码字符..." + ut_utf8Toiso);
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	}
	
}
