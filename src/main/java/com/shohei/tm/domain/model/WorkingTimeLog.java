/*
 * 2020.03.08 初版
 */

package com.shohei.tm.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="working_time_log")
public class WorkingTimeLog {
	
	//カラム情報を定義
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String taskUID;
	
	@NotNull
	@Column(name="ss_flg")
	private String ssFlg;
	
	@NotNull
	@Column(name="ss_name")
	private String ssName;
	
	@Column(name="registered_dt", columnDefinition = "TIMESTAMP")
	private LocalDateTime registeredDate;
	
	//Setter, Getter
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTaskUID() {
		return this.taskUID;
	}
	public void setTaskUID(String taskUID) {
		this.taskUID = taskUID;
	}
	
	public String getSsFlg() {
		return this.ssFlg;
	}
	public void setSsFlg(String ssFlg) {
		this.ssFlg = ssFlg;
	}
	
	public String getSsName() {
		return this.ssName;
	}
	public void setSsName(String ssName) {
		this.ssName = ssName;
	}
	
	public LocalDateTime getRegisteredDate() {
		return this.registeredDate;
	}
	public void setRegisteredDate(LocalDateTime registeredDate) {
		this.registeredDate = registeredDate;
	}
}
