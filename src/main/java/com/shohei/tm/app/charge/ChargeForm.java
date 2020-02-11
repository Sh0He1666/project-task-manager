/**
 * 20200121 初版
 */
package com.shohei.tm.app.charge;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * フォームからの入力内容を受け取るクラスです。
 * @author shoheitokumaru
 *
 */
public class ChargeForm implements Serializable {
	@NotNull(message="記入必須項目です")
	private String code; //チャージコード
	
	@NotNull(message="記入必須項目です")
	private String name; //チャージ名
	
	//Setter Getter 
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
