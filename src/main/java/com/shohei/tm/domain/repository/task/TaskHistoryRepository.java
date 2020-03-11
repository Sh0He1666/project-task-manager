/**
 * 20200117 初版
 * 
 */
package com.shohei.tm.domain.repository.task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shohei.tm.domain.model.TaskHistory;
import com.shohei.tm.domain.model.User;

/**
 * タスク履歴リポジトリを表すインテーフェースです
 * @author shoheitokumaru
 *
 */
@Transactional
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Integer> {
	
//	@Query(value = "select x from TaskHistory x order by id, projectId asc")
	@Query(value = "select x from TaskHistory x order by deadlineDate asc")
	List<TaskHistory> queryAll();
	
	//翌日のタスク一覧の雛形を作成する
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value=""
			+ " insert into task_history "
			+ " (user_id, project_id, charge_code_id, code, detail, deadline_dt, status, progress_rt, c_date)"
			+ " select user_id, project_id, charge_code_id, code, detail, deadline_dt, status, progress_rt,date (current_date)"
			+ " from task_history"
			+ " where status in ('未着手','進行中')"
			+ " and c_date = date (current_date + interval '-1')")
	public Integer createTaskEditBase();
	
	//引数の年月日に合致するレコードを取得する
	@Modifying
	@Transactional
	@Query("select x from TaskHistory x where x.cdate =:cdate")
	public List<TaskHistory> getTaskListByDate(
			@Param("cdate") LocalDate cdate);
	
	//タスク詳細情報をUPDATEする
	@Modifying
	@Transactional
	@Query("update TaskHistory th set"
			+ " th.status =:status,"
			+ " th.progressRate =:progressRate,"
			+ " th.deadlineDate =:deadlineDate,"
			+ " th.content =:content,"
			+ " th.problem =:problem,"
			+ " th.plan =:plan"
			+ " where th.id =:id") 
	public Integer updateTaskDetailById (
			@Param("status") String status,
			@Param("progressRate") String progressRate,
			@Param("deadlineDate") LocalDate deadlineDate,
			@Param("content") String content,
			@Param("problem") String problem,
			@Param("plan") String plan,
			@Param("id") Integer id
			);
	
	//最新のcdateを取得する
//	@Query(value="select max(c_date) as c_date from task_history", nativeQuery=true)
//	public TaskHistory getLatestCdate();
	
}
