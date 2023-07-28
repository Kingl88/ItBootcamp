create table users
(
    id         bigint NOT NULL primary key auto_increment,
    name       varchar(20),
    surname    varchar(40),
    lastname   varchar(40),
    email      varchar(50),
    role_id    bigint references roles(id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);
create table roles
(
    id         bigint primary key NOT NULL auto_increment,
    name       varchar(20),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into users(name, surname, lastname, email, role_id)
values ('rterte', 'tetdfsf','fsdfsf', 'erwsdfsf', 1);

insert into roles(name)
values('hghjh');