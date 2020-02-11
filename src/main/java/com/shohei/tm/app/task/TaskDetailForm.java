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
	
	@Column(length=1000, nullable=true)
	private String content;
	
	@Column(length=1000, nullable=true)
	private String problem; //課題 same as above

	@Column(length=1000, nullable=true)
    private String plan; //今後の予定 same as above

	// Setter Getter
	
	public void setId(Integer id) {
		this.id = id;
		}
	public Integer getId() {
		return this.id;
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
