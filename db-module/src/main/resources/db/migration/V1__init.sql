create table users
(
    id       bigint      NOT NULL primary key auto_increment,
    name     varchar(20) NOT NULL,
    lastname varchar(40) NOT NULL,
    surname  varchar(40) NOT NULL,
    email    varchar(50) NOT NULL,
    role_id  bigint references roles (id)
);
create table roles
(
    id   bigint primary key NOT NULL auto_increment,
    name varchar(20)
);