/**
 * 2020.03.13 初版
 */
package com.shohei.tm.domain.repository.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shohei.tm.domain.model.WorkingTimeLog;

/**
 * 作業時間ログリポジトリを表すインターフェースです。
 * @author shoheitokumaru
 *
 */
@Transactional
public interface WorkingTimeLogRepository extends JpaRepository<WorkingTimeLog, Integer> {
	
	//タスク一覧作成時にss_flgを'off'に初期化
	@Modifying
	@Query(value = ""
			+ " insert into working_time_log (taskUID, ss_flg, ss_name)"
			+ " select taskUID, 'off', '停止中'"
			+ " from working_time_log"
			+ " where date (current_date + interval '-1') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')",
			nativeQuery=true)
	public void initWorkingTimeLog();
	
	//タスクUIDのレコードの作業開始・終了を記録する
	@Modifying
	@Query(value = ""
			+ " insert into working_time_log (taskUID, ss_flg, ss_name)"
			+ " values (:taskUID, :ssFlg, (select name from code where genre = 'ss_flg' and code = :ssFlg))",
			nativeQuery = true)
	public void insertSsFlg(
			@Param("taskUID") String taskUID,
			@Param("ssFlg") String ss_flg);
	
	//タスクUIDの最新の作業開始・終了ステータスを取得する
	@Modifying
	@Query(value = ""
			+ " select max(l.id) as id, l.taskUID, l.ss_flg, l.registered_dt, l.ss_name"
			+ " from ("
			+ " select id, taskUID, ss_flg, registered_dt, ss_name,"
			+ "        rank() over (partition by taskUID order by registered_dt desc) as rank"
			+ "   from working_time_log) l"
			+ " where l.rank = 1 group by l.taskUID, l.ss_flg, l.registered_dt, l.ss_name",
			nativeQuery=true)
	public List<WorkingTimeLog> getWorkingTimeLog();

	//タスクUIDの作業開始・終了ステータスを取得する
	@Modifying
	@Query(value = ""
			+ " select max(l.id) as id, l.taskUID, 'dmy' as ss_flg, l.registered_dt, '　　　' as ss_name"
			+ " from ("
			+ " select id, taskUID, ss_flg, registered_dt, ss_name,"
			+ "        rank() over (partition by taskUID order by registered_dt desc) as rank"
			+ "   from working_time_log) l"
			+ " where l.rank = 1 group by l.taskUID, l.ss_flg, l.registered_dt, l.ss_name",
			nativeQuery=true)
	public List<WorkingTimeLog> getDummyWorkingTimeLog();

}
