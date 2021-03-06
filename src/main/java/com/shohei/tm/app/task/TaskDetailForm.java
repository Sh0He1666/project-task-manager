/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.app.task;

import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shohei.tm.domain.model.Project;
import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.service.project.ProjectService;
import com.shohei.tm.domain.service.task.TaskService;

/**
 * タスク詳細に関するリクエストを受けるコントローラークラス
 * @author shoheitokumaru
 *
 */

public class TaskDetailForm {
	
	private Integer id;
	
    private String status; // 進捗状況　0:未着手, 1:進行中 ,2:処理済み 
	
	private String progressRate; //進捗度 0 =< progressRate =< 10 
	
	@Column(length=1000, nullable=true)
	private String content;
	
	@Column(length=1000, nullable=true)
	private String problem; //課題 same as above

	@Column(length=1000, nullable=true)
    private String plan; //今後の予定 same as above
	
	private String year;

	private String month;

	private String day;

	
	// Setter Getter
	
	public void setId(Integer id) {
		this.id = id;
		}
	public Integer getId() {
		return this.id;
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
}
