<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.io.File"%>
<%@ page import="java.io.*"%>
<%@ page import="com.oreilly.servlet.ServletUtils"%>

<%
   String fileName = request.getParameter("downFile");
 
   String savePath = "/boardUpload";
   ServletContext context = getServletContext();
   String sDownloadPath = context.getRealPath(savePath);
   System.out.println(sDownloadPath);
   String sFilePath = sDownloadPath + "\\" + fileName;
   System.out.println(sFilePath);
   
   byte b[] = new byte[4096];
   File oFile = new File(sFilePath);
  
   FileInputStream in = new FileInputStream(sFilePath);

   String sMimeType = getServletContext().getMimeType(sFilePath);
   System.out.println("sMimeType>>>"+sMimeType );

   // octet-stream은  8비트로 된 일련의 데이터를 뜻합니다. 지정되지 않은 파일 형식을 의미합니다.
 
   if(sMimeType == null) sMimeType = "application/octet-stream";

   response.setContentType(sMimeType);

   //한글 업로드 (이 부분이 한글 파일명이 깨지는 것을 방지해 줍니다.)
   String sEncoding = new String(fileName.getBytes("utf-8"),"8859_1");

   response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
   
   // OutputStream객체를 생성하기 전에 jsp 자체의 out객체를 비워주고 사용해야 한다. 
   out.clear();
   out=pageContext.pushBody();
   
   //PrintWriter out2 = response.getWriter();
   ServletOutputStream out2 = response.getOutputStream();
   int numRead;

   // 바이트 배열b의 0번 부터 numRead번 까지 브라우저로 출력
   while((numRead = in.read(b, 0, b.length)) != -1) {
    out2.write(b, 0, numRead);
   }
   out2.flush(); 
   out2.close();
   in.close();

 //  ServletUtils.returnFile( PdsMisc.UPLOAD_DIRECTORY + File.separator + StringMisc.uniToEuc( fileName ), response.getOutputStream() );
%>
