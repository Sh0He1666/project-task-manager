/**
 * 20200120 初版
 */
package com.shohei.tm.domain.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * DB・エンティティ間の時刻型を変換するためのコンバータクラスです
 * @author shoheitokumaru
 *
 */
@Converter(autoApply=true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	
	//Entity -> DB
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		return dateTime == null ? null : Timestamp.valueOf(dateTime);
	}
	
	//DB -> Entity
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp value) {
		return value == null ? null :value.toLocalDateTime();
	}

}
