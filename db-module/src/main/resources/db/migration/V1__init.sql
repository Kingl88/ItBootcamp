create table users
(
    id         bigint NOT NULL primary key ,
    name       varchar(20),
    surname    varchar(40),
    lastname   varchar(40),
    email      varchar(50),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
create table roles
(
    id         bigint primary key NOT NULL,
    name       varchar(20),
    user_id    bigint references users (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into users(id, name, surname, lastname, email)
values (25, 'rterte', 'tetdfsf','fsdfsf', 'erwsdfsf');

insert into roles( id, name, user_id)
values(48,'hghjh', 1);