package com.spring.naonnaTest.notice;

import java.util.ArrayList;

public interface NoticeService {

   int insertwrite(NoticeVO noticevo);
   ArrayList<NoticeVO> getNoticeJson();
   NoticeVO That_notice_Info(String title);
   int delete_notice(String title);
}