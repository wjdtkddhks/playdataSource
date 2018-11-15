package com.spring.naonnaTest.notice;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
   
   @Autowired
   private SqlSession sqlSession;
        
   public int insertwrite(NoticeVO noticevo) {
      NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
      int check = noticeMapper.addwrite(noticevo);
      return check;
   }

   
   public ArrayList<NoticeVO> getNoticeJson(){
      ArrayList<NoticeVO> noticeList = null;
      NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
      noticeList = noticeMapper.noticelistget();
      return noticeList;
   }
   
   public NoticeVO That_notice_Info(String title) {
      
      NoticeVO ThatNotice = null;
      try {
      NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
      ThatNotice = noticeMapper.noticedetail(title);
      }
      catch(Exception e) {
         e.getStackTrace();
      }
      return ThatNotice;
      
   }
   
   public int delete_notice (String title) {
      NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
      int check = noticeMapper.removeNotice(title);
      return check;
      
   }
}