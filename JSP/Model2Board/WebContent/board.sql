create table board(
    board_num int,
    board_name varchar2(20) not null,
    board_pass varchar2(15) not null,
    board_subject varchar2(50) not null,
    board_content varchar2(2000) not null,
    board_file varchar2(50),
    board_re_ref int not null,
    board_re_lev int not null,
    board_re_seq int not null,
    board_readcount int default 0,
    board_date date,
    primary key(board_num)
    );