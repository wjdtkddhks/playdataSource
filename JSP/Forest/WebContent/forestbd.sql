create table forestbd(
    num number primary key,
    writer varchar2(15),
    passwd varchar2(15),
    subject varchar2(50),
    email varchar2(50),
    grade varchar2(10),
    content varchar2(2000),
    ref_date timestamp,
    readcount number,
    ref number,
    ref_step number,
    ref_level number
);