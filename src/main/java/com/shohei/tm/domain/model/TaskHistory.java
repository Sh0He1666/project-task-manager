/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * タスク履歴エンティティを表すクラスです。
 * @author shoheitokumaru
 *
 */
@Entity
@Table(name="task_history")
public class TaskHistory implements Serializable {

	//カラム情報を定義
	private String code; // pj_code + task number, varchar(20)
	private String detail; //タスクの題名 varchar(100)
	private String content; //内容 varchar(1000)
	private String problem; //課題 same as above
	private String plan; //今後の予定 same as above
	private Timestamp deadlineDate; //期日 
	private String status; // 進捗状況　0:未着手, 1:進行中 ,2:処理済み 
	private Integer progressRate; //進捗度 0 =< progressRate =< 10 

	@ManyToOne
	@JoinColumn(name="id")
	private User user; //ユーザー情報
	
	@ManyToOne
	@JoinColumn(name="id")
	private ChargeCode chargeCode; //チャージコード情報
	
	//Setter Getter	
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
	
	public void setDeadLineDate(Timestamp deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public Timestamp getDeadLineDate() {
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
}
