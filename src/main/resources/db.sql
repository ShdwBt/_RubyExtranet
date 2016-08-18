-- look in application.properties 

-- CREATE DATABASE ruby_extranet_release;

INSERT INTO role(role_text)
VALUES ('ADMIN');
 
INSERT INTO role(role_text)
VALUES ('USER');


INSERT INTO department(department_text) VALUE('DIRECTORATE_GENERAL');
INSERT INTO department(department_text) VALUE('ADMINISTRATION');
INSERT INTO department(department_text) VALUE('HR');
INSERT INTO department(department_text) VALUE('COMMERCIAL');
INSERT INTO department(department_text) VALUE('DELIVERY');
INSERT INTO department(department_text) VALUE('MARKETING');
INSERT INTO department(department_text) VALUE('MANUFACTURING');
INSERT INTO department(department_text) VALUE('IT');

INSERT INTO state(state_text) VALUE('ACTIVE');
INSERT INTO state(state_text) VALUE('INACTIVE');
INSERT INTO state(state_text) VALUE('DELETED');
INSERT INTO state(state_text) VALUE('LOCKED');

insert into user(email, first_name, last_name, password, fk_department_id, fk_state_id) 
values('admin@admin', 'admin', 'admin', 'admin', 8, 1);

insert into user(email, first_name, last_name, password, fk_department_id, fk_state_id) 
values('user@user', 'user', 'user', 'user', 8, 1);

INSERT INTO user_role (fk_user_id, fk_role_id)
  SELECT pk_user_id, pk_role_id FROM user, role  
  where user.email = 'admin@admin' and role.pk_role_id=1;
  
INSERT INTO user_role (fk_user_id, fk_role_id)
  SELECT pk_user_id, pk_role_id FROM user, role  
  where user.email = 'admin@admin' and role.pk_role_id=2;
  
INSERT INTO user_role (fk_user_id, fk_role_id)
  SELECT pk_user_id, pk_role_id FROM user, role  
  where user.email = 'user@user' and role.pk_role_id=2;

select * from user;

select * from role;

select * from user_role;

select * from department;

select * from state;

select * from reset;

-- truncate table user_role;

select * from user, user_role where pk_user_id = fk_user_id;
