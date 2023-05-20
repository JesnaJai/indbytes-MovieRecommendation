--liquibase formatted sql
--changeset JESNA:movie table

    CREATE TABLE IF NOT EXISTS movie(
        movie_id INT primary key,
        movie_name Varchar(50));

--changeset JESNA:hibernate_movie
CREATE SEQUENCE IF NOT EXISTS public.hibernate_sequence1 INCREMENT 1 START 1 MINVALUE 1;

ALTER TABLE movie ALTER COLUMN movie_id SET DEFAULT nextval('hibernate_sequence1');

--changeset JESNA:insert_movie
INSERT INTO movie(movie_name)
    VALUES('Titanic'),
        ('Rambo'),
        ('Insidious'),
        ('Inception'),
        ('Conjuring'),
        ('EvilDead'),
        ('Anabelle'),
        ('Curse of La Lorrona'),
        ('The Boy');