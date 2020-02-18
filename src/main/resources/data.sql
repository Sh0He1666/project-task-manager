-- account_user
INSERT INTO account_user (name, passwd, last_login_dt, role_name)
VALUES ('shohei', 'test', null, 'ADMIN')/;
-- charge_code
INSERT INTO charge_code (code, name)
VALUES ('F001', 'ほげほげ')/;
INSERT INTO charge_code (code, name)
VALUES ('E', '保守系')/;
INSERT INTO charge_code (code, name)
VALUES ('PL', 'コンサル')/;
INSERT INTO charge_code (code, name)
VALUES ('RB', 'バグ修正')/;
-- project
INSERT INTO project (code, name)
VALUES ('SSS', 'セブンエス')/;
INSERT INTO project (code, name)
VALUES ('JJJ', 'スリージェ')/;
INSERT INTO project (code, name)
VALUES ('AIM', 'エーイム')/;
-- task_history
INSERT INTO task_history (user_id, project_id, charge_code_id, code, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 1, 1, 'SSS_001', 'フローチャート改修', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '未着手', '0%')/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 1, 2, 'SSS_111', 'ドメイン変更対応', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '未着手', '0%')/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 2, 3, 'JJJ_001', '商品リスト修正', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '未着手', '0%')/;
INSERT INTO task_history (user_id, project_id, charge_code_id, code, detail, content, problem, plan, deadline_dt, status, progress_rt)
VALUES (1, 3, 4, 'AIM_001', '標準バグ修正', '内容記載枠', '課題記載枠', '今後の予定記載枠', null, '未着手', '0%')/;
-- code
INSERT INTO code (genre, code, name)
VALUES ('status','0', '未着手')/;
INSERT INTO code (genre, code, name)
VALUES ('status','1', '進行中')/;
INSERT INTO code (genre, code, name)
VALUES ('status','2', '処理済み')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',0, '0%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',1, '10%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',2, '20%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',3, '30%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',4, '40%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',5, '50%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',6, '60%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',7, '70%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',8, '80%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',9, '90%')/;
INSERT INTO code (genre, code, name)
VALUES ('progress_rt',10, '100%')/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2000	, 	2000	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2001	, 	2001	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2002	, 	2002	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2003	, 	2003	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2004	, 	2004	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2005	, 	2005	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2006	, 	2006	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2007	, 	2007	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2008	, 	2008	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2009	, 	2009	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2010	, 	2010	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2011	, 	2011	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2012	, 	2012	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2013	, 	2013	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2014	, 	2014	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2015	, 	2015	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2016	, 	2016	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2017	, 	2017	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2018	, 	2018	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2019	, 	2019	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2020	, 	2020	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2021	, 	2021	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2022	, 	2022	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2023	, 	2023	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2024	, 	2024	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2025	, 	2025	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2026	, 	2026	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2027	, 	2027	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2028	, 	2028	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2029	, 	2029	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2030	, 	2030	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2031	, 	2031	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2032	, 	2032	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2033	, 	2033	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2034	, 	2034	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2035	, 	2035	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2036	, 	2036	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2037	, 	2037	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2038	, 	2038	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2039	, 	2039	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2040	, 	2040	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2041	, 	2041	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2042	, 	2042	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2043	, 	2043	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2044	, 	2044	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2045	, 	2045	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2046	, 	2046	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2047	, 	2047	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2048	, 	2048	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2049	, 	2049	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2050	, 	2050	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2051	, 	2051	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2052	, 	2052	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2053	, 	2053	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2054	, 	2054	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2055	, 	2055	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2056	, 	2056	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2057	, 	2057	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2058	, 	2058	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2059	, 	2059	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2060	, 	2060	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2061	, 	2061	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2062	, 	2062	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2063	, 	2063	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2064	, 	2064	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2065	, 	2065	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2066	, 	2066	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2067	, 	2067	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2068	, 	2068	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2069	, 	2069	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2070	, 	2070	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2071	, 	2071	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2072	, 	2072	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2073	, 	2073	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2074	, 	2074	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2075	, 	2075	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2076	, 	2076	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2077	, 	2077	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2078	, 	2078	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2079	, 	2079	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2080	, 	2080	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2081	, 	2081	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2082	, 	2082	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2083	, 	2083	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2084	, 	2084	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2085	, 	2085	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2086	, 	2086	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2087	, 	2087	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2088	, 	2088	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2089	, 	2089	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2090	, 	2090	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2091	, 	2091	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2092	, 	2092	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2093	, 	2093	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2094	, 	2094	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2095	, 	2095	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2096	, 	2096	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2097	, 	2097	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2098	, 	2098	)/;
INSERT INTO code (genre, code, name)				
VALUES ('year',	2099	, 	2099	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'01'	, 	'01'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'02'	, 	'02'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'03'	, 	'03'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'04'	, 	'04'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'05'	, 	'05'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'06'	, 	'06'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'07'	, 	'07'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'08'	, 	'08'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	'09'	, 	'09'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	10	, 	10	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	11	, 	11	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	12	, 	12	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	13	, 	13	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	14	, 	14	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	15	, 	15	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	16	, 	16	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	17	, 	17	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	18	, 	18	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	19	, 	19	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	20	, 	20	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	21	, 	21	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	22	, 	22	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	23	, 	23	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	24	, 	24	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	25	, 	25	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	26	, 	26	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	27	, 	27	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	28	, 	28	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	29	, 	29	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	30	, 	30	)/;
INSERT INTO code (genre, code, name)				
VALUES ('day',	31	, 	31	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'01'	, 	'01'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'02'	, 	'02'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'03'	, 	'03'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'04'	, 	'04'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'05'	, 	'05'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'06'	, 	'06'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'07'	, 	'07'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'08'	, 	'08'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	'09'	, 	'09'	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	10	, 	10	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	11	, 	11	)/;
INSERT INTO code (genre, code, name)				
VALUES ('month',	12	, 	12	)/;