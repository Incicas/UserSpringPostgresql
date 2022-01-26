create table if not exists users(
id serial primary key,
created_at timestamp default current_timestamp,
email varchar(50) not null,
password varchar(50) not null
);