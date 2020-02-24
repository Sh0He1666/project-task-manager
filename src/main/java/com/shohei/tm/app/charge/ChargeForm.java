/**
 * 20200121 初版
 */
package com.shohei.tm.app.charge;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * フォームからの入力内容を受け取るクラスです。
 * @author shoheitokumaru
 *
 */
public class ChargeForm implements Serializable {
	@NotEmpty(message="記入必須項目です")
	@Size(min=1, max=20)
	@Pattern(regexp="[0-9a-zA-Z]+", message="大文字の英字を入力してください")
	private String code; //チャージコード
	
	@NotEmpty(message="記入必須項目です")
	@Size(min=1, max=20)
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
