package com.shohei.tm.app.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
}