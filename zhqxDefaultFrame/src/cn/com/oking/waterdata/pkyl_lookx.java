package cn.com.oking.waterdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class pkyl_lookx {
	/**
	 * 获取x轴时间
	 * 
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static List<String> getHour(String time, int internal)
			throws Exception {

		List<String> ll = new ArrayList<String>();

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int temp = hour;

		do {
			temp += internal;
			if (temp >= 24) {
				temp -= 24;
			}
			ll.add(temp + "");
		} while (temp != hour);

		return ll;
	}

	
	public static String getData(String time, int internal)
			throws Exception {

		List<String> ll = new ArrayList<String>();

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		date = dateFormat.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int temp = hour;

		do {
			temp += internal;
			if (temp >= 24) {
				temp -= 24;
			}
			ll.add(temp + "");
		} while (temp != hour);

		return ll.toString();
	}
}