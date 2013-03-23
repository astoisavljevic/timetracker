insert into stt_role(id, name) values(1, 'ADMIN');
insert into stt_role(id, name) values(2, 'USER');

insert into stt_user(email, username, password, enabled, role_id) values ('admin@gmail.com', 'admin', 'admin', TRUE, 1);
insert into stt_user(email, username, password, enabled, role_id) values ('java.developer@gmail.com', 'java', 'java', TRUE, 2);

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