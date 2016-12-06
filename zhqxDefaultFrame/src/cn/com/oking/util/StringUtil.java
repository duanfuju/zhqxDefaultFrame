/**
 * 
 */
package cn.com.oking.util;

import java.util.List;

/**
 * @ClassName: StringUtil
 * @Description: TODO(String工具类)
 * @author: Ctt http://weibo.com/u/3227366511
 * @date: 2014-12-26 下午4:49:26 Company: OKING 广东奥博信息产业有限公司 版权所有 QQContact:
 *        点击链接加入群【ITTeam】：http://jq.qq.com/?_wv=1027&k=WTydpC
 */
public class StringUtil {

	public static String changNull(Object obj) {
		String s = "";
		if (obj != null) {
			s = (String) obj;
		}
		return s;
	}

	public static boolean isNotEmpty(String s) {
		if (s != null && !s.equals("") && !s.equals("null")
				&& !s.equals("undefined")) {
			return true;
		}
		return false;
	}

	/**
	 * 将字符创用特定字符拼接
	 * 
	 * @param ls
	 *            字符创组
	 * @param sub
	 *            分隔符
	 * @return
	 */
	public static String changeListToStirng(List<String> ls, String sub) {
		String str = "";
		for (String s : ls) {
			str = str + s + sub;
		}
		return str;
	}

	public static String getSubString(String str, int start, int end) {
		str = str.substring(start, end);
		return str;
	}

	public static String replaceWord(String s) {
		s = s.trim();
		String b = "";
		if (s != null && !s.equals("")) {
			String message = s.substring(0, s.length() - 1);
			String end = s.substring(s.length() - 1);
			message = message.replaceAll("，", ", ");
			message = message.replaceAll("；", "; ");
			message = message.replaceAll("。", "; ");
			b = message + end;
		}
		return b;
	}

	public static String changeColor(String color) {

		if (color.equals("白色")) {
			color = "#FFFFFF";
		} else if (color.equals("黑色")) {
			color = "#000000";
		} else if (color.equals("红色")) {
			color = "#FF0000";
		} else if (color.equals("金色")) {
			color = "#FFF8DC";
		} else if (color.equals("黄色")) {
			color = "#FFD700";
		} else if (color.equals("灰色")) {
			color = "#666666";
		} else if (color.equals("皇家蓝")) {
			color = "#6495ED";
		} else if (color.equals("天蓝色")) {
			color = "#f0ffff";
		} else {
			color = "#FFD700";
		}

		return color;
	}

	public static String changeDefault(String isdefault) {

		if (isdefault.equals("否")) {
			isdefault = "no";
		} else {
			isdefault = "yes";
		}

		return isdefault;
	}

	public static String changeRefresh(String refresh) {

		if (refresh.equals("15分钟/次")) {
			refresh = "900";
		} else if (refresh.equals("30分钟/次")) {
			refresh = "1800";
		} else if (refresh.equals("60分钟/次")) {
			refresh = "3600";
		} else {
			refresh = "300";
		}

		return refresh;
	}

	public static String changeTimeid(String temp) {

		if(temp.equals("样式一")){
			temp="time1";
		}else if(temp.equals("样式二")){
			temp="time2";
		}else{
			temp="time3";
		}
		
		return temp;
	}
	
	 public static String changeZero(Object obj){
		 String s = "0";
			if(obj != null ){
				s = obj.toString();
			}
			return s;
	 }

}
