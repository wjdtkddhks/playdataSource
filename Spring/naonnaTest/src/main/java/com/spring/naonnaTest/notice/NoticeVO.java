package com.spring.naonnaTest.notice;

import java.sql.Date;

public class NoticeVO {

   String title;
   String contents;
   String writer;
   Date write_date;
   
   
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContents() {
      return contents;
   }
   public void setContents(String contents) {
      this.contents = contents;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
   }
   public Date getWrite_date() {
      return write_date;
   }
   public void setWrite_date(Date write_date) {
      this.write_date = write_date;
   }
   
   
   
}