/**
 * 20200120 初版
 */
package com.shohei.tm.domain.model.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * DB・エンティティ間の時刻型を変換するためのコンバータクラスです
 * @author shoheitokumaru
 *
 */
@Converter(autoApply=true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> { //<Entity, DB>
	
	//Entity -> DB
	@Override
	public Date convertToDatabaseColumn(LocalDate date) {
		return date == null ? null : Date.valueOf(date);
	}
	
	//DB -> Entity
	@Override
	public LocalDate convertToEntityAttribute(Date value) {
		return value == null ? null : value.toLocalDate();
	}
}
