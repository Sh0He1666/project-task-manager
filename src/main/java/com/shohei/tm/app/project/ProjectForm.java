/**
 * 20200121 初版
 */
package com.shohei.tm.app.project;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * フォームからの入力内容を受け取るクラスです。
 * @author shoheitokumaru
 *
 */
public class ProjectForm implements Serializable {
	@Size(min=1, max=20, message="")
	@Pattern(regexp="[A-Z]+", message="未記入か、大文字のアルファベト以外を記載しています。")
	private String code; //プロジェクトコード
	
	@Size(min=1, max=20, message="未記入か、20文字を超えています")
	private String name; //プロジェクト名
	
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
