
/* Drop Tables */

DROP TABLE IF EXISTS task_history;
DROP TABLE IF EXISTS account_user;
DROP TABLE IF EXISTS charge_code;
DROP TABLE IF EXISTS project;




/* Create Tables */

CREATE TABLE account_user
(
	id serial NOT NULL UNIQUE,
	name varchar(20) NOT NULL UNIQUE,
	passwd varchar(20) NOT NULL,
	registerd_dt timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	latest_login_dt timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE charge_code
(
	id serial NOT NULL UNIQUE,
	code varchar(20) NOT NULL UNIQUE,
	name varchar(20) NOT NULL,
	pj_id int NOT NULL,
	registerd_dt timestamp NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE project
(
	id serial NOT NULL UNIQUE,
	code varchar(20) NOT NULL UNIQUE,
	name varchar(20) NOT NULL UNIQUE,
	registered_dt timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE task_history
(
	user_id int NOT NULL,
	charge_code_id int NOT NULL,
	-- Pj_code + task number
	code  NOT NULL,
	name varchar(100) NOT NULL,
	detail varchar(100) NOT NULL,
	content varchar(1000),
	problem varchar(1000),
	plan varchar(1000),
	deadline_dt timestamp,
	-- 0:未着手, 1:進行中 ,2:処理済み
	status varchar(10) NOT NULL,
	progress_rt int NOT NULL CONSTRAINT number_check   CHECK(progress_rt >= 0 and progress_rt <= 10),
	registered_dt timestamp NOT NULL
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE task_history
	ADD FOREIGN KEY (user_id)
	REFERENCES account_user (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE task_history
	ADD FOREIGN KEY (charge_code_id)
	REFERENCES charge_code (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE charge_code
	ADD FOREIGN KEY (pj_id)
	REFERENCES project (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



/* Comments */

COMMENT ON COLUMN task_history.code IS 'Pj_code + task number';
COMMENT ON COLUMN task_history.status IS '0:未着手, 1:進行中 ,2:処理済み';



