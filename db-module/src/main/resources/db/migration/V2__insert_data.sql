insert into users(name, lastname, surname, email, role_id)
values ('Иван', 'Иванович', 'Иванов', 'ivan@mail.nt', 1),
       ('Петр', 'Петрович', 'Петров', 'petr@mail.nt', 2),
       ('Сергей', 'Иванович', 'Петров', 'sergey@mail.nt', 3),
       ('Игнат', 'Эдуардович', 'Иванов', 'ignat@mail.nt', 4),
       ('Инакентий', 'Васильевич', 'Петров', 'inakent@mail.nt', 2);

insert into roles(name)
values ('Administrator'),
       ('Sale User'),
       ('Customer User'),
       ('Secure API User');