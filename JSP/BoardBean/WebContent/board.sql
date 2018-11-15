create table board(
    num number primary key,
    writer varchar2(15),
    passwd varchar2(15),
    subject varchar2(50),
    email varchar2(50),
    content varchar2(2000),
    reg_date timestamp,
    readcount number,
    ref number,
    re_step number,
    re_level number
);

create sequence board_seq
    start with 1
    increment by 1
    maxvalue 100000;