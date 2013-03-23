
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




