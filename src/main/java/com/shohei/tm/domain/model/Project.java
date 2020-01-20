/**
 * 20200113 初版
 * 
 */

package com.shohei.tm.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.sun.istack.NotNull;

/**
 * プロジェクトエンティティを表すクラスです
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="project")
public class Project implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //プロジェクトID
	@NotNull
	@Column(length=20, nullable=false)
	private String code; //プロジェクトコード
	@NotNull
	@Column(length=20, nullable=false)
	private String name; //プロジェクト名
	
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
