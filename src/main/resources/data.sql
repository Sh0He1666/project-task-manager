INSERT INTO account_user (name, passwd, latest_login_dt)
VALUES ('F001', '集英社PJ関連', null)/;
INSERT INTO charge_code (code, name)
VALUES ('F001', '集英社PJ関連')/;
INSERT INTO project (code, name)
VALUES ('SES', '集英社')/;
INSERT INTO task_history (user_id, charge_code_id, code, name, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 1, 'SES_001', 'タスク名', 'タスク詳細', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '0', 0)/;
