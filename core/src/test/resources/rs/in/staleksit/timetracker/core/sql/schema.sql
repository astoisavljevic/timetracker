create table stt_activity_type(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default 0,
	name varchar(255) not null,
	description varchar(255) not null,
	color varchar(255) not null,
	status varchar(255) not null
);

create table stt_role(
	id bigint(20) not null AUTO_INCREMENT PRIMARY KEY,
	version bigint(20) not null default '0',
	name varchar(80) not null
);
