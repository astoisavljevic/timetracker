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
insert into stt_task_type(name, description, color, status) values('Illness', 'Sick leave', '#FFA500', 'OPEN');

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
insert into stt_activity_type(name, description, color, status) values('Illness', 'sick leave', '#FFA500', 'OPEN');


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
	birth_date date,
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

insert into stt_user(id, email, username, password, enabled, role_id) values (1, 'admin@gmail.com', 'admin', 'admin', TRUE, 1);

insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (2, 'a.neric@yahoo.com', 'a.neric', '12345', 'Adam', 'Neric', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (3, 'v.saric@hotmail.com', 'v.saric', '12345', 'Velibor', 'Saric', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (4, 'dj.vukovic@online.com', 'dj.vukovic', '12345', 'Djordje', 'Vukovic', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (5, 'v.popov@gmail.com', 'v.popov', '12345', 'Vesna', 'Popov', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (6, 'j.brkic@yahoo.com', 'j.brkic', '12345', 'Jelena', 'Brkic', '1978-12-26', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (7, 'm.markovic@hotmail.com', 'm.markovic', '12345', 'Mateja', 'Markovic', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (8, 'o.sremac@online.com', 'o.sremac', '12345', 'Ognjen', 'Sremac', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (9, 'p.nikolic@gmail.com', 'p.nikolic', '12345', 'Petar', 'Nikolic', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (10, 's.zoric@yahoo.com', 's.zoric', '12345', 'Svetlana', 'Zoric', TRUE, 2);
insert into stt_user(id, email, username, password, first_name, last_name, enabled, role_id) values (11, 't.isakovic@hotmail.com', 't.isakovic', '12345', 'Tijana', 'Isakovic', TRUE, 2);

insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (12, 'katherine.williams@synaxana.net', 'k.williams', '12345', 'Katherine', 'Williams', '1916-11-24', TRUE, 2);

insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (13, 'chrisgriffin@gmail.com', 'c.griffin', '12345', 'Chris', 'Griffin', '1978-12-16', TRUE, 2);

insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (14, 'vreynolds@perg.it', 'v.reynolds', '12345', 'Vickie', 'Reynolds', '1933-07-27', TRUE, 2);

insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (15, 'richard_ward@txa.com', 'r.ward', '12345', 'Richard', 'Ward', '1980-06-01', TRUE, 2);

insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (16, 'terry.andrews@vtz.us', 't.andrews', '12345', 'Terry', 'Andrews', '1919-06-22', TRUE, 2);

insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (17, 'kennethherman@lkb.de', 'k.herman', '12345', 'Kenneth', 'Herman', '1921-03-20', TRUE, 2);
	
insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (18, 'joanna.burnett@visstghoijy.de', 'j.burnett', '12345', 'Joanna', 'Burnett', '1998-02-11', TRUE, 2);
	
insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (19, 'wsmith@tlbpjyawla.de', 'w.smith', '12345', 'Walter', 'Smith', '1934-03-23', TRUE, 2);
	
insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (20, 'matthew.waters@brian-dorsey.com', 'm.waters', '12345', 'Matthew', 'Waters', '1989-02-23', TRUE, 2);
	
insert into stt_user(id, email, username, password, first_name, last_name, birth_date, enabled, role_id) 
	values (21, 'carolyn_chaney@efb.com', 'c.chaney', '12345', 'Carolyn', 'Chaney', '1967-03-01', TRUE, 2);

	
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

-- Internal projects
insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(1, 0, 'Illness', 'employee will have to book hours when is on sick leave', '1970-01-01', 'L9', 'Levi9');

insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(2, 0, 'Kick off', 'employee will have to book hours when starting to work, getting to know procedures, etc.', '1970-01-01', 'L9', 'Levi9');

-- Real projects	
insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(3, 0, 'JKP Cistoca', 'Information system for public service company JKP Cistoca Novi Sad', '2013-03-01', 'CIS', 'JKP Cistoca');
insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(4, 0, 'Startup Academy', 'Registration and early booking system for startup academy', '2013-01-20', 'SA', 'Startup Academy');
insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(5, 0, 'Argo Insurance', '3rd party plugin for customer ticketing system', '2013-02-10', 'ARG', 'Argo Insurance');
insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(6, 0, 'Lidl', 'Reporting engine for delivery department', '2012-11-01', 'LID', 'Lidl company');
insert into stt_project(id, version, name, description, start_on, company_code, company_name)
	values(7, 0, 'Simple Time Tracker', 'Software for bookkeeping hours spent on certain project', '2013-03-01', 'SIT', 'Staleks Information System');
	
	
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
