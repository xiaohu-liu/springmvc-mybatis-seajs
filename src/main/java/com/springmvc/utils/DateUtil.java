package com.springmvc.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {

	public static final String pattern = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 
	 * convertStringDateAndTime
	 * 
	 * @description:
	 * @param dateTime
	 *            需转换的串型日期(yyyyMMddHHmmss)
	 * @return
	 */
	public static Date convertStringDateAndTime(String dateTime) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = (Date) df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static long  getCurrentMillSecond(){
		return System.currentTimeMillis()/1000;
	}

	/**
	 * 
	 * convertString_Date
	 * 
	 * @description:
	 * @param date
	 * @return
	 */
	public static Date convertString_Date(String date) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = (Date) df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 
	 * getcurrentTime当前日期
	 * 
	 * @description:
	 * @author HZG
	 * @param pattern
	 * @return
	 */
	public static final String getCurrentTime(String pattern) {

		SimpleDateFormat fam = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		String currentTime = fam.format(calendar.getTime());
		return currentTime;
	}
	
	/**
	 * 
	 * getcurrentTime当前日期
	 * 
	 * @description:
	 * @author HZG
	 * @param pattern
	 * @return
	 */
	public static final String getCurrentTime() {

		SimpleDateFormat fam = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String currentTime = fam.format(calendar.getTime());
		return currentTime;
	}

	/**
	 * 
	 * getcurrentTime转换日期格式 yyyy-mm-dd to yyyymmdd
	 * 
	 * @description:
	 * @author HZG
	 * @param pattern
	 * @return
	 */
	public static final String getFormatDate(String date) {

		if (date == null || date.length() == 0) {

			return date;
		}
		String year = date.substring(0, 4);
		int firstIndex = date.indexOf("-");
		int lastIndex = date.lastIndexOf("-");
		String month = date.substring(firstIndex + 1, lastIndex);
		String day = date.substring(lastIndex + 1);
		if (month.length() == 1) {

			month = "0" + month;
		}
		if (day.length() == 1) {

			day = "0" + day;
		}

		return year + month + day;
	}

	/**
	 * 
	 * getFirstDayOfMonth
	 * 
	 * @description: 取当月的第一天
	 * @author HZG
	 * @return
	 */
	public static String getFirstDayOfMonth() {

		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-01");

		java.util.Date firstDay = new java.util.Date();

		return format.format(firstDay);

	}

	/**
	 * 
	 * getLastDayOfMonth
	 * 
	 * @description:当前月最后一天
	 * @author HZG
	 * @return
	 */
	public static String getLastDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		java.text.Format formatter = new java.text.SimpleDateFormat("yyyy-MM-"
				+ maxDay);
		return formatter.format(cal.getTime());

	}

	/**
	 * today
	 * 
	 * @description:获取当天日期
	 * @return String:yyyy-MM-dd
	 */
	public static String today() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	/**
	 * yestoday
	 * 
	 * @description: 获取前一天日期
	 * @return String:yyyy-MM-dd
	 */
	public static String yestoday() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int d = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, d - 1);
		return sdf.format(c.getTime());
	}
	
	/**
	 * get the date string value three months later
	 * @return
	 */
	public static String threeMonthLater(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.pattern);
		int m = c.get(Calendar.MONTH);
		c.set(Calendar.MONTH, m+3);
		return sdf.format(c.getTime());
	}
	/**
	 * convertStringDate
	 * 
	 * @description:将String型日期转换成Date型
	 * @param date:需转换的串型日期(yyyy-MM-dd)
	 * @return Date
	 */
	public static Date convertStringDate(String date) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = (Date) df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * get the Date object one day after the of date given
	 * @param d
	 * 			parameter date given to according to 
	 * @return
	 */
	public static Date nextDay(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.DAY_OF_YEAR,
				(calendar.get(Calendar.DAY_OF_YEAR) + 1));
		return calendar.getTime();
	}
	
	/**
	 * get the Date object one month after the  month given
	 * @param d
	 * 		parameter date given to according to 
	 * @return
	 */
	public static Date nextMonth(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.MONTH,
				(calendar.get(Calendar.MONTH) + 1));
		return calendar.getTime();
	}
	
	
	/**
	 * get the Date object one year after the date given
	 * @param d
	 * 		parameter date given to according to 
	 * @return
	 */
	public static Date nextYear(Date d){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.set(Calendar.YEAR,
				(calendar.get(Calendar.YEAR) + 1));
		return calendar.getTime();
	}

	/**
	 * 获得当前时间。由于freemarker的日期必须有具体类型，所以使用timestamp。
	 * 
	 * @return
	 */
	public static java.sql.Timestamp now() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * 日期格式化
	 * 
	 * @param date
	 * @param pattern
	 *            the pattern describing the date and time format
	 * @return
	 * @author SunWenbao 2009-06-25
	 */
	public static String date2String(Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat df = new SimpleDateFormat(pattern);
		String d = df.format(date);
		return d;
	}

	/**
	 * 两个日期之间相隔天数的共通
	 * 
	 * @param from
	 *            开始时间
	 * @param to
	 *            终了时间
	 * @return 天数
	 * @author SunWenbao 2009-07-01
	 */
	public static Integer getDaysBetweenTwoDates(Date dtFrom, Date dtEnd) {
		long begin = dtFrom.getTime();
		long end = dtEnd.getTime();
		long inter = end - begin;
		int flag = 1;
		if (inter < 0) {
			inter = inter * (-1);
			flag = flag * (-1);
		}
		long dateMillSec = 24 * 60 * 60 * 1000;

		long dateCnt = inter / dateMillSec;

		long remainder = inter % dateMillSec;
		
		if (remainder!= 0&&dateCnt!=0) {
			dateCnt++;
		}
		return flag * (int) dateCnt;
	}
	
	public static Integer getDaysBetweenTowTimestamp(Timestamp tsFrom,Timestamp tsEnd){
		long begin = tsFrom.getTime();
		long end = tsEnd.getTime();
		long inter = end - begin;
		int flag = 1;
		if (inter < 0) {
			inter = inter * (-1);
			flag = flag * (-1);
		}
		long dateMillSec = 24 * 60 * 60 * 1000;

		long dateCnt = inter / dateMillSec;

		long remainder = inter % dateMillSec;

		if (remainder != 0) {
			dateCnt++;
		}
		return flag * (int) dateCnt;
	}

	public final static java.sql.Timestamp string2Time(String dateString)
			throws java.text.ParseException {
		Date timeDate = null;
		DateFormat df = new SimpleDateFormat(pattern);
		try {
			timeDate = (Date) df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}
	public static void main (String[] args){
		
		System.out.println(DateUtil.getCurrentTime("yyyy"));
		System.out.println(DateUtil.now());
		System.out.println(DateUtil.now().getTime());
		Date now  = new Date(DateUtil.now().getTime());
	    Date nextday = DateUtil.nextDay(now);
	    System.out.println(nextday.getTime());
	    System.out.println(DateUtil.getDaysBetweenTwoDates(now, nextday));
		System.out.println();
		
		System.out.println(DateUtil.date2String(nextYear(new Date()),pattern));
		System.out.println(new Date().getTime());
		
		
	}
}
