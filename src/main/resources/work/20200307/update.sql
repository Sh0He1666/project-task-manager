/*
 * 作業時間を記録するTBL
 * */

/* Drop Table */
DROP TABLE IF EXISTS working_time_log CASCADE /;

/* Create Table */
CREATE TABLE working_time_log
(
	id serial NOT NULL UNIQUE,
	-- task_history.code + task_history.detail 
	taskUID varchar(300) NOT NULL,
	-- start: on, stop:off
    ss_flg varchar(5) NOT NULL,
	registered_dt timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY (id)
)/;

/* タスク履歴TBLに作業実施の年月日を記録するカラム追加 */
ALTER TABLE task_history ADD COLUMN c_date date;

/* タスク履歴TBLに日時のベースデータをセット */
insert into task_history ((user_id, project_id, charge_code_id, code, detail, deadline_dt, status, progress_rt, c_date))
select user_id, 
       project_id, 
       charge_code_id, 
       code, 
       detail, 
       deadline_dt, 
       status, 
       progress_rt,
       date (current_date)
  from task_history
 where status in ('未着手','進行中')
   and c_date = date (current_date + interval '-1')

