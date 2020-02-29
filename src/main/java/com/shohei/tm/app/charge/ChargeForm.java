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

	@Pattern(regexp="[0-9a-zA-Z]+", message="未記入か、英数字以外の記入があります。")
	@Size(min=1, max=20, message="")
	private String code; //チャージコード
	

	@NotEmpty(message="")
	@Size(min=1, max=20, message="未記入か、20文字を超えています")
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
