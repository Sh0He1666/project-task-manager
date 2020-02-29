/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.app.task;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.shohei.tm.app.converter.LocalDateConverter;
import com.shohei.tm.domain.model.ChargeCode;
import com.shohei.tm.domain.model.Project;


/**
 * タスク詳細に関するリクエストを受けるコントローラークラス
 * @author shoheitokumaru
 *
 */

public class TaskForm {
		
	private Integer id;//多分なくてもOK
	
	@NotNull
	private Project projectId; //プロジェクトコードのPK
	
	@Size(min=1, max=20, message="未記入か、数字以外の記載があります。")
	private String projectCodeId; //プロジェクトコードに付加されるID
	
	@Column(length=20, nullable=false)
	private String code; //タスクコード

	@NotNull
	private ChargeCode chargeId; //チャージコードのPK
	
	@NotNull
	@Size(min=1, max=100, message="未記入か、文字数が100を超えています。")
	private String detail; //タスクの題名 varchar(100)

	@Column(name="deadline_dt", columnDefinition = "DATE" ,nullable=true)
	private LocalDate deadlineDate; //期日 
	
	private String year;

	private String month;

	private String day;

	@Column(length=2, nullable=false)
	private String status; // 進捗状況　0:未着手, 1:進行中 ,2:処理済み 

	@Column(name="progress_rt")
	private String progressRate; //進捗度 0 =< progressRate =< 10 
	
	Project project;
	
	//Setter Getter		
	public void setId(Integer id) {
		this.id = id;
		}
	public Integer getId() {
		return this.id;
		}	

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
		}
	public Project getProjectId() {
		return this.projectId;
		}

	public void setProjectCodeId(String projectCodeId) {
		this.projectCodeId = projectCodeId;
		}
	public String getProjectCodeId() {
		return this.projectCodeId;
		}
	/**
	public void setCode(Integer projectId, String projectCodeId) {
		this.code = project.getCodeById(projectId) + "_" + projectCodeId;
		}
	public String getCode() {
		return this.code;
		} **/
    /**
	public void setCode() {
		this.code = project.getCodeById(this.getProjectId().getId()) + "_" + this.getProjectCodeId();
		}
	public String getCode() {
		return this.code;
		}**/ 

	
	public void setChargeId(ChargeCode chargeId) {
		this.chargeId = chargeId;
		}
	public ChargeCode getChargeId() {
		return this.chargeId;
		}	
	
	public void setDetail(String detail) {
		this.detail = detail;
		}
	public String getDetail() {
		return this.detail;
		}
	/**
	public void setDeadlineDate() {
		LocalDateConverter conv = new LocalDateConverter();
		this.deadlineDate = conv.convertToLocalDate(this.getYear(), this.getMonth(), this.getDay(), this.FORMAT);
		}
	public LocalDate getDeadlineDate() {
		return this.deadlineDate;
		}**/
	
	public void setYear(String year) {
		this.year = year;
		}
	public String getYear() {
		return this.year;
		}
	
	public void setMonth(String month) {
		this.month = month;
		}
	public String getMonth() {
		return this.month;
		}

	public void setDay(String day) {
		this.day = day;
		}
	public String getDay() {
		return this.day;
		}
	
	public void setStatus(String status) {
		this.status = status;
		}
	public String getStatus() {
		return this.status;
		}		

	public void setProgressRate(String progressRate) {
		this.progressRate = progressRate;
		}
	public String getProgressRate() {
		return this.progressRate;
		}
}
