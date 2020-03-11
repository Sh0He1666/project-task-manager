package com.shohei.tm.app.converter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 文字列型→LocalDate型に変換するメソッドのあつまり
 * @author shoheitokumaru
 *
 */
public class LocalDateConverter {

	/**
	 * 文字列の日付をフォーマット(yyyyMMddやyyyy/mm/ddなど)をもとにLocalDate型に変換するメソッド
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static LocalDate convertToLocalDate(String year, String month, String day, String format) {
		// シンプルにLocalDate型に変換された日付を返却
		String date = year + month + day;
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
		}
	
	/**
	 * 現在時刻をベースに引数に指定した日数分計算して出力するメソッド
	 * 
	 */
	public static LocalDate convertToLocalDateByCalcDays(int calcDays, String format) {
		// カレンダークラスで現在日時を演算
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_WEEK, calcDays);

		// 取得した年月日をStringのyyyymmddに変更
		Date target = calendar.getTime();
		String strDate =  new SimpleDateFormat(format).format(target);
		return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(format));
		} 

	/**
	 * 引数に受け取った年月日を基準に年月日を出力する
	 * 
	 */
	public static LocalDate convertToLocalDateByCalcDays(LocalDate date, int calcDays, String format) {
		// カレンダークラスで現在日時を演算
		Calendar calendar = Calendar.getInstance();

		if (date == null) {
			calendar.setTime(new Date());//入力無しの場合はデフォで現在日時
		} else {
			calendar.setTime(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		}
		
		calendar.add(Calendar.DAY_OF_WEEK, calcDays);
		// 取得した年月日をStringのyyyymmddに変更
		Date target = calendar.getTime();
		String strDate =  new SimpleDateFormat(format).format(target);
		return LocalDate.parse(strDate, DateTimeFormatter.ofPattern(format));
		} 
	
	/**
	 * 文字列の年月日→LocalDateに変換
	 * yyyy-mm-dd, yyyy/mm/ddに対応
	 */
	public static LocalDate convertToLocalDateFromStr(String str_date, String format) {
		String v = null;

		if (str_date.contains("-")) {
			v = str_date.replace("-", "");
		} else if (str_date.contains("/")) {
			v = str_date.replace("/","");
		}
		
		return LocalDate.parse(v, DateTimeFormatter.ofPattern(format));
		}
	
}