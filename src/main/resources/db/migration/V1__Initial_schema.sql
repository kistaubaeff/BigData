create table t_user (
    id bigserial primary key,
    identifier varchar(255),
    fio varchar(255)

);

create table t_book (
    id bigserial primary key,
    isbn varchar(255),
    title varchar(255),
    list_of_authors varchar(255),
    volume integer,
    year integer
);

create table t_issue (
    id bigserial primary key,
    identifier varchar(255),
    user_id bigint not null references t_user(id),
    book_id bigint not null references t_book(id),
    issue_date varchar(255),
    period integer
);