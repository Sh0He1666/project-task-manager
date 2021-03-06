/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * チャージコードエンティティを表すクラスでsu
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="code")
public class Code implements Serializable {
	//カラム情報を定義
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; //Charge Code  
	@NotNull
	@Column(length=20, nullable=false)
	private String genre; //Charge Code varchar(20) ex) F001, E, etc..
	@NotNull
	@Column(length=20, nullable=false)
	private String code; //Charge Code varchar(20) ex) F001, E, etc..
	@NotNull
	@Column(length=20, nullable=false)
	private String name; //Charge Code Name varchar(20) ex) 保守
	
	//Setter Getter
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getGenre() {
		return this.genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
