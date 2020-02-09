/**
 * 20200121 初版
 */
package com.shohei.tm.app.project;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * フォームからの入力内容を受け取るクラスです。
 * @author shoheitokumaru
 *
 */
public class ProjectForm implements Serializable {
	@NotNull(message="記入必須項目です")
	private String code; //プロジェクトコード
	
	@NotNull(message="記入必須項目です")
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
