/**
 * 
 */
package cn.com.oking.util;

import java.util.List;

/**
 * @ClassName: StringUtil
 * @Description: TODO(String������)
 * @author: Ctt http://weibo.com/u/3227366511
 * @date: 2014-12-26 ����4:49:26 Company: OKING �㶫�²���Ϣ��ҵ���޹�˾ ��Ȩ���� QQContact:
 *        ������Ӽ���Ⱥ��ITTeam����http://jq.qq.com/?_wv=1027&k=WTydpC
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
	 * ���ַ������ض��ַ�ƴ��
	 * 
	 * @param ls
	 *            �ַ�����
	 * @param sub
	 *            �ָ���
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
			message = message.replaceAll("��", ", ");
			message = message.replaceAll("��", "; ");
			message = message.replaceAll("��", "; ");
			b = message + end;
		}
		return b;
	}

	public static String changeColor(String color) {

		if (color.equals("��ɫ")) {
			color = "#FFFFFF";
		} else if (color.equals("��ɫ")) {
			color = "#000000";
		} else if (color.equals("��ɫ")) {
			color = "#FF0000";
		} else if (color.equals("��ɫ")) {
			color = "#FFF8DC";
		} else if (color.equals("��ɫ")) {
			color = "#FFD700";
		} else if (color.equals("��ɫ")) {
			color = "#666666";
		} else if (color.equals("�ʼ���")) {
			color = "#6495ED";
		} else if (color.equals("����ɫ")) {
			color = "#f0ffff";
		} else {
			color = "#FFD700";
		}

		return color;
	}

	public static String changeDefault(String isdefault) {

		if (isdefault.equals("��")) {
			isdefault = "no";
		} else {
			isdefault = "yes";
		}

		return isdefault;
	}

	public static String changeRefresh(String refresh) {

		if (refresh.equals("15����/��")) {
			refresh = "900";
		} else if (refresh.equals("30����/��")) {
			refresh = "1800";
		} else if (refresh.equals("60����/��")) {
			refresh = "3600";
		} else {
			refresh = "300";
		}

		return refresh;
	}

	public static String changeTimeid(String temp) {

		if(temp.equals("��ʽһ")){
			temp="time1";
		}else if(temp.equals("��ʽ��")){
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
