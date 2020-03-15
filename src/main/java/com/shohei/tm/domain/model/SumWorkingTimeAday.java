/**
 * 2020.03.14 初版
 */
package com.shohei.tm.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="sum_working_time_aday")
public class SumWorkingTimeAday {
	
	//カラム情報
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String taskUID;
	
	@NotNull
	@Column(name="date", columnDefinition = "DATE")
	private LocalDate date;
	
	@NotNull
	@Column(name="sum_wktime")
	private String sumWkTime;
	
	// Setter Getter

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

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getDate() {
		return date;
	}
	
	public String getSumWkTime() {
		return this.sumWkTime;
	}
	public void setSumWkTime(String sumWkTime) {
		this.sumWkTime = sumWkTime;
	}
 }
