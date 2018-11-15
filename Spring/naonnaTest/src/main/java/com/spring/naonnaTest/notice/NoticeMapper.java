package com.spring.naonnaTest.notice;

import java.util.ArrayList;

public interface NoticeMapper {
   
   int addwrite(NoticeVO noticevo);
   ArrayList<NoticeVO> noticelistget();
   NoticeVO noticedetail(String title);
   int removeNotice(String title);
}