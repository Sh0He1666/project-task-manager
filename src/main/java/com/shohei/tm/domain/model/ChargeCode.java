/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * チャージコードエンティティを表すクラスです
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="charge_code")
public class ChargeCode implements Serializable {
	//カラム情報を定義
	private Integer id; //Charge Code  
	private String code; //Charge Code varchar(20) ex) F001, E, etc..
	private String name; //Charge Code Name varchar(20) ex) 保守
	
	//Setter Getter
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setId(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}