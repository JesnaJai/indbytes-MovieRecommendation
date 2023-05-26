--liquibase formatted sql
--changeset JESNA:user table

    CREATE TABLE IF NOT EXISTS users(
        user_id INT primary key,
        user_name Varchar(50));

--changeset JESNA:hibernate_user
CREATE SEQUENCE IF NOT EXISTS public.hibernate_sequence INCREMENT 1 START 1 MINVALUE 1;
ALTER TABLE users ALTER COLUMN user_id SET DEFAULT nextval('hibernate_sequence');


--changeset JESNA:insert_users
INSERT INTO users(user_name)
    VALUES('user1'),
        ('user2'),
        ('user3');

