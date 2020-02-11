/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.app.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shohei.tm.domain.model.Project;
import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.service.project.ProjectService;
import com.shohei.tm.domain.service.task.TaskService;

/**
 * タスクに関するリクエストを受けるコントローラークラス
 * @author shoheitokumaru
 *
 */
@RequestMapping("task/edit/{id}")
@Controller
public class TaskDetailController {
	@Autowired
	TaskService taskService;
	@Autowired
	ProjectService projectService;
	
	/**
	 * タスク詳細編集画面→データ更新→タスク詳細編集画面
	 * 渡す値：task_history.id
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	String updateTaskDetail(
			//フォームで入力された情報を保持
			@Validated TaskDetailForm form, 
			//フォームクラスの入力チェック結果を保持
			BindingResult bindingResult,
			//@PathVariable リクエストパラメータ"roomId"に入っている値を取得する
			@PathVariable("id") Integer id, 
			Model model			
			) {
		
		if (bindingResult.hasErrors()) {
			return "redirect:/task/{id}";
		}
		
		//フォームの入力値を取得
		String content = form.getContent();
		String problem = form.getProblem();
		String plan = form.getPlan();
		
		//データを更新
		taskService.updateTaskDetailById(content, problem, plan, id);
		return "redirect:/task/{id}";
	}
	
	//リクエストパラメータをバインドする
	@ModelAttribute
	TaskDetailForm setUpTaskDetailForm() {
		TaskDetailForm form = new TaskDetailForm();
		return form;
	}
}
