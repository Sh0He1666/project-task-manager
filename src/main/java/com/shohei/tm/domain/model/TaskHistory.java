/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * タスク履歴エンティティを表すクラスです。
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="task_history")
public class TaskHistory implements Serializable {

	//カラム情報を定義
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(length=20, nullable=false)
	private String code; // pj_code + task number, varchar(20)
	
	@NotNull
	@Column(length=100, nullable=false)
	private String detail; //タスクの題名 varchar(100)

	@Column(length=1000, nullable=true)
	private String content; //内容 varchar(1000)

	@Column(length=1000, nullable=true)
	private String problem; //課題 same as above

	@Column(length=1000, nullable=true)
    private String plan; //今後の予定 same as above

	@Column(name="deadline_dt", columnDefinition = "DATE" ,nullable=true)
	private LocalDate deadlineDate; //期日 
	
	@Column(length=2, nullable=false)
	private String status; // 進捗状況　0:未着手, 1:進行中 ,2:処理済み 
	
	@Column(name="progress_rt")
	private Integer progressRate; //進捗度 0 =< progressRate =< 10 

	@ManyToOne
	@NotNull
	@JoinColumn(name="user_id")
	private User user; //ユーザー情報
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="project_id")
	private Project projectId; //プロジェクト情報
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="charge_code_id")
	private ChargeCode chargeCode; //チャージコード情報
	
	//Setter Getter	
	public void setId(Integer id) {
		this.id = id;
		}
	public Integer getId() {
		return this.id;
		}
	
	public void setCode(String code) {
		this.code = code;
		}
	public String getCode() {
		return this.code;
		}
	
	public void setDetail(String detail) {
		this.detail = detail;
		}
	public String getDetail() {
		return this.detail;
		}

	public void setContent(String content) {
		this.content = content;
		}
	public String getContent() {
		return this.content;
		}
	
	public void setProblem(String problem) {
		this.problem = problem;
		}
	public String getProblem() {
		return this.problem;
		}	
	
	public void setPlan(String plan) {
		this.plan = plan;
		}
	public String getPlan() {
		return this.plan;
		}	
	
	public void setDeadlineDate(LocalDate deadlineDate) {
		this.deadlineDate = deadlineDate;
		}
	public LocalDate getDeadlineDate() {
		return this.deadlineDate;
		}
	
	public void setStatus(String status) {
		this.status = status;
		}
	public String getStatus() {
		return this.status;
		}		

	public void setProgressRate(Integer progressRate) {
		this.progressRate = progressRate;
		}
	public Integer getProgressRate() {
		return this.progressRate;
		}
	
	public void setUser(User user) {
		this.user = user;
		}
	public User getUser() {
		return this.user;
		}
	
	public void setChargeCode(ChargeCode chargeCode) {
		this.chargeCode = chargeCode;
		}
	public ChargeCode getChargeCode() {
		return this.chargeCode;
		}
	
	public void setProjectId(Project projectId) {
		this.projectId = projectId;
		}
	public Project getProjectId() {
		return this.projectId;
		}
}
