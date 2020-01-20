/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.app.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@Controller
@RequestMapping("/task")
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	ProjectService projectService;
	
	/**
	//タスク一覧を返すビジネスロジック
	@RequestMapping(method=RequestMethod.GET)
	String listTasks(Model model) {
		//taskListsにテーブル内のタスクを取得
		List<TaskHistory> taskLists = taskService.findAllTaskLists();
		
		//取得した値をmodelに追加する
		model.addAttribute("task_lists", taskLists);
		return "task/task-list";
	}
	**/
	
	//タスク一覧とチャージコードリストを返すビジネスロジック
	@RequestMapping(method=RequestMethod.GET)
	String listTasks(Model model) {
		//taskListsにテーブル内のタスクを取得
		List<TaskHistory> taskLists = taskService.findAllTaskLists();
		//プロジェクトIDリストを取得
		List<Project> projectLists = projectService.findAll();
		
		//取得した値をmodelに追加する
		model.addAttribute("task_lists", taskLists);
		model.addAttribute("project_lists", projectLists);
		return "task/task-list";
	}
}
