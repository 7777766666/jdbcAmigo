CREATE TABLE actor
(
    id BIGSERIAL PRIMARY KEY ,
    name TEXT NOT NULL ,
    movie BIGINT REFERENCES postgres.public.movie (id),
    unique (name, movie)
);