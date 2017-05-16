alter table users add column (
	email varchar(255),
	password char(128),
	password_salt char(128),
	last_sign_in date
);

alter table users modify column email varchar(255) not null;
alter table users modify column password char(128) not null;
alter table users modify column password_salt char(128) not null;

alter table users modify column email varchar(255) unique not null;