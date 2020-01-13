/**
 * 20200113 初版
 * 
 */

package com.shohei.tm.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * プロジェクトエンティティを表すクラスです
 * @author shoheitokumaru
 *
 */
@Entity
public class Project implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //プロジェクトID
	
	private String code; //プロジェクトコード
	
	private String name; //プロジェクト名
	
	private Timestamp registered_dt; //登録日
	
	//Setter Getter
	
	//ID
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//code
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	//name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//registered Date
	public Timestamp getRegisteredDate() {
		return this.registered_dt;
	}
	public void setCode(Timestamp registered_dt) {
		this.registered_dt = registered_dt;
	}
}
