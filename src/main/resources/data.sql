INSERT INTO account_user (name, passwd, last_login_dt, role_name)
VALUES ('shohei', '2469tkmr', null, 'ADMIN')/;
INSERT INTO charge_code (code, name)
VALUES ('F001', '集英社PJ関連')/;
INSERT INTO charge_code (code, name)
VALUES ('E', '保守')/;
INSERT INTO charge_code (code, name)
VALUES ('PL', 'コンサル')/;
INSERT INTO charge_code (code, name)
VALUES ('RB', 'バグ修正')/;
INSERT INTO project (code, name)
VALUES ('JSC', 'ジュピター')/;
INSERT INTO project (code, name)
VALUES ('SES', '集英社')/;
INSERT INTO project (code, name)
VALUES ('AIM', 'V8標準課題')/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, name, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 1, 1, 'SES_001', 'タスク名', 'タスク詳細', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '0', 0)/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, name, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 1, 2, 'SES_111', 'タスク名', 'タスク詳細', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '0', 0)/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, name, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 2, 3, 'JCS_001', 'タスク名', 'タスク詳細', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '0', 0)/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, name, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 3, 4, 'AIM_001', 'タスク名', 'タスク詳細', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '0', 0)/;
