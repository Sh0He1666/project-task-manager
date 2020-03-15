package com.shohei.tm.domain.repository.task;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shohei.tm.domain.model.SumWorkingTimeAday;

@Transactional
public interface SumWorkingTimeAdayRepository extends JpaRepository<SumWorkingTimeAday, Integer> {
	
	//タスク一覧作成時にsum_working_time_adayを初期化
	@Modifying
	@Query(value=""
			+ " insert into sum_working_time_aday (taskUID, date, sum_wktime)"
			+ " select code || detail, c_date, '00:00:00'"
			+ " from task_history"
			+ " where date (current_date + interval '0') = c_date",
			nativeQuery=true)
	public void initSumWorkingTimeAday(); 
	
	//sum_working_time_adayに作業時間(日単位)をINSERT
	@Modifying
	@Query(value=""
			+ " insert into sum_working_time_aday (taskUID, date, sum_wktime)"
			+ " select a.taskuid, a.date, a.sum_wktime"
			+ " from ("
			+ " select taskuid, date, to_char(sum_wktime, 'HH24:MI:SS') as sum_wktime"
			+ " from ("
			+ " select tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd') as date,"
			+ " sum(tbl1.registered_dt - tbl2.registered_dt) as sum_wktime"
			+ " from ("
			+ " select rank() over (partition by taskUID order by registered_dt desc) as rnk,"
			+ "        taskuid, ss_flg, registered_dt"
			+ " from working_time_log"
			+ " where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')"
			+ " order by taskuid, registered_dt desc"
			+ " ) tbl1 join ("
			+ " select rank() over (partition by taskUID order by registered_dt desc) as rnk,"
			+ "        taskuid, ss_flg, registered_dt"
			+ " from working_time_log"
			+ " where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')"
			+ " order by taskuid, registered_dt desc"
			+ " ) tbl2 on tbl1.taskuid = tbl2.taskuid and tbl1.rnk = tbl2.rnk - 1"
			+ " where tbl1.ss_flg = 'off'"
			+ " group by tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')) tbl"
			+ " ) a left join sum_working_time_aday b on a.taskuid = b.taskuid and a.date = b.date"
			+ " where b.taskuid is null and b.date is null",
			nativeQuery=true)
	public void addSumWorkingTimeAday(); 
	
	//作業時間(日単位)をUPDATEする
	@Modifying
	@Query(value = ""
			+ " update sum_working_time_aday"
			+ " set sum_wktime = src.sum_wktime from ("
			+ " select taskuid, date, to_char(sum_wktime, 'HH24:MI:SS') as sum_wktime"
			+ " from ("
			+ " select tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd') as date,"
			+ " sum(tbl1.registered_dt - tbl2.registered_dt) as sum_wktime"
			+ " from ("
			+ " select rank() over (partition by taskUID order by registered_dt desc) as rnk,"
			+ "        taskuid, ss_flg, registered_dt"
			+ " from working_time_log"
			+ " where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')"
			+ " order by taskuid, registered_dt desc"
			+ " ) tbl1 join ("
			+ " select rank() over (partition by taskUID order by registered_dt desc) as rnk,"
			+ "        taskuid, ss_flg, registered_dt"
			+ " from working_time_log"
			+ " where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')"
			+ " order by taskuid, registered_dt desc"
			+ " ) tbl2 on tbl1.taskuid = tbl2.taskuid and tbl1.rnk = tbl2.rnk - 1"
			+ " where tbl1.ss_flg = 'off'"
			+ " group by tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')) tbl"
			+ " ) src"
			+ " where sum_working_time_aday.taskuid = src.taskuid and sum_working_time_aday.date = src.date",
			nativeQuery=true)
	public void updateSumWorkingTimeAday();
	
	//作業時間(日単位)を取得する
	@Modifying
	@Query(value = ""
			+ " select x.sumWkTime from SumWorkingTimeAday x where x.taskUID = :taskUID "
			+ " and x.date = :date")
	public SumWorkingTimeAday getSumWorkingTimeAday(
			@Param("taskUID") String taskUID,
			@Param("date") LocalDate date);
	
	//作業時間(日単位)を取得する
	@Modifying
	@Query(value = ""
			+ " select x from SumWorkingTimeAday x where x.date = :date")
	public List<SumWorkingTimeAday> getSumWorkingTimeAdayList(
			@Param("date") LocalDate date);
	
	//タスクUIDのトータルの作業時間を返す(タスク編集画面用)

}
