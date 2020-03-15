insert into code (genre, code, name) values('ss_flg', 'on', '作業中');
insert into code (genre, code, name) values('ss_flg', 'off', '停止中');

alter table working_time_log 
add column ss_name varchar(10);

/* Drop Table */
DROP TABLE IF EXISTS sum_working_time_aday CASCADE /;

/* Create Table */
CREATE TABLE sum_working_time_aday
(
	id serial NOT NULL UNIQUE,
	-- task_history.code  task_history.detail 
	taskUID varchar(300) NOT NULL,
    date date NOT NULL,
	sum_wktime varchar(30) NOT NULL,
	PRIMARY KEY (id)
)/;

/* sum_working_time_adayに入れるデータ */
select taskuid, date, to_char(sum_wktime, 'HH24:MI:SS') as sum_wktime
from
(
select 
tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd') as date,
sum(tbl1.registered_dt - tbl2.registered_dt) as sum_wktime
from
(
select rank() over (partition by taskUID order by registered_dt desc) as rnk,
       taskuid, ss_flg, registered_dt
from working_time_log
where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')
order by taskuid, registered_dt desc
) tbl1 join 
(
select rank() over (partition by taskUID order by registered_dt desc) as rnk,
       taskuid, ss_flg, registered_dt
from working_time_log
where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')
order by taskuid, registered_dt desc
) tbl2 on tbl1.taskuid = tbl2.taskuid and tbl1.rnk = tbl2.rnk - 1
where tbl1.ss_flg = 'on'
group by tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')) tbl

/* initSumWorkingTimeAday */
insert into sum_working_time_aday (taskUID, date, sum_wktime)
select a.taskuid, a.date, a.sum_wktime
from
(
select taskuid, date, to_char(sum_wktime, 'HH24:MI:SS') as sum_wktime
from
(
select 
tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd') as date,
sum(tbl1.registered_dt - tbl2.registered_dt) as sum_wktime
from
(
select rank() over (partition by taskUID order by registered_dt desc) as rnk,
       taskuid, ss_flg, registered_dt
from working_time_log
where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')
order by taskuid, registered_dt desc
) tbl1 join 
(
select rank() over (partition by taskUID order by registered_dt desc) as rnk,
       taskuid, ss_flg, registered_dt
from working_time_log
where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')
order by taskuid, registered_dt desc
) tbl2 on tbl1.taskuid = tbl2.taskuid and tbl1.rnk = tbl2.rnk - 1
where tbl1.ss_flg = 'on'
group by tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')) tbl
) a left join sum_working_time_aday b on a.taskuid = b.taskuid and a.date = b.date
where b.taskuid is null and b.date is null

/* updateSumWorkingTimeAday */

update sum_working_time_aday
set sum_wktime = src.sum_wktime from (
select taskuid, date, to_char(sum_wktime, 'HH24:MI:SS') as sum_wktime
from (
select tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd') as date,
sum(tbl1.registered_dt - tbl2.registered_dt) as sum_wktime
from (
select rank() over (partition by taskUID order by registered_dt desc) as rnk,
       taskuid, ss_flg, registered_dt
from working_time_log
where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')
order by taskuid, registered_dt desc
) tbl1 join (
select rank() over (partition by taskUID order by registered_dt desc) as rnk,
       taskuid, ss_flg, registered_dt
from working_time_log
where date (current_date + interval '0') = to_date(to_char(registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')
order by taskuid, registered_dt desc
) tbl2 on tbl1.taskuid = tbl2.taskuid and tbl1.rnk = tbl2.rnk - 1
where tbl1.ss_flg = 'on'
group by tbl1.taskuid, to_date(to_char(tbl1.registered_dt, 'yyyy-mm-dd'), 'yyyy-mm-dd')) tbl
) src
where sum_working_time_aday.taskuid = src.taskuid and sum_working_time_aday.date = src.date

/* initWorkingTimeLog リカバリ*/
insert into working_time_log (taskUID, ss_flg, ss_name)
select code || detail, 'off', '停止中'
from task_history
where date (current_date + interval '0') = c_date

/* initSumWorkingTimeAday リカバリ*/
insert into sum_working_time_aday (taskUID, date, sum_wktime)
select code || detail, c_date, '00:00:00'
from task_history
where date (current_date + interval '0') = c_date


