create table users (
  id integer not null primary key,
  name varchar(128) not null,
  created_at timestamp with time zone default now(),
  updated_at timestamp with time zone default now()
);

grant select, update, insert, delete on table users to ${username};