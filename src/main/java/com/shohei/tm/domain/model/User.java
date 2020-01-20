/**
 * 20200116 初版
 * 
 */
package com.shohei.tm.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * ユーザーエンティティを表すクラスです
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="account_user")
public class User implements Serializable{
	//カラム情報を定義
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //UserId Primary Key
	@NotNull
	@Column(length=20, nullable=false)
	private String name; //User Name varchar(20)
	@NotNull
	@Column(name="passwd", length=20, nullable=false)
	private String password; //Pass word varchar(20)
	@Column(name="last_login_dt")
	private Timestamp lastLoginDate=null; //Not Necessary
	
	@Enumerated(EnumType.STRING)
	private RoleName roleName;
	
	//Getter Setter 
	public void setId(Integer id) {
		this.id = id;
		}
	public Integer getId() {
		return this.id;
	}	
	
	public void setName(String name) {
		this.name = name;
		}
	public String getName() {
		return this.name;
	}	
	
	public void setPassword(String password) {
		this.password = password;
		}
	public String getPassword() {
		return this.password;
	}	
	
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
		}
	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}	
	
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName=roleName;
	}
}
