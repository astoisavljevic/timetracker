--
-- Simple Time Tracker Database Model
--
-- Author: Aleksandar Stoisavljevic
-- email: staleks@gmail.com
-- webpage: http://www.staleksit.in.rs
--

-- 
-- Table structure: stt_task_type
--

create table stt_task_type(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	name varchar(255) not null,
	description varchar(255) not null,
	color varchar(255) not null,
	status varchar(255) not null
) ENGINE=InnoDB;

create unique index idx_stt_task_type_name on stt_task_type(name);

--
-- Table: stt_task_type
-- data import
--

insert into stt_task_type(name, description, color, status) values('Features', 'working on new features, improvements, etc.', '#FF0000', 'OPEN');
insert into stt_task_type(name, description, color, status) values('Maintanance', 'working on existing features', '#00FF00', 'OPEN');
insert into stt_task_type(name, description, color, status) values('Proposal', 'sales force', '#0000FF', 'OPEN');

--
-- Table structure: stt_activity_type
--

create table stt_activity_type(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	name varchar(255) not null,
	description varchar(255) not null,
	color varchar(255) not null,
	status varchar(255) not null
) ENGINE=InnoDB;

create unique index idx_stt_activity_type_name on stt_activity_type(name);

--
-- Table: stt_activity_type
-- data import
--

insert into stt_activity_type(name, description, color, status) values('Design', 'design architectual solutions, ideas, etc.', '#FF0000', 'OPEN');
insert into stt_activity_type(name, description, color, status) values('Coding', 'actual writing code', '#00FF00', 'OPEN');
insert into stt_activity_type(name, description, color, status) values('Debugging', 'debugging code', '#0000FF', 'OPEN');
insert into stt_activity_type(name, description, color, status) values('Testing', 'testing code', '#000000', 'OPEN');


create table stt_role(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	name varchar(80) not null
) ENGINE=InnoDB;

create unique index idx_stt_role_name on stt_role(name);

insert into stt_role(id, name) values(1, 'ADMIN');
insert into stt_role(id, name) values(2, 'USER');


--
-- Table structure: stt_user
--

create table stt_user(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	email varchar(255) not null,
	username varchar(30) not null,
	password varchar(30) not null,
	first_name varchar(80),
	last_name varchar(80),
	enabled bit(1),
	role_id bigint(20) not null,
	constraint fk_stt_user_role foreign key (role_id) references stt_role(id)
) ENGINE=InnoDB;

create unique index idx_stt_user_email on stt_user(email);
create unique index idx_stt_user_username on stt_user(username);

--
-- Table: stt_user
-- data import
--

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


--
-- Table structure: stt_project
--

create table stt_project(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',	
	name varchar(255) not null,
	description varchar(255) not null,
	start_on date,
	color varchar(255),
	company_code varchar(255) not null,
	company_name varchar(255) not null,
	status varchar(255)
) ENGINE=InnoDB;

create unique index idx_stt_project_name on stt_project(name);
create unique index idx_stt_project_company_code on stt_project(company_code);
create unique index idx_stt_project_company_name on stt_project(company_name);


--
-- Table structure: stt_project_member
--

create table stt_project_member(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',	
	user_id bigint(20) not null,
	project_id bigint(20) not null,
	constraint fk_stt_project_member_user foreign key (user_id) references stt_user(id),
	constraint fk_stt_project_member_project foreign key (project_id) references stt_project(id)	
) ENGINE=InnoDB;

--
-- Table structure: stt_project_task
--

create table stt_project_task(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	project_id bigint(20) not null,
	user_id bigint(20) not null,
	task_type_id bigint(20) not null,
	name varchar(255) not null,
	description varchar(255) not null,
	start_on date,
	due_on date,
	bid_hours decimal,
	color varchar(255),
	status varchar(255),
	constraint fk_stt_project_task_user foreign key (user_id) references stt_user(id),
	constraint fk_stt_project_task_project foreign key (project_id) references stt_project(id),
	constraint fk_stt_project_task_task_type foreign key (task_type_id) references stt_task_type(id)		
) ENGINE=InnoDB;


--
-- Table structure: stt_time_sheet
--

create table stt_time_sheet(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',	
	project_task_id bigint(20) not null,
	user_id bigint(20) not null,
	activity_type_id bigint(20) not null,
	started_at datetime,
	hours decimal,
	description varchar(255),
	status varchar(255),
	constraint fk_stt_time_sheet_project_task foreign key (project_task_id) references stt_project_task(id),
	constraint fk_stt_time_sheet_user foreign key (user_id) references stt_user(id),
	constraint fk_stt_time_sheet_activity_type foreign key (activity_type_id) references stt_activity_type(id)		
) ENGINE=InnoDB;
