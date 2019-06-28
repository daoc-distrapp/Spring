insert into users (username, password, enabled) values ('user', '{noop}user', true);
insert into authorities (username, authority) values ('user', 'ROLE_USER');
insert into users (username, password, enabled) values ('admin', '{noop}admin', true);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');