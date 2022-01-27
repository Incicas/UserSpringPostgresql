create table if not exists assets(
id serial primary key,
created_at timestamp default current_timestamp,
price int8 not null,
name varchar(50) not null,
user_id int8 references users(id)
);