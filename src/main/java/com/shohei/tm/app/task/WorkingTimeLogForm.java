/**
 * 2020.03.13 初版
 */

package com.shohei.tm.app.task;

import javax.validation.constraints.NotNull;

/**
 * 不要？
 * @author shoheitokumaru
 *
 */
public class WorkingTimeLogForm {
	
	@NotNull
	private String taskUID; //task_history.code + task_history.detail
	
	@NotNull
	private String ssFlg; // 作業開始：on, 作業終了：off
	
	@NotNull
	private String ssName; // 作業中、停止中
	
	// Setter Getter
	
	public void setTaskUID(String taskUID) {
		this.taskUID = taskUID;
	}
	public String getTaskUID() {
		return this.taskUID;
	}
	
	public void setSsFlg(String ssFlg) {
		this.ssFlg = ssFlg;
	}
	public String getSsFlg() {
		return this.ssFlg;
	}

	public void setSsName(String ssName) {
		this.ssName = ssName;
	}
	public String getSsName() {
		return this.ssName;
	}
}
