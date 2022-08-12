create table if not exists weather
(
    id           serial primary key,
    city         varchar(50) not null,
    temp         numeric     not null,
    create_stamp timestamp   not null
);