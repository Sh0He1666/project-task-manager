/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.domain.service.task;

import java.time.LocalDate;
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
	public Integer updateTaskDetailById(String status, String progressRate, LocalDate deadlineDate, String content, String problem, String plan, Integer id) {
		return taskHistoryRepository.updateTaskDetailById(status, progressRate, deadlineDate, content, problem, plan, id);
	}
	
	//タスク情報を追加するメソッド
	public void save(TaskHistory taskHistory) {
		taskHistoryRepository.save(taskHistory);
	}
	
	//受け取ったIDのタスク情報を削除する
	public void deleteTaskInfoById(Integer id) {
		taskHistoryRepository.deleteById(id);			
	}

}
