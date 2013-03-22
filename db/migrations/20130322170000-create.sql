create table STT_TASK_TYPE(
	id bigint(20) not null AUTO_INCREMENT,
	name varchar(255) not null,
	description varchar(255) not null,
	color varchar(255) not null,
	status varchar(255) not null,
	primary key (id)
) ENGINE=InnoDB;

insert into STT_TASK_TYPE(name, description, color, status) values('Features', 'working on new features, improvements, etc.', '#FF0000', 'OPEN');
insert into STT_TASK_TYPE(name, description, color, status) values('Maintanance', 'working on existing features', '#00FF00', 'OPEN');
insert into STT_TASK_TYPE(name, description, color, status) values('Proposal', 'sales force', '#0000FF', 'OPEN');