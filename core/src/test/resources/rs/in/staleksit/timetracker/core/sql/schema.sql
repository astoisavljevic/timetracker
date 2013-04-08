
create table stt_role(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	name varchar(80) not null
);

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
);

create table stt_activity_type(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,
	name varchar(255) not null,
	description varchar(255) not null,
	color varchar(255) not null,
	status varchar(255) not null
);

create table stt_task_type(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,
	name varchar(255) not null,
	description varchar(255) not null,
	color varchar(255) not null,
	status varchar(255) not null
);

create table stt_project(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,	
	name varchar(255) not null,
	description varchar(255) not null,
	start_on date,
	color varchar(255),
	company_code varchar(255) not null,
	company_name varchar(255) not null,
	status varchar(255)
);

create table stt_project_member(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,	
	user_id bigint(20) not null,
	project_id bigint(20) not null,
	constraint fk_stt_project_member_user foreign key (user_id) references stt_user(id),
	constraint fk_stt_project_member_project foreign key (project_id) references stt_project(id)	
);

create table stt_project_task(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,
	project_id bigint(20) not null,
	user_id bigint(20),
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
);

create table stt_time_sheet(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,	
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
);





