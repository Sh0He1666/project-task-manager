/*
 * 2020.03.08 初版
 */

package com.shohei.tm.domain.model;

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
	private String ss_flg;
	
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
		return this.ss_flg;
	}
	public void setId(String ss_flg) {
		this.ss_flg = ss_flg;
	}
}
