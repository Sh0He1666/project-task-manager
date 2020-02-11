/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.app.task;

import java.time.LocalDate;
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

import com.shohei.tm.app.converter.LocalDateConverter;
import com.shohei.tm.app.project.ProjectForm;
import com.shohei.tm.domain.model.ChargeCode;
import com.shohei.tm.domain.model.Code;
import com.shohei.tm.domain.model.Project;
import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.model.User;
import com.shohei.tm.domain.service.charge.ChargeService;
import com.shohei.tm.domain.service.code.CodeService;
import com.shohei.tm.domain.service.project.ProjectService;
import com.shohei.tm.domain.service.task.TaskService;

/**
 * タスクに関するリクエストを受けるコントローラークラス
 * @author shoheitokumaru
 *
 */
@RequestMapping("task")
@Controller
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ChargeService chargeService;
	@Autowired
	CodeService codeService;
	
	//タスク一覧とチャージコードリストを返すビジネスロジック
	@RequestMapping(method=RequestMethod.GET)
	String listTasks(Model model) {
		//taskListsにテーブル内のタスクを取得
		List<TaskHistory> taskLists = taskService.findAllTaskLists();
		//プロジェクトIDリストを取得
		List<Project> projectLists = projectService.findAll();
		//コードマスタ
		List<Code> codeList = codeService.findAll();
		
		//取得した値をmodelに追加する
		model.addAttribute("task_lists", taskLists);
		model.addAttribute("project_lists", projectLists);
		model.addAttribute("codeList", codeList);
		return "task/task-list";
	}
	
	/**
	 * タスク一覧画面→タスク詳細クリック→タスク詳細を編集する画面へ遷移
	 * 渡す値：task_historyのカラム
	 * code, chargeCode.code, name, detail, content, plan, 
	 * @param model
	 * @return
	 */
	@RequestMapping(path="{id}", method=RequestMethod.GET)
	String goToTaskEdit(@PathVariable("id") Integer id, Model model) {
		//パスに入力されたidのデータを取得
		TaskHistory taskDetailData = taskService.findOne(id);
		//取得した値をModelに格納
		model.addAttribute("task_detail_data", taskDetailData);
		return "task/task-edit";
	}

	@RequestMapping(path="task-add-info", method=RequestMethod.GET)
	String goToTaskAddInfo(Model model) {
		//カレントのステータスを取得
		List<Project> currentProjectList = projectService.findAll();
		List<ChargeCode> currentChargeList = chargeService.findAll();
		List<TaskHistory> currentTaskList = taskService.findAllTaskLists();
		List<Code> codeList = codeService.findAll();
		
		//取得した値をmodelに突っ込む
		model.addAttribute("currentProjectList", currentProjectList);
		model.addAttribute("currentChargeList", currentChargeList);		
		model.addAttribute("currentTaskList", currentTaskList);		
		model.addAttribute("codeList", codeList);		
		return "task/task-add-info";
	}
	
	//タスク情報追加
	@RequestMapping(method=RequestMethod.POST)
	String addTaskInfo(
			//フォームで入力された情報を保持
			@Validated TaskForm form,
			Model model) {
		
		//取得する値を定義
		Project projectId; //プロジェクトコードのPK
		String projectCodeId;
		ChargeCode chargeId;  //チャージコードのPK
		String code; //SES_100
		String detail; //タスク名
		LocalDate deadlineDate; //期日
		String status; //ステータス
		String progressRate; //進捗度		
		
		//formの値を取得
		projectId = form.getProjectId();
		projectCodeId = form.getProjectCodeId();
		chargeId = form.getChargeId();
		//code = form.getCode();
		detail = form.getDetail();
		//deadlineDate = form.getDeadlineDate();
		status = form.getStatus();
		progressRate = form.getProgressRate();
		
		//codeを生成
		code = projectId.getCode() + "_" + projectCodeId;
		
		//deadlineDateを生成
		deadlineDate = createDeadlineDate(form.getYear(), form.getMonth(), form.getDay());
		
		//ダミーのUserを定義
		User user = new User();
		user.setId(1);
		
		//formの値をTaskHistoryに詰める
		TaskHistory taskHistory = new TaskHistory();
		taskHistory.setUser(user);
		taskHistory.setProjectId(projectId);
		taskHistory.setChargeCode(chargeId);
		taskHistory.setCode(code);
		taskHistory.setDetail(detail);
		taskHistory.setDeadlineDate(deadlineDate);
		taskHistory.setStatus(status);	
		taskHistory.setProgressRate(Integer.parseInt(progressRate));
		
		//TaskHistoryに値を追加
		taskService.save(taskHistory);
		
		return "redirect:/task/task-add-info";
	}

	//リクエストパラメータをバインドする
	@ModelAttribute
	TaskForm setUpTaskForm() {
		TaskForm form = new TaskForm();
		return form;
	}
	
	//DeadlineDateを生成するメソッド
	private LocalDate createDeadlineDate(String year, String month, String day) {
		LocalDateConverter conv = new LocalDateConverter();
		return conv.convertToLocalDate(year, month, day, "yyyyMMdd");
	}
}
