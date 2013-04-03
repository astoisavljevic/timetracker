insert into stt_role(id, name) values(1, 'ADMIN');
insert into stt_role(id, name) values(2, 'USER');

insert into stt_user(email, username, password, enabled, role_id) values ('admin@gmail.com', 'admin', 'admin', TRUE, 1);

insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('a.neric@yahoo.com', 'a.neric', '12345', 'Adam', 'Neric', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('v.saric@hotmail.com', 'v.saric', '12345', 'Velibor', 'Saric', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('dj.vukovic@online.com', 'dj.vukovic', '12345', 'Djordje', 'Vukovic', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('v.popov@gmail.com', 'v.popov', '12345', 'Vesna', 'Popov', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('j.brkic@yahoo.com', 'j.brkic', '12345', 'Jelena', 'Brkic', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('m.markovic@hotmail.com', 'm.markovic', '12345', 'Mateja', 'Markovic', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('o.sremac@online.com', 'o.sremac', '12345', 'Ognjen', 'Sremac', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('p.nikolic@gmail.com', 'p.nikolic', '12345', 'Petar', 'Nikolic', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('s.zoric@yahoo.com', 's.zoric', '12345', 'Svetlana', 'Zoric', TRUE, 2);
insert into stt_user(email, username, password, first_name, last_name, enabled, role_id) values ('t.isakovic@hotmail.com', 't.isakovic', '12345', 'Tijana', 'Isakovic', TRUE, 2);

insert into stt_activity_type(name, description, color, status) values('Design', 'design architectual solutions, ideas, etc.', '#FF0000', 'OPEN');
insert into stt_activity_type(name, description, color, status) values('Coding', 'actual writing code', '#00FF00', 'OPEN');
insert into stt_activity_type(name, description, color, status) values('Debugging', 'debugging code', '#0000FF', 'OPEN');
insert into stt_activity_type(name, description, color, status) values('Testing', 'testing code', '#000000', 'OPEN');

insert into stt_task_type(name, description, color, status) values('Features', 'working on new features, improvements, etc.', '#FF0000', 'OPEN');
insert into stt_task_type(name, description, color, status) values('Maintanance', 'working on existing features', '#00FF00', 'OPEN');
insert into stt_task_type(name, description, color, status) values('Proposal', 'sales force', '#0000FF', 'OPEN');

insert into stt_project(id, name, description, start_on, company_code, company_name, status) values (1, 'Simple Time Tracker', 'Simple presentation of a time tracker application', '2013-03-01', 'SIT', 'StaleksIT', 'OPEN');

insert into stt_project_member(id, user_id, project_id) values(1, 2, 1);

insert into stt_project_task(id, project_id, user_id, task_type_id, name, description, start_on, due_on, bid_hours) values(1, 1, 2, 1, 'Setup Maven project', 'Prepare Maven Multi-Module project according to specified high level architecture design', '2013-03-01', '2013-03-07', 8);

insert into stt_time_sheet(id, project_task_id, user_id, activity_type_id, started_at, hours, description) values(1, 1, 2, 2, '2013-03-02 08:30:00', 1, 'started to work on this issue');