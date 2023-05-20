--liquibase formatted sql
--changeset JESNA:Selected table

    CREATE TABLE IF NOT EXISTS selected_movie(
        id INT primary key,
        movie_id int,
        user_id int,
        date DATE);
--changeset JESNA:hibernate_selected_movie
CREATE SEQUENCE IF NOT EXISTS public.hibernate_sequence2 INCREMENT 1 START 1 MINVALUE 1;
ALTER TABLE selected_movie ALTER COLUMN id SET DEFAULT nextval('hibernate_sequence2');

