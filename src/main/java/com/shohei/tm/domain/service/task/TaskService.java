/**
 * 20200118 初版
 * 
 */
package com.shohei.tm.domain.service.task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shohei.tm.domain.model.SumWorkingTimeAday;
import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.model.User;
import com.shohei.tm.domain.model.WorkingTimeLog;
import com.shohei.tm.domain.repository.chargeCode.ChargeCodeRepository;
import com.shohei.tm.domain.repository.project.ProjectRepository;
import com.shohei.tm.domain.repository.task.SumWorkingTimeAdayRepository;
import com.shohei.tm.domain.repository.task.TaskHistoryRepository;
import com.shohei.tm.domain.repository.task.WorkingTimeLogRepository;

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
	@Autowired
	WorkingTimeLogRepository workingTimeLogRepository;
	@Autowired
	SumWorkingTimeAdayRepository sumWorkingTimeAdayRepository;
	
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
	
	//引数の年月日に合致するレコードを取得する
	public List<TaskHistory> getTaskListByDate(LocalDate cdate) {
		return taskHistoryRepository.getTaskListByDate(cdate);
	}
	
	//翌日のタスク一覧の雛形を作成する
	public void createTaskEditBase() {
		taskHistoryRepository.createTaskEditBase();
	}
	
	//タスクUIDのレコードの作業開始・終了を記録する
	public void insertSsFlg(String taskUID, String ss_flg) {
		workingTimeLogRepository.insertSsFlg(taskUID, ss_flg);
	}
	
	//タスクUIDの作業開始・終了ステータスを取得する
	public List<WorkingTimeLog> getWorkingTimeLog() {
		return workingTimeLogRepository.getWorkingTimeLog();
	}
	
	//タスク一覧作成時にss_flgを'off'に初期化
	public void initWorkingTimeLog() {
		workingTimeLogRepository.initWorkingTimeLog();
	}

	//過去日付のタスク一覧に遷移した場合は、作業状況にダミーの値を仕込む
	public List<WorkingTimeLog> getDummyWorkingTimeLog() {
		return workingTimeLogRepository.getDummyWorkingTimeLog();
	}
	
	//タスク一覧作成時にsum_working_time_adayを初期化
	public void initSumWorkingTimeAday() {
		sumWorkingTimeAdayRepository.initSumWorkingTimeAday();
	}
	
	//sum_working_time_adayに作業時間(日単位)をINSERT
	public void addSumWorkingTimeAday() {
		sumWorkingTimeAdayRepository.addSumWorkingTimeAday();
	}
	
	//作業時間(日単位)をUPDATEする
	public void updateSumWorkingTimeAday() {
		sumWorkingTimeAdayRepository.updateSumWorkingTimeAday();
	}
	
	//作業時間(日単位)を取得する
	public List<SumWorkingTimeAday> getSumWorkingTimeAdayList(LocalDate date){
		return sumWorkingTimeAdayRepository.getSumWorkingTimeAdayList(date);
	}
	
}
