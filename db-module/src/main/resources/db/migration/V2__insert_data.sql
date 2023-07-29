insert into users(name, lastname, surname, email, role_id)
values ('Александр', 'Иванович', 'Иванов', 'alex@mail.nt', 1),
       ('Михаил', 'Петрович', 'Петров', 'miha@mail.nt', 2),
       ('Дмитрий', 'Иванович', 'Петров', 'dima@mail.nt', 3),
       ('Николай', 'Эдуардович', 'Иванов', 'nik@mail.nt', 4),
       ('Иван', 'Васильевич', 'Петров', 'ivan@mail.nt', 2),
       ('Алексей', 'Иванович', 'Иванов', 'alexei@mail.nt', 1),
       ('Сергей', 'Петрович', 'Петров', 'sergey@mail.nt', 2),
       ('Тимофей', 'Иванович', 'Петров', 'tima@mail.nt', 3),
       ('Матвей', 'Эдуардович', 'Иванов', 'matvei@mail.nt', 4),
       ('Илья', 'Васильевич', 'Петров', 'ilya@mail.nt', 2),
       ('Никита', 'Иванович', 'Иванов', 'nikita@mail.nt', 1),
       ('Андрей', 'Петрович', 'Петров', 'andrey@mail.nt', 2),
       ('Максим', 'Иванович', 'Петров', 'maksim@mail.nt', 3),
       ('Артем', 'Эдуардович', 'Иванов', 'artem@mail.nt', 4),
       ('Роман', 'Васильевич', 'Петров', 'roman@mail.nt', 2);

insert into roles(name)
values ('Administrator'),
       ('Sale User'),
       ('Customer User'),
       ('Secure API User');