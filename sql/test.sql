select * from users;
select * from user_roles;

-- insert into users (email, password, username, version) values ('hunter','hunter', 'hunter', 1);
#insert into user_roles (version, role_name, user_id) values (1, 'USER',2);

#UPDATE user_roles set role_name = 'USER';