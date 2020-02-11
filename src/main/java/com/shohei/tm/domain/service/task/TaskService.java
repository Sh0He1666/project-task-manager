/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.domain.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.model.User;
import com.shohei.tm.domain.repository.chargeCode.ChargeCodeRepository;
import com.shohei.tm.domain.repository.project.ProjectRepository;
import com.shohei.tm.domain.repository.task.TaskHistoryRepository;

/**
 * ビジネスロジック実装クラスです
 * @author shoheitokumaru
 *
 */
@Service
@Transactional
public class TaskService {
	@Autowired
	TaskHistoryRepository taskHistoryRepository;
	@Autowired 
	ProjectRepository projectRepository;
	@Autowired
	ChargeCodeRepository chargeCodeRepository;
	
	//タスク一覧を表示するメソッド OK
	//User_id stands 
	public List<TaskHistory> findAllTaskLists() {
		return taskHistoryRepository.queryAll();
	}
	
	//IDのタスクリストを取得する
	public TaskHistory findOne(Integer id) {
		return taskHistoryRepository.findById(id).orElse(null);
	}
	
	//idのcontent, problem, planを更新する
	public Integer updateTaskDetailById(String content, String problem, String plan, Integer id) {
		return taskHistoryRepository.updateTaskDetailById(content, problem, plan, id);
	}
	
	//プロジェクト情報を追加するメソッド
	public void save(TaskHistory taskHistory) {
		taskHistoryRepository.save(taskHistory);
	}

}
